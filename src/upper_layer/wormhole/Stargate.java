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
 * � a csillagkapu. Ha egy j�t�kos �tk�zik vele, �tteleport�lja a m�sik csillagkapuhoz.
 */
public class Stargate implements IStargate, ICollisionObserver {
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
	public void mask(ISpecWall wall) {}

	
	@Override
	public void notify(IWorldObject obj) {}

}
