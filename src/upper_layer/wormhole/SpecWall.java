package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitor;
import common.IWorldObject;

/**
 * Ez az, akire portalt lehet loni. Ha egy teleportalhato valakivel utkozik,
 * szol a WormHole-nak, hogy ot kene pakolni ot a masik SpecWall elo.
 */
public class SpecWall implements ISpecWall {
	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
	}

	
	@Override
	public void accept(IVisitor visitor) {
		//TODO Lorant
	}

	
	@Override
	public void replace(IStargate o) {
		//TODO Lorant
	}

	
	@Override
	public void restore() {}

}
