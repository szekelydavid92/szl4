package bottom_layer;

import java.util.Vector;

/**
 * Ez az az oszt�ly reprezent�lja a virtu�lis vil�got. Tartarmaz egy WorldObject t�mb�t.
 * F� feladata, hogy a t�mb elemeit l�ptesse az id�ben.
 */
public class World {
	
	Vector<WorldObject> objects;
	
	//�tk�z�s ellen�rz�s.
	public void checkCollision() {
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size(); i++){
			for(int j=0; j<objects.size(); j++){
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
	 * L�ptet�s megval�s�t�sa.
	 * @param dt ???????????
	 * @return void
	 */
	public void step(double dt) {
		
		for(int i=0; i<objects.size(); i++){
			objects.elementAt(i).getIVisitable();
		}
	}	
}
