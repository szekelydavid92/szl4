package upper_layer.reactive;

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
 * Ez a szakadek. Ha utkozott egy IKillable-t megvalosito objektummal, akkor megoli.
 */
public class Chasm implements ICollisionObserver, IVisitor {	
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
