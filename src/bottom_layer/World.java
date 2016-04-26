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
	
	/**
	 * @brief Ez a fuggveny felelos azert, hogy minden testen vegigmenjen,
	 * es mindenkivel utkozest vizsgaljon
	 * 
	 * @return void
	 */
	public void checkCollision() {
		
		WorldObject temp1,temp2;
		
		/*
		 * Minden testre...
		 */
		for(int i=0; i<objects.size(); i++){
			/*
			 * Vegigmegyunk minden ot koveto testen, leellenorizzuk,
			 * hogy utkoznek-e.
			 */
			for(int j=i+1; j<objects.size(); j++){
				temp1 = objects.get(i);
				temp2 = objects.get(j);
			
				if(temp1.checkCollision(temp2)){
					/*
					 * Ha igen, akkor megkeressuk a legsekelyebb utkozes iranyat.
					 */
					Direction direction = Direction.UP;
					
					int distUp = 0;
					int distDown = 1;
					int distLeft = 2;
					int distRight = 3;
					
					/*
					 * Kiszamoljuk mind a 4 lehetseges utkozes melyseget
					 */
					double [] dist = new double[4];
					dist[distUp]	= Math.abs(temp1.getPosY() - (temp2.getPosY() + temp2.getHeight()));
					dist[distDown]	= Math.abs((temp1.getPosY() + temp1.getHeight()) - temp2.getPosY());
					dist[distLeft]	= Math.abs(temp1.getPosX() - (temp2.getPosX() + temp2.getWidth()));
					dist[distRight]	= Math.abs((temp1.getPosX() + temp1.getWidth()) - temp2.getPosX());
					
					/*
					 * es megkeressuk a minimumukat.
					 */
					int min = 0;
					for(int k=0;k < 4;k++) {
						if(dist[min] > dist[k]) {
							min = k;
						}
					}
					
					/*
					 * Ennek megfeleloen beallitjuk az enum erteket.
					 */
					if(min == distUp) {direction = Direction.UP;}
					if(min == distDown) {direction = Direction.DOWN;}
					if(min == distLeft) {direction = Direction.LEFT;}
					if(min == distRight) {direction = Direction.RIGHT;}
					
					double tmp1_dx = 0.0,tmp1_dy=0.0;
					double tmp2_dx = 0.0,tmp2_dy=0.0;
					
					/*
					 * Ez utan kivalasztjuk a visszalokes vektorat
					 */
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
					
					/*
					 * Majd visszalokjuk oket egymastol
					 */
					temp1.push(temp2, tmp1_dx, tmp1_dy);
					temp2.push(temp1, tmp2_dx, tmp2_dy);
					
					/*
					 * es ertesitjuk a collision observereket az utkozes iranyarol,
					 * es az utkozes tenyerol.
					 */
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
		
		for  (int i=0;i<objects.size();i++) {
			if (objects.get(i).isRemovable())
				objects.remove(i);
		}
		
		for(int i=0; i<objects.size(); i++) {
				objects.get(i).step();
		}
	}	
	
	/*
	 *  Ezek a fuggvenyek a teszteles megkonnyitese
	 *  miatt jottek letre
	 *  
	 */
	/**
	 * @brief Hozzad egy world objectet a world
	 * objektumaihoz
	 * 
	 * @param obj: a hozzadando world object
	 *
	 * @return void
	 */
	public void addWorldObject(WorldObject obj) {
		objects.add(obj);
	}
	
	/**
	 * @brief Visszaadja a world world object listajabol
	 * az n. objektumot ha van van ilyen, egyebkent null-t.
	 * 
	 * @param n: a visszaadando world object helye a listaban
	 *
	 * @return WorldObject: a visszaadott WorldObject
	 * 
	 */
	public WorldObject getWorldObject(int n) {
		return objects.get(n);
	}
	
	/**
	 * @brief Visszaadja a World World Object-jeinek teljes listajat.
	 * 
	 * @param 
	 *
	 * @return List<WorldObject> a world objectek listaja 
	 */
	public List<WorldObject> getAllWorldObject() {
		return objects;
	}
	 
}
