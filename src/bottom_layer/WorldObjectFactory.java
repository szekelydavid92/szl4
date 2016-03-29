package bottom_layer;

import common.IWorldObject;
import common.IWorldObjectFactory;
import skeleton.Depth;

/**
 * O hozza letre a WorldObject-et.
 */
public class WorldObjectFactory implements IWorldObjectFactory {
	
	public String name = "worldObjectFactory";
	public World world;
	
	/**
	 * @brief IWorldObject interfeszt megvalosito osztaly peldanyt hoz letre.
	 * 
	 * @param width Letrehozando objektum szelessege.
	 * @param height Letrehozando objektum magassaga.
	 * @return IWorldObject - a letrehozott peldanyra mutato referencia
	 */
	@Override
	public IWorldObject createObject(double width, double height)
	{
		Depth.getInstance().printTabs();
		System.out.print(name + ".createObject()\n");
		Depth.getInstance().enterFunction();
		
		WorldObject worldObject = new WorldObject();
		//world.objects.add(worldObject);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".createObject()\n");
		
		return worldObject;
	}

}
