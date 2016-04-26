package upper_layer.reactive;

import common.ICollisionObserver;
import common.IDoor;
import common.IEntity;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import upper_layer.entity.Door;
import upper_layer.entity.Killable;

/*
 * Elteres a specifikaciotol: nem implementalja az ICollisionObservert.
 */

/**
 * @brief O a merleg. Ha valaki lenyomja, akkor kinyitja a hozza tartozo ajtot.
 */
public class Scale extends ReactiveObject implements IScale, IVisitable, /*ICollisionObserver,*/ IEntity{
	
	public String name = "scale";
	
	/*
	 * Attributumok
	 */
	
	public IDoor door = null; 		//Ez az ajtó, akit ő kinyit, ha lenyomják.
	double accumulatedMass = 0; 	//Ez a rá nehezedő összes súly.
	double massThreshold; 			//ha a rá nehezedő súly nagyobb ennél, akkor a mérleg kinyitja az ajtót.
	
	/*
	 * Ideiglenesen a proto erejeig.
	 */
	public boolean isPushed;
	public double massToPrint; // majd toroljuk , kiirashoz kell
	
	/*
	 * Metodusok
	 */
	
	public double getMassThreshold() {
		return massThreshold;
	}
	
	public double getAccumulatedMass() {
		return accumulatedMass;
	}
	
	public Scale(IWorldObject worldObject,double massThreshold) {
		super(worldObject);
		
		//worldObject.setCollisionObserver(this);
		worldObject.setVisitable(this);
		this.massThreshold = massThreshold;
	}
	/*
	@Override
	public void notify(IWorldObject obj) {
		
		/*
		 * Nem lesz lehivva, ertelmetlen a letezese. A merleg nem csinal semmit a vele utkozokkel.
		 * /
	}
	*/
	/**
	 * @brief az IVisitable interface fuggvenye, ebben kozli a parameterben
	 * kapott visitorrel a tipusat.
	 * 
	 * @param visitor az ajton muveletet vegzo visitor
	 * @return void
	 */
	@Override
	public void accept(IVisitor visitor) {		
		visitor.visit(this);
	}
	
	/**
	 * @brief Ezzel a fuggvennyel kepes egy suly lenyomni egy merleget, es
	 * kinyitni a hozza tartozo ajtot.
	 * 
	 * @return void
	 */
	@Override
	public void push(double mass) {		
		this.accumulatedMass += mass;
		
		if(this.massThreshold <= this.accumulatedMass){
			if(door != null) {
				door.open();
			}
		}
	}

	@Override
	public void step() {
		/*
		 * TMP A proto erejeig
		 */
		this.massToPrint=this.accumulatedMass;
		if (this.accumulatedMass >= this.massThreshold) {
			isPushed=true;
		}
		else {
			isPushed=false;
		}
		
		/*
		 * TMP vege
		 */
		this.accumulatedMass = 0.0;
	}

	public void setDoor(Door door) {
		this.door = door;
	}

}
