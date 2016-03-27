package upper_layer.wormhole;

import common.ICarriable;
import common.ICollisionObserver;
import common.IKillable;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * Lovedek. Amennyiben SpecWall-al utkozik, ott nyit egy WormHole-t.
 */
public class Projectile implements ICollisionObserver, IVisitor {
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
	public void visit(IScale scale) {
		//TODO Lorant
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		//TODO Lorant
	}
	

	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
	}
}
