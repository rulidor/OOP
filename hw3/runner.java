package hw3;
import PlayerClasses.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class runner {
	
	public static void main(String[] args)
	{
//		System.out.println("****Args is:****");
//		for (int i=0;i<args.length;i++)
//			System.out.println(args[i]);
//		System.out.println("\n\n");
		if (args.length>0 && args[args.length-1].contains("-D"))
		{
			int choice=readchoice("user_actions.txt");
			System.out.println("Test mode is ON");
			Controller c=new Controller(args[0] ,choice, true);
		}
		else
		{
			System.out.println("Test mode is OFF");
			Scanner scan=new Scanner(System.in);
			Screen s=new Screen();
			s.openMenu();
			int choice=scan.nextInt();
			String path="";
			switch (choice){
				case 1:
					path="level1.txt";
					break;
				case 2:
					path="level2.txt";
					break;
				case 3:
					path="level3.txt";
					break;
				case 4:
					path="level4.txt";
					break;
			}
			Controller c=new Controller(path ,choice, false);
		}
		
		
	}
	
	public static int readchoice(String path)
	{
		String choice="";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Scanner file = new Scanner(new File(path));
			choice=br.readLine();
		    br.close();
		    file.close();
		}
		catch (IOException e) {
			/* Handle IOException */
			}
		return Integer.parseInt(choice);
	}
}
