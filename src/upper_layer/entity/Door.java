package upper_layer.entity;

import common.IDoor;

/**
 * O az ajto. Ket allapota van: nyitott ill. zart. Ha valaki kinyitja,
 * akkor az also retegbeli reprezentaciojat ateresztove teszi, ha nem, akkor mozdithatatlanna.
 */
public class Door extends ColEntity implements IDoor {
	private boolean opened;
	
	@Override
	public void close() {
		opened = false;
	}
	
	@Override
	public void open() {
		opened = true;
	}

	@Override
	public void step() {}
}
