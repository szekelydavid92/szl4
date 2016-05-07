package common;

/**
 * Ezt az interface-t implementalja a csillagkapu.
 */
public interface IStargate extends IVisitor, ICollisionObserver {
	/**
	 * Ezzel a fuggvennyel nyilik meg a csillagkapu egy specialis falon.
	 * @param wall Egy ISpecWall interfeszt implementalo objektum.
	 * @return void
	 */
	public void mask(ISpecWall wall);
	
	/**
	 * Ez a fuggveny azt a specialis falat, amelyre az IStargate ki van love.
	 * @param 
	 * @return ISpecWall
	 */
	public ISpecWall getMasked();
	
	public Direction getTeleportDirection();
}
