package upper_layer;

import common.Direction;

public class Utility {
	public static Direction getPair(Direction direction) {
		if (direction == Direction.UP) {
			return Direction.DOWN;
		}
		else if (direction == Direction.DOWN) {
			return Direction.UP;
		}
		else if (direction== Direction.LEFT) {
			return Direction.RIGHT;
		}
		else {
			return Direction.LEFT;
		}
		/*
		switch(direction) {
		case UP:
			return Direction.DOWN;
		case DOWN:
			return Direction.UP;
		case LEFT:
			return Direction.RIGHT;
		case RIGHT:
			return Direction.LEFT;
		default:
			return Direction.UP;
		}*/
	}
}
