package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
import common.IControllable;
import common.IController;

public class ControllerWhiteBoard implements IController, KeyListener, MouseListener {
	IControllable oneill; //fel, le jobb, bal , forog(egérmozg), lő(katt, jobbklikk) 
	IControllable jaffa;  //WASD, lő(Q, E) forog(1, 2)
	

	@Override
	public void setOneill(IControllable contr){
		this.oneill = contr;
	}

	@Override
	public void setJaffa(IControllable contr){
		this.jaffa = contr;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() ==MouseEvent.BUTTON1){
			oneill.shootBlue(true);
		}
		if(e.getButton() ==MouseEvent.BUTTON2){
			oneill.shootYellow(true);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() ==MouseEvent.BUTTON1){
			oneill.shootBlue(false);
		}
		if(e.getButton() ==MouseEvent.BUTTON2){
			oneill.shootYellow(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			oneill.moveUp(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			oneill.moveDown(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			oneill.moveRight(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			oneill.moveLeft(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W){
			jaffa.moveUp(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A){
			jaffa.moveLeft(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S){
			jaffa.moveDown(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			jaffa.moveRight(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q){
			jaffa.shootBlue(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E){
			jaffa.shootYellow(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_1){
			//TODO
		}
		
		if(e.getKeyCode() == KeyEvent.VK_2){
			//TODO
		}
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			oneill.moveUp(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			oneill.moveDown(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			oneill.moveRight(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			oneill.moveLeft(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W){
			jaffa.moveUp(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A){
			jaffa.moveLeft(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S){
			jaffa.moveDown(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D){
			jaffa.moveRight(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Q){
			jaffa.shootBlue(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_E){
			jaffa.shootYellow(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_1){
			//TODO
		}
		
		if(e.getKeyCode() == KeyEvent.VK_2){
			//TODO
		}

	}
	

}
