package hw3;

public class Enemy extends GameUnit{
	
	private int experience;
	
	public Enemy(String name, int health_pool, int current_health, int attack_points,
			int defense_points, int experience,int position_x, int position_y)
	{
		super(name, health_pool, current_health, attack_points,
				defense_points, position_x,  position_y);
		this.experience=experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public String toString()
	{
		return this.getName()+"		Health: "+this.getCurrent_health()+"		Attack damage: "+this.getAttack_points()+"		Defense: "+this.getDefense_points();
	}

}
