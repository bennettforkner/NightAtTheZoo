import java.util.ArrayList;

/**
 * FightEvent is the class for GameEvents that involve fights with other Creatures
 * 
 * @author Bennett Forkner
 * @since 12/21/2020
 *
 */
public abstract class FightEvent implements GameEvent {
	
	/**
	 * The enemies that this fight is with
	 */
	private ArrayList<Enemy> enemies;

	/**
	 * The constructor for a FightEvent
	 */
	public FightEvent() {
		enemies = new ArrayList<Enemy>();
	}
	
	@Override
	public void doEvent() {
		
	}

	/**
	 * The method to return the enemies involved in this fight
	 * 
	 * @return the enemies
	 * 
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * The method to add an enemy to this fight
	 * 
	 * @param enemy the enemy to add
	 * 
	 */
	public void addEnemy(Enemy enemy) {
		this.enemies.add(enemy);
	}
	
	/**
	 * The method to remove an enemy from this fight
	 * 
	 * @param enemy the enemy to remove
	 * 
	 */
	public void removeEnemy(Enemy enemy) {
		this.enemies.remove(enemy);
	}

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public int getUsesLeft() {
		return 1;
	}

	
	

}
