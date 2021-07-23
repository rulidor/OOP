package EnemyClasses;

public class LannisterSolider extends Monster{

	/*
	 * Constructor for LannisterSolider
	 */
	public LannisterSolider(int position_x, int position_y)
	{
		super("Lannister Solider",80,80, 8, 3, 25,3, position_x,  position_y);
		this.setTile('s');
	}
	
	

}
