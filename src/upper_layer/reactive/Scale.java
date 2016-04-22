package upper_layer.reactive;

import common.ICollisionObserver;
import common.IDoor;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import proto.Depth;

/**
 * @brief O a merleg. Ha valaki lenyomja, akkor kinyitja a hozza tartozo ajtot.
 */
public class Scale implements IScale, IVisitable, ICollisionObserver{
	
	public String name = "scale";

	public IDoor door; 				//Ez az ajtó, akit ő kinyit, ha lenyomják.
	double accumulatedMass = 0; 	//Ez a rá nehezedő összes súly.
	double massThreshold = 1; 		//ha a rá nehezedő súly nagyobb ennél, akkor a mérleg kinyitja az ajtót.

	
	@Override
	public void notify(IWorldObject obj) {
		
		/*
		 * Nem lesz lehivva, ertelmetlen a letezese. A merleg nem csinal semmit a vele utkozokkel.
		 */
	}
	
	/**
	 * @brief az IVisitable interface fuggvenye, ebben kozli a parameterben
	 * kapott visitorrel a tipusat.
	 * 
	 * @param visitor az ajton muveletet vegzo visitor
	 * @return void
	 */
	@Override
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".accept()");
		
		//TODO Lorant
	}
	
	/**
	 * @brief Ezzel a fuggvennyel kepes egy suly lenyomni egy merleget, es
	 * kinyitni a hozza tartozo ajtot.
	 * 
	 * @return void
	 */
	@Override
	public void push(double mass) {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".push()");
		Depth.getInstance().enterFunction();
		
		this.accumulatedMass++;
		
		if(this.massThreshold <= this.accumulatedMass){
			door.open();
		}
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".push()");
	}

}
