package upper_layer.entity;

import common.ICarriable;
import common.IKillable;
import common.IProjectileFactory;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IVisitable;
import common.IWorldObject;
import common.IZPM;

import java.io.IOException;

import common.Colour;
import skeleton.Depth;

/**
 * Ez a jatekos. Kepes hordozni az ICarriable-t megvalosoto objektumot es megolheto.
 */
public class Player extends Killable implements ITeleportable {
	/**
	 * Ezzel a fuggvennyel lehet rakenyszeriteni a jatekost, hogy elengedje a cipelt dobozt, pl. ha az megsemmisul.
	 * @return void
	 */
	
	private double posX, posY;
	public String name = "player"; //O kell az objektum nevenek a kiprintelesehez!
	public IProjectileFactory projFactory;
	public ICarriable box = null;
	private boolean TMPShootYellow = false; //teszteles miatt
	private boolean TMPShootBlue = false; 	//teszteles miatt
	
	public void accept(IVisitor visitor){
		visitor.visit((IKillable) this);
		visitor.visit((ITeleportable) this);
	}
	
	public void forcedRelelease() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".forcedRelelease()\n");		
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".forcedRelelease()\n");
		
	}
	
	/*
	 * segédfv, egy adott poziciorol eldönti, hogy az az
	 * adott pályához érvényes pozicio lehet-e, vagy sem
	 * esetleg ha nem, akkor merre lóg ki
	 * 
	 */
	private boolean validPos(double x, double y){
		Depth.getInstance().printTabs();
		System.out.print(name + ".validPos()\n");
		Depth.getInstance().enterFunction();
			
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".validPos()\n");
		return true;
	}
	
	/**
	 * Ezzel a fuggvennyel lehet a jatekost elteleportalni az (x,y) pozicioba.
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void teleport(double x, double y) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".teleport()\n");
		Depth.getInstance().enterFunction();
		/*	
		if(validPos(x, y)){
			posX = x;
			posY = y;
		} else {	
		}
		*/
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".teleport()\n");
	
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a felfele megy.
	 * @param up ???????
	 * @return void
	 */
	public void moveUp(boolean up) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveUp()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveUp()\n");
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jetokos a lefele megy.
	 * @param down ???????
	 * @return void
	 */
	public void moveDown(boolean down) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveDown()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveDown()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a balra megy.
	 * @param left ???????
	 * @return void
	 */
	public void moveLeft(boolean left) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveLeft()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveLeft()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a jobbra megy.
	 * @param right ???????
	 * @return void
	 */
	public void moveRight(boolean right) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveRight()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveRight()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a felveszi az elotte levo dobozt.
	 * @param pick ???????
	 * @return void
	 */
	public void pickUp(boolean pick) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".pickUp(" + pick + ")\n");
		Depth.getInstance().enterFunction();
		
		
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".pickUp()\n");
		
	}
	
	
	/**
	 * Itt lehet megadni, hogy a jatekos mely iranyba lojon.
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void lookAt(double x,double y) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".lookAt()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".lookAt()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja, a jatekos kilo egy sarga lovedeket.
	 * @param shootingYellow ???????
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".shootYellow(true)\n");
		Depth.getInstance().enterFunction();
		
		TMPShootYellow = shootingYellow;
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".shootYellow()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja, a jatekos kilo egy kek lovedeket.
	 * @param shootingBlue ???????
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".shootBlue(true)\n");
		Depth.getInstance().enterFunction();
				
		TMPShootBlue = shootingBlue;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".shootBlue()\n");
		
	}
	
	
	/**
	 * Ezzel lehet megolni a jatekost.
	 * @return void
	 */
	public void kill() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".kill()\n");
		Depth.getInstance().enterFunction();
		
		if (box!=null)
			box.release();
		
		box=null;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".kill()\n");
		
	}
	
	
	/**
	 * Ez a fuggveny lepteti elore az allapotat az idoben.
	 * @return void
	 */
	public void step() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".step()\n");
		Depth.getInstance().enterFunction();
		
		move();
		carryBox();
		shoot();
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".step()\n");
		
	}
	
	
	/**
	 * Ez a fuggveny valositja meg a jatekos mozgasat.
	 * @return void
	 */
	public void move() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".move()\n");
		Depth.getInstance().enterFunction();
		
		double normalizedDirectionX = 0;
		double normalizedDirectionY = 0;
		worldObject.setDisplacementX(normalizedDirectionX);
		worldObject.setDisplacementY(normalizedDirectionY);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".move()\n");
		
	}
	
	
	/**
	 * Ez a fuggveny valositja meg a doboz cipeleset.
	 * @return void
	 */
	public void carryBox() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".carryBox()\n");
		Depth.getInstance().enterFunction();
		
		if(box != null)
		{
			System.out.println("Kerem, adja meg, hogy el kivanja-e dobni a dobozt vagy sem. [i/n]");
			try {
				skeleton.SkeletonMain.line = skeleton.SkeletonMain.in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(skeleton.SkeletonMain.line.equals("i")) { /*Sztringeket a .equals()-szal komparálunk. :P*/
				box.setPos(12, 12);
			}
			
			if(skeleton.SkeletonMain.line.equals("n")) { /*Sztringeket a .equals()-szal komparálunk. :P*/
				Depth.getInstance().returnFromFunction();
				Depth.getInstance().printTabs();
				System.out.print("ret " + name + ".carryBox()\n");
				return;
			}
			
			System.out.println("Kerem, adja meg, hogy van-e hely a doboznak! [i/n]");	
			try {
				skeleton.SkeletonMain.line = skeleton.SkeletonMain.in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(skeleton.SkeletonMain.line.equals("i")) { /*Sztringeket a .equals()-szal komparálunk. :P*/
				box.release();
			}
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".carryBox()\n");
		
	}
	
	
	/**
	 * Ez a fuggveny valositja meg a lovest.
	 * @return void
	 */
	public void shoot() { 
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".shoot()\n");
		Depth.getInstance().enterFunction();
		
		double x = worldObject.getPosX();
		double y = worldObject.getPosY();
		
		if(TMPShootYellow)
			projFactory.createProjectile(Colour.YELLOW, x, y, 1.0, 1.0);
		if(TMPShootBlue)
			projFactory.createProjectile(Colour.BLUE, x, y, 1.0, 1.0);
			
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".shoot()\n");
		
	}
	
	
	@Override
	public void visit(ISpecWall wall) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		//TODO Lorant
	}

	
	@Override
	public void visit(IKillable killable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		//TODO Lorant
	}

	
	@Override
	public void visit(ICarriable carriable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		
		//TODO Lorant
	}

	/**
	 * Meglatogatunk egy ZPM objektumot es felvesszuk.
	 * @param zpm: mutato a ZPM objektumra.
	 * @return void
	 */
	@Override
	public void visit(IZPM zpm) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		if (zpm != null)
		zpm.pickUp();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		
		//TODO Lorant
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
		
		//TODO Lorant
	}

	
	@Override
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify(" + "zmpObject" + ")\n");
		Depth.getInstance().enterFunction();	
		
		IVisitable visitable=obj.getVisitable();
		if (visitable != null)
			visitable.accept(this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify() \n");
		
		
	}
}
