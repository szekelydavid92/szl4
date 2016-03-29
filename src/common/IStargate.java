package common;

/**
 * Ezt az interface-t implementalja a csillagkapu.
 */
public interface IStargate extends IVisitor, ICollisionObserver /*Ez az extra ősosztály kellett.*/ {
	/**
	 * Ezzel a fuggvennyel nyilik meg a csillagkapu egy specialis falon.
	 * @param wall Egy ISpecWall interfeszt implementalo objektum.
	 * @return void
	 */
	public void mask(ISpecWall wall);
}
