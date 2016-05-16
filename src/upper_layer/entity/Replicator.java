package upper_layer.entity;

import common.IChasm;
import common.IKillable;
import common.IReplicator;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import upper_layer.reactive.Chasm;
import upper_layer.wormhole.Projectile;

/**
 * @brief Ez az osztaly valositja meg a replikatort. 
 */
public class Replicator extends Player implements IReplicator {
	
	/*
	 * Attributumok
	 */
	boolean collidedWithChasm = false;
	
	/*
	 * Metodusok
	 */
	public Replicator(IWorldObject worldObject, double mass) {
		super(worldObject, null, mass);
	}
	
	/**
	 * @brief Ezzel a fuggvennyel tudja a projectile megolni a replikatort.
	 * 
	 * @return void
	 */
	@Override
	public void projectileKill() {
		this.kill();
	}
	
	/**
	 * @brief Ezzel a fuggvennyel tud a replikator ertesulni afelol, hogy Chasm-mel utkozott.
	 * 
	 * @param chasm a szakadek, akivel utkozott.
	 * @return void
	 */
	@Override
	public void visit(IChasm chasm) {
		collidedWithChasm = true;
	}
	
	@Override
	public void visit(IZPM zpm) {
		/*
		 * Üres
		 */
	}

	/**
	 * @brief Ezzel a fuggvennyel tudja kozolni egy visitorrel a tipusat.
	 * 
	 * @param visitor a visitor, aki meglatogatja ot.
	 * @return void
	 */
	@Override
	public void accept(IVisitor visitor) {
		super.accept(visitor);
		visitor.visit((IReplicator) this);
	}
	
	/**
	 * @brief Ez a fuggveny ertesiti a replikatort arrol, hogy utkozott valakivel.
	 * 
	 * @param obj a world object, akivel utkozott.
	 */
	@Override
	public void notify(IWorldObject obj) {
		super.notify(obj);
		
		/*
		 * Ha szakadaekkal utkozik, akkor megoli.
		 */
		if(collidedWithChasm) {
			/*
			 * Aucs. A Chasm.getInstance() fuggveny miatt nott a fuggoseg a Reactive package-dzsel.
			 * Ezen javitani kell.
			 */
			Chasm.getInstance().remove(obj);
			obj.markRemovable();
			collidedWithChasm = false;
		}
	}
}
