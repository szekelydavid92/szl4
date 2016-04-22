package upper_layer.entity;

import common.ICarriable;
import common.ICarrier;
import common.IKillable;
import common.IProjectileFactory;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IVisitable;
import common.IWorldObject;
import common.IZPM;
import proto.Depth;

import java.io.IOException;

import common.Colour;

/**
 * Ez a jatekos. Kepes hordozni az ICarriable-t megvalosoto objektumot es megolheto.
 */
public class Player extends Killable implements ITeleportable,ICarrier {

	public String name = "player"; //O kell az objektum nevenek a kiprintelesehez!
	
	/*
	 * Attributumok
	 */
	int zpmNumber = 0; 						//Itt tárolódik a felvett ZPM-ek száma.
	public ICarriable carriedObject = null; 		// Referencia a cipelt objektumra.
	boolean up = true;						//ha a játékos fölfelé megy, false egyébként.
	boolean down = true;					//ha a játékos lefelé megy, false egyébként.
	boolean left = true;  					//ha a játékos balra megy, false egyébként.
	boolean right = true; 					//ha a játékos jobbra megy, false egyébként.
	boolean pick = false; 					//ha a játékos fölveszi az előtte lévő dobozt, false egyébként.
	double dirX = 0.0; 						//a kilövendő lövedék irányának X komponense
	double dirY = 0.0;  					//a kilövendő lövedék irányának Y komponense
	boolean shootingYellow = true; 			//ha a játékos sárga lövedéket lő, false egyébként.
	boolean shootingBlue = true;  			//ha a játékos kék lövedéket lő, false egyébként.
	protected double displacement = 1;  	//megadja, hogy egy lépéssel a játékos mekkora távolságot tesz meg.
	public IProjectileFactory projFactory;
	
	/*
	 * Metodusok
	 */
	
