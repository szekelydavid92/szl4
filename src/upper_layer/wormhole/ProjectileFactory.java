package upper_layer.wormhole;

import common.CollisionResponse;
import common.Colour;
import common.IProjectileFactory;
import common.IWorldObject;
import common.IWorldObjectFactory;
import proto.Depth;

/**
 * Megvalositja az IProjectileFactory Interface-t.
 */
public class ProjectileFactory implements IProjectileFactory {
	
	public String name = "projFactory";
	
	/*
	 * Attributumok
	 */
	private IWorldObjectFactory worldObjectFactory;
	private WormHole wormHole;
	
	private static final double PROJECTILE_SIZE = 12.0;
	private static final double PROJECTILE_SPEED = 10.0;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	public ProjectileFactory(IWorldObjectFactory worldObjectFactory,WormHole wormHole)
	{
		this.worldObjectFactory = worldObjectFactory;
		this.wormHole = wormHole;
	}
	
	@Override
	public void createProjectile(Colour colour, double posX, double posY, double dirX, double dirY) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".createProjectile(" + colour + ",playerX, playerY, dirX, dirY)\n");
		Depth.getInstance().enterFunction();
		
		IWorldObject worldObject = worldObjectFactory.createObject(PROJECTILE_SIZE, PROJECTILE_SIZE);
		
		worldObject.setPosX(posX);
		worldObject.setPosY(posY);
		worldObject.setCollisionResponse(CollisionResponse.PASS);
		
		double abs=Math.sqrt((dirX-posX)*(dirX-posX)+(dirY-posY)*(dirY-posY));
		double normalizedProjectileDirX=(dirX-posX)/abs;
		double normalizedProjectileDirY=(dirY-posY)/abs;
		
		worldObject.setDisplacementX(PROJECTILE_SPEED*normalizedProjectileDirX);
		worldObject.setDisplacementY(PROJECTILE_SPEED*normalizedProjectileDirY);
		
		Projectile projectile = new Projectile(colour,wormHole);
		worldObject.setCollisionObserver(projectile);
		worldObject.setVisitable(projectile);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".createProjectile()\n");
		
	}
	
}
