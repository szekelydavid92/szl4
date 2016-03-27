package upper_layer.reactive;

import common.ICollisionObserver;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * O a merleg. Ha valaki lenyomja, akkor kinyitja a hozza tartozo ajtot.
 */
public class Scale implements IScale, IVisitable, ICollisionObserver{
	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
	}

	@Override
	public void accept(IVisitor visitor) {
		//TODO Lorant
	}

	@Override
	public void push() {}

}
