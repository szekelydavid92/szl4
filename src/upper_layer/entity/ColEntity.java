package upper_layer.entity;

import common.IEntity;

/**
 * Az Entity interfészt implementáló absztrakt osztály, van referenciája egy IWorldObjectre,
 * belõle örököl minden olyan Entity, akinek van alsó rétegbeli reprezentációja.
 */
public abstract class ColEntity implements IEntity {
	/**
	 * A ColEntity-bõl öröklõ objektumok ebben a függvényben léptetik elõre az állapotukat az idõben.
	 * @return void
	 */
	public abstract void step();
}
