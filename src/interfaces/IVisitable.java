package interfaces;

/**
 * A Visitor tervezési minta egyik eleme. Ezen Interface-t implementáló osztály
 * képes egy IVisitor tudomására hozni, hogy õ milyen típusú.
 */
public interface IVisitable {
	/**
	 * Ez a függvény felelõs azért, hogy a paraméterként kapott IVisitor-rel közölje, hogy milyen típusú.
	 * @param visitor Az IVisitor interfészt implementáló objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor);
}
