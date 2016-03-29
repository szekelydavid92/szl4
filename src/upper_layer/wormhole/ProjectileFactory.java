package upper_layer.wormhole;

import common.Colour;
import common.IProjectileFactory;
import common.IWorldObjectFactory;
import skeleton.Depth;

/**
 * Megvalositja az IProjectileFactory Interface-t.
 */
public class ProjectileFactory implements IProjectileFactory {
	
	public String name;
	public IWorldObjectFactory iwo;
	
	@Override
	public void createProjectile(Colour colour, double pX, double pY, double mX, double mY) { //p: player, m: mouse
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".createProjectile()\n");
		Depth.getInstance().enterFunction();
		
		iwo.createObject(12, 12);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".createProjectile()\n");
		
	}
	
}
