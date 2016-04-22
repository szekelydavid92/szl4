package upper_layer.entity;

import common.ICollisionObserver;
import common.IKillable;
import common.IProjectile;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import proto.Depth;

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
	 * Ezzel nyomja le a merleget a jatekos ill. a doboz.
	 * @param scale ????????
	 * @return void
	 */
	@Override
	public void visit(IScale scale){
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".visit()");
		Depth.getInstance().enterFunction();
		
		scale.push(this.mass);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".visit()");
	}
	
	public void visit(IProjectile projectile) {
		
	}
	
	/**
	 * Ezen keresztol ertesul az utkozes bekovetkezterol.
	 * @param obj ?????????
	 * @return void
	 */
	public abstract void notify(IWorldObject obj);
	
	protected Killable(IWorldObject worldObject,double mass) {
		super(worldObject);
		
		worldObject.setVisitable(this);
		worldObject.setCollisionObserver(this);
		
		this.mass = mass;
	}
}
