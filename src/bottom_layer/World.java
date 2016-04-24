package bottom_layer;

import java.util.ArrayList;
import java.util.List;

import common.Direction;
import common.IWorldObjectFactory;
import upper_layer.Utility;

/**
 * @brief Ez az az osztaly reprezentalja a virtualis vilagot. Tartalmaz egy WorldObject tombot.
 * Fo feladata, hogy a tomb elemeit leptesse az idoben.
 * 
 */
public class World {
	public String name = "world";
	
	private List<WorldObject> objects = new ArrayList<WorldObject>();
	private WorldObjectFactory worldObjectFactory;
	
	public World() {
		worldObjectFactory = new WorldObjectFactory(this);
	}
	
	public IWorldObjectFactory getWorldObjectFactory() {
		return worldObjectFactory;
	}
	
	/*
	 * Ez randa, ez a fuggveny nem ide tartozik, de csak itt hasznaljuk
	 * Lehet, hogy ki kene vagni valami utility classba.
	 */
	public static Direction getPair(Direction direction) {
		switch(direction) {
		case UP:
			return Direction.DOWN;
		case DOWN:
			return Direction.UP;
		case LEFT:
			return Direction.RIGHT;
		case RIGHT:
			return Direction.LEFT;
		}
		
		return Direction.UP;
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
					dist[distDown]	= Math.abs((temp1.getPosY() + temp1.getHeight()) - temp2.getPosY());
					dist[distLeft]	= Math.abs(temp1.getPosX() - (temp2.getPosX() + temp2.getWidth()));
					dist[distRight]	= Math.abs((temp1.getPosX() + temp1.getWidth()) - temp2.getPosX());
					
					int min = 0;
					for(int k=0;k < 4;k++) {
						if(dist[min] > dist[k]) {
							min = k;
						}
					}
					
					if(min == distUp) {direction = Direction.UP;}
					if(min == distDown) {direction = Direction.DOWN;}
					if(min == distLeft) {direction = Direction.LEFT;}
					if(min == distRight) {direction = Direction.RIGHT;}
					
					double tmp1_dx = 0.0,tmp1_dy=0.0;
					double tmp2_dx = 0.0,tmp2_dy=0.0;
					
					switch(direction) {
					case UP:
						tmp1_dy = dist[min];
						tmp2_dy =-dist[min];
						break;
					case DOWN:
						tmp1_dy =-dist[min];
						tmp2_dy = dist[min];
						break;
					case LEFT:
						tmp1_dx = dist[min];
						tmp2_dx =-dist[min];
						break;
					case RIGHT:
						tmp1_dx =-dist[min];
						tmp2_dx = dist[min];
						break;
					}
					
					temp1.push(temp2, tmp1_dx, tmp1_dy);
					temp2.push(temp1, tmp2_dx, tmp2_dy);
					
					temp1.setDirection(direction);
					temp2.setDirection(Utility.getPair(direction));
					
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
			
			if (objects.get(i).isRemovable()) {
				objects.remove(i);
			} else {
				objects.get(i).step();
			}
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
