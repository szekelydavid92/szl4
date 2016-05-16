package upper_layer.reactive;

import common.IWorldObject;

/*
 * Itt el kellett terni a specifikaciotol, ez a class nem szerepel benne.
 */

public abstract class ReactiveObject {
	
	/*
	 * Attributumok
	 */
	protected IWorldObject worldObject;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	protected ReactiveObject(IWorldObject worldObject) {
		this.worldObject = worldObject;
	}
	
	public IWorldObject getWorldObject() {
		return worldObject;
	}
}