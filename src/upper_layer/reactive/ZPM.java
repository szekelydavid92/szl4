package upper_layer.reactive;

import common.ICollisionObserver;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;
import skeleton.Depth;

/**
 * ZPM. Ket allapota van, felvett es nem felvett. 
 */
public class ZPM implements IZPM, ICollisionObserver {
	
	public String name;
	
	@Override
	public void accept(IVisitor visitor) {
		//TODO Lorant
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit((IZPM)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()");
		
	}

	
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
		
		//Nem hívódik meg.
		
	}

}
