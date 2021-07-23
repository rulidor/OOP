package hw3;
import java.util.ArrayList;

/*
 * Represents a Mage
 */
public class Mage extends Player{
	
	private int spell_power;
	private int mana_pool;
	private int current_mana;
	private int cost;
	private int hit_times;
	private int range;
	
	/*
	 * Constructor for Mage
	 */
	public Mage(String name, int health_pool, int current_health, int attack_points,
			int defense_points ,int spell_power, int mana_pool, int cost, int hit_times, int range, int position_x, int position_y)
	{
		super(name, health_pool, current_health, attack_points,
				defense_points,  position_x,  position_y);
		this.spell_power=spell_power;
		this.mana_pool=mana_pool;
		this.current_mana=this.mana_pool/4;
		this.cost=cost;
		this.hit_times=hit_times;
		this.range=range;
	}
	
	/*
	 * After gaining (50 * level) experience points, the player will level up.
	 * Upon leveling up, the next properties will be updated
	 */
	public void levelUp()
	{
		super.levelUp();
		this.mana_pool=this.mana_pool + (25*this.getLevel());
		this.current_mana=Math.min(this.current_mana + this.mana_pool/4, this.mana_pool);
		this.spell_power=this.spell_power + (10*this.getLevel());
	}
	
	/*
	 * Will be updated when game tick occur
	 */
	public void gameTick()
	{
		this.current_mana=Math.min(this.mana_pool, this.current_mana+1);
	}
	
	/*
	 * Uses Blizzard ability
	 */
	public void useAbility(ArrayList<Enemy> enemies)
	{
		if (this.current_mana<this.cost)
			System.out.println(this.getName()+" tried to cast Blizzard, but mana is not enough - cost is: "+this.cost);
		else
		{
			System.out.println(this.getName()+" cast Blizzard.");
			this.setCurrent_mana(this.current_mana-this.cost);
			int hits=0;
			while (hits<this.hit_times && isEnemyInRange(enemies)==true)
			{
				for (Enemy e : enemies)
				{
					if (e.getTile()=='X')
						continue;
					else
					{
						Range range=new Range(e.getPosition_x(),e.getPosition_y(),this.getPosition_x(),this.getPosition_y());
						if (range.getRange()<this.range)
						{
							System.out.println(this.getName()+" used Blizzard and attacked "+e.getName()+" in spell power "+this.spell_power);
							System.out.println(e.getName()+" defended itself with amount of "+e.getDefense_points()+" defense");
							int damage=this.spell_power-e.getDefense_points();
							if (damage<0)
								damage=0;
							System.out.println(this.getName()+" hit "+e.getName()+" for "+damage+" damage.");
							if(e.getCurrent_health()<=0)
							{
								e.setTile('X');
								System.out.println(e.getName()+" died.");
							}
							hits++;
						}
					}
				}
			}
			
		}
	}
	
	
	/*
	 * Returns true if there is an Enemy within range
	 */
	public boolean isEnemyInRange(ArrayList<Enemy> enemies)
	{
		Range range;
		for (Enemy e: enemies)
		{
			range=new Range(e.getPosition_x(), e.getPosition_y(), this.getPosition_x(), this.getPosition_y());
			if (range.getRange()<this.range)
				return true;
		}
		return false;
	}
	
	
	
	public int getSpell_power() {
		return spell_power;
	}

	public void setSpell_power(int spell_power) {
		this.spell_power = spell_power;
	}

	public int getMana_pool() {
		return mana_pool;
	}

	public void setMana_pool(int mana_pool) {
		this.mana_pool = mana_pool;
	}

	public int getCurrent_mana() {
		return current_mana;
	}

	public void setCurrent_mana(int current_mana) {
		this.current_mana = current_mana;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getHit_times() {
		return hit_times;
	}

	public void setHit_times(int hit_times) {
		this.hit_times = hit_times;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
	
	public String toString()
	{
		return super.toString()+"		SpellPower: "+this.getSpell_power()+"		Mana: "+this.getCurrent_mana()+"/"+this.getMana_pool();
	}

}
