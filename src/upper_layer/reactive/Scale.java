package upper_layer.reactive;

import common.ICollisionObserver;
import common.IScale;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import skeleton.Depth;

/**
 * O a merleg. Ha valaki lenyomja, akkor kinyitja a hozza tartozo ajtot.
 */
public class Scale implements IScale, IVisitable, ICollisionObserver{
	
	public String name;
	
	@Override
	public void notify(IWorldObject obj) {
		
		//Nem lesz lehivva.
	}

	@Override
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()");
		Depth.getInstance().enterFunction();
		
		visitor.visit(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()");
		
		//TODO Lorant
	}

	@Override
	public void push() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".push()");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".push()");
		
	}

}
