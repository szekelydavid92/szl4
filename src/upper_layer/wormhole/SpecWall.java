package upper_layer.wormhole;

import common.ISpecWall;
import common.IStargate;
import common.IVisitor;
import common.IWorldObject;
import proto.Depth;

/**
 * Ez az, akire portalt lehet loni. Ha egy teleportalhato valakivel utkozik,
 * szol a WormHole-nak, hogy ot kene pakolni ot a masik SpecWall elo.
 */
public class SpecWall implements ISpecWall {
	
	public String name = "wall";
	public IWorldObject iwo;
	
	@Override
	public void notify(IWorldObject obj) {
		//TODO
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();
		
		obj.getVisitable().accept((IVisitor)this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify()\n");
		
	}

	
	@Override
	public void accept(IVisitor visitor) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()\n");
		Depth.getInstance().enterFunction();
		
		//visitor.visit((ISpecWall)this);
		visitor.visit(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()\n");
		
	}

	
	@Override
	public void replace(IStargate o) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".replace()\n");
		Depth.getInstance().enterFunction();
		
		//TODO Lorant
		iwo.setCollisionObserver(o);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".replace()\n");
		
	}

	
	@Override
	public void restore() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".restore()\n");
		Depth.getInstance().enterFunction();
		
		iwo.setCollisionObserver(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".restore()\n");
		
	}

}
