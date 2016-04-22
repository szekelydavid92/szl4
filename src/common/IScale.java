package common;

/**
 * @brief Ez az interfesz felelos azert, hogy az ot megvalasito objektum lenyomhato legyen.
 */
public interface IScale {
	
	/**
	 * @brief Ezzel a fuggvennyel kepes egy suly lenyomni egy merleget.
	 * 
	 * @return void
	 */
	public void push(double mass);
}
