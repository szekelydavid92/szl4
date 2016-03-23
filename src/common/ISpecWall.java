package common;

/**
 * Ezt az interface-t a speci�lis fal implement�lja.
 */
public interface ISpecWall extends ICollisionObserver, IVisitable {
	/**
	 * Ezzel a f�ggv�nnyel tudja jelezni egy csillagkapu a speci�lis falnak, hogy � megny�lik rajta.
	 * @param o Az IStargate interf�szt megval�s�t� objektum.
	 * @return void
	 */
	public void replace(IStargate o);
	
	
	/**
	 * Ezzel a f�ggv�nnyel tudja vissza�ll�tani mag�t a fal, ha a csillagkapu �thelyez�dik.
	 * @return void
	 */
	public void restore();
}
