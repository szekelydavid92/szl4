package upper_layer.wormhole;

import common.Colour;
import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IScale;
import common.ISpecWall;
import common.IStargate;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;

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
			wormHole.teleportToYellow(teleportable);
		}
		if(colour == Colour.YELLOW) {
			wormHole.teleportToBlue(teleportable);
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
		if(masked != null)
			masked.restore();
		
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
			visitable.accept((IVisitor)this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
	}
	
}
