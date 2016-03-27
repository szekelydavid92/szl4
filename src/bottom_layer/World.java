package bottom_layer;

import java.util.Vector;

/**
 * Ez az az osztály reprezentálja a virtuális világot. Tartarmaz egy WorldObject tömböt.
 * Fõ feladata, hogy a tömb elemeit léptesse az idõben.
 */
public class World {
	
	Vector<WorldObject> objects;
	
	public World() {
		objects = new Vector<WorldObject>();
	}
	
	//Ütközés ellenõrzés.
	public void checkCollision() {
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size()-1; i++){
			for(int j=i+1; j<objects.size(); j++){
			temp1 = objects.elementAt(i);
			temp2 = objects.elementAt(j);
			if(temp1.checkCollision(temp2)){
				temp1.notify(temp2);
				temp2.notify(temp1);
				}
			}
		}
	};
	
	/**
	 * Léptetés megvalósítása.
	 * @return void
	 */
	public void step() {
		
		for(int i=0; i<objects.size(); i++){
			objects.elementAt(i).step();
		}
	}	
	
	/*
	 *  UJITAS!!
	 */
	public void addWorldObject(WorldObject obj){
		objects.add(obj);
	}
	
	public WorldObject getWorldObject(int n){
		return objects.get(n);
	}
	
	public Vector<WorldObject> getAllWorldObject(){
		return objects;
	}
	 
}
