package hw3;

import EnemyClasses.*;
import PlayerClasses.*;


/**
 * This is a testing framework, used to verify that the code is working
 * properly.
 */
public class Tester {
	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
	
		// Each function here should test a different class.

		// BearWright
		testBearWright();
		
		// BonusTrap
		testBonusTrap();

		// DeathTrap
		testDeathTrap();
		
		// GiantWright
		testGiantWright();

		// TheMountain
		testTheMountain();

		// Monster
		testMonster();
		
		// Trap
		testTrap();
		
		
		// Board
		testBoard();
		
		// Controller
		testController();

		// Warrior
		testWarrior();
		
		// Mage
		testMage();
		
		// Player
		testPlayer();

		// Range
		testRange();
		
		
		// AryaStark
		testAryaStark();

		// JonSnow
		testJonSnow();
		
		// Melisandre
		testMelisandre();
		
		// TheHound
		testTheHound();
		
		

		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	/**
	 * Checks the testBearWright class.
	 */
	private static void testBearWright(){
		BearWright e=new BearWright(2,5);
		test(e.getPosition_x() == 2, "x coor. should be 2");
		test(e.getPosition_y() == 5, "y coor. should be 5");
		test(e.getName() == "Bear-Wright", "Name should be 'Bear-Wright'");
		test(e.getHealth_pool() == 1000, "Health pool should be 1000");
		test(e.getDefense_points() == 30, "Defense should be 30");
		test(e.getTile() == 'b', "Tile should be 'b'");
	}
	
	/**
	 * Checks the BonusTrap class.
	 */
	private static void testBonusTrap(){
		BonusTrap e=new BonusTrap(7,4);
		test(e.getPosition_x() == 7, "x coor. should be 7");
		test(e.getPosition_y() == 4, "y coor. should be 4");
		test(e.getName() == "Bonus Trap", "Name should be 'Bonus Trap'");
		test(e.getHealth_pool() == 1, "Health pool should be 1");
		test(e.getDefense_points() == 1, "Defense should be 1");
		test(e.getTile() == 'B', "Tile should be 'B'");
	}

	private static void testDeathTrap(){
		DeathTrap e=new DeathTrap(5,5);
		test(e.getPosition_x() == 5, "x coor. should be 5");
		test(e.getPosition_y() == 5, "y coor. should be 5");
		test(e.getName() == "Death Trap", "Name should be 'Death Trap'");
		test(e.getHealth_pool() == 500, "Health pool should be 500");
		test(e.getDefense_points() == 20, "Defense should be 20");
		test(e.getTile() == 'D', "Tile should be 'D'");
	}
	
	private static void testGiantWright(){
		GiantWright e=new GiantWright(1,10);
		test(e.getPosition_x() == 1, "x coor. should be 1");
		test(e.getPosition_y() == 10, "y coor. should be 10");
		test(e.getName() == "Giant-Wright", "Name should be 'Giant-Wright'");
		test(e.getHealth_pool() == 1500, "Health pool should be 1500");
		test(e.getDefense_points() == 40, "Defense should be 40");
		test(e.getTile() == 'g', "Tile should be 'g'");
	}
	
	private static void testTheMountain(){
		TheMountain e=new TheMountain(3,3);
		test(e.getPosition_x() == 3, "x coor. should be 3");
		test(e.getPosition_y() == 3, "y coor. should be 3");
		test(e.getName() == "The Mountain", "Name should be 'The Mountain'");
		test(e.getHealth_pool() == 1000, "Health pool should be 1000");
		test(e.getDefense_points() == 25, "Defense should be 25");
		test(e.getTile() == 'M', "Tile should be 'M'");
	}
	
	private static void testMonster(){
		
	}
	
	private static void testTrap(){
		
	}
	
	private static void testBoard(){
		
	}
	
	private static void testController(){
		
	}

	private static void testWarrior(){
		
	}
	
	private static void testMage(){
		
	}
	
	private static void testPlayer(){
		
	}
	
	private static void testRange(){
		Range range=new Range(0,0,0,0);
		test(range.getRange() == 0, "Range should be 0");
		range=new Range(10,10,11,10);
		test(range.getRange() == 1, "Range should be 1");
		range=new Range(0,0,1,1);
		test(range.getRange() == 1, "Range should be 1");
		
	}
	
	private static void testAryaStark(){
		AryaStark e=new AryaStark(2,1);
		test(e.getPosition_x() == 2, "x coor. should be 2");
		test(e.getPosition_y() == 1, "y coor. should be 1");
		test(e.getName() == "Arya Stark", "Name should be 'Arya Stark'");
		test(e.getHealth_pool() == 150, "Health pool should be 150");
		test(e.getDefense_points() == 2, "Defense should be 2");
		test(e.getTile() == '@', "Tile should be '@'");
		
	}
	
	private static void testJonSnow(){
		JonSnow e=new JonSnow(1,1);
		test(e.getPosition_x() == 1, "x coor. should be 1");
		test(e.getPosition_y() == 1, "y coor. should be 1");
		test(e.getName() == "Jon Snow", "Name should be 'Jon Snow'");
		test(e.getHealth_pool() == 300, "Health pool should be 300");
		test(e.getDefense_points() == 4, "Defense should be 4");
		test(e.getTile() == '@', "Tile should be '@'");
	}
	
	private static void testMelisandre(){
		Melisandre e=new Melisandre(1,1);
		test(e.getPosition_x() == 1, "x coor. should be 1");
		test(e.getPosition_y() == 1, "y coor. should be 1");
		test(e.getName() == "Melisandre", "Name should be 'Melisandre'");
		test(e.getHealth_pool() == 160, "Health pool should be 160");
		test(e.getDefense_points() == 1, "Defense should be 1");
		test(e.getTile() == '@', "Tile should be '@'");
		test(e.getCost() == 30, "Mana cost should be 30");
		test(e.getRange() == 6, "Range should be 6");
	}

	private static void testTheHound(){
		TheHound e=new TheHound(1,1);
		test(e.getPosition_x() == 1, "x coor. should be 1");
		test(e.getPosition_y() == 1, "y coor. should be 1");
		test(e.getName() == "The Hound", "Name should be 'The Hound'");
		test(e.getHealth_pool() == 400, "Health pool should be 400");
		test(e.getDefense_points() == 6, "Defense should be 6");
		test(e.getTile() == '@', "Tile should be '@'");
	}
	


}
