package upper_layer.entity;

import common.ICarriable;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IWorldObject;
import common.IZPM;

/**
 * Ez a jatekos. Kepes hordozni az ICarriable-t megvalosoto objektumot es megolheto.
 */
public class Player extends Killable {
	/**
	 * Ezzel a fuggvennyel lehet rakenyszeriteni a jatekost, hogy elengedje a cipelt dobozt, pl. ha az megsemmisul.
	 * @return void
	 */
	
	private double posX, posY;
	
	public void forcedRelelease() {}
	
	/*
	 * segédfv, egy adott poziciorol eldönti, hogy az az
	 * adott pályához érvényes pozicio lehet-e, vagy sem
	 * esetleg ha nem, akkor merre lóg ki
	 * 
	 */
	private boolean validPos(double x, double y){
		return true;
	}
	
	/**
	 * Ezzel a fuggvennyel lehet a jatekost elteleportalni az (x,y) pozicioba.
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void teleport(double x, double y) {
		if(validPos(x, y)){
			posX = x;
			posY = y;
		} else {
			
		}
		
	}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a felfele megy.
	 * @param up ???????
	 * @return void
	 */
	public void moveUp(boolean up) {}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jetokos a lefele megy.
	 * @param down ???????
	 * @return void
	 */
	public void moveDown(boolean down) {}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a balra megy.
	 * @param left ???????
	 * @return void
	 */
	public void moveLeft(boolean left) {}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a jobbra megy.
	 * @param right ???????
	 * @return void
	 */
	public void moveRight(boolean right) {}
	
	
	/**
	 * Ha valaki lehivja ezt a fuggvenyt, a jatekos a felveszi az elotte levo dobozt.
	 * @param pick ???????
	 * @return void
	 */
	public void pickUp(boolean pick) {}
	
	
	/**
	 * Itt lehet megadni, hogy a jatekos mely iranyba lojon.
	 * @param x Az x koordinata.
	 * @param y Az y koordinata.
	 * @return void
	 */
	public void lookAt(double x,double y) {}
	
	
	/**
	 * Ha valaki lehivja, a jatekos kilo egy sarga lovedeket.
	 * @param shootingYellow ???????
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {}
	
	
	/**
	 * Ha valaki lehivja, a jatekos kilo egy kek lovedeket.
	 * @param shootingBlue ???????
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {}
	
	
	/**
	 * Ezzel lehet megolni a jatekost.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ez a fuggveny lepteti elore az allapotat az idoben.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * Ez a fuggveny valositja meg a jatekos mozgasat.
	 * @return void
	 */
	public void move() {}
	
	
	/**
	 * Ez a fuggveny valositja meg a doboz cipeleset.
	 * @return void
	 */
	public void carryBox() {}
	
	
	/**
	 * Ez a fuggveny valositja meg a lovest.
	 * @return void
	 */
	public void shoot() {}
	
	
	@Override
	public void visit(ISpecWall wall) {
		//TODO Lorant
	}

	
	@Override
	public void visit(IKillable killable) {
		//TODO Lorant
	}

	
	@Override
	public void visit(ICarriable carriable) {
		//TODO Lorant
	}

	
	@Override
	public void visit(IZPM zpm) {
		//TODO Lorant
	}

	
	@Override
	public void visit(ITeleportable teleportable) {
		//TODO Lorant
	}

	
	@Override
	public void notify(IWorldObject obj) {
		//TODO Lorant
	}
}
