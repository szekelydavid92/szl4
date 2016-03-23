package upper_layer.entity;

import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Azon oszt�lyok �r�k�lnek ebb�l az absztrakt oszt�lyb�l, akiknek a p�ld�nyainak
 * van als� r�tegbeli reprezent�ci�ja, minden iter�ci�ban el�rel�pteti az �llapot�t, �s meg�lhet�.
 */
public abstract class Killable implements IKillable, IVisitor, IVisitable, ICollisionObserver {
	/**
	 * Ezzel a f�ggv�nnyel lehet az oszt�ly p�ld�ny�t megsemmis�teni.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ebben a f�ggv�nyben k�pes az objektum k�z�lni az IVisitor-ral, hogy milyen t�pus�.
	 * @param visitor ???????????
	 * @return void
	 */
	public void accept(IVisitor visitor) {}
	
	
	/**
	 * Ezzel nyomja le a m�rleget a j�t�kos ill. a doboz.
	 * @param scale ????????
	 * @return void
	 */
	public void visit(IScale scale) {}
	
	
	/**
	 * Ezen kereszt�l �rtes�l az �tk�z�s bek�vetkezt�r�l.
	 * @param obj ?????????
	 * @return void
	 */
	public abstract void notify(IWorldObject obj);
}
