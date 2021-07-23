package EnemyClasses;

public class NightKing extends Monster{

	/*
	 * Constructor for NightKing
	 */
	public NightKing(int position_x, int position_y)
	{
		super("Night King",5000,5000, 300, 150, 5000,8, position_x,  position_y);
		this.setTile('K');
	}
	
}
