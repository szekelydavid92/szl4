package upper_layer.entity;

import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Azon osztályok örökölnek ebbõl az absztrakt osztályból, akiknek a példányainak
 * van alsó rétegbeli reprezentációja, minden iterációban elõrelépteti az állapotát, és megölhetõ.
 */
public abstract class Killable implements IKillable, IVisitor, IVisitable, ICollisionObserver {
	/**
	 * Ezzel a függvénnyel lehet az osztály példányát megsemmisíteni.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ebben a függvényben képes az objektum közölni az IVisitor-ral, hogy milyen típusú.
	 * @param visitor ???????????
	 * @return void
	 */
	public void accept(IVisitor visitor) {}
	
	
	/**
	 * Ezzel nyomja le a mérleget a játékos ill. a doboz.
	 * @param scale ????????
	 * @return void
	 */
	public void visit(IScale scale) {}
	
	
	/**
	 * Ezen keresztül értesül az ütközés bekövetkeztérõl.
	 * @param obj ?????????
	 * @return void
	 */
	public abstract void notify(IWorldObject obj);
}
