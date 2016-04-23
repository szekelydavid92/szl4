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
 * Aprilis 22 14:00 9 óra Seres belekezdett a GameFactory (createWall createSpecWall) osztályba,
 * es folytatta a ProtoGodObject boviteset. LoadLevel megírása, Replicator notify() függvénye
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
		commandInterpreter = new ProtoGodObject.ProtoCommandInterpreter(in);
		commandInterpreter.Menu();
	}
}