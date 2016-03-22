package interfaces;

/**
 * Ezen interface-t azon oszt�lyok implement�lj�k, akik �rtes�lni akarnak arr�l, hogy az id� telik,
 * azaz el�re akarj�k l�ptetni az �llapotukat minden ciklusban.
 */
public interface IEntity {
	/**
	 * Ez az a f�ggv�ny, amelyet a GameLoop minden ciklusban leh�v.
	 * Ebben a met�dusban l�ptetik el�re az objektumok az �llapotukat az id� f�ggv�ny�ben.
	 * @return void
	 */
	public void step();
}
