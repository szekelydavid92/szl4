package upper_layer.entity;

import common.IChasm;
import common.IReplicator;
import common.IWorldObject;

public class Replicator extends Player implements IReplicator {

	public Replicator(IWorldObject worldObject, double mass) {
		super(worldObject, mass);
		// TODO Auto-generated constructor stub
	}
	
	public void projectileKill() {
		
	}
	
	public void visit(IChasm chasm) {
		
	}
}
