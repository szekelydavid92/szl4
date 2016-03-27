package common;

/**
 * Az ot implementalo objektum cipelheto lesz.
 */
public interface ICarriable extends IVisitable {
	/**
	 * A cipelheto objektumot cipelo objektum ezen keresztul tudja beallitani a cipelheto objektum poziciojat.
	 * @param x A cipelheto objektum x koordinataja.
	 * @param y A cipelheto objektum y koordinataja.
	 * @return void
	 */
	public void setPos(double x, double y);
	
	
	/**
	 * Itt ertesul a cipelheto objektum, hogy a parameterkent kapott ICarrier interfeszt megvalosito objektum ot cipeli.
	 * @param c Az ICarrier interfeszt megvalosito objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c);
	
	
	/**
	 * A hordozo objektum ezen keresztul ertesiti a cipelheto objektumot, hogy elengedte.
	 * @return void
	 */
	public void release();
}
