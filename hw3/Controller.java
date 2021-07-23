package hw3;
import EnemyClasses.*;
import PlayerClasses.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller implements IObserver{
	
	private Player player;
	private ArrayList<Enemy> enemies;
	private Board board;
	
	/*
	 * Constructor for Controller.
	 * param. path - txt file of level. choice is the user's choice for a Player. isTest - true if it's a test
	 */
	public Controller(String path, int choice, boolean isTest)
	{
		
		this.enemies=new ArrayList<Enemy>();
		board=new Board(path);
		for (int i=0;i<board.getBoard().length;i++)
		{
			for (int j=0;j<board.getBoard()[i].length;j++)
			{
				char tile=board.getBoard()[i][j];
				switch (tile) {
					case '@':
						constructPlayer(choice,j,i); //x=j, y=i
						break;
					case '#':
						break;
					case '.':
						break;
					default: //an enemy is located in this spot
						this.enemies.add( constructEnemy( tile,  j,  i) );
						break;
				}
				
			}
		}
		this.player.add(this);
		startGame(isTest);
	}
	
	/*
	 * Returns num. of lines in the received txt file path.
	 */
	public int numOfLine(String path)
	{
		int line_counter=1;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Scanner file = new Scanner(new File(path));
//		    int counter = 0;
//		    while (file.hasNextLine()) {
//		    	  counter++;
//		    	  file.nextLine();
//		    	}
			String line=br.readLine();
			while ((line = br.readLine()) != null) {
		    	line_counter++;
		    }
		    br.close();
		    file.close();
		    return line_counter;
		}
		catch (IOException e) {
			/* Handle IOException */
			}
	return line_counter;

	}
	
	
	/*
	 * Starts a game.
	 * Param. isTest - true if it's a test
	 */
	public void startGame(boolean isTest)
	{
		System.out.println("You have selected:");
		System.out.println(this.player);
		System.out.println("Use w/s/a/d to move.");
		System.out.println("Use e for special ability or q to pass.");
		System.out.println(this.board);
		if (isTest==true)
		{
			char move=charAtLine(2);
		}
		int count=2;
		int numOfLines=numOfLine("user_actions.txt");
		while(this.player.getCurrent_health()>0)
		{
			count++;
			char move;
			if (isTest==true)
			{
				if (count>numOfLines)
				{
					System.out.println("Reached to the end of actions entered in user_actions.txt file.");
					return;
				}
				move=charAtLine(count);
			}
			else
			{
				Scanner scan=new Scanner(System.in);
				move=scan.next().charAt(0);
			}
			
			if (move!='q' && move != 'e')
			{
				boolean isValidMove=this.board.isValidMove(move, this.player.getPosition_x(), this.player.getPosition_y());
				
				if (isValidMove==false)
					System.out.println("Not a valid move.");
				else
				{
					switch (move) {
						case 'a':
							this.player.setPosition_x(this.player.getPosition_x()-1);
							break;
						case 'd':
							this.player.setPosition_x(this.player.getPosition_x()+1);
							break;
						case 's':
							this.player.setPosition_y(this.player.getPosition_y()+1);
							break;
						case 'w':
							this.player.setPosition_y(this.player.getPosition_y()-1);
							break;
					}
				}
				
			}
			else
			{
				if (move=='q') //stay in place
				{
					
				}
				if (move=='e')
				{
				/*	String name=this.player.getName();
					if (name.equals("Jon Snow") || name.equals("The Hound"))
						((Warrior)this.player).useAbility();
					if (name.equals("Melisandre") || name.equals("Thoros of Myr"))
						((Mage)this.player).useAbility(this.enemies);
					if (name.equals("Arya Stark") || name.equals("Bronn"))
						((Rogue)this.player).useAbility(this.enemies);  */
					
					if (Warrior.class.isAssignableFrom(this.player.getClass()))
						((Warrior)this.player).useAbility();
					if (Mage.class.isAssignableFrom(this.player.getClass()))
						((Mage)this.player).useAbility(this.enemies);
					if (Rogue.class.isAssignableFrom(this.player.getClass()))
						((Rogue)this.player).useAbility(this.enemies);
					update();
				}
			}
			for (Enemy e : this.enemies)
			{
				if (e.getTile()=='X')
					continue;
				char t=e.getTile();
				Range range=new Range(e.getPosition_x(), e.getPosition_y(), this.player.getPosition_x(), this.player.getPosition_y());
				if (t=='B' || t=='Q' || t=='D')
				{
					((Trap)e).makeTurn(this.player, this.board);
					//if (e.getPosition_x()==this.player.getPosition_x() && e.getPosition_y()==this.player.getPosition_y())
					//	this.board.getBoard()[e.getPosition_y()][e.getPosition_x()]='@';
					//now should check if range<2, if it is-trap should attack
					if (range.getRange()<2)
					{
						while (this.player.getCurrent_health()>0 && e.getCurrent_health()>0)
						{
							Combat c=new Combat();
							c.combat(e, this.player);
							update();
							if (this.player.getCurrent_health()>0 && e.getCurrent_health()>0)
							{
								c.combat(this.player,e);
								update();
							}
							this.player.gameTick();
						}
					}
				}
				else //e is a Monster
				{
					((Monster)e).makeTurn(this.player, this.board);
					if(range.getRange()<2)
					{
						//this.board.getBoard()[e.getPosition_y()][e.getPosition_x()]='@';
						Combat c=new Combat();
						c.combat(e, this.player);
						update();
						if (this.player.getCurrent_health()>0 && e.getCurrent_health()>0)
						{
							c.combat(this.player,e);
							update();
						}
						this.player.gameTick();
					}
				}

				
			}
			System.out.println(this.board);
			
		}//while Player's health>0
				
	}
	
	/*
	 * Returns char at line index, from user_actions.txt file
	 */
	public char charAtLine(int index)
	{
		// This will reference one line at a time
        String line = null;
        char res='o';
        try {        	
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader("user_actions.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
            String[] arr;
            int counter=0;
           while((line = bufferedReader.readLine()) != null && counter<index) { 
        	   res=line.charAt(0);
               //System.out.println("line="+line);
        	   counter++;
            }   

            // Always close files.
            bufferedReader.close();   
            return res;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                "user_actions.txt" + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + "user_actions.txt" + "'");                  
        }
        return res;
		
	}
	
	
	public void update()
	{
		if (this.player.getCurrent_health()<=0)
		{
			System.out.println(this.player.getName()+" died.");
			System.out.println("You Lost.");
			this.board.getBoard()[this.player.getPosition_y()][this.player.getPosition_x()]='X';
			//System.out.println(this.board);
		}
		else
		{
			for (Enemy e : this.enemies)
			{
				if (e.getTile()=='X')
					continue;
				if (e.getCurrent_health()<=0)
				{
					System.out.println(e.getName()+" died. "+this.player.getName()+" gained "+e.getExperience()+" experience!");
					this.board.getBoard()[e.getPosition_y()][e.getPosition_x()]='.';
					e.setTile('X');
					//enemies.remove(e);
					
				}
				if (e.getTile()=='B' || e.getTile()=='Q' || e.getTile()=='D')
				{
					if ( ((Trap)e).isVisible()==false )
					{
						this.board.getBoard()[e.getPosition_y()][e.getPosition_x()]='.';
					}
					else
					{
						this.board.getBoard()[e.getPosition_y()][e.getPosition_x()]=e.getTile();
					}
				}

			}
			int counter=0; //counts alive Enemies
			for (Enemy e : this.enemies)
			{
				if (e.getTile()!='X')
					counter++;
			}
			if (counter==0)
				System.out.println("Game is finished. You won!");
				
		}
	}
	
	/*
	 * Constructs a Player according to user's choice and x, y coordinates
	 */
	public void constructPlayer(int choice, int x, int y)
	{
		switch (choice) {
			case 1:
				this.player=new JonSnow(x,y);
				break;
			case 2:
				this.player=new TheHound(x,y);
				break;
			case 3:
				this.player=new Melisandre(x,y);
				break;
			case 4:
				this.player=new ThorosOfMyr(x,y);
				break;
			case 5:
				this.player=new AryaStark(x,y);
				break;
			case 6:
				this.player=new Bronn(x,y);
				break;
			default:
				System.out.println("Error: invalid choice");
				break;
		}
	}
	
	public Enemy constructEnemy(char tile, int x, int y)
	{
		Enemy e;
		switch (tile) {
			case 's':
				e=new LannisterSolider(x,y);
				break;
			case 'k':
				e=new LannisterKnight(x,y);
				break;
			case 'q':
				e=new QueenGuard(x,y);
				break;
			case 'z':
				e=new Wright(x,y);
				break;
			case 'b':
				e=new BearWright(x,y);
				break;
			case 'g':
				e=new GiantWright(x,y);
				break;
			case 'w':
				e=new WhiteWalker(x,y);
				break;
			case 'M':
				e=new TheMountain(x,y);
				break;
			case 'C':
				e=new QueenCersei(x,y);
				break;
			case 'K':
				e=new NightKing(x,y);
				break;
			case 'B':
				e=new BonusTrap(x,y);
				break;
			case 'Q':
				e=new QueenTrap(x,y);
				break;
			case 'D':
				e=new DeathTrap(x,y);
				break;
			
			default:
				System.out.println("Error: invalid board");
				e=new DeathTrap(x,y);
				break;
		}//end of switch
		return e;
	}
	
	
	public void blizzard()
	{
		
	}
	

	public String toString()
	{
		String res="";
		res+=this.player;
		for (Enemy e : enemies)
			res+="\n" + e;
		return res;
	}
	
}
