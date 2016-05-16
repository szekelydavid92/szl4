package upper_layer.entity;

import common.ICarriable;
import common.ICarrier;
import common.IChasm;
import common.IControllable;
import common.IKillable;
import common.IProjectileFactory;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IVisitable;
import common.IWorldObject;
import common.IZPM;
import upper_layer.ZPMObserver;

import java.io.IOException;

import common.Colour;
import common.Direction;

/**
 * Ez a jatekos. Kepes hordozni az ICarriable-t megvalosoto objektumot es megolheto.
 */
public class Player extends Killable implements ITeleportable, ICarrier, IControllable {

	
	//public String name = "player"; //O kell az objektum nevenek a kiprintelesehez!
	public String name = new String("player");
	private int blockTeleportTime = 0;
	private int blockPickUpTime = 0;
	//////
	
	/*
	 * Attributumok
	 */
	int zpmNumber = 0; 						//Itt tárolódik a felvett ZPM-ek száma.
	public ICarriable carriedObject = null; 		// Referencia a cipelt objektumra.
	boolean up = false;						//ha a játékos fölfelé megy, false egyébként.
	boolean down = false;					//ha a játékos lefelé megy, false egyébként.
	boolean left = false;  					//ha a játékos balra megy, false egyébként.
	boolean right = false; 					//ha a játékos jobbra megy, false egyébként.
	boolean pick = false; 					//ha a játékos fölveszi az előtte lévő dobozt, false egyébként.
	double dirX = 0.0; 						//a kilövendő lövedék irányának X komponense
	double dirY = 0.0;  					//a kilövendő lövedék irányának Y komponense
	boolean shootingYellow = false; 			//ha a játékos sárga lövedéket lő, false egyébként.
	boolean shootingBlue = false;  			//ha a játékos kék lövedéket lő, false egyébként.
	private double displacement = 5.0;  	//megadja, hogy egy lépéssel a játékos mekkora távolságot tesz meg.
	public IProjectileFactory projFactory;
	private Direction direction;
	ZPMObserver zpmObserver = null;
	
	private static final double rotationalAngle = 0.0174532925 * 10.0;
	//eltértünk a spceifikációtól, ne használjatok egeret és billentyűzetet egyszerre
	private double angle = 0;
	
	/*
	 * Itt eltertunk a specifikációtól.
	 */
	
	//boolean justPicked = false;
	
	/*
	 * Metodusok
	 */
	public Player(double mass, IWorldObject playerObject) {
		super(playerObject,mass);
	}
	
	public void registerZPMObserver(ZPMObserver zpmObserver) {
		this.zpmObserver = zpmObserver;
	}
	
	public double getDirX() {
		return dirX;
	}
	
	public double getDirY() {
		return dirY;
	}
	
	public int getNumZPM() {
		return zpmNumber;
	}
	
	/**
	 * @brief Ezzel a fuggvennyel tudja kozolni egy visitorrel a tipusat.
	 * 
	 * @param visitor a visitor, aki meglatogatja ot.
	 * @return void
	 */
	public void accept(IVisitor visitor){		
		visitor.visit((IKillable) this);
		visitor.visit((ITeleportable) this);
	}
	
	/**
	 * @brief Ezzel a fuggvennyel lehet rakenyszeriteni a jatekost, hogy elengedje a cipelt dobozt, pl. ha az megsemmisul.
	 * 
	 * @return void
	 */
	public void forcedRelease() {		
		carriedObject = null;		
	}
		
