package interfaces;

/**
 * A Visitor tervez�si minta egyik eleme. Ezen Interface-t implement�l� oszt�ly
 * k�pes egy IVisitor tudom�s�ra hozni, hogy � milyen t�pus�.
 */
public interface IVisitable {
	/**
	 * Ez a f�ggv�ny felel�s az�rt, hogy a param�terk�nt kapott IVisitor-rel k�z�lje, hogy milyen t�pus�.
	 * @param visitor Az IVisitor interf�szt implement�l� objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor);
}
