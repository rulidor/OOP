package EnemyClasses;

public class Wright extends Monster{
	
	/*
	 * Constructor for Wright
	 */
	public Wright(int position_x, int position_y)
	{
		super("Wright",600,600, 30, 15, 100,3, position_x,  position_y);
		this.setTile('z');
	}

}
