package upper_layer.reactive;

import common.ICollisionObserver;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * @brief ZPM. Ket allapota van, felvett es nem felvett. 
 */
public class ZPM extends ReactiveObject implements IZPM/*, ICollisionObserver*/ {

	public String name = "zpm";
	
	/*
	 * Attributumok
	 */
	boolean picked = false;
	
	/*
	 * Metodusok
	 */
	
	public ZPM(IWorldObject worldObject) {
		super(worldObject);
		
		worldObject.setVisitable(this);
	}
	
	/**
	 * @brief az IVisitable interface fuggvenye, ebben kozli a parameterben
	 * kapott visitorrel, hogy o egy zpm.
	 * 
	 * @param visitor a zpm-en muveletet vegzo visitor
	 * @return void
	 */
	@Override
	public void accept(IVisitor visitor) {		
		visitor.visit(this);		
	}

	/**
	 * @brief Ezzel a fuggvennyel lekerdezhetjuk, hogy a ZPM-et felvettek-e.
	 * 
	 * @return bool
	 */
	@Override
	public boolean isPicked() {				
		return picked;
	}

	/**
	 * @brief Ezzel a fuggvennyel jelezzuk, hogy felvettuk a ZPM-et.
	 * 
	 * @return void
	 */
	@Override
	public void pickUp() {		
		picked = true;		
	}

	/*
	@Override
	public void notify(IWorldObject obj) {
		
		/*
		 * Nem hivodik meg. A ZPM nem csinal semmit a vele utkozokkel, ertelmetlen a letezese.
		 * /
		
	}
	*/

}
