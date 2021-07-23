package hw3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import EnemyClasses.*;
import PlayerClasses.*;

public class Board {
	
	private char[][] board;
	
	/*
	 * Constructor for a Board
	 */
	public Board(String path)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Scanner file = new Scanner(new File(path));
		    int counter = 0;
		    while (file.hasNextLine()) {
		    	  counter++;
		    	  file.nextLine();
		    	}
			String line=br.readLine();
			char[] chars = line.toCharArray();
			this.board=new char[counter][chars.length];
			for (int i=0;i<chars.length;i++)
			{
				this.board[0][i]=chars[i];
			}
			int line_counter=1;
			while ((line = br.readLine()) != null) {
				chars = line.toCharArray();
		    	for (int j=0;j<chars.length;j++)
				{
					this.board[line_counter][j]=chars[j];
				}
		    	line_counter++;
		    }
		    br.close();
		    file.close();
		}
		catch (IOException e) {
			/* Handle IOException */
			}
		
	}
	
	public char[][] getBoard()
	{
		return this.board;
	}
	
	public String toString()
	{
		String res="";
		for (int i=0;i<this.board.length;i++)
		{
			for (int j=0;j<this.board[i].length;j++)
				res+=this.board[i][j];
			res+="\n";
		}
		
		return res;
	}
	
	/*
	 * checks if a move is valid, according to walls, and updates board accordingly
	 */
	public boolean isValidMove(char move, int x, int y)
	{
		switch (move) {
			case 'a':
				if(this.board[y][x-1]!='.')
					return false;
				else
				{
					this.board[y][x]='.';
					this.board[y][x-1]='@';
					return true;
				}
				//break;
			case 'd':
				if(this.board[y][x+1]!='.')
					return false;
				else
				{
					this.board[y][x]='.';
					this.board[y][x+1]='@';
					return true;
				}
				//break;
			case 's':
				if(this.board[y+1][x]!='.')
					return false;
				else
				{
					this.board[y][x]='.';
					this.board[y+1][x]='@';
					return true;
				}
				//break;
			case 'w':
				if(this.board[y-1][x]!='.')
					return false;
				else
				{
					this.board[y][x]='.';
					this.board[y-1][x]='@';
					return true;
				}
				//break;
		}
		return false;
	}
	

}
