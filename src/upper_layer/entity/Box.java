package upper_layer.entity;

import common.ICarriable;
import common.ICarrier;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * Ez a doboz. Az ICarrier interfeszt megvalasito objektum kepes oket mozgatni.
 */
public class Box extends Killable implements ICarriable {
	
	ICarrier carrier; //referencia a hordozora
	public String name = "Box";
	
	/**
	 * A dobozt cipelo objektum ezen keresztul tudja beallitani a doboz objektum poziciojat.
	 * @param x Az elso parameter az x koordinata.
	 * @param y A masodik parameter az y koordinata.
	 * @return void
	 */
	public void setPos(double x, double y) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".setPos()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".setPos()");
		
	}	
	
	/**
	 * Itt ertesul a doboz objektum, hogy a parameterkent kapott ICarrier interface-t megvalosito objektum ot cipeli.
	 * @param c ICarrier interfeszt megvalosito objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".regCarrier()");
		Depth.getInstance().enterFunction();
		
		carrier=c;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".regCarrier()");
		
		//TODO Lorant
	}
	
	
	/**
	 * A hordozo objektum ezen keresztul ertesiti a doboz objektumot, hogy elengedte.
	 * @return void
	 */	
	public void release() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".release()");
		Depth.getInstance().enterFunction();
		
		carrier=null;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".release()");
	}
	
	
	/**
	 * Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * @return void
	 */	
	public void kill() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".kill()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".kill()");
		
	}
	
	
	/**
	 * Ezen keresztul kozli a doboz, hogy a killable es carriable.
	 * @param visitor IVisitor interfeszt megvalasito objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit((IKillable)this);
		visitor.visit((ICarriable)this);
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()");
		
	}
	
	
	/**
	 * Ha utkozik merleggel, es epp nem cipeli senki, akkor lenyomja.
	 * @param o IWorldObject interfeszt megvalosito objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		//TODO
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()");
	}
	
	
	/**
	 * Elorelepteti a doboz allapotat az idoben.
	 * @return void
	 */
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".step()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".step()");
		
	}

	@Override
	public void visit(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
	}


	@Override
	public void visit(IKillable killable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
	}


	@Override
	public void visit(ICarriable carriable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
	}


	@Override
	public void visit(IZPM zpm) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
	}


	@Override
	public void visit(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()");
		Depth.getInstance().enterFunction();
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()");
	}
}
