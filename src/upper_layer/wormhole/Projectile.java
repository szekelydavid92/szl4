package upper_layer.wormhole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.Colour;
import common.Direction;
import common.ICarriable;
import common.IChasm;
import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;
import proto.ProtoMain;

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
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	public Projectile(Colour colour,WormHole wormHole)
	{
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
		
		if(colour == Colour.YELLOW) {
			wormHole.setYellow(wall);
		}
		if(colour == Colour.BLUE) {
			wormHole.setBlue(wall);
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
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
		
	}

	@Override
	public void visit(IChasm chasm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		
	}
	
}
