package bottom_layer;

import java.util.LinkedList;
import java.util.List;

import common.IEntity;
import proto.Depth;

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
	
	public String name = "gameLoop"; //O kell az objektum nevenek a kiprintelesehez!
	
	/*
	 * Ok az asszociaciakat ill. kompoziciokat
	 * megvalosito referenciak.
	 * A tesztesetek felallitasanak egyszerusitese
	 * erdekeben publikusak.
	 * 
	 */
	private World world = new World();
	private List<IEntity> Entities = new LinkedList<IEntity>();
	
	public GameLoop(World world) {
		this.world = world;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void addEntity(IEntity entity) {
		Entities.add(entity);
	}
	
	/**
	 * @brief Ez a fuggveny felel az objektumok lepteteseert.
	 * @return void
	 */
	public void run() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".run()\n");
		Depth.getInstance().enterFunction();
		
		world.checkCollision();
		world.step();
		
		System.out.println("Entity lepteto ciklus belepes");
		for(IEntity e : Entities)
		{
			e.step();
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".run()\n");
	}
}
