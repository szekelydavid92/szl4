package proto;

import common.IControllable;
import upper_layer.entity.Player;

/**
 * @brief Ez az osztaly felel a player iranyitasaert.
 * 
 */
public class PlayerController {
	IControllable player;

	/**
	 * @brief Beallitja, az iranyitando player-t.
	 *
	 * @param controlledPlayer: az iranyitando player
	 *
	 * @return void
	 */
	public void setPlayer(Player controlledPlayer) {
		player=controlledPlayer;
	}
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * merre mozogjon az objektum
	 * 
	 * @param up:felfele irany, down: lefele irany
	 * left: balra irany, right: jobbra irany
	 *
	 * @return void
	 */
	public void move(boolean up, boolean down, boolean left, boolean right) {
		player.moveUp(up);
		player.moveDown(down);
		player.moveLeft(left);
		player.moveRight(right);
	}
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * vegyen-e fel, tegyen-e le carriable objektumot.
	 * 
	 * @param pick: tegyen-e le, vegyen-e fel carriable objektumot
	 *
	 * @return void
	 */
	public void pickUp(boolean up) {
		player.pickUp(up);
	}
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * az objektum iranyvektorat.
	 * 
	 * @param double x: iranyvektor x koordinataja
	 * double y: iranyvektor y koordinataja
	 *
	 * @return void
	 */
	public void lookAt(double x, double y) {
		player.lookAt(x, y);
	}
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * lojon-e sarga lovedeket az objektum.
	 * 
	 * @param shootingYellow lojon/ne lojon sarga lovedeket
	 *
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow) {
		player.shootYellow(shootingYellow);
	}
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * lojon-e kek lovedeket az objektum.
	 * 
	 * @param shootingBlue: lojon/ne lojon kek lovedeket
	 *
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue) {
		player.shootBlue(shootingBlue);
	}
	
	
	
	

}
