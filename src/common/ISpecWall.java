package common;

/**
 * Ezt az interface-t a speciális fal implementálja.
 */
public interface ISpecWall extends ICollisionObserver, IVisitable {
	/**
	 * Ezzel a függvénnyel tudja jelezni egy csillagkapu a speciális falnak, hogy õ megnyílik rajta.
	 * @param o Az IStargate interfészt megvalósító objektum.
	 * @return void
	 */
	public void replace(IStargate o);
	
	
	/**
	 * Ezzel a függvénnyel tudja visszaállítani magát a fal, ha a csillagkapu áthelyezõdik.
	 * @return void
	 */
	public void restore();
}
