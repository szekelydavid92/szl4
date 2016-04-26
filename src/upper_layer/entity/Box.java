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
		worldObject.setPosX(x);
		worldObject.setPosY(y);
	}	
	
	/**
	 * @brief Itt ertesul a doboz objektum, hogy a parameterkent kapott ICarrier interface-t megvalosito objektum ot cipeli.
	 * 
	 * @param c ICarrier interfeszt megvalosito objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {	
		carrier=c;
	}
	
	
	/**
	 * @brief A hordozo objektum ezen keresztul ertesiti a doboz objektumot, hogy elengedte.
	 * 
	 * @return void
	 */	
	public void release() {		
		carrier = null;
	}
	
	
	/**
	 * @brief Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * 
	 * @return void
	 */	
	public void kill() {		
		if (carrier != null) {
			carrier.forcedRelease();
		}
		
		carrier=null;
		
		super.kill();
		
	}
	
	
	/**
	 * @brief Ezen keresztul kozli a doboz, hogy o killable es carriable.
	 * 
	 * @param visitor IVisitor interfeszt megvalasito objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {	
		visitor.visit((IKillable)this);
		visitor.visit((ICarriable)this);	
	}
	
	/**
	 * @brief Ha utkozik merleggel, es epp nem cipeli senki, akkor lenyomja.
	 * 
	 * @param o IWorldObject interfeszt megvalosito objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {	
		IVisitable visitable = o.getVisitable();
		
		if(visitable != null)
		{
			visitable.accept((IVisitor)this);
		}
	}
	
	
	/**
	 * Elorelepteti a doboz allapotat az idoben.
	 * @return void
	 */
	public void step() {
		//Nem fut le mert a Player lepteti	
	}
	
	public ICarrier getCarrier() {
		return carrier;
	}

	@Override
	public void setDirection(Direction direction) {
		
	}
	
}
