package upper_layer.wormhole;

import common.CollisionResponse;
import common.Colour;
import common.IDrawableFactory;
import common.IProjectileFactory;
import common.IWorldObject;
import common.IWorldObjectFactory;
import view.DrawableColor;

/**
 * Megvalositja az IProjectileFactory Interface-t.
 */
public class ProjectileFactory implements IProjectileFactory {
	
	public String name = "projFactory";
	
	/*
	 * Attributumok
	 */
	private IWorldObjectFactory worldObjectFactory;
	private IDrawableFactory drawableFactory;
	private WormHole wormHole;
	
	private static final double PROJECTILE_SIZE = 10.0;
	public static double PROJECTILE_SPEED = 10.0;
	
	private DrawableColor blueColor;
	private DrawableColor yellowColor;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 * 
	 */
	public ProjectileFactory(IWorldObjectFactory worldObjectFactory,IDrawableFactory drawableFactory,DrawableColor blueColor,DrawableColor yellowColor)
	{
		this.worldObjectFactory = worldObjectFactory;
		this.drawableFactory = drawableFactory;
		
		this.blueColor = blueColor;
		this.yellowColor = yellowColor;
		//this.wormHole = wormHole;
	}
	
	@Override
	public void createProjectile(Colour colour, double posX, double posY, double dirX, double dirY) {
		
		if(wormHole == null)
		{
			wormHole = new WormHole();
			
			drawableFactory.createStargateDrawable(wormHole.yellowGate, yellowColor);
			drawableFactory.createStargateDrawable(wormHole.blueGate, blueColor);
		}
		
		IWorldObject worldObject = worldObjectFactory.createObject(PROJECTILE_SIZE, PROJECTILE_SIZE);
		
		worldObject.setPosX(posX);
		worldObject.setPosY(posY);
		worldObject.setCollisionResponse(CollisionResponse.PASS);
		
		double abs=Math.sqrt((dirX-posX)*(dirX-posX)+(dirY-posY)*(dirY-posY));
		
		double normalizedProjectileDirX;
		double normalizedProjectileDirY;
		if (abs > 1e-4) {
			normalizedProjectileDirX=(dirX-posX)/abs;
			normalizedProjectileDirY=(dirY-posY)/abs;
		}
		else {
			normalizedProjectileDirX=1;
			normalizedProjectileDirY=0;
		}
		
		worldObject.setDisplacementX(PROJECTILE_SPEED*normalizedProjectileDirX);
		worldObject.setDisplacementY(PROJECTILE_SPEED*normalizedProjectileDirY);
		
		Projectile projectile = new Projectile(worldObject,colour,wormHole);
		worldObject.setCollisionObserver(projectile);
		worldObject.setVisitable(projectile);
		
		if(colour == Colour.YELLOW) {
			drawableFactory.createObjectDrawable(worldObject, yellowColor);
		}
		else {
			drawableFactory.createObjectDrawable(worldObject, blueColor);
		}
	}
	
}
