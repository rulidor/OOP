package EnemyClasses;

public class BonusTrap extends Trap{
	
	/*
	 * Constructor for BonusTrap
	 */
	public BonusTrap(int position_x, int position_y)
	{
		super("Bonus Trap", 1,1,1,1,250,5,6,2, position_x,  position_y);
		this.setTile('B');
	}

}
