package upper_layer.entity;

import common.CollisionResponse;
import common.IDoor;
import common.IWorldObject;

/**
 * O az ajto. Ket allapota van: nyitott ill. zart. Ha valaki kinyitja,
 * akkor az also retegbeli reprezentaciojat ateresztove teszi, ha nem, akkor mozdithatatlanna.
 */
public class Door extends ColEntity implements IDoor {
	
	private boolean isOpen = false;
	public boolean wasOpen = false; // csak kiirashoz 
	
	public String name; //O kell az objektum nevenek a kiprintelesehez!
	
	public boolean isClosed() {
		return !isOpen;
	}
	
	@Override
	public void open() {	
		isOpen = true;
	}
	
	@Override
	public void close() {		
		isOpen = false;		
	}
	
	
	@Override
	public void step() {	
		this.wasOpen=this.isOpen;
		if (isOpen ==true) {
			worldObject.setCollisionResponse(CollisionResponse.PASS);
		}
		else { 
			worldObject.setCollisionResponse(CollisionResponse.IMMOVABLE);
		}
		
		close();		
	}
	
	public Door(IWorldObject worldObject) {
		super(worldObject);
		/*
		 * Nem csinál semmit.
		 */
	}

	@Override
	public boolean isOpen() {
		return wasOpen;
	}
}
