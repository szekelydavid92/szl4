package upper_layer.reactive;

import common.ICollisionObserver;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * @brief ZPM. Ket allapota van, felvett es nem felvett. 
 */
public class ZPM implements IZPM, ICollisionObserver {
	
	public String name = "zpm";
	
	/**
	 * @brief az IVisitable interface fuggvenye, ebben kozli a parameterben
	 * kapott visitorrel a tipusat.
	 * 
	 * @param visitor az zpm-en muveletet vegzo visitor
	 * @return void
	 */
	@Override
	public void accept(IVisitor visitor) {
		//TODO Lorant
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()");
		
	}

	/**
	 * @brief Ezzel a fuggvennyel lekerdezhetjuk, hogy a ZPM-et felvettek-e.
	 * 
	 * @return bool
	 */
	@Override
	public boolean isPicked() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".isPicked()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".isPicked()");
		
		return true;
	}

	/**
	 * @brief Ezzel a fuggvennyel jelezzuk, hogy felvettuk a ZPM-et.
	 * 
	 * @return void
	 */
	@Override
	public void pickUp() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".pickUp()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".pickUp()");
		
	}

	
	@Override
	public void notify(IWorldObject obj) {
		
		/*
		 * Nem hivodik meg. A ZPM nem csinal semmit a vele utkozokkel, ertelmetlen a letezese.
		 */
		
	}

}
