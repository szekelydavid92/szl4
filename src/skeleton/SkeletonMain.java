package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import upper_layer.entity.Player;

public class SkeletonMain {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String line = null;
	
	public static void main(String[] args) {
		System.out.print("Tunderpuszcsyka\n");
		System.out.print("8=====Dn");
		
	}
	//O�Neill mozgat�sa
	void case_1(){
		Player p = new Player();
		System.out.println("O�Neill vez�rl�f�ggv�nyeinek tesztel�se\n");
		//FEL
		System.out.println("K�rem, adja meg, hogy O�Neill felfel� mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveUp(true);
		if(line.equals("n")) p.moveUp(false);
		//LE
		System.out.println("K�rem, adja meg, hogy O�Neill lefel� mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveDown(true);
		if(line.equals("n")) p.moveDown(false);
		//JOBBRA
		System.out.println("K�rem, adja meg, hogy O�Neill jobbra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) 		{p.moveRight(true);}
		else if(line.equals("n")) 	{p.moveRight(false);}
		else {
			System.out.println("ERROR: �rv�nytelen bemenet!/n");
		}
		//BALRA
		System.out.println("K�rem, adja meg, hogy O�Neill balra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveLeft(true);
		if(line.equals("n")) p.moveLeft(false);
		
	}
	//S�rga l�ved�k l�v�se
	void case_2(){
	
	}
	//K�k l�ved�k l�v�se
	void case_3(){
		
	}
	//S�rga csillagkapu nyit�sa
	void case_4(){
		
	}
	//K�k csillagkapu nyit�sa
	void case_5(){
		
	}
	//Csillagkapu �tj�r�sa
	void case_6(){
		
	}
	//Doboz felv�tele
	void case_7(){
			
	}
	//Doboz lerak�sa
	void case_8(){
		
	}
	//ZPM felv�tele
	void case_9(){
		
	}
	//Ajt� nyit�sa
	void case_10(){
			
	}
	// Ajt� z�r�sa
	void case_11(){
			
	}
	//Objektum megsemmis�l�se
	void case_12(){
		
	}
}