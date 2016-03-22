package interfaces;

/**
 * Az õt implementáló objektum cipelhetõ lesz.
 */
public interface ICarriable {
	/**
	 * A cipelhetõ objektumot cipelõ objektum ezen keresztül tudja beállítani a cipelhetõ objektum pozícióját.
	 * @param x A cipelhetõ objektum x koordinátája.
	 * @param y A cipelhetõ objektum y koordinátája.
	 * @return void
	 */
	public void setPos(double x, double y);
	
	
	/**
	 * Itt értesül a cipelhetõ objektum, hogy a paraméterként kapott ICarrier interfészt megvalósító objektum õt cipeli.
	 * @param c Az ICarrier interfészt megvalósító objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c);
	
	
	/**
	 * A hordozó objektum ezen keresztül értesíti a cipelhetõ objektumot, hogy elengedte.
	 * @return void
	 */
	public void release();
}
