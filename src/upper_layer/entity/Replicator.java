package upper_layer.entity;

import common.IChasm;
import common.IReplicator;
import common.IVisitable;
import common.IWorldObject;
import proto.Depth;

public class Replicator extends Player implements IReplicator {
	
	boolean CollidedWithChasm = false;
	
	public Replicator(IWorldObject worldObject, double mass) {
		super(worldObject, mass);
	}
	
	public void projectileKill() {
		isAlive = false;
	}
	
	public void visit(IChasm chasm) {
		CollidedWithChasm = true;
	}

	@Override
	public void notify(IWorldObject obj) {
		super.notify(obj);
		
		if(CollidedWithChasm) {
			obj.markRemovable();
			CollidedWithChasm = false;
		}
	}
}
