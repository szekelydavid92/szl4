package bottom_layer;

import java.util.LinkedList;
import java.util.List;

import common.IEntity;
import common.IView;

/* 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Az implements Runnable NEM kerul ide!
 * Ki lett szedve analazis modell 1 utan!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

/**
 * @brief Ez az osztaly felel azert, hogy a jatek 
 * idoben eloreleptesse az allapotat.
 */
public class GameLoop {
	
	/*
	 * Ok az asszociaciakat ill. kompoziciokat
	 * megvalosito referenciak.
	 * A tesztesetek felallitasanak egyszerusitese
	 * erdekeben publikusak.
	 * 
	 */
	
	IView view;
	boolean running;
	private World world = new World();
	private List<IEntity> Entities = new LinkedList<IEntity>();
	
	public GameLoop(World world) {
		this.world = world;
	}
	
	public GameLoop(World world, IView v) {
		this.world = world;
		this.view = v;
	}
	
	
	/**
	 * @brief Ezzel a fuggvennyel lehet lekerdezni a vilaghoz tartozo World
	 * peldanyt.
	 * 
	 * @return World - a GameLoophoz tartozo world
	 */
	public World getWorld() {
		return world;
	}
	
	/**
	 * @brief Ez a fuggveny felelos azert, hogy a vilaghoz uj entitasokat
	 * adhassunk hozza, amely elore lepteti az allapotat.
	 * 
	 * @param entity az ujonnan a vilaghoz adando entitas.
	 * @return void
	 */
	public void addEntity(IEntity entity) {
		Entities.add(entity);
	}
	
	/**
	 * @brief Ez a fuggveny felel az objektumok lepteteseert.
	 * @return void
	 */
	public void run() {
		
		running = true;
		
		/*
		 * Itt adjuk meg, hogy max mennyi FPS-sel fusson a program.
		 */
		int FPS = 30;
		while(running){
			/*
			 * Frame limitálás, mert enélkül túl gyors lenne a program.
			 */
			long beginTime = System.currentTimeMillis();
			
			world.checkCollision();
			world.step();
			
			for(IEntity e : Entities) {
				e.step();
			}
			
			/*
			 * Szólunk az ablaknak, hogy újra kéne rajzolni a világot.
			 */
			view.render();

			/*
			 * Frame limitálás, mert enélkül túl gyors lenne a program.
			 */
			long endTime = System.currentTimeMillis();
			long timeElapsed = endTime-beginTime;
			if(timeElapsed < 1000/FPS) {
				try {
					Thread.sleep(1000/FPS - timeElapsed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
				
	}
	void stop(){
		running = false;
	}
}
