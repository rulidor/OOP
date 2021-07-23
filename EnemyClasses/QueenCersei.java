package EnemyClasses;

public class QueenCersei extends Monster{
	
	/*
	 * Constructor for QueenCersei
	 */
	public QueenCersei(int position_x, int position_y)
	{
		super("Queen Cersei",100,100, 10, 10, 1000,1, position_x,  position_y);
		this.setTile('C');
	}

}
