package hw3;

/*
 * Represents a Player
 */
public class Player extends GameUnit implements IObservable{
	
	private IObserver observer;
	private int experience;
	private int level;
	
	/*
	 * Constructor for Player
	 */
	public Player(String name, int health_pool, int current_health, int attack_points,
			int defense_points, int position_x, int position_y)
	{
		super(name, health_pool, current_health, attack_points,
				defense_points,  position_x,  position_y);
		this.experience=0;
		this.level=1;
		this.setTile('@');
	}
	
	public void add(IObserver observer) 
	{
		this.observer=observer;
	}
	
	public void remove(IObserver observer)
	{
		this.observer=null;
	}
	
	public void doNotify()
	{
		this.observer.update();
	}
	
	
	/*
	 * Will be implemented in every sub class
	 */
	public void useAbility()
	{
	}

	//Getters and Setters
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	//End of Getters and Setters
	
	/*
	 * After gaining (50 * level) experience points, the player will level up.
	 * Upon leveling up, the next properties will be updated
	 */
	public void levelUp()
	{
		this.experience=this.experience - (50*this.level);
		this.level++;
		System.out.print(this.getName()+" has been leveled up: +"+(10*this.level)+" Health, +"+(5*this.level)+" Attack, +"+(2*this.level)+" Defense\n");
		this.setHealth_pool(this.getHealth_pool() + (10*this.level));
		this.setCurrent_health(this.getHealth_pool());
		this.setAttack_points(this.getAttack_points() + (5*this.level));
		this.setDefense_points(this.getDefense_points() + (2*this.level));
	}
	
	/*
	 * Will be updated when game tick occur
	 * To be override in subclasses.
	 */
	public void gameTick()
	{
	}

	@Override
	public String toString() {
		return this.getName()+"		Health: "+this.getCurrent_health()+"		Attack damage: "+this.getAttack_points()+"		Defense: "+this.getDefense_points()+"\r\n"+
		"		Level: "+this.getLevel()+"		Experience: "+this.getExperience()+"/"+(50*this.getLevel());
	}
	
	
}
