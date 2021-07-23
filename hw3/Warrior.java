package hw3;

public class Warrior extends Player{
	
	private int cooldown;
	public int remaining;
	
	public Warrior(String name, int health_pool, int current_health, int attack_points,
			int defense_points ,int cooldown, int position_x, int position_y)
	{
		super(name, health_pool, current_health, attack_points,
				defense_points,  position_x,  position_y);
		this.cooldown=cooldown;
		this.remaining=0;
	}
	
	/*
	 * heal the warrior for amount equals to (2 * defense) (but will not exceed
	 *	the total amount of health pool).
	 * The warrior’s ability has a cooldown, meaning it can only use it only every cooldown game ticks
	 */
	public void useAbility()
	{
		
		if (this.remaining>0)
			System.out.println(this.getName()+" tried to cast Heal, but there is a cool-down: "+this.remaining);
		else
		{
			System.out.println(this.getName()+" cast Heal.");
			this.remaining=this.cooldown;
			this.setCurrent_health(Math.min(this.getCurrent_health()+(2*this.getDefense_points()), this.getHealth_pool()));
		}
	}
	
	public void levelUp()
	{
		super.levelUp();
		this.remaining=0;
		this.setHealth_pool(this.getHealth_pool() + (5*this.getLevel()));
		this.setDefense_points(this.getDefense_points() + this.getLevel());
	}
	
	/*
	 * Will be updated when game tick occur
	 */
	public void gameTick()
	{
		this.remaining=this.remaining-1;
	}
	
	
	//Getters and Setters
	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	
	//End of Getters and Setters
	
	public String toString()
	{
		return super.toString()+"		Ability cooldown: "+this.getCooldown()+"		Remaining: "+this.getRemaining();
	}

}
