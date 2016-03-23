package upper_layer.reactive;

import common.ICollisionObserver;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * Õ a ZPM. Két állapota van, felvett és nem felvett. 
 */
public class ZPM implements IZPM, ICollisionObserver {
	@Override
	public void accept(IVisitor visitor) {}

	
	@Override
	public boolean isPicked() {return true;}

	
	@Override
	public void pickUp() {}

	
	@Override
	public void notify(IWorldObject obj) {}

}
