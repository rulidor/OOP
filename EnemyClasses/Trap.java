package EnemyClasses;
import java.util.Random;
import hw3.*;

/*
 * Represents a Trap
 */
public class Trap extends Enemy{
	private int relocation_range;
	private int relocation_time;
	private int visibility_time;
	private int ticks_count;
	boolean visible;
	
	public Trap(String name, int health_pool, int current_health, int attack_points,
			int defense_points, int experience, int relocation_range, int relocation_time, int visibility_time,int position_x, int position_y)
	{
		super(name,  health_pool,  current_health,  attack_points,
				 defense_points,  experience, position_x,  position_y);
		this.relocation_range=relocation_range;
		this.relocation_time=relocation_time;
		this.visibility_time=visibility_time;
		this.ticks_count=0;
		this.visible=false;
	}

	/*
	 * Trap method to make a turn.
	 */
	public void makeTurn(Player player, Board board)
	{
		if (this.ticks_count==this.relocation_time)
		{
			this.ticks_count=0;
			Random rand=new Random();
			boolean flag=false;
			while (flag==false)
			{
				int dx=rand.nextInt(2*this.relocation_range +1) - this.relocation_range;
				int dy=rand.nextInt(2*this.relocation_range +1) - this.relocation_range;
				if (this.getPosition_y()+dy<board.getBoard().length && this.getPosition_y()+dy>0)
				{
					if (this.getPosition_x()+dx<board.getBoard()[0].length && this.getPosition_x()+dx>0)
					{
						if (board.getBoard()[this.getPosition_y()+dy][this.getPosition_x()+dx] == '.')
						{
							board.getBoard()[this.getPosition_y()][this.getPosition_x()]='.';
							this.setPosition_x(this.getPosition_x()+dx);
							this.setPosition_y(this.getPosition_y()+dy);
							board.getBoard()[this.getPosition_y()][this.getPosition_x()]=this.getTile();
							flag=true;
						}
					}
				}
			}
		}
		else //ticks count != relocation time
		{
			this.ticks_count++;
			Range range=new Range(this.getPosition_x(),this.getPosition_y(),player.getPosition_x(),player.getPosition_y());
			if (range.getRange()<2)
			{
				/*
				 * ENGAGE IN MELEE
				 */
			}
		}
		
		if (this.ticks_count<this.visibility_time)
			this.visible=true;
		else
			this.visible=false;
	}
	
	
	
	
	public int getRelocation_range() {
		return relocation_range;
	}

	public void setRelocation_range(int relocation_range) {
		this.relocation_range = relocation_range;
	}

	public int getRelocation_time() {
		return relocation_time;
	}

	public void setRelocation_time(int relocation_time) {
		this.relocation_time = relocation_time;
	}

	public int getVisibility_time() {
		return visibility_time;
	}

	public void setVisibility_time(int visibility_time) {
		this.visibility_time = visibility_time;
	}

	public int getTicks_count() {
		return ticks_count;
	}

	public void setTicks_count(int ticks_count) {
		this.ticks_count = ticks_count;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	


}
