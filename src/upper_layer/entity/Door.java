package upper_layer.entity;

import common.CollisionResponse;
import common.IDoor;
import common.IWorldObject;
import skeleton.Depth;

/**
 * O az ajto. Ket allapota van: nyitott ill. zart. Ha valaki kinyitja,
 * akkor az also retegbeli reprezentaciojat ateresztove teszi, ha nem, akkor mozdithatatlanna.
 */
public class Door extends ColEntity implements IDoor {
	private boolean opened;
	public String name; //O kell az objektum nevenek a kiprintelesehez!
	public IWorldObject worldObject;
	
	@Override
	public void close() {
			
		Depth.getInstance().printTabs();
		System.out.println(name + ".close()");
		Depth.getInstance().enterFunction();
		
		opened = false;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".close()");
		
	}
	
	
	
	@Override
	public void open() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".open()");
		Depth.getInstance().enterFunction();
		
		opened = true;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".open()");
	}

	@Override
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".step()");
		Depth.getInstance().enterFunction();
		
		
		if (opened ==true) 
			worldObject.setCollisionResponse(CollisionResponse.PASS);
		
		else 
			worldObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		
		opened=false;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".step()");
		
	}
}
