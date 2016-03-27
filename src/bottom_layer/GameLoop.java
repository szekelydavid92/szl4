package bottom_layer;

import java.util.LinkedList;
import java.util.List;

import common.IEntity;
import skeleton.Depth;

/* 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * Az implements Runnable NEM kerül ide.!
 * Ki lett szedve analízis modell 1 után!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

/**
 * @brief Ez az osztály felel azért, hogy a játék 
 * időben előreléptesse az állapotát.
 */
public class GameLoop {
	
	public String name = "gameLoop"; //Ő kell az objektum nevének a kiprinteléséhez!
	
	/*
	 * Ők az asszociációkat ill. kompozíciókat
	 * megvalósító referenciák.
	 * A tesztesetek felállításának egyszerűsítése
	 * érdekében publikusak.
	 * 
	 */
	public World world;
	public List<IEntity> Entites = new LinkedList<IEntity>();
	
	/**
	 * Ez a függvény felel az objektumok léptetéséért.
	 * @return void
	 */
	public void run() {
		Depth.getInstance().printTabs();
		System.out.print(name + ".run()");
		Depth.getInstance().enterFunction();
		
		world.checkCollision();
		world.step();
		
		for(IEntity e : Entites)
		{
			e.step();
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".run()");
	}
}
