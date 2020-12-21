import java.util.ArrayList;

public abstract class FightEvent implements GameEvent {
	
	private ArrayList<Enemy> enemies;

	public FightEvent(Location location) {
		enemies = new ArrayList<Enemy>();
	}
	
	@Override
	public abstract void doEvent();

	/**
	 * @return the enemies
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * @param enemy the enemies to add
	 */
	public void addEnemy(Enemy enemy) {
		this.enemies.add(enemy);
	}
	
	/**
	 * @param enemy the enemies to remove
	 */
	public void removeEnemy(Enemy enemy) {
		this.enemies.remove(enemy);
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUsesLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
