package upper_layer.entity;

import common.IChasm;
import common.IReplicator;
import common.IVisitable;
import common.IWorldObject;
import proto.Depth;
import upper_layer.reactive.Chasm;

public class Replicator extends Player implements IReplicator {
	
	boolean CollidedWithChasm = false;
	
	public Replicator(IWorldObject worldObject, double mass) {
		super(worldObject, null, mass);
	}
	
	public void projectileKill() {
		kill();
		
	}
	
	public void visit(IChasm chasm) {
		CollidedWithChasm = true;
	}

	@Override
	public void notify(IWorldObject obj) {
		super.notify(obj);
		
		if(CollidedWithChasm) {
			Chasm.getInstance().remove(obj);
			obj.markRemovable();
			CollidedWithChasm = false;
		}
	}
}
