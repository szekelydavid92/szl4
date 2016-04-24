package upper_layer.entity;

import common.CollisionResponse;
import common.IDoor;
import common.IWorldObject;
import proto.Depth;

/**
 * O az ajto. Ket allapota van: nyitott ill. zart. Ha valaki kinyitja,
 * akkor az also retegbeli reprezentaciojat ateresztove teszi, ha nem, akkor mozdithatatlanna.
 */
public class Door extends ColEntity implements IDoor {
	
	private boolean isOpen = false;
	public boolean isOpenToPrint = false; // csak kiirashoz 
	
	public String name; //O kell az objektum nevenek a kiprintelesehez!
	
	public boolean isClosed() {
		return !isOpen;
	}
	
	@Override
	public void open() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".open()");
		Depth.getInstance().enterFunction();
		
		isOpen = true;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".open()");
	}
	
	@Override
	public void close() {
			
		Depth.getInstance().printTabs();
		System.out.println(name + ".close()");
		Depth.getInstance().enterFunction();
		
		isOpen = false;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".close()");
		
	}

	@Override
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.println(name + ".step()");
		Depth.getInstance().enterFunction();
		
		this.isOpenToPrint=this.isOpen;
		if (isOpen ==true) {
			worldObject.setCollisionResponse(CollisionResponse.PASS);
		}
		else { 
			worldObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		}
		
		close();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.println("ret " + name + ".step()");
		
	}
	
	public Door(IWorldObject worldObject) {
		super(worldObject);
		/*
		 * Nem csinál semmit.
		 */
	}
}
