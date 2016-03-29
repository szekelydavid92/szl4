package upper_layer.wormhole;

import common.Colour;
import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.IStargate;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * O a csillagkapu. Ha egy jatekos utkozik vele, atteleportalja a masik csillagkapuhoz.
 */
public class Stargate implements IStargate/*, ICollisionObserver*/ {

	public String name;
	public Colour colour;
	private ISpecWall masked = null;
	
	WormHole wormHole;
	
	Stargate(WormHole wormHole,Colour colour){
		this.wormHole = wormHole;
		this.colour = colour;
	}
	
	@Override
	public void visit(ISpecWall wall) {
		//Nem h�v�dik meg.
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
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		//!!!!!!!!!!!!!!!
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
		//TODO Lorant
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		obj.getVisitable().accept((IVisitor)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
	}

}
