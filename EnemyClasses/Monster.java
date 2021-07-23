package EnemyClasses;
import java.util.Random;
import hw3.*;


/*
 * Represents a Monster
 */
public class Monster extends Enemy{
	
	private int vision;
	
	/*
	 * Constructor for a Monster
	 */
	public Monster(String name, int health_pool, int current_health, int attack_points,
			int defense_points, int experience ,int vision, int position_x, int position_y)
	{
		super(name,  health_pool,  current_health,  attack_points,
				 defense_points,  experience, position_x,  position_y);
		this.vision=vision;
	}
	
	/*
	 * Monster method to make a turn.
	 */
	public void makeTurn(Player player, Board board)
	{
		Range range=new Range(this.getPosition_x(),this.getPosition_y(),player.getPosition_x(),player.getPosition_y());
		int d=range.getRange(); //use for distance
		if (d<this.vision)
		{
			int dx=this.getPosition_x()-player.getPosition_x();
			int dy=this.getPosition_y()-player.getPosition_y();
			if (Math.abs(dx)>Math.abs(dy))
			{
				if (dx>0)
				{
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()-1]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
				}
				else //dx<=0
				{
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()+1]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
				}
			}
			else //(Math.abs(dx)<=Math.abs(dy))
			{
				if (dy>0)
				{
					if(board.getBoard()[this.getPosition_y()-1][this.getPosition_x()]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
				}
				else
				{
					if(board.getBoard()[this.getPosition_y()+1][this.getPosition_x()]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
				}
			}
		}
		else //d>=this.vision
		{
			Random rand=new Random();
			int move=rand.nextInt(5);
			switch (move)
			{
				case 0:
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()-1]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					break;
				case 1:
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()+1]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					break;
				case 2:
					if(board.getBoard()[this.getPosition_y()-1][this.getPosition_x()]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					break;
				case 3:
					if(board.getBoard()[this.getPosition_y()+1][this.getPosition_x()]!='.')
						return;
					else
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					break;
				case 4:
					
					break;
			}
		}
			
			
			
			/*if (Math.abs(dx)>Math.abs(dy))
			{
				if (dx>0)
				{
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()-1]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					else
					{
						if (dy>0)
						{
							if(board.getBoard()[this.getPosition_y()+1][this.getPosition_x()]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
						else
						{
							if(board.getBoard()[this.getPosition_y()-1][this.getPosition_x()]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
					}
				}
				else //dx<0
				{
					
					if(board.getBoard()[this.getPosition_y()][this.getPosition_x()+1]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					else
					{
						if (dy>0)
						{
							if(board.getBoard()[this.getPosition_y()+1][this.getPosition_x()]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
						else
						{
							if(board.getBoard()[this.getPosition_y()-1][this.getPosition_x()]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
					}	
				}
			}			
			else //Math.abs(dx)<Math.abs(dy)
			{
				
				if (dy>0)
				{
					if(board.getBoard()[this.getPosition_y()+1][this.getPosition_x()]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()+1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					else
					{
						if (dx>0)
						{
							if(board.getBoard()[this.getPosition_y()][this.getPosition_x()-1]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
						else
						{
							if(board.getBoard()[this.getPosition_y()][this.getPosition_x()+1]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_y(this.getPosition_y()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
					}
				}
				else //dy<0
				{
					
					if(board.getBoard()[this.getPosition_y()-1][this.getPosition_x()]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()-1);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
					}
					else
					{
						if (dx>0)
						{
							if(board.getBoard()[this.getPosition_y()][this.getPosition_x()-1]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
						else
						{
							if(board.getBoard()[this.getPosition_y()][this.getPosition_x()+1]!='#')
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()+1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
							else
							{
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
								this.setPosition_x(this.getPosition_x()-1);
								board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							}
						}
					}	
				}
				
				
				
			}
					
		}
		else //d>=this.vision
		{
			Random rand=new Random();
			boolean flag=false; //to determine if a move had chosen
			
			while (flag==false)
			{
				int move=rand.nextInt(5); //0=left, 1=right, 2=down, 3=up, 4=stay
				if (move==4)
					break;
				int moveValue=move%2; //left/down=negative, right/up=positive, as below
				if (moveValue==0)
					moveValue=-1;
				else
					moveValue=1;
				if (move==0 || move==1)
				{
					if (board.getBoard()[this.getPosition_y()][this.getPosition_x()+moveValue]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_x(this.getPosition_x()+moveValue);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
						flag=true;
					}
				}
				else //move==2 or move==3
				{
					if (board.getBoard()[this.getPosition_y()+moveValue][this.getPosition_x()]!='#')
					{
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
						this.setPosition_y(this.getPosition_y()+moveValue);
						board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
						flag=true;
					}
				}
			}
		}*/
	}
	

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	
	
}
