import java.util.ArrayList;

public abstract class InteractionEvent implements GameEvent {
	
	private ArrayList<Enemy> enemies;

	private String title;
	
	private int usesLeft;

	public InteractionEvent(String title) {
		this(title,1);
	}
	
	public InteractionEvent(String title, int usesLeft) {
		enemies = new ArrayList<Enemy>();
		this.title = title;
		this.usesLeft = usesLeft;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void doEvent() {
		this.usesLeft--;
		if (this.usesLeft == 0) {
			CONTROLLER.GAME.getLocations().remove(this);
		}
	}

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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	

	/**
	 * @return the usesLeft
	 */
	public int getUsesLeft() {
		return usesLeft;
	}

}
