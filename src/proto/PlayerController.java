package proto;

import common.IControllable;
import upper_layer.entity.Player;

public class PlayerController {
	IControllable player;
	
	public void setPlayer(Player controlledPlayer) {
		player=controlledPlayer;
	}
	
	public void move(boolean up, boolean down, boolean left, boolean right) {
		player.moveUp(up);
		player.moveDown(down);
		player.moveLeft(left);
		player.moveRight(right);
	}
	
	public void pickUp(boolean up) {
		player.pickUp(up);
	}
	

}