	/**
	 * @brief Ezzel a fuggvennyel lehet a jatekost elteleportalni az (x,y) pozicioba.
	 * 
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void teleport(double x, double y) {		
		if (blockTeleportTime == 0) {
			worldObject.setPosX(x);
			worldObject.setPosY(y);
			blockTeleportTime = 20;
		}	
	}
	
	
	/**
	 * @brief Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti, hogy menjen-e a jatekos felfele.
	 * 
	 * @param up: menjen-e a jatekos felfele (true vagy false)
	 * @return void
	 */
	@Override
	public void moveUp(boolean up) {				
		this.up = up;
	}
	
	
	/**
	 * @brief Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e lefele.
	 * 
	 * @param down: menjen-e a jatekos lefele (true vagy false) 
	 * @return void
	 */
	@Override
	public void moveDown(boolean down) {
		this.down = down;		
	}
	
	
	/**
	 * @brief Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e balra.
	 * 
	 * @param left: menjen-e a jatekos balra (true vagy false) 
	 * @return void
	 */
	@Override
	public void moveLeft(boolean left) {		
		this.left = left;		
	}
	
	
	/**
	 * @brief Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos mozogjon-e jobbra.
	 * 
	 * @param right: menjen-e a jatekos jobbra (true vagy false) 
	 * @return void
	 */
	@Override
	public void moveRight(boolean right) {				
		this.right = right;		
	}
	
	
	/**
	 * @brief Ha valaki lehivja ezt a fuggvenyt, azzal eldontheti ,hogy a jatekos vegye-e fel az elotte levo dobozt.
	 * 
	 * @param pick: vegye-e fel a jatekos a dobozt(true vagy false) 
	 * @return void
	 */
	@Override
	public void pickUp(boolean pick) {		
		this.pick = pick;		
	}
	
	
	/**
	 * @brief Itt lehet megadni, hogy a jatekos mely iranyba lojon.
	 * 
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	@Override
	public void lookAt(double x,double y) {		
		this.dirX = x;
		this.dirY = y;		
	}
	
	
	/**
	 * @brief Ha valaki lehivja, azzal eldontheti, hogy lojon-e ki a jatekos egy sarga lovedeket.
	 * 
	 * @param shootingYellow: Lojon-e a jatekos sarga lovedeket (true vagy false).
	 * @return void
	 */
	@Override
	public void shootYellow(boolean shootingYellow) {		
		this.shootingYellow = shootingYellow;		
	}
	
	
	/**
	 * @brief Ha valaki lehivja, azzal eldontheti, hogy lojon-e ki a jatekos egy kek lovedeket.
	 * 
	 * @param shootingBlue: Lojon-e a jatekos kek lovedeket (true vagy false).
	 * @return void
	 */
	@Override
	public void shootBlue(boolean shootingBlue) {				
		this.shootingBlue = shootingBlue;		
	}
	
	
	/**
	 * @brief Ezzel lehet megolni a jatekost.
	 * 
	 * @return void
	 */
	@Override
	public void kill() {		
		if (carriedObject!=null) {
			carriedObject.release();
		}
		
		carriedObject=null;
		super.kill();		
	}
	
	
	/**
	 * @brief Ez a fuggveny lepteti elore az allapotat az idoben.
	 * 
	 * @return void
	 */
	public void step() {
		if(this.isAlive) {
			move(); 
			carryBox(); 
			shoot(); 
			if (blockTeleportTime > 0) {
				blockTeleportTime--;
			}
			
			if(blockPickUpTime > 0) {
				blockPickUpTime--;
			}
		}
	}
	
	
	/**
	 * @brief Ez a fuggveny valositja meg a jatekos mozgasat.
	 * 
	 * @return void
	 */
	protected void move() {
		double normalizedDirectionX = 0.0;
		double normalizedDirectionY = 0.0;
		
		if(up) 		{normalizedDirectionY += -1.0;}
		if(down)	{normalizedDirectionY +=  1.0;}
		if(left) 	{normalizedDirectionX += -1.0;}
		if(right)	{normalizedDirectionX +=  1.0;}
		
		double abs = Math.sqrt(normalizedDirectionY*normalizedDirectionY + normalizedDirectionX*normalizedDirectionX);
		
		if(abs > 1e-4) {
			normalizedDirectionX /= abs;
			normalizedDirectionY /= abs;
		}
		
		worldObject.setDisplacementX(displacement*normalizedDirectionX);
		worldObject.setDisplacementY(displacement*normalizedDirectionY);
	}
	
	
	/**
	 * @brief Ez a fuggveny valositja meg a doboz cipeleset.
	 * 
	 * @return void
	 */
	protected void carryBox() {		
		if(carriedObject != null) {
			//if(blockPickUpTime > 0) {
			//	justPicked = false;
			//} else {
				if(pick && (blockPickUpTime == 0)) {
					carriedObject.release();
					carriedObject = null;
					blockPickUpTime = 10;
				} else {
					carriedObject.setPos(worldObject.getPosX(),worldObject.getPosY());
				}
			//}
		}
	}
	
	
	/**
	 * @brief Ez a fuggveny valositja meg a lovest.
	 * 
	 * @return void
	 */
	protected void shoot() {
		if(projFactory != null) {
			double x = worldObject.getPosX();
			double y = worldObject.getPosY();
			
			if(shootingYellow) {
				projFactory.createProjectile(Colour.YELLOW, x, y, dirX, dirY);
			}
			if(shootingBlue) {
				projFactory.createProjectile(Colour.BLUE, x, y, dirX, dirY);
			}
		}
	}
	
