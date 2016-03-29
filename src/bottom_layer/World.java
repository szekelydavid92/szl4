package bottom_layer;

import skeleton.SkeletonMain;

import java.io.IOException;
import java.util.Vector;

import skeleton.Depth;

/**
 * Ez az az osztaly reprezentalja a virtualis vilagot. Tartalmaz egy WorldObject tombot.
 * Fo feladata, hogy a tomb elemeit leptesse az idoben.
 */
public class World {
	
	Vector<WorldObject> objects;
	public static String name = "World";
	
	public World() {
		objects = new Vector<WorldObject>();
	}
	
	//Utkozes ellenorzes.
	public void checkCollision() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".checkCollision()");
		Depth.getInstance().enterFunction();
		
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size()-1; i++){
			for(int j=i+1; j<objects.size(); j++){
			temp1 = objects.elementAt(i);
			temp2 = objects.elementAt(j);
			if(temp1.checkCollision(temp2)){
				temp1.notify(temp2);
				temp2.notify(temp1);
				}
			}
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".checkCollision()");
		
	};
	
	/**
	 * Leptetes megvalositasa.
	 * @return void
	 */
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".step()");
		Depth.getInstance().enterFunction();
		
		for(int i=0; i<objects.size(); i++){
			objects.elementAt(i).step();
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".checkCollision()");
		
	}	
	
	/*
	 *  UJITAS!!
	 */
	public void addWorldObject(WorldObject obj){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".addWorldObject()");
		Depth.getInstance().enterFunction();
		
		objects.add(obj);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".addWorldObject()");
	}
	
	public WorldObject getWorldObject(int n){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".getWorldObject()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getWorldObject()");
		
		return objects.get(n);
	}
	
	public Vector<WorldObject> getAllWorldObject(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".getAllWorldObject()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getAllWorldObject()");
		
		return objects;
	}
	 
}
