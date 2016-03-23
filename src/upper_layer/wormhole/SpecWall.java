package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitor;
import common.IWorldObject;

/**
 * � az, akire port�lt lehet l�ni. Ha egy teleport�lhat� valakivel �tk�zik,
 * sz�l a WormHole-nak, hogy �t k�ne pakolni �t a m�sik SpecWall el�.
 */
public class SpecWall implements ISpecWall {
	@Override
	public void notify(IWorldObject obj) {}

	
	@Override
	public void accept(IVisitor visitor) {}

	
	@Override
	public void replace(IStargate o) {}

	
	@Override
	public void restore() {}

}
