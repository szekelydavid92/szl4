package bottom_layer;

/**
 * Ez az az osztály reprezentálja a virtuális világot. Tartarmaz egy WorldObject tömböt.
 * Fõ feladata, hogy a tömb elemeit léptesse az idõben.
 */
public class World {
	/**
	 * Ütközés ellenõrzés.
	 * @return void
	 */
	public void checkCollision() {};
	
	
	/**
	 * Léptetés megvalósítása.
	 * @param dt ???????????
	 * @return void
	 */
	public void step(double dt) {}
}
