package common;

/**
 * Ezt az interface-t implement�lja minden olyan objektum, akinek van poz�ci�ja,
 * van elmozdul�s vektora, amivel el�rel�p minden iter�ci�ban,
 * �s k�pes �tk�zni m�s vil�gbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * 
	 */
	public void setCollisionResponse(CollisionResponse colResp);
}