	@Override
	public void rotateLeft() {
		
		this.angle -= this.rotationalAngle;
		
		this.dirX = this.getWorldObject().getPosX() + 10*Math.cos(this.angle);
		this.dirY = this.getWorldObject().getPosY() + 10*Math.sin(this.angle);
	}

	@Override
	public void rotateRight() {
		
		this.angle += this.rotationalAngle;
		
		this.dirX = this.getWorldObject().getPosX() + 10*Math.cos(this.angle);
		this.dirY = this.getWorldObject().getPosY() + 10*Math.sin(this.angle);
	}
	
	
	@Override
	public void setDirection(Direction dir) {
		direction=dir;
	}
	
	// Csunya, es majd at kell gondolni: 
	//A setDirection az ICollisionObservertol,
	//a getDirection pedig az ITeleportable interfacetol szarmazik...
	/*@Override
	public Direction getDirection() {
		return direction;
	}*/

	/**
	 * @brief Meglatogatunk egy carriable objektumot es ha a bemenet
	 * azt mondja, cipeljuk.
	 * 
	 * @param carriable: a cipelheto objektum.
	 * @return void
	 */
	@Override
	public void visit(ICarriable carriable) {		
		if(pick && (carriedObject == null) && (blockPickUpTime == 0)) {
			carriable.regCarrier(this);
			carriedObject=carriable;
			//justPicked = true;
			blockPickUpTime = 10;
		}
	}

	/**
	 * @brief Meglatogatunk egy ZPM objektumot es felvesszuk.
	 * 
	 * @param zpm: mutato a ZPM objektumra.
	 * @return void
	 */
	@Override
	public void visit(IZPM zpm) {		
		if (!zpm.isPicked()) {
			zpm.pickUp();
			zpmNumber++;
			if(zpmObserver != null) {
				zpmObserver.notifyPickUp();
			}
		}
	}

	/**
	 * @brief Ez a fuggveny ertesiti a replikatort arrol, hogy utkozott valakivel.
	 * 
	 * @param obj a world object, akivel utkozott.
	 */
	@Override
	public void notify(IWorldObject obj) {		
		IVisitable visitable=obj.getVisitable();
		if (visitable != null) {
			visitable.accept(this);
		}
	}
	
	/**
	 * @brief Bealitja a jatekos sebesseget
	 * 
	 * @param displacement a jatekos uj sebessege
	 * @return void
	 */
	public void setDisplacement(double displacement) {
		this.displacement=displacement;
	}
	
	/**
	 * @brief Ezzel tudjuk elkerni a jatekos altal cipelt dobozt
	 * 
	 * @return a cipelt doboz.
	 */
	public ICarriable getBox() {
		return carriedObject;
	}
	
	public Player(IWorldObject worldObject,IProjectileFactory projFactory,double mass) {
		super(worldObject,mass);
		this.projFactory = projFactory;
	}

	
}
