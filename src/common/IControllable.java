package common;

public interface IControllable {
	
	public void moveUp(boolean up); 
	
	public void moveDown(boolean down);
	
	public void moveLeft(boolean left);
	
	public void moveRight(boolean right);
	
	public void pickUp(boolean pick);
	
	public void lookAt(double x, double y);
	
	public void shootYellow(boolean shootingYellow);
	
	public void shootBlue(boolean shootingBlue);
	
}
