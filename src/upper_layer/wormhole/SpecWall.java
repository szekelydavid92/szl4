package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;

/**
 * Ez az, akire portalt lehet loni. Ha egy teleportalhato valakivel utkozik,
 * szol a WormHole-nak, hogy ot kene pakolni ot a masik SpecWall elo.
 */
public class SpecWall implements ISpecWall {
	
	public String name = "wall";
	
	/*
	 * Attributumok
	 */
	private IWorldObject worldObject;
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Konstruktor
	 */
	public SpecWall(IWorldObject worldObject) {
		this.worldObject = worldObject;
		this.worldObject.setVisitable(this);
	}
	
	/*
	@Override
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		IVisitable visitable = obj.getVisitable();
		if(visitable != null) {
			visitable.accept(this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
	}
	*/
	
	@Override
	public void accept(IVisitor visitor) {		
		visitor.visit(this);		
	}
	
	@Override
	public void replace(IStargate stargate) {		
		//worldObject.setVisitable(stargate); ///Lehet, hogy erre szükség lesz.
		worldObject.setCollisionObserver(stargate);		
	}
	
	@Override
	public void restore() {
		//worldObject.setVisitable(this); ///Lehet, hogy erre szükség lesz.
		worldObject.setCollisionObserver(null);		
	}
	
	/*
	 * Itt el kellett ternunk a specifikaciotol: az alabbi extra fuggvenyeket kellett
	 * letrehoznunk:
	 */
	
	public IWorldObject getWorldObject() {
		return worldObject;
	}
}
