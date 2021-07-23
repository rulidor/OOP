package EnemyClasses;

public class QueenTrap extends Trap{

	
	/*
	 * Constructor for QueenTrap
	 */
	public QueenTrap(int position_x, int position_y)
	{
		super("Queen Trap", 250,250,50,10,100,4,10,4, position_x,  position_y);
		this.setTile('Q');
	}
	
	
	
}
