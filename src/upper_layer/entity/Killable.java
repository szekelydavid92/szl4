package upper_layer.entity;

import common.Direction;
import common.ICarriable;
import common.IChasm;
import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IReplicator;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * Azon osztolyok orokolnek ebbol az absztrakt osztalybol, akiknek a peldanyainak
 * van also retegbeli reprezentacioja, minden iteracioban elorelepteti az allapotat, es megolheto.
 */
public abstract class Killable extends ColEntity implements IKillable, IVisitor, IVisitable, ICollisionObserver {

	public String name = "Killable";
	
	/*
	 * Attributumok
	 */
	
	protected boolean isAlive = true; 	//Itt tárolódik az, hogy az adott objektum él-e.
	protected double mass;  		//Az objektum tömege, amivel lenyomja a mérleget.
	
	/**
	 * Ezzel a fuggvennyel lehet az osztaly peldanyat megsemmisiteni.
	 * @return void
	 */
	public void kill() {
		isAlive = false;
		worldObject.markRemovable();
	}
	
	@Override
	public void setDirection(Direction direction) {
		
	}
	
	@Override
	public void visit(IChasm chasm) {
		/*
		 * Nem torodunk az esettel.
		 */
		
	}
	/**
	 * Ebben a fuggvenyben kepes az objektum kozolni az IVisitor-ral, hogy milyen tipusa.
	 * @param visitor ???????????
	 * @return void
	 */
	public void accept(IVisitor visitor) {
		visitor.visit((IKillable) this);
	}
	
	/**
	 * @brief Itt kérdezzük le az objektumunk tömegét.
	 * @return double
	 */
	public double getMass() {
		return mass;
	}
	
	public boolean isKilled() {
		return !isAlive;
	}
	
	/**
	 * Ezzel nyomja le a merleget a jatekos ill. a doboz.
	 * @param scale ????????
	 * @return void
	 */
	@Override
	public void visit(IScale scale){		
		scale.push(this.mass);
	}
	
	public void visit(IProjectile projectile) {
		/*
		 * Nem torodunk az esettel.
		 */
	}

	@Override
	public void visit(ISpecWall wall) {
		/*
		 * Nem torodunk az esettel.
		 */
	}


	@Override
	public void visit(IKillable killable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}


	@Override
	public void visit(ICarriable carriable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}


	@Override
	public void visit(IZPM zpm) {
		/*
		 * Nem torodunk az esettel.
		 */
	}


	@Override
	public void visit(ITeleportable teleportable) {
		/*
		 * Nem torodunk az esettel.
		 */
	}
	
	@Override
	public void visit(IReplicator replikator) {
		/*
		 * Nem torodunk az esettel.
		 */
	}
	
	/**
	 * @brief Ez a fuggveny ertesiti a replikatort arrol, hogy utkozott valakivel.
	 * 
	 * @param obj a world object, akivel utkozott.
	 */
	public abstract void notify(IWorldObject obj);
	
	protected Killable(IWorldObject worldObject,double mass) {
		super(worldObject);
		
		worldObject.setVisitable(this);
		worldObject.setCollisionObserver(this);
		
		this.mass = mass;
	}
}
