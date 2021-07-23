package hw3;

import java.util.ArrayList;

public class Rogue extends Player{
	
	private int cost;
	private int current_energy;
	
	/*
	 * Constructor for Rogue
	 */
	public Rogue(String name, int health_pool, int current_health, int attack_points,
			int defense_points ,int cost, int position_x, int position_y)
	{
		super(name, health_pool, current_health, attack_points,
				defense_points, position_x,  position_y);
		this.cost=cost;
		this.current_energy=100;
	}

	public void levelUp()
	{
		super.levelUp();
		this.current_energy=100;
		this.setAttack_points(this.getAttack_points() + (3*this.getLevel()));
	}
	
	public void gameTick()
	{
		this.current_energy=Math.min(this.current_energy+10, 100);
	}
	
	/*
	 * Special ability: Fan of Knives hits everyone around the rogue for amount equal to the rogue’s
	 *	attack points at the cost of energy.
	 */
	public void useAbility(ArrayList<Enemy> enemies)
	{
		if (this.current_energy<this.cost)
			System.out.println(this.getName()+" tried to cast Fan of Knives, but current energy is not enough - cost is: "+this.cost);
		else
		{
			System.out.println(this.getName()+" cast Fan of Knives.");
			this.current_energy=this.current_energy-this.cost;
			for (Enemy e : enemies)
			{
				if (e.getTile()=='X')
					continue;
				Range range=new Range(e.getPosition_x(),e.getPosition_y(),this.getPosition_x(),this.getPosition_y());
				if (range.getRange()<2)
				{
					System.out.println(this.getName()+" used Fan of Knives and attacked "+e.getName()+" for amount of "+this.getAttack_points());
					System.out.println(e.getName()+" defended itself with amount of "+e.getDefense_points()+" defense");
					int damage=this.getAttack_points()-e.getDefense_points();
					if (damage<0)
						damage=0;
					System.out.println(this.getName()+" hit "+e.getName()+" for "+damage+" damage.");
					if(e.getCurrent_health()<=0)
					{
						e.setTile('X');
						System.out.println(e.getName()+" died.");
					}
				}
			}
		}
	}
	
	
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCurrent_energy() {
		return current_energy;
	}

	public void setCurrent_energy(int current_energy) {
		this.current_energy = current_energy;
	}
	
	public String toString()
	{
		return super.toString()+"		Energy: "+this.getCurrent_energy()+"/100";
	}
	
	
}
