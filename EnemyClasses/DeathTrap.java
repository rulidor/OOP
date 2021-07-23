package EnemyClasses;

public class DeathTrap extends Trap{
	
	
	/*
	 * Constructor for DeathTrap
	 */
	public DeathTrap(int position_x, int position_y)
	{
		super("Death Trap", 500,500,100,20,250,6,10,3, position_x,  position_y);
		this.setTile('D');
	}
	

}
