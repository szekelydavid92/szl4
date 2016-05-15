package bottom_layer;

import java.util.LinkedList;
import java.util.List;

import common.IEntity;

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
	boolean running;
	private World world = new World();
	private List<IEntity> Entities = new LinkedList<IEntity>();
	
	public GameLoop(World world) {
		this.world = world;
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
		
		while(running){
			world.checkCollision();
			world.step();
			
			for(IEntity e : Entities)
			{
				e.step();
			}
		}
				
	}
	void stop(){
		running = false;
	}
}
