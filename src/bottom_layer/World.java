package bottom_layer;

import java.util.ArrayList;
import java.util.List;

import common.IWorldObjectFactory;

/**
 * @brief Ez az az osztaly reprezentalja a virtualis vilagot. Tartalmaz egy WorldObject tombot.
 * Fo feladata, hogy a tomb elemeit leptesse az idoben.
 * 
 */
public class World {
	public String name = "world";
	
	public List<WorldObject> objects = new ArrayList<WorldObject>();
	private WorldObjectFactory worldObjectFactory;
	
	public World() {
		worldObjectFactory = new WorldObjectFactory(this);
	}
	
	public IWorldObjectFactory getWorldObjectFactory() {
		return worldObjectFactory;
	}
	
	/**
	 * @brief Utkozes ellenorzes.
	 * 
	 * @return void
	 */
	public void checkCollision() {
		
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size(); i++){
			for(int j=i+1; j<objects.size(); j++){
				temp1 = objects.get(i);
				temp2 = objects.get(j);
			
				if(temp1.checkCollision(temp2)){
					temp1.notify(temp2);
					temp2.notify(temp1);
				}
			}
		}
	};
	
	/**
	 * @brief Leptetes megvalositasa.
	 * 
	 * @return void
	 */
	public void step() {
		for(int i=0; i<objects.size(); i++) {
			objects.get(i).step();
		}
	}	
	
	/*
	 *  Ezek a fuggvenyek a teszteles megkonnyitese
	 *  miatt jottek letre
	 *  
	 */
	public void addWorldObject(WorldObject obj) {
		objects.add(obj);
	}
	
	public WorldObject getWorldObject(int n) {
		return objects.get(n);
	}
	
	public List<WorldObject> getAllWorldObject() {
		return objects;
	}
	 
}
