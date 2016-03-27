package common;

/**
 * A Visitor tervezesi minta egyik eleme. Az implementalo osztaly feladata,
 * hogy a megfelelo visit() fuggvenyenek meghivasa eseten biztositsa
 * a megfelelo tipusu objektummal szemben produkalt viselkedest.
 */
public interface IVisitor {
	/**
	 * Itt valosul meg az ISpecWall-al valo utkozes soran tanusutott viselkedes.
	 * @param wall Az ISpecWall interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(ISpecWall wall);
	
	
	/**
	 * Itt valosul meg az IKillable-el valo utkozes soran tanusitott viselkedes.
	 * @param killable Az IKillable interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(IKillable killable);
	
	
	/**
	 * Itt valosul meg az ICarriable-el valo utkozes soran tanusitott viselkedes.
	 * @param carriable Az ICarriable interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(ICarriable carriable);
	
	
	/**
	 * Itt valosul meg az IZPM-el valo utkozos soran tanusitott viselkedes.
	 * @param zpm Az IZPM interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(IZPM zpm);
	
	
	/**
	 * Itt valosul meg az IScale-el valo utkozes soran tanusitott viselkedes.
	 * @param scale Az IScale interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(IScale scale);
	
	
	/**
	 * Itt valosul meg az ITeleportable-al valo utkozes soran tanusitott viselkedes.
	 * @param teleportable Az ITeleportable interfeszt implementalo objektum.
	 * @return void
	 */
	public void visit(ITeleportable teleportable);
}
