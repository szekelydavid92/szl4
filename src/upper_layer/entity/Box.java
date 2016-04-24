package upper_layer.entity;

import common.CollisionResponse;
import common.Direction;
import common.ICarriable;
import common.ICarrier;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;

/**
 * @brief Ez a doboz. Az ICarrier interfeszt megvalasito objektum kepes oket mozgatni.
 */
public class Box extends Killable implements ICarriable {
	
	
	/*
	 * Attributumok
	 */
	ICarrier carrier = null; //referencia a hordozora
	
	/*
	 * Metodusok
	 */
	
	public Box(IWorldObject worldObject,double mass) {
		super(worldObject,mass);
	}
	
	/**
	 * @brief A dobozt cipelo objektum ezen keresztul tudja beallitani a doboz objektum poziciojat.
	 * 
	 * @param x Az elso parameter az x koordinata.
	 * @param y A masodik parameter az y koordinata.
	 * @return void
	 */
	public void setPos(double x, double y) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".setPos()");
		Depth.getInstance().enterFunction();
		
		worldObject.setPosX(x);
		worldObject.setPosY(y);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".setPos()");
		
	}	
	
	/**
	 * @brief Itt ertesul a doboz objektum, hogy a parameterkent kapott ICarrier interface-t megvalosito objektum ot cipeli.
	 * 
	 * @param c ICarrier interfeszt megvalosito objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".regCarrier()");
		Depth.getInstance().enterFunction();
		
		carrier=c;
		worldObject.setCollisionResponse(CollisionResponse.PASS);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".regCarrier()");
	}
	
	
	/**
	 * @brief A hordozo objektum ezen keresztul ertesiti a doboz objektumot, hogy elengedte.
	 * 
	 * @return void
	 */	
	public void release() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".release()");
		Depth.getInstance().enterFunction();
		
		carrier = null;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".release()");
	}
	
	
	/**
	 * @brief Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * 
	 * @return void
	 */	
	public void kill() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".kill()");
		Depth.getInstance().enterFunction();
		
		if (carrier != null)
			carrier.forcedRelease();
		
		carrier=null;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".kill()");
		
	}
	
	
	/**
	 * @brief Ezen keresztul kozli a doboz, hogy o killable es carriable.
	 * @param visitor IVisitor interfeszt megvalasito objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit((IKillable)this);
		//visitor.visit((ICarriable)this);
		visitor.visit((ICarriable)this);
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".accept()");
		
	}
	
	/**
	 * Ha utkozik merleggel, es epp nem cipeli senki, akkor lenyomja.
	 * @param o IWorldObject interfeszt megvalosito objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {
		Depth.getInstance().printTabs();
		System.out.println(name + ".notify()");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = o.getVisitable();
		
		if(visitable != null)
		{
			visitable.accept((IVisitor)this);
		}
						
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".notify()");
	}
	
	
	/**
	 * Elorelepteti a doboz allapotat az idoben.
	 * @return void
	 */
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".step()");
		Depth.getInstance().enterFunction();
		//Nem fut le mert a Player lepteti
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".step()");
		
	}

	@Override
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		
	}
	
}
