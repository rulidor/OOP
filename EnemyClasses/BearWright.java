package EnemyClasses;

public class BearWright extends Monster{
	
	/*
	 * Constructor for BearWright
	 */
	public BearWright(int position_x, int position_y)
	{
		super("Bear-Wright",1000,1000, 75, 30, 250,4, position_x,  position_y);
		this.setTile('b');
	}

}
