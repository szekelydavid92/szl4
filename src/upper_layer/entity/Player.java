package upper_layer.entity;

import common.ICarriable;
import common.IKillable;
import common.ISpecWall;
import common.ITeleportable;
import common.IWorldObject;
import common.IZPM;

/**
 * � a j�t�kos. K�pes hordozni az ICarriable-t megval�s�t� objektumot �s meg�lhet�.
 */
public class Player extends Killable {
	/**
	 * Ezzel a f�ggv�nnyel lehet r�k�nyszer�teni a j�t�kost, hogy elengedje a cipelt dobozt, pl. ha az megsemmis�l.
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
	 * Ezzel a f�ggv�nnyel lehet a j�t�kost elteleport�lni az (x,y) poz�ci�ba.
	 * @param x Az x koordin�ta.
	 * @param y Az y koordin�ta.
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
	 * Ha valaki leh�vja ezt a f�ggv�nyt, a j�t�kos a felfel� megy.
	 * @param up ???????
	 * @return void
	 */
	public void moveUp(boolean up) {}
	
	
	/**
	 * Ha valaki leh�vja ezt a f�ggv�nyt, a j�t�kos a lefel� megy.
	 * @param down ???????
	 * @return void
	 */
	public void moveDown(boolean down) {}
	
	
	/**
	 * Ha valaki leh�vja ezt a f�ggv�nyt, a j�t�kos a balra megy.
	 * @param left ???????
	 * @return void
	 */
	public void moveLeft(boolean left) {}
	
	
	/**
	 * Ha valaki leh�vja ezt a f�ggv�nyt, a j�t�kos a jobbra megy.
	 * @param right ???????
	 * @return void
	 */
	public void moveRight(boolean right) {}
	
	
	/**
	 * Ha valaki leh�vja ezt a f�ggv�nyt, a j�t�kos a f�lveszi az el�tte l�v� dobozt.
	 * @param pick ???????
	 * @return void
	 */
	public void pickUp(boolean pick) {}
	
	
	/**
	 * Itt lehet megadni, hogy a j�t�kos mely ir�nyba l�j�n.
	 * @param x Az x koordin�ta.
	 * @param y Az y koordin�ta.
	 * @return void
	 */
	public void lookAt(double x,double y) {}
	
	
	/**
	 * Ha valaki leh�vja, a j�t�kos kil� egy s�rga l�ved�ket.
	 * @param shootingYellow ???????
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {}
	
	
	/**
	 * Ha valaki leh�vja, a j�t�kos kil� egy k�k l�ved�ket.
	 * @param shootingBlue ???????
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {}
	
	
	/**
	 * Ezzel lehet meg�lni a j�t�kost.
	 * @return void
	 */
	public void kill() {}
	
	
	/**
	 * Ez a f�ggv�ny l�pteti el�re az �llapot�t az id�ben.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * Ez a f�ggv�ny val�s�tja meg a j�t�kos mozg�s�t.
	 * @return void
	 */
	public void move() {}
	
	
	/**
	 * Ez a f�ggv�ny val�s�tja meg a doboz cipel�s�t.
	 * @return void
	 */
	public void carryBox() {}
	
	
	/**
	 * Ez a f�ggv�ny val�s�tja meg a l�v�st.
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
