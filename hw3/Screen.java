package hw3;
import EnemyClasses.*;
import PlayerClasses.*;

public class Screen {
	
	public void openMenu()
	{
		System.out.println("Select player:\r\n" + 
				"1. Jon Snow		Health: 300		Attack damage: 30		Defense: 4\r\n" + 
				"		Level: 1		Experience: 0/50		Ability cooldown: 6		Remaining: 0\r\n" + 
				"2. The Hound		Health: 400		Attack damage: 20		Defense: 6\r\n" + 
				"		Level: 1		Experience: 0/50		Ability cooldown: 4		Remaining: 0\r\n" + 
				"3. Melisandre		Health: 160		Attack damage: 10		Defense: 1\r\n" + 
				"		Level: 1		Experience: 0/50		SpellPower: 15		Mana: 75/300\r\n" + 
				"4. Thoros of Myr		Health: 250		Attack damage: 25		Defense: 3\r\n" + 
				"		Level: 1		Experience: 0/50		SpellPower: 20		Mana: 37/150\r\n" + 
				"5. Arya Stark		Health: 150		Attack damage: 40		Defense: 2\r\n" + 
				"		Level: 1		Experience: 0/50		Energy: 100/100\r\n" + 
				"6. Bronn		Health: 250		Attack damage: 35		Defense: 3\r\n" + 
				"		Level: 1		Experience: 0/50		Energy: 100/100");
	}

}
