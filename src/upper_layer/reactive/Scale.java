package upper_layer.reactive;

import common.ICollisionObserver;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * � a m�rleg. Ha valaki lenyomja, akkor kinyitja a hozz� tartoz� ajt�t.
 */
public class Scale implements IScale, IVisitable, ICollisionObserver{
	@Override
	public void notify(IWorldObject obj) {}

	@Override
	public void accept(IVisitor visitor) {}

	@Override
	public void push() {}

}
