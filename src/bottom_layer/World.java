package bottom_layer;

import java.util.ArrayList;
import java.util.List;
import skeleton.SkeletonMain;

import java.io.IOException;

import skeleton.Depth;

/**
 * Ez az az osztaly reprezentalja a virtualis vilagot. Tartalmaz egy WorldObject tombot.
 * Fo feladata, hogy a tomb elemeit leptesse az idoben.
 * 
 */
public class World {
	
	List<WorldObject> objects = new ArrayList<WorldObject>();
	public String name = "world";
	
	public World() {}
	
	//Utkozes ellenorzes.
	public void checkCollision() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".checkCollision()");
		Depth.getInstance().enterFunction();
		
		WorldObject temp1,temp2;
		
		for(int i=0; i<objects.size(); i++){
			for(int j=0; j<objects.size(); j++){
			temp1 = objects.get(i);
			temp2 = objects.get(j);
			
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
			objects.get(i).step();
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
	
	public List<WorldObject> getAllWorldObject(){
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".getAllWorldObject()");
		Depth.getInstance().enterFunction();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".getAllWorldObject()");
		
		return objects;
	}
	 
}
