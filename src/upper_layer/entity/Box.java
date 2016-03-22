package upper_layer.entity;

import interfaces.ICarriable;
import interfaces.ICarrier;
import interfaces.IVisitor;
import interfaces.IWorldObject;

/**
 * � a doboz. Az ICarrier interf�szt megval�s�t� objektum k�pes �ket mozgatni.
 */
public class Box extends Killable implements ICarriable {
	/**
	 * A dobozt cipel� objektum ezen kereszt�l tudja be�ll�tani a doboz objektum poz�ci�j�t.
	 * @param x Az els� param�ter az x koordin�ta.
	 * @param y A m�sodik param�ter az y koordin�ta.
	 * @return void
	 */
	public void setPos(double x, double y) {}
	
	
	/**
	 * Itt �rtes�l a doboz objektum, hogy a param�terk�nt kapott ICarrier interface-t megval�s�t� objektum �t cipeli.
	 * @param c ICarrier interf�szt megval�s�t� objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {}
	
	
	/**
	 * A hordoz� objektum ezen kereszt�l �rtes�ti a doboz objektumot, hogy elengedte.
	 * @return void
	 */	
	public void release() {}
	
	
	/**
	 * Ezzel a f�ggv�nnyel lehet az oszt�ly p�ld�ny�t megsemmis�teni.
	 * @return void
	 */	
	public void kill() {}
	
	
	/**
	 * Ezen kereszt�l k�zli a doboz, hogy � killable �s carriable.
	 * @param visitor IVisitor interf�szt megval�s�t� objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {}
	
	
	/**
	 * Ha �tk�zik m�rleggel, �s �pp nem cipeli senki, akkor lenyomja.
	 * @param o IWorldObject interf�szt megval�s�t� objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {}
	
	
	/**
	 * El�rel�pteti a doboz �llapot�t az id�ben.
	 * @return void
	 */
	public void step() {}
}
