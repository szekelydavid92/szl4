package bottom_layer;

import java.util.ArrayList;
import java.util.List;

import common.Direction;
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
					
					Direction direction = Direction.UP;
					
					int distUp = 0;
					int distDown = 1;
					int distLeft = 2;
					int distRight = 3;
					
					double [] dist = new double[4];
					dist[distUp]	= Math.abs(temp1.getPosY() - (temp2.getPosY() + temp2.getHeight()));
					dist[distDown]	= Math.abs(temp2.getPosY() - (temp1.getPosY() + temp1.getHeight()));
					dist[distRight]	= Math.abs(temp1.getPosX() - (temp2.getPosX() + temp2.getWidth()));
					dist[distLeft]	= Math.abs(temp2.getPosX() - (temp1.getPosX() + temp1.getWidth()));
					
					int min = 0;
					for(int k=0;k < 4;i++) {
						if(dist[min] > dist[k]) {
							min = k;
						}
					}
					
					if(min == distUp) {direction = Direction.UP;}
					if(min == distDown) {direction = Direction.DOWN;}
					if(min == distLeft) {direction = Direction.LEFT;}
					if(min == distRight) {direction = Direction.RIGHT;}
					
					switch(direction) {
					case UP:
						temp1.addDisplacement(0.0, 1.0);
						temp2.addDisplacement(0.0,-1.0);
						break;
					case DOWN:
						temp1.addDisplacement(0.0,-1.0);
						temp2.addDisplacement(0.0, 1.0);
						break;
					case LEFT:
						temp1.addDisplacement( 1.0, 0.0);
						temp2.addDisplacement(-1.0, 0.0);
						break;
					case RIGHT:
						temp1.addDisplacement(-1.0, 0.0);
						temp2.addDisplacement( 1.0, 0.0);
						break;
					}
					
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
