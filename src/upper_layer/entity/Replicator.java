package upper_layer.entity;

import common.IChasm;
import common.IKillable;
import common.IReplicator;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import proto.Depth;
import upper_layer.reactive.Chasm;
import upper_layer.wormhole.Projectile;

public class Replicator extends Player implements IReplicator {
	
	boolean CollidedWithChasm = false;
	
	public Replicator(IWorldObject worldObject, double mass) {
		super(worldObject, null, mass);
	}
	
	public void projectileKill() {
		this.kill();
		
	}
	
	public void visit(IChasm chasm) {
		CollidedWithChasm = true;
	}
	
	@Override
	public void accept(IVisitor visitor) {
		super.accept(visitor);
		visitor.visit((IReplicator) this);
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
