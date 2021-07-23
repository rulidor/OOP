package EnemyClasses;

public class QueenGuard extends Monster{
	
	
	/*
	 * Constructor for Queen Guard
	 */
	public QueenGuard(int position_x, int position_y)
	{
		super("Queen Guard",400,400, 20, 15, 100,5, position_x,  position_y);
		this.setTile('q');
	}

}
