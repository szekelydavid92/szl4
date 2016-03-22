package interfaces;

/**
 * A Visitor tervez�si minta egyik eleme. Az implement�l� oszt�ly feladata,
 * hogy a megfelel� visit() f�ggv�ny�nek megh�v�sa eset�n biztos�tsa
 * a megfelel� t�pus� objektummal szemben produk�lt viselked�st.
 */
public interface IVisitor {
	/**
	 * Itt val�sul meg az ISpecWall-al val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param wall Az ISpecWall interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(ISpecWall wall);
	
	
	/**
	 * Itt val�sul meg az IKillable-el val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param killable Az IKillable interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(IKillable killable);
	
	
	/**
	 * Itt val�sul meg az ICarriable-el val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param carriable Az ICarriable interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(ICarriable carriable);
	
	
	/**
	 * Itt val�sul meg az IZPM-el val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param zpm Az IZPM interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(IZPM zpm);
	
	
	/**
	 * Itt val�sul meg az IScale-el val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param scale Az IScale interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(IScale scale);
	
	
	/**
	 * Itt val�sul meg az ITeleportable-al val� �tk�z�s sor�n tan�s�tott viselked�s.
	 * @param teleportable Az ITeleportable interf�szt implement�l� objektum.
	 * @return void
	 */
	public void visit(ITeleportable teleportable);
}
