package common;

/**
 * Ezt az interface-t implement�lja minden olyan objektum, akinek van poz�ci�ja,
 * van elmozdul�s vektora, amivel el�rel�p minden iter�ci�ban,
 * �s k�pes �tk�zni m�s vil�gbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * Ezzel a f�ggv�nnyel lehet be�ll�tani a megval�s�t� objektum �llapot�t, hogy elmozd�that� legyen,
	 * mozd�thatatlan legyen vagy �tereszt� (azaz m�s objektumok kereszt�l tudjanak rajta menni).
	 * @param colResp ???????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp);
	
	
	/**
	 * A vil�gbeli objektum  X koordin�t�j�t �ll�tja be a vil�g koordin�ta rendszer�ben.
	 * @param x ???????????????????????
	 * @return void
	 */
	public void setPosX(double x);
	
	
	/**
	 * A vil�gbeli objektum Y koordin�t�j�t �ll�tja be a vil�g koordin�ta rendszer�ben.
	 * @param y ????????????????????
	 * @return void
	 */
	public void setPosY(double y);
	
	
	/**
	 * Az objektum poz�ci�j�hoz hozz�adja a (dx,dy) vektort.
	 * @param dx ??????????????????
	 * @param dy ???????????????????
	 * @return void
	 */
	public void displace(double dx, double dy);
	
	
	/**
	 * A vil�gbeli objektum X tengely menti poz�ci�j�t adja vissza eredm�ny�l.
	 * @return double
	 */
	public double getPosX();
	
	
	/**
	 * A vil�gbeli objektum Y tengely menti poz�ci�j�t adja vissza eredm�ny�l.
	 * @return double
	 */
	public double getPosY();
	
	
	/**
	 * Az elmozdul�s vektor X komponens�nek be�ll�t�sa.
	 * @param x ?????????????????
	 * @return void
	 */
	public void setDisplacementX(double x);
	
	
	/**
	 * Az elmozdul�s vektor Y komponens�nek be�ll�t�sa.
	 * @param y ??????????????
	 * @return void
	 */
	public void setDisplacementY(double y);
	
	
	/**
	 * A (dx,dy) vektor hozz�ad�sa az elmozdul�s vektorhoz.
	 * @param dx ???????????????
	 * @param dy ???????????????
	 * @return void
	 */
	public void addDisplacement(double dx, double dy);
	
	
	/**
	 * Eredm�ny�l adja az elmozdul�s vektor X ir�ny� �rt�k�t.
	 * @return double
	 */
	public double getDisplacementX();
	
	
	/**
	 * Eredm�ny�l adja az elmozdul�s vektor Y ir�ny� �rt�k�t.
	 * @return double
	 */
	public double getDisplacementY();
	
	
	/**
	 * Be�ll�tja a megval�s�t� objektumra feliratkoz� observert.
	 * @param observer ??????????????????
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer);
	
	
	/**
	 * Visszaadja a vil�gbeli objektum fels� r�tegbeli reprezent�ci�j�nak az IVisitable interf�sz�t,
	 * ha van fels� r�tegbeli reprezent�ci�ja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable();
}
