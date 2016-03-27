package upper_layer.reactive;

import common.ICollisionObserver;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * ZPM. Ket allapota van, felvett es nem felvett. 
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
