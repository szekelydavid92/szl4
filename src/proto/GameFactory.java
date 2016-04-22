package proto;

import bottom_layer.*;

class GameFactory {
	private World world;
	private GameLoop gameLoop; //Itt elterunk a specifikaciotol, de ez kell ide.
	
	GameFactory(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
		this.world = gameLoop.getWorld();
	}
}