	public void accept(IVisitor visitor){

		Depth.getInstance().printTabs();
		System.out.print(name + ".accept()\n");		
		Depth.getInstance().enterFunction();
		
		visitor.visit((IKillable) this);
		visitor.visit((ITeleportable) this);
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".accept()\n");
	}
	
	/**
	 * Ezzel a fuggvennyel lehet rakenyszeriteni a jatekost, hogy elengedje a cipelt dobozt, pl. ha az megsemmisul.
	 * @return void
	 */
	public void forcedRelease() {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".forcedRelelease()\n");		
		Depth.getInstance().enterFunction();
		
		carriedObject = null;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".forcedRelelease()\n");
		
	}
	
	/*
	 * segedfv, amely egy adott poziciorol eldonti, hogy az az
	 * adott palyahozhoz ervenyes pozicio lehet-e, vagy sem
	 * esetleg ha nem, akkor merre log ki
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
	 * Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti, hogy menjen-e a jatekos felfele.
	 * @param up: menjen-e a jatekos felfele (true vagy false)
	 * @return void
	 */
	public void moveUp(boolean up) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveUp()\n");
		Depth.getInstance().enterFunction();
				
		this.up = up;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveUp()\n");
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e lefele.
	 * @param down: menjen-e a jatekos lefele (true vagy false) 
	 * @return void
	 */
	public void moveDown(boolean down) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveDown()\n");
		Depth.getInstance().enterFunction();
		
		this.down = down;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveDown()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e balra.
	 * @param left: menjen-e a jatekos balra (true vagy false) 
	 * @return void
	 */
	public void moveLeft(boolean left) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveLeft()\n");
		Depth.getInstance().enterFunction();
		
		this.left = left;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveLeft()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e jobbra.
	 * @param right: menjen-e a jatekos jobbra (true vagy false) 
	 * @return void
	 */
	public void moveRight(boolean right) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".moveRight()\n");
		Depth.getInstance().enterFunction();
				
		this.right = right;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".moveRight()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos vegye-e fel az elotte levo dobozt.
	 * @param pick: vegye-e fel a jatekos a dobozt(true vagy false) 
	 * @return void
	 */
	public void pickUp(boolean pick) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".pickUp(" + pick + ")\n");
		Depth.getInstance().enterFunction();
		
		this.pick = pick;
		
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
		
		this.dirX = x;
		this.dirY = y;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".lookAt()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja, azzal eldontheti, hogy lojon-e ki a jatekos egy sarga lovedeket.
	 * @param shootingYellow: Lojon-e a jatekos sarga lovedeket (true vagy false).
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".shootYellow(true)\n");
		Depth.getInstance().enterFunction();
		
		this.shootingYellow = shootingYellow;
				
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".shootYellow()\n");
		
	}
	
	
	/**
	 * Ha valaki lehivja, azzal eldontheti, hogy lojon-e ki a jatekos egy kek lovedeket.
	 * @param shootingBlue: Lojon-e a jatekos kek lovedeket (true vagy false).
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".shootBlue(true)\n");
		Depth.getInstance().enterFunction();
				
		this.shootingBlue = shootingBlue;
		
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
		
		if (carriedObject!=null)
			carriedObject.release();
		
		carriedObject=null;
		
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
		
		double normalizedDirectionX = 0.0;
		double normalizedDirectionY = 0.0;
		
		if(up) 		{normalizedDirectionY += -1.0;}
		if(down)	{normalizedDirectionY +=  1.0;}
		if(left) 	{normalizedDirectionX += -1.0;}
		if(right)	{normalizedDirectionX +=  1.0;}
		
		double abs = Math.sqrt(normalizedDirectionY*normalizedDirectionY + normalizedDirectionX*normalizedDirectionX);
		
		normalizedDirectionX /= abs;
		normalizedDirectionY /= abs;
		
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
		
		if(carriedObject != null) {
			Depth.getInstance().printTabs();
			System.out.println("Kerem, adja meg, hogy el kivanja-e dobni a dobozt vagy sem. [i/n]");
			
			proto.ProtoMain.line = proto.ProtoMain.in.next();
			
			
			if(proto.ProtoMain.line.equals("i")) { /*Sztringeket a .equals()-szal komparalunk. :P*/
				Depth.getInstance().printTabs();
				System.out.println("Kerem, adja meg, hogy van-e hely a doboznak! [i/n]");	
				
				proto.ProtoMain.line = proto.ProtoMain.in.next();
				
				if (proto.ProtoMain.line.equals("i"))
					carriedObject.release();
			}
			
			if(proto.ProtoMain.line.equals("n")) { /*Sztringeket a .equals()-szal komparalunk. :P*/
				carriedObject.setPos(12, 12);
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
		
		if(shootingYellow) {
			projFactory.createProjectile(Colour.YELLOW, x, y, 1.0, 1.0);
		}
		if(shootingBlue) {
			projFactory.createProjectile(Colour.BLUE, x, y, 1.0, 1.0);
		}
			
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".shoot()\n");
		
	}
	
	@Override
	public void visit(ICarriable carriable) {
		
		Depth.getInstance().printTabs();
		System.out.print(name + ".visit()\n");
		Depth.getInstance().enterFunction();
		
		carriable.regCarrier(this);
		carriedObject=carriable;
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
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
		
		if (zpm != null) {
			zpm.pickUp();
		}
		
		/*
		 * ZPM-ek novelese kell ide.
		 */
			
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".visit()\n");
	}

	
	@Override
	public void notify(IWorldObject obj) {
		Depth.getInstance().printTabs();
		System.out.print(name + ".notify()\n");
		Depth.getInstance().enterFunction();	
		
		IVisitable visitable=obj.getVisitable();
		if (visitable != null) {
			visitable.accept(this);
		}
		
		Depth.getInstance().returnFromFunction();
		Depth.getInstance().printTabs();
		System.out.print("ret " + name + ".notify() \n");
		
		
	}
	
	public Player(IWorldObject worldObject,double mass) {
		super(worldObject,mass);
	}
}
