package proto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

import bottom_layer.World;
import bottom_layer.WorldObject;
import bottom_layer.WorldObjectFactory;
import upper_layer.entity.Box;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Chasm;
import upper_layer.reactive.Scale;
import upper_layer.reactive.ZPM;
import upper_layer.wormhole.Projectile;
import upper_layer.wormhole.ProjectileFactory;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

/*
 * Aprilis 19 21:00 Seres kommentezte a kodot, megirta a WorldObjectFactory, a ColEntity,
 * a Killable, a Player, a Box, a Projectile, a ProjectileFactory, a SpecWall, a Stargate,
 * a WormHole, konstruktorat.
 * 3 óra
 * 
 * Aprilis 20 16:00 1 óra Seres belekezdett a ProtoGodObject osztályba.
 * 
 * Aprilis 22 14:00 [] óra Seres belekezdett a GameFactory osztályba, es folytatta a ProtoGodObject
 * boviteset.
 * 
 */

public class ProtoMain {
	
	/*
	 * A Scanner azert kell, mert azzal lehet konnyen parsolni szamokat meg stringeket.
	 */
	public static Scanner in = new Scanner(System.in);
	
	public static String line = null;
	public static String name = "SkeletonMain";
	
	static CommandInterpreter commandInterpreter;
	
	
	public static void main(String[] args) {
		
		while (true) {
	        	writeCases();
				line = in.next();
				if(line.equals("0")) 		{ONeillTeszt.ONeillMozgatas();}
				else if(line.equals("1")) 	{ONeillTeszt.zpmFelvetel();}
				else if(line.equals("2")) 	{WormholeTest.KekLovedekLovese();}
				else if(line.equals("3")) 	{WormholeTest.SargaLovedekLovese();}
				else if(line.equals("4")) 	{WormholeTest.CsillagkapuNyitas();}
				else if(line.equals("5")) 	{WormholeTest.CsillagkapuAtjaras();}
				else if(line.equals("6")) 	{ONeillTeszt.dobozFelvetel();}
				else if(line.equals("7")) 	{ONeillTeszt.dobozLerakas();}
				else if(line.equals("8")) 	{AjtoDobozTeszt.ajtoNyitasZaras();}
				else if(line.equals("9")) 	{ONeillTeszt.oNeillMeghal();}
				else if(line.equals("10")) 	{AjtoDobozTeszt.boxMeghal();}
				else if(line.equals("11")) 	{
					commandInterpreter = new ProtoGodObject.ProtoCommandInterpreter(in);
					commandInterpreter.Menu();
				}
				else {break;}
	    }
	}
	
	static void writeCases(){
		System.out.println("\nO Neill mozgatasa[0]");
		System.out.println("ZPM felvetele[1]");
		System.out.println("Kek lovedek lovese[2]");
		System.out.println("Sarga lovedek lovese[3]");
		System.out.println("Csillagkapu nyitasa[4]");
		System.out.println("Csillagkapu atjarasa[5]");
		System.out.println("Doboz felvetele[6]");
		System.out.println("Doboz lerakasa[7]");
		System.out.println("Ajto nyitasa es zarasa[8]");
		System.out.println("Player Objektum megsemmisulese[9]");
		System.out.println("Box Objektum megsemmisulese[10]");
		System.out.println("Command line interpreter kiprobalasa[11]");
		System.out.println("Barmi mas: kilepes");
	}
}