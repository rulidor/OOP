package hw3;

/*
 * Represents a Game Unit
 */
public class GameUnit {
	private String name;
	private int health_pool;
	private int current_health;
	private int attack_points;
	private int defense_points;
	private int position_x;
	private int position_y;
	private char tile;
	
	/*
	 * Constructor for Game Unit
	 */
	public GameUnit(String name, int health_pool, int current_health, int attack_points,
			int defense_points, int position_x, int position_y)
	{
		this.name=name;
		this.health_pool=health_pool;
		this.current_health=current_health;
		this.attack_points=attack_points;
		this.defense_points=defense_points;
		this.position_x=position_x;
		this.position_y=position_y;
		this.tile='?';
	}
	
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth_pool() {
		return health_pool;
	}
	public void setHealth_pool(int health_pool) {
		this.health_pool = health_pool;
	}
	public int getCurrent_health() {
		return current_health;
	}
	public void setCurrent_health(int current_health) {
		this.current_health = current_health;
	}
	public int getAttack_points() {
		return attack_points;
	}
	public void setAttack_points(int attack_points) {
		this.attack_points = attack_points;
	}
	public int getDefense_points() {
		return defense_points;
	}
	public void setDefense_points(int defense_points) {
		this.defense_points = defense_points;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public char getTile() {
		return tile;
	}

	public void setTile(char tile) {
		this.tile = tile;
	}

	//end of getters and setters


	@Override
	public String toString() {
		return "GameUnit [name=" + name + ", health_pool=" + health_pool + ", current_health=" + current_health
				+ ", attack_points=" + attack_points + ", defense_points=" + defense_points + ", position_x="
				+ position_x + ", position_y=" + position_y + ", tile=" + tile + "]";
	}
	
	
	
	
	

}
