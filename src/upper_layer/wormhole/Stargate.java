package upper_layer.wormhole;

import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.IStargate;
import common.ITeleportable;
import common.IWorldObject;
import common.IZPM;

/**
 * O a csillagkapu. Ha egy jatekos utkozik vele, atteleportalja a masik csillagkapuhoz.
 */
public class Stargate implements IStargate, ICollisionObserver {
	@Override
	public void visit(ISpecWall wall) {
		//TODO Lorant
	}

	
	@Override
	public void visit(IKillable killable) {
		//TODO Lorant
	}

	
	@Override
	public void visit(ICarriable carriable) {
		//TODO Lorant
	}

	
	@Override
	public void visit(IZPM zpm) {
		//TODO Lorant
	}

	
	@Override
	public void visit(IScale scale) {}

	
	@Override
	public void visit(ITeleportable teleportable) {
		//TODO Lorant
	}

	
	@Override
	public void mask(ISpecWall wall) {
		//TODO Lorant
	}

	
	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
	}

}
