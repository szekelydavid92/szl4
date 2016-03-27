package upper_layer.entity;

import common.ICarriable;
import common.ICarrier;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * Ez a doboz. Az ICarrier interfeszt megvalasito objektum kepes oket mozgatni.
 */
public class Box extends Killable implements ICarriable {
	
	ICarrier carrier; //referencia a hordozora
	
	/**
	 * A dobozt cipelo objektum ezen keresztul tudja beallitani a doboz objektum poziciojat.
	 * @param x Az elso parameter az x koordinata.
	 * @param y A masodik parameter az y koordinata.
	 * @return void
	 */
	public void setPos(double x, double y) {}
	
	
	/**
	 * Itt ertesul a doboz objektum, hogy a parameterkent kapott ICarrier interface-t megvalosito objektum ot cipeli.
	 * @param c ICarrier interfeszt megvalosito objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {
		carrier=c;
		//TODO Lorant
	}
	
	
	/**
	 * A hordozo objektum ezen keresztul ertesiti a doboz objektumot, hogy elengedte.
	 * @return void
	 */	
	public void release() {
		carrier=null;
	}
	
	
	/**
	 * Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * @return void
	 */	
	public void kill() {
	}
	
	
	/**
	 * Ezen keresztul kozli a doboz, hogy a killable es carriable.
	 * @param visitor IVisitor interfeszt megvalasito objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {
		/*visitor.visit(this);*/
		//TODO Lorant
	}
	
	
	/**
	 * Ha utkozik merleggel, es epp nem cipeli senki, akkor lenyomja.
	 * @param o IWorldObject interfeszt megvalosito objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {
		//TODO Lorant
	}
	
	
	/**
	 * Elorelepteti a doboz allapotat az idoben.
	 * @return void
	 */
	public void step() {}


	@Override
	public void visit(ISpecWall wall) {
		//TODO Lorant
	}


	@Override
	public void visit(IKillable killable) {
		//TODO Lorant
	}


	@Override
	public void visit(ICarriable carriable) {
		//TODO Lorant
	}


	@Override
	public void visit(IZPM zpm) {
		//TODO Lorant
	}


	@Override
	public void visit(ITeleportable teleportable) {
		//TODO Lorant
	}
}
