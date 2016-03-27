package upper_layer.entity;

import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Azon osztolyok orokolnek ebbol az absztrakt osztalybol, akiknek a peldanyainak
 * van also retegbeli reprezentacioja, minden iteracioban elorelepteti az allapotat, es megolheto.
 */
public abstract class Killable implements IKillable, IVisitor, IVisitable, ICollisionObserver {
	/**
	 * Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ebben a fuggvenyben kepes az objektum kozolni az IVisitor-ral, hogy milyen tipusa.
	 * @param visitor ???????????
	 * @return void
	 */
	public void accept(IVisitor visitor) {}
	
	
	/**
	 * Ezzel nyomja le a merleget a jatekos ill. a doboz.
	 * @param scale ????????
	 * @return void
	 */
	public void visit(IScale scale) {}
	
	
	/**
	 * Ezen keresztol ertesul az utkozes bekovetkezterol.
	 * @param obj ?????????
	 * @return void
	 */
	public abstract void notify(IWorldObject obj);
}
