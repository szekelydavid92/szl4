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
	//O’Neill mozgatása
	void case_1(){
		Player p = new Player();
		System.out.println("O’Neill vezérlõfüggvényeinek tesztelése\n");
		//FEL
		System.out.println("Kérem, adja meg, hogy O’Neill felfelé mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveUp(true);
		if(line.equals("n")) p.moveUp(false);
		//LE
		System.out.println("Kérem, adja meg, hogy O’Neill lefelé mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveDown(true);
		if(line.equals("n")) p.moveDown(false);
		//JOBBRA
		System.out.println("Kérem, adja meg, hogy O’Neill jobbra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) 		{p.moveRight(true);}
		else if(line.equals("n")) 	{p.moveRight(false);}
		else {
			System.out.println("ERROR: érvénytelen bemenet!/n");
		}
		//BALRA
		System.out.println("Kérem, adja meg, hogy O’Neill balra mozogjon-e![i/n]\n");
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(line.equals("i")) p.moveLeft(true);
		if(line.equals("n")) p.moveLeft(false);
		
	}
	//Sárga lövedék lövése
	void case_2(){
	
	}
	//Kék lövedék lövése
	void case_3(){
		
	}
	//Sárga csillagkapu nyitása
	void case_4(){
		
	}
	//Kék csillagkapu nyitása
	void case_5(){
		
	}
	//Csillagkapu átjárása
	void case_6(){
		
	}
	//Doboz felvétele
	void case_7(){
			
	}
	//Doboz lerakása
	void case_8(){
		
	}
	//ZPM felvétele
	void case_9(){
		
	}
	//Ajtó nyitása
	void case_10(){
			
	}
	// Ajtó zárása
	void case_11(){
			
	}
	//Objektum megsemmisülése
	void case_12(){
		
	}
}