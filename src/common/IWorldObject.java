package common;

/**
 * Ezt az interface-t implementálja minden olyan objektum, akinek van pozíciója,
 * van elmozdulás vektora, amivel elõrelép minden iterációban,
 * és képes ütközni más világbeli objektummal.
 */
public interface IWorldObject {
	/**
	 * 
	 */
	public void setCollisionResponse(CollisionResponse colResp);
}
