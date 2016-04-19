package upper_layer.wormhole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.Colour;
import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
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
public class Projectile implements ICollisionObserver, IVisitor {
	
	public String name = "projectile";
	public WormHole wormHole;
	public Colour colour;
	//private IVisitable iv; //importot is kivenni
	
	@Override
	public void visit(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		BufferedReader in = ProtoMain.in; //Shortcut
		String line = null;

		Depth.getInstance().printTabs();
		System.out.println("Kerem, adja meg, hogy milyen szinu (sarga vagy kek) portal nyiljon! [s/k]");
		
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("s"))
			wormHole.setYellow(wall);
		if(line.equals("k"))
			wormHole.setBlue(wall);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
	}

	
	@Override
	public void visit(IKillable killable) {
		//Nem h�v�dik meg.
	}

	
	@Override
	public void visit(ICarriable carriable) {
		//Nem h�v�dik meg.
	}
	

	@Override
	public void visit(IZPM zpm) {
		//Nem h�v�dik meg.
	}

	
	@Override
	public void visit(IScale scale) {
		//Nem h�v�dik meg.
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		//Nem h�v�dik meg.
	}
	

	@Override
	public void notify(IWorldObject obj) {
		
		//TODO
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		//obj.getVisitable().accept((IVisitor)this);
		
		IVisitable visitable = obj.getVisitable();
		if(visitable != null)
			visitable.accept(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
		
	}
}
