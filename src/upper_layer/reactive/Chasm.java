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
 * � a szakad�k. Ha �tk�z�tt egy IKillable-t megval�s�t� objektummal, akkor meg�li.
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
