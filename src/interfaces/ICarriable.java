package interfaces;

/**
 * Az �t implement�l� objektum cipelhet� lesz.
 */
public interface ICarriable {
	/**
	 * A cipelhet� objektumot cipel� objektum ezen kereszt�l tudja be�ll�tani a cipelhet� objektum poz�ci�j�t.
	 * @param x A cipelhet� objektum x koordin�t�ja.
	 * @param y A cipelhet� objektum y koordin�t�ja.
	 * @return void
	 */
	public void setPos(double x, double y);
	
	
	/**
	 * Itt �rtes�l a cipelhet� objektum, hogy a param�terk�nt kapott ICarrier interf�szt megval�s�t� objektum �t cipeli.
	 * @param c Az ICarrier interf�szt megval�s�t� objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c);
	
	
	/**
	 * A hordoz� objektum ezen kereszt�l �rtes�ti a cipelhet� objektumot, hogy elengedte.
	 * @return void
	 */
	public void release();
}
