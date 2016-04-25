package upper_layer.wormhole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.CollisionResponse;
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
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;
import proto.ProtoMain;
import upper_layer.Utility;
import upper_layer.entity.Replicator;

/**
 * Lovedek. Amennyiben SpecWall-al utkozik, ott nyit egy WormHole-t.
 */
public class Projectile implements IProjectile, ICollisionObserver, IVisitable, IVisitor {
	
	public String name = "projectile";
	
	/*
	 * Attributumok
	 */
	private Colour colour;
	private WormHole wormHole;
	private Direction direction;
	
	boolean active = true;
	IWorldObject worldObject;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	public Projectile(IWorldObject worldObject,Colour colour,WormHole wormHole)
	{
		this.worldObject = worldObject;
		this.colour = colour;
		this.wormHole = wormHole;
	}
	
	@Override
	public Colour getColour() {
		return colour;
	}
	
	@Override
	public void visit(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		//Scanner in = ProtoMain.in; //Shortcut
		//String line = null;

		//Depth.getInstance().printTabs();
		//System.out.println("Kerem, adja meg, hogy milyen szinu (sarga vagy kek) portal nyiljon! [s/k]");
		
		//line = ProtoMain.in.next();
		System.out.println(direction+";"+Utility.getPair(direction));
		
		if(active) {
			if(colour == Colour.YELLOW) {
				wormHole.setYellow(wall,Utility.getPair(direction));
				//wormHole.setYellowGateDirection(direction);
			}
			if(colour == Colour.BLUE) {
				wormHole.setBlue(wall,Utility.getPair(direction));
				//wormHole.setBlueGateDirection(direction);
			}
			active = false;
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
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
	public void visit(IReplicator replikator) {
		replikator.projectileKill(); 
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
	public void visit(ITeleportable teleportable) {
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
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = obj.getVisitable();
		if(visitable != null) {
			visitable.accept(this);
		}
		
		if(obj.getCollisionResponse() == CollisionResponse.IMMOVABLE) {
			worldObject.markRemovable();
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
		
	}

	@Override
	public void visit(IChasm chasm) {
		// Ures marad, nem tortenik semmi.
		
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction=direction;
	}
	
}
