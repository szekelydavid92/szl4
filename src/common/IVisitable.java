package common;

/**
 * A Visitor tervezesi minta egyik eleme. Ezen Interface-t implementalo osztaly
 * kepes egy IVisitor tudomasara hozni, hogy o milyen tipusa.
 */
public interface IVisitable {
	/**
	 * Ez a fuggveny felelos azert, hogy a parameterkent kapott IVisitor-rel kozolje, hogy milyen tipusu.
	 * @param visitor Az IVisitor interfeszt implementalo objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor);
}
