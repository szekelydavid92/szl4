package upper_layer.entity;

import java.util.Random;

import common.IEntity;

public class ReplicatorController implements IEntity {
	private int direction;
	private boolean active;
	private Replicator replicator;
	
	public void setReplicator(Replicator r) {
		replicator = r;
	}
	
	public int randomize() {
		
	}
	
	@Override
	public void step() {
		
		if (active) {
			switch (direction) {
				case 0:
					replicator.moveUp(true);
					break;
				case 1:
					replicator.moveLeft(true);
					replicator.moveUp(true);
					break;
				case 2:
					replicator.moveLeft(true);
					break;
				case 3:
					replicator.moveLeft(true);
					replicator.moveDown(true);
					break;
				case 4:
					replicator.moveDown(true);
					break;
				case 5:
					replicator.moveDown(true);
					replicator.moveRight(true);
					break;
				case 6:
					replicator.moveRight(true);
					break;
				case 7:
					replicator.moveRight(true);
					replicator.moveUp(true);
					break;
			}
		}
		
	}
	
	public void move(boolean up, boolean down, boolean left, boolean right) {
		if (!active) {
			replicator.moveUp(up);
			replicator.moveDown(down);
			replicator.moveLeft(left);
			replicator.moveRight(right);
		}
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}