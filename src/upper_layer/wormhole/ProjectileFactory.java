package upper_layer.wormhole;

import common.Colour;
import common.IProjectileFactory;
import common.IWorldObject;
import common.IWorldObjectFactory;
import skeleton.Depth;

/**
 * Megvalositja az IProjectileFactory Interface-t.
 */
public class ProjectileFactory implements IProjectileFactory {
	
	public String name = "projFactory";
	public IWorldObjectFactory iwof;
	private IWorldObject wo;
	
	@Override
	public void createProjectile(Colour colour, double pX, double pY, double mX, double mY) { //p: player, m: mouse
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".createProjectile(" + colour + "playerX, playerY, dirX, dirY)\n");
		Depth.getInstance().enterFunction();
		
		Projectile p = new Projectile();
		wo = iwof.createObject(12, 12);
		
		wo.setPosX(12);
		wo.setPosY(12);
		wo.setDisplacementX(24);
		wo.setDisplacementY(24);
		wo.setCollisionObserver(p);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".createProjectile()\n");
		
	}
	
}
