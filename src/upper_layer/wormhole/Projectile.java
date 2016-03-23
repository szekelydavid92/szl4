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
 * � a l�ved�k. Amennyiben SpecWall-al �tk�zik, ott nyit egy WormHole-t.
 */
public class Projectile implements ICollisionObserver, IVisitor {
	@Override
	public void visit(ISpecWall wall) {}

	
	@Override
	public void visit(IKillable killable) {}

	
	@Override
	public void visit(ICarriable carriable) {}
	

	@Override
	public void visit(IZPM zpm) {}

	
	@Override
	public void visit(IScale scale) {}

	
	@Override
	public void visit(ITeleportable teleportable) {}
	

	@Override
	public void notify(IWorldObject obj) {}
}
