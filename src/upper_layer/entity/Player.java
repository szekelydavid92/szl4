package upper_layer.entity;

import common.ICarriable;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IWorldObject;
import common.IZPM;

/**
 * Õ a játékos. Képes hordozni az ICarriable-t megvalósító objektumot és megölhetõ.
 */
public class Player extends Killable {
	/**
	 * Ezzel a függvénnyel lehet rákényszeríteni a játékost, hogy elengedje a cipelt dobozt, pl. ha az megsemmisül.
	 * @return void
	 */
	public void forcedRelelease() {}
	
	
	/**
	 * Ezzel a függvénnyel lehet a játékost elteleportálni az (x,y) pozícióba.
	 * @param x Az x koordináta.
	 * @param y Az y koordináta.
	 * @return void
	 */
	public void teleport(double x, double y) {}
	
	
	/**
	 * Ha valaki lehívja ezt a függvényt, a játékos a felfelé megy.
	 * @param up ???????
	 * @return void
	 */
	public void moveUp(boolean up) {}
	
	
	/**
	 * Ha valaki lehívja ezt a függvényt, a játékos a lefelé megy.
	 * @param down ???????
	 * @return void
	 */
	public void moveDown(boolean down) {}
	
	
	/**
	 * Ha valaki lehívja ezt a függvényt, a játékos a balra megy.
	 * @param left ???????
	 * @return void
	 */
	public void moveLeft(boolean left) {}
	
	
	/**
	 * Ha valaki lehívja ezt a függvényt, a játékos a jobbra megy.
	 * @param right ???????
	 * @return void
	 */
	public void moveRigh(boolean right) {}
	
	
	/**
	 * Ha valaki lehívja ezt a függvényt, a játékos a fölveszi az elõtte lévõ dobozt.
	 * @param pick ???????
	 * @return void
	 */
	public void pickUp(boolean pick) {}
	
	
	/**
	 * Itt lehet megadni, hogy a játékos mely irányba lõjön.
	 * @param x Az x koordináta.
	 * @param y Az y koordináta.
	 * @return void
	 */
	public void lookAt(double x,double y) {}
	
	
	/**
	 * Ha valaki lehívja, a játékos kilõ egy sárga lövedéket.
	 * @param shootingYellow ???????
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {}
	
	
	/**
	 * Ha valaki lehívja, a játékos kilõ egy kék lövedéket.
	 * @param shootingBlue ???????
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {}
	
	
	/**
	 * Ezzel lehet megölni a játékost.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ez a függvény lépteti elõre az állapotát az idõben.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * Ez a függvény valósítja meg a játékos mozgását.
	 * @return void
	 */
	public void move() {}
	
	
	/**
	 * Ez a függvény valósítja meg a doboz cipelését.
	 * @return void
	 */
	public void carryBox() {}
	
	
	/**
	 * Ez a függvény valósítja meg a lövést.
	 * @return void
	 */
	public void shoot() {}
	
	
	@Override
	public void visit(ISpecWall wall) {}

	
	@Override
	public void visit(IKillable killable) {}

	
	@Override
	public void visit(ICarriable carriable) {}

	
	@Override
	public void visit(IZPM zpm) {}

	
	@Override
	public void visit(ITeleportable teleportable) {}

	
	@Override
	public void notify(IWorldObject obj) {}
}
