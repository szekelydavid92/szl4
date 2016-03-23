package upper_layer.entity;

import common.ICarriable;
import common.ICarrier;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitor;
import common.IWorldObject;
import common.IZPM;

/**
 * Õ a doboz. Az ICarrier interfészt megvalósító objektum képes õket mozgatni.
 */
public class Box extends Killable implements ICarriable {
	/**
	 * A dobozt cipelõ objektum ezen keresztül tudja beállítani a doboz objektum pozícióját.
	 * @param x Az elsõ paraméter az x koordináta.
	 * @param y A második paraméter az y koordináta.
	 * @return void
	 */
	public void setPos(double x, double y) {}
	
	
	/**
	 * Itt értesül a doboz objektum, hogy a paraméterként kapott ICarrier interface-t megvalósító objektum õt cipeli.
	 * @param c ICarrier interfészt megvalósító objektum.
	 * @return void
	 */
	public void regCarrier(ICarrier c) {}
	
	
	/**
	 * A hordozó objektum ezen keresztül értesíti a doboz objektumot, hogy elengedte.
	 * @return void
	 */	
	public void release() {}
	
	
	/**
	 * Ezzel a függvénnyel lehet az osztály példányát megsemmisíteni.
	 * @return void
	 */	
	public void kill() {}
	
	
	/**
	 * Ezen keresztül közli a doboz, hogy õ killable és carriable.
	 * @param visitor IVisitor interfészt megvalósító objektum.
	 * @return void
	 */
	public void accept(IVisitor visitor) {}
	
	
	/**
	 * Ha ütközik mérleggel, és épp nem cipeli senki, akkor lenyomja.
	 * @param o IWorldObject interfészt megvalósító objektum.
	 * @return void
	 */
	public void notify(IWorldObject o) {}
	
	
	/**
	 * Elõrelépteti a doboz állapotát az idõben.
	 * @return void
	 */
	public void step() {}


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
}
