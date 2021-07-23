package EnemyClasses;

public class GiantWright extends Monster{
	
	/*
	 * Constructor for GiantWright
	 */
	public GiantWright(int position_x, int position_y)
	{
		super("Giant-Wright",1500,1500, 100, 40, 500,5, position_x,  position_y);
		this.setTile('g');
	}

}
