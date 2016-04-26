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
	
	/**
	 * @brief Visszaadja a falat, amin a csillagkapu van.
	 * 
	 * @param 
	 * @return ISpecWall: a speciális fal, amin van a csillagkapu.
	 */
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

	/**
	 * @brief Ha meglatogat egy teleportalhato objektumot,
	 * szol a WormHole-nak, hogy teleportalja el.
	 * 
	 * @param teleportable:a teleportalando objektum
	 * @return void
	 */
	@Override
	public void visit(ITeleportable teleportable) {
		//System.out.println(direction + ";" + this.teleportDirection);
		
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
	}

	/**
	 * @brief Beallitja a csillagkapuhoz tartozo specialis falat,
	 * azaz amin o eppen van.
	 * 
	 * @param wall: a specialis fal, amit beallitunk.
	 * @return void
	 */
	@Override
	public void mask(ISpecWall wall) {
	
		if(masked != null) {
			masked.restore();
		}
		
		masked = wall;
		wall.replace(this);
		//wall.obj.setCollisionObserver(this);
	}

	
	@Override
	public void notify(IWorldObject obj) {
		IVisitable visitable = obj.getVisitable();
		
		if(visitable != null) {
			visitable.accept(this);
		}
	}

	@Override
	public void visit(IChasm chasm) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void visit(IReplicator replikator) {
		
	}
	
	/**
	 * @brief Beallitja az iranyt, hogy a fal melyik oldalan van o.
	 * 
	 * @param dir: az irany.
	 * @return void
	 */
	@Override
	public void setDirection(Direction dir) {
		direction=dir;
		
	}
	
	/**
	 * @brief Beallitja, melyik irany fele teleportalon.
	 * 
	 * @param teleportDirection: az irany amely fele teleportal
	 * @return void
	 */
	public void setTeleportDirection(Direction teleportDirection) {
		this.teleportDirection=teleportDirection;
	}
}