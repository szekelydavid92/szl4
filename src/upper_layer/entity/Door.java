package upper_layer.entity;

import common.IDoor;

/**
 * � az ajt�. K�t �llapota van: nyitott ill. z�rt. Ha valaki kinyitja,
 * akkor az als� r�tegbeli reprezent�ci�j�t �tereszt�v� teszi, ha nem, akkor mozd�thatatlann�.
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
