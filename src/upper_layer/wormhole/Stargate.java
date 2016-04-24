package upper_layer.wormhole;

import common.Colour;
import common.Direction;
import common.ICarriable;
import common.IChasm;
import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IReplicator;
import common.IScale;
import common.ISpecWall;
import common.IStargate;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;
import upper_layer.Utility;


/**
 * O a csillagkapu. Ha egy jatekos utkozik vele, atteleportalja a masik csillagkapuhoz.
 */
public class Stargate implements IStargate{

	public String name;
	
	/*
	 * Attributumok
	 */
	public Colour colour;
	WormHole wormHole;
	
	private ISpecWall masked = null;
	private Direction direction;
	private Direction teleportDirection;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	Stargate(Colour colour,WormHole wormHole) {
		this.colour = colour;
		this.wormHole = wormHole;
	}
	
	@Override 
	public ISpecWall getMasked() {
		return masked;
	}
	
	@Override
	public void visit(ISpecWall wall) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	
	@Override
	public void visit(IKillable killable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	
	@Override
	public void visit(ICarriable carriable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	
	@Override
	public void visit(IZPM zpm) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	
	@Override
	public void visit(IScale scale) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	@Override
	public void visit(IProjectile projectile) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		if(colour == Colour.BLUE) {
			//if (teleportable.getDirection() == Utility.getPair(this.teleportDirection)) {
			if (direction == this.teleportDirection) {
				wormHole.teleportToYellow(teleportable);
			}	
		}
		if(colour == Colour.YELLOW) {
			//if (teleportable.getDirection() == Utility.getPair(this.teleportDirection)) {
			if (direction == this.teleportDirection) {
				wormHole.teleportToBlue(teleportable);
			}
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		
	}

	
	@Override
	public void mask(ISpecWall wall) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".mask()\n");
		Depth.getInstance().enterFunction();
		
		//!!!!!!!!!!!!!!!!!!!!!!lorant
		if(masked != null) {
			masked.restore();
		}
		
		masked = wall;
		wall.replace(this);
		//wall.obj.setCollisionObserver(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".mask()\n");
	}

	
	@Override
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = obj.getVisitable();
		
		if(visitable != null) {
			visitable.accept(this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
	}

	@Override
	public void visit(IChasm chasm) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visit(IReplicator replikator) {
		
	}

	@Override
	public void setDirection(Direction dir) {
		direction=dir;
		
	}

	public void setTeleportDirection(Direction teleportDirection) {
		this.teleportDirection=teleportDirection;
	}
}