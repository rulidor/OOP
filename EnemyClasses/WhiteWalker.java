package EnemyClasses;

public class WhiteWalker extends Monster{
	
	/*
	 * Constructor for WhiteWalker
	 */
	public WhiteWalker(int position_x, int position_y)
	{
		super("White Walker",2000,2000, 150, 50, 1000,6, position_x,  position_y);
		this.setTile('w');
	}

}
