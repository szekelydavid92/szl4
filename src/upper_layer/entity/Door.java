package upper_layer.entity;

import common.IDoor;

/**
 * Õ az ajtó. Két állapota van: nyitott ill. zárt. Ha valaki kinyitja,
 * akkor az alsó rétegbeli reprezentációját áteresztõvé teszi, ha nem, akkor mozdíthatatlanná.
 */
public class Door extends ColEntity implements IDoor {
	@Override
	public void close() {}
	
	@Override
	public void open() {}

	@Override
	public void step() {}
}
