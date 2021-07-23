package hw3;
import EnemyClasses.*;
import PlayerClasses.*;
import java.util.Random;

public class Combat {
	
	public void combat(GameUnit attacker, GameUnit defender)
	{
		
		System.out.println(attacker.getName()+" engaged in battle with "+defender.getName()+":");
		System.out.println(attacker);
		System.out.println(defender);
		Random rand=new Random();
		int attack=rand.nextInt(attacker.getAttack_points()+1);
		int defense=rand.nextInt(defender.getDefense_points()+1);
		System.out.println(attacker.getName()+" rolled "+attack+" attack points.");
		System.out.println(defender.getName()+" rolled "+defense+" defense points.");
		if (attack>defense)
		{
			defender.setCurrent_health(defender.getCurrent_health()- (attack-defense) );
			System.out.println(attacker.getName()+" hit "+defender.getName()+" for "+(attack-defense)+" damage.");
		}
		else
		{
			System.out.println(attacker.getName()+" hit "+defender.getName()+" for "+0+" damage.");
		}
		if (defender.getCurrent_health()<=0)
		{
			if (attacker.getTile()=='@') //attacker is Player
			{
				((Player)attacker).setExperience(((Player)attacker).getExperience()+((Enemy)defender).getExperience());
				if (((Player)attacker).getExperience()  >=  50*( ((Player)attacker).getLevel()))
				{
					((Player)attacker).levelUp();
				}
				
				
				//don't forget - now should REMOVE the Enemy from the game!
			}
			else //attacker is an Enemy
			{
				defender.setTile('X');
				//now game should be OVER!
			}
		}
	}
}
