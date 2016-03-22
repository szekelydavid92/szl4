package interfaces;

/**
 * A Visitor tervezési minta egyik eleme. Az implementáló osztály feladata,
 * hogy a megfelelõ visit() függvényének meghívása esetén biztosítsa
 * a megfelelõ típusú objektummal szemben produkált viselkedést.
 */
public interface IVisitor {
	/**
	 * Itt valósul meg az ISpecWall-al való ütközés során tanúsított viselkedés.
	 * @param wall Az ISpecWall interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(ISpecWall wall);
	
	
	/**
	 * Itt valósul meg az IKillable-el való ütközés során tanúsított viselkedés.
	 * @param killable Az IKillable interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(IKillable killable);
	
	
	/**
	 * Itt valósul meg az ICarriable-el való ütközés során tanúsított viselkedés.
	 * @param carriable Az ICarriable interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(ICarriable carriable);
	
	
	/**
	 * Itt valósul meg az IZPM-el való ütközés során tanúsított viselkedés.
	 * @param zpm Az IZPM interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(IZPM zpm);
	
	
	/**
	 * Itt valósul meg az IScale-el való ütközés során tanúsított viselkedés.
	 * @param scale Az IScale interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(IScale scale);
	
	
	/**
	 * Itt valósul meg az ITeleportable-al való ütközés során tanúsított viselkedés.
	 * @param teleportable Az ITeleportable interfészt implementáló objektum.
	 * @return void
	 */
	public void visit(ITeleportable teleportable);
}
