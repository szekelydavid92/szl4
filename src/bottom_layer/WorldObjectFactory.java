package bottom_layer;

import common.IWorldObject;
import common.IWorldObjectFactory;

/**
 * @brief O hozza letre a WorldObject-eket.
 */
public class WorldObjectFactory implements IWorldObjectFactory {
	
	public String name = new String( "worldObjectFactory");
	
	/*
	 * Attributumok
	 */
	public World world;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief IWorldObject interfeszt megvalosito osztaly peldanyt hoz letre.
	 * 
	 * @param width Letrehozando objektum szelessege.
	 * @param height Letrehozando objektum magassaga.
	 * @return IWorldObject - a letrehozott peldanyra mutato referencia
	 */
	@Override
	public IWorldObject createObject(double width, double height) {
		WorldObject worldObject = new WorldObject();
		worldObject.setWidth(width);
		worldObject.setHeight(height);
		
		world.addWorldObject(worldObject);
		
		return worldObject;
	}
	
	/**
	 * @brief Konstruktor, megkapja a world objektumot, 
	 * aminek majd palyaelemeket hoz letre.
	 * 
	 * @param world: a world object, amelynek majd
	 * palyaelemeket hoz letre.
	 *
	 * @return void
	 */
	public WorldObjectFactory(World world) {
		this.world = world;
	}
}
