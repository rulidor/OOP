package EnemyClasses;

public class LannisterKnight extends Monster{

	
	/*
	 * Constructor for LannisterKnight
	 */
	public LannisterKnight(int position_x, int position_y)
	{
		super("Lannister Knight",200,200, 14, 8, 50,4, position_x,  position_y);
		this.setTile('k');
	}
	
}
