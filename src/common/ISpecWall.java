package common;

/**
 * Ezt az interface-t a specialis fal implementalja.
 */
public interface ISpecWall extends /*ICollisionObserver,*/ IVisitable {
	/**
	 * Ezzel a fuggvennyel tudja jelezni egy csillagkapu a specialis falnak, hogy o megnyilik rajta.
	 * @param o Az IStargate interfeszt megvalasito objektum.
	 * @return void
	 */
	public void replace(IStargate o);
	
	
	/**
	 * Ezzel a fuggvennyel tudja visszaallitani magat a fal, ha a csillagkapu athelyezodik.
	 * @return void
	 */
	public void restore();
}
