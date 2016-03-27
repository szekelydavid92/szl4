package bottom_layer;

import java.util.ArrayList;
import java.util.List;

/**
 * Ez az az osztály reprezentalja a virtualis vilagot. Tartarmaz egy WorldObject tombot.
 * Fo feladata, hogy a tomb elemeit leptesse az idoben.
 */
public class World {
	
	List<WorldObject> objects = new ArrayList<WorldObject>();
	
	//Utkozes ellenorzes.
	public void checkCollision() {
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size(); i++){
			for(int j=0; j<objects.size(); j++){
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
	 * Leptetes megvalositasa.
	 * @return void
	 */
	public void step() {
		
		for(int i=0; i<objects.size(); i++){
			objects.get(i).step();
		}
	}	
}
