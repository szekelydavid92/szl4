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
	public World world = new World();
	public List<IEntity> Entites = new LinkedList<IEntity>();
	
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
		for(IEntity e : Entites)
		{
			e.step();
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".run()\n");
	}
}
