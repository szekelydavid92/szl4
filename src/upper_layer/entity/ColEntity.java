package upper_layer.entity;

import common.IEntity;
import common.IWorldObject;

/**
 * @brief Az Entity interfeszt implementalo absztrakt osztaly, van referenciaja egy IWorldObjectre,
 * belole orokol minden olyan Entity, akinek van also retegbeli reprezentacioja.
 */
public abstract class ColEntity implements IEntity {
	
	protected IWorldObject worldObject;
	
	/**
	 * @brief A ColEntity-bol oroklo objektumok ebben a fuggvenyben leptetik elore az allapotukat az idoben.
	 * @return void
	 */
	public abstract void step();
	
	/*
	 * Itt elterunk a specifikaciotol, getWorldObject fuggvenyunk nem volt.
	 */
	
	public IWorldObject getWorldObject() {
		return worldObject;
	}
	
	protected ColEntity(IWorldObject worldObject) {
		this.worldObject = worldObject;
	}
	
}
