package upper_layer.entity;

import common.IDoor;
import skeleton.Depth;

/**
 * O az ajto. Ket allapota van: nyitott ill. zart. Ha valaki kinyitja,
 * akkor az also retegbeli reprezentaciojat ateresztove teszi, ha nem, akkor mozdithatatlanna.
 */
public class Door extends ColEntity implements IDoor {
	private boolean opened;
	public String name; //O kell az objektum nevenek a kiprintelesehez!
	
	@Override
	public void close() {
			
		Depth.getInstance().printTabs();
		System.out.print(name + ".close()");
		Depth.getInstance().enterFunction();
		
		opened = false;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".close()");
		
	}
	
	@Override
	public void open() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".open()");
		Depth.getInstance().enterFunction();
		
		opened = true;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".open()");
	}

	@Override
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".step()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".step()");
		
	}
}
