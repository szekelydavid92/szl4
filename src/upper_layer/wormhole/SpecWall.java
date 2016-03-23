package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitor;
import common.IWorldObject;

/**
 * Õ az, akire portált lehet lõni. Ha egy teleportálható valakivel ütközik,
 * szól a WormHole-nak, hogy át kéne pakolni õt a másik SpecWall elé.
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
