package upper_layer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ZPMObserver {
	
	private class ZPMRandPos {
		public double x;
		public double y;
		public double width;
		public double height;
		
		ZPMRandPos(double x,double y,double width,double height) {
			this.x = x;
			this.y = y;
			this.width	= width;
			this.height	= height;
		}
	}
	
	/*
	 * Attributumok
	 */
	private int numNotify = 0;
	private boolean fired = false;
	private boolean randomize = true;
	private List<ZPMRandPos> randPos = new LinkedList<ZPMRandPos>();
	
	GameFactory gameFactory;
	Random randomizer = new Random();
	
	/*
	 * Metodusok
	 */
	
	public ZPMObserver(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
	}
	
	public void add(double x,double y,double width,double height) {
		randPos.add(new ZPMRandPos(x,y,width,height));
	}
	
	public void clear() {
		randPos.clear();
	}
	
	public void setRandomize(boolean randomize) {
		this.randomize = randomize;
	}
	
	/*
	 * Itt eltérünk a specifikációtól, a notify nevet nem engedte, mert
	 * az a java egy beépített függvénye.
	 */
	public void notifyPickUp() {
		numNotify++;
		if(numNotify == 2 && !fired) {
			if(randPos.size() == 0) {
				return;
			}
			
			int rand = 0;
			if(randomize) {
				rand = randomizer.nextInt(randPos.size());
			}
			
			ZPMRandPos zpmRandPos = randPos.get(rand);
			gameFactory.createZpm(zpmRandPos.x, zpmRandPos.y, zpmRandPos.width, zpmRandPos.height);
			fired = true;
		}
	}
}