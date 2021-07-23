package EnemyClasses;

public class TheMountain extends Monster{
	
	/*
	 * Constructor for TheMountain
	 */
	public TheMountain(int position_x, int position_y)
	{
		super("The Mountain",1000,1000, 60, 25, 500,6, position_x,  position_y);
		this.setTile('M');
	}

}
