package upper_layer.entity;

import common.IEntity;

/**
 * Az Entity interfeszt implementalo absztrakt osztaly, van referenciaja egy IWorldObjectre,
 * belole orokol minden olyan Entity, akinek van also retegbeli reprezentacioja.
 */
public abstract class ColEntity implements IEntity {
	/**
	 * A ColEntity-bol oroklo objektumok ebben a fuggvenyben leptetik elore az allapotukat az idoben.
	 * @return void
	 */
	public abstract void step();
}
