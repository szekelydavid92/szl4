package proto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import bottom_layer.GameLoop;
import bottom_layer.World;
import bottom_layer.WorldObject;
import common.Colour;
import common.ICarriable;
import common.IChasm;
import common.IKillable;
import common.IProjectile;
import common.IScale;
import common.ISpecWall;
import common.ITeleportable;
import common.IVisitable;
import common.IVisitor;
import common.IWorldObject;
import upper_layer.entity.Box;
import upper_layer.entity.Door;
import upper_layer.entity.Player;
import upper_layer.reactive.Scale;
import common.IZPM;
import upper_layer.reactive.ZPM;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

class ProtoGodObject {
	private World world;
	private GameLoop gameLoop;
	private static ProtoGodObject instance = null;
	
	static class VisitableWriter implements IVisitor {
		public static enum VisitableType { zpm,chasm,projectile}
		VisitableType visiting;
		public void visit(IZPM zpm) {
			if (visiting==VisitableType.zpm) {
			System.out.println("Pozicio: " + ((ZPM)zpm).getWorldObject().getPosX() + ", " +
					((ZPM)zpm).getWorldObject().getPosY()	);
			System.out.println("Zpm szelessege" + ((ZPM)zpm).getWorldObject().getWidth() +
					", Magassaga: " + ((ZPM)zpm).getWorldObject().getHeight());
			System.out.println("ZPM allapota: " + (zpm.isPicked()?"felveve":"nincs felveve") );
			}
		}
		
		public void visit(ISpecWall specWall) {
			
		}
		
		public void visit(ITeleportable teleportable) {
			
		}
		
		public void visit(IKillable killable) {
			
		}
		
		public void visit(IScale scale) {
			
		}
		
		public void visit(ICarriable carriable) {
			
		}

		
		public void visit(IProjectile projectile) {
			if (visiting==VisitableType.projectile) {
				System.out.println("");
			}
			
		}

		@Override
		public void visit(IChasm chasm) {
			// TODO Auto-generated method stub
			
		}
			
	}
	
	
	/*
	 * Ott elterunk a specifikaciotol, hogy ezek az attributumok publicok,
	 * mivel ez ugyis kikerul a vegso programbol, ez nem tragedia.
	 */
	public List<WorldObject> walls = new LinkedList<WorldObject>();
	public List<SpecWall> specWalls = new LinkedList<SpecWall>();
	public Map<String, WormHole> stargates = new TreeMap<String, WormHole>();
	public List<Box> boxes = new LinkedList<Box>();
	public List<Scale> scales = new LinkedList<Scale>();
	public List<Door> doors = new LinkedList<Door>();
	public Map<String, Player> players = new TreeMap<String, Player>();
	
	public static ProtoGodObject getInstance() {
		if(instance == null) {
			instance = new ProtoGodObject();
		}
		
		return instance;
	}

	private void run(int iterations) {
		for(int i=0;i < iterations;i++) {
			gameLoop.run();
		}
	}
	
	private boolean loadMap(String map)
	{
		world = new World();
		gameLoop = new GameLoop(world);

		walls.clear();
		specWalls.clear();
		
		GameFactory gameFactory = new GameFactory(gameLoop);
		
		gameFactory.createWall(0, 0, 10, 10);
		gameFactory.createWall(0, 10, 10, 20);
		gameFactory.createSpecWall(10, 10, 10, 20);
		
		return true;
	}
	
	private void listZpms() {
		System.out.println("listZpms");
		
		VisitableWriter visitableWriter= new VisitableWriter();
		for (WorldObject o : world.objects) {
			IVisitable zpm= o.getVisitable();
			if (zpm != null) {
				zpm.accept(visitableWriter);
			}
		}
		
		System.out.println("");
	}
	
	private void listWalls() {
		for(WorldObject o : walls) {
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			System.out.println("Fal típusa: általános");
			System.out.println("Falhoz tartozó csillagkapu:");
			System.out.println("");
		}
		
		for(SpecWall s : specWalls) {
			IWorldObject o = s.getWorldObject();
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			System.out.println("Fal típusa: speciális");
			System.out.println("Falhoz tartozó csillagkapu:"); //TODO ezt meg kell csinalni
			System.out.println("");
		}
	}
	
	//listazasra kell: !scales, !stargates, !doors, players(map), zpm/projectile/chams(majd a world bejarasaval kell)
	private void listStargates(String colour) {
		//TODO (map mar letre van hozva
//		Szín: [portal színe]
//		WormHole: [amelyik féreglyukhoz tartozik (lehet üres is, az első lövés után)]
//		Fal koordinátái: [portálhoz tartozó fal x koordinátája, portálhoz tartozó fal y koordinátája]
//		Megjegyzés: Ha van érvényes szín paraméter, akkor csak a megadott színű csillagkapuk tulajdonságait listázza.
	}
	
	private void listBoxes() {
		for(Box b : boxes) {
			IWorldObject o = b.getWorldObject();
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Doboz szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			System.out.println("Cipelő játékos neve: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println("Doboz súlya: " + b.getMass());
			System.out.println("Megsemmisült-e: " + b.isKilled());
			System.out.println("");
		}
	}
	
	private void listScales() {
		for(Scale s : scales) {
			IWorldObject o = s.getWorldObject();
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Mérleg szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			System.out.println("Hozzátartozó ajtó pozíciója: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.print("Mérleg ajtónyitó súlykorlát: " + s.getMassThreshold());
			String state="felengedve";
			if(s.getMassThreshold() <= s.getAccumulatedMass()) {
				state="lenyomva";
			}
			System.out.println("Mérleg állapota: " + state);
			System.out.println("Mérlegen lévő aktuális súlyok összege: " + s.getAccumulatedMass());
			System.out.println("Mérlegen lévő dobozok száma: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}
	
	private void listDoors() {
		for(Door d : doors) {
			IWorldObject o = d.getWorldObject();
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Ajtó szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			if (d.isClosed()) {
				System.out.println("Az ajtó állapota: zárt");
			}
			else {
				System.out.println("Az ajtó állapota: nyitott");
			}
		}
	}
	
	private void listPlayers(String player) {
		if (player == null) {
			Set<String> keySet = players.keySet();
			for(String s : keySet) {
				Player p = players.get(s);
				IWorldObject o = p.getWorldObject();
				System.out.println("Játékos neve/típusa: " + s);
				System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
				System.out.println("Irányvektor: " + p.getDirX() + " " + p.getDirY());
				System.out.println("Játékos szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
				System.out.println("Felvett ZPM-ek száma: " + p.getZpmNumber());
				System.out.println("Cipelt dobozok van-e: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				String isDead = "igen";
				if (p.isKilled()) {
					isDead = "nem";
				}
				System.out.println("Halott-e: " + isDead);
			}
		} else {
			Player p = players.get(player);
			IWorldObject o = p.getWorldObject();
			System.out.println("Játékos neve/típusa: " + player);
			System.out.println("Pozíció: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Irányvektor: " + p.getDirX() + " " + p.getDirY());
			System.out.println("Játékos szélessége: " + o.getWidth() + ", Magassága: " + o.getHeight());
			System.out.println("Felvett ZPM-ek száma: " + p.getZpmNumber());
			System.out.println("Cipelt dobozok van-e: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String isDead = "igen";
			if (p.isKilled()) {
				isDead = "nem";
			}
			System.out.println("Halott-e: " + isDead);
		}
	}
//		Játékos neve: [játékos neve]
//		Pozíció: [x koordináta, y koordináta]
//		Irányvektor: [x koordináta,y koordináta]
//		Játékos szélessége: [szélesség] , Magassága: [magasság]
//		ZPMek: [felvett ZPMek száma]
//		Cipelt doboz: [van-e/nincs-e]
//		Halott: [igen/nem]
//		Megjegyzés: Ha van érvényes név paraméter, akkor csak a megadott játékos tulajdonságait listázza.
	
	public static class ProtoLoadMap implements IProtoCommand {
		
		/*
		 * VIGYAZAT! A palyanevbe implementacios okokbol NE keruljon szokoz!
		 */
		@Override
		public boolean Execute(Scanner in) {
			String mapName = in.next();
			
			System.out.println("loadMap");
			ProtoGodObject.getInstance().loadMap(mapName);
			return true;
		}
		
		ProtoLoadMap() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	
	public static class ProtoRun implements IProtoCommand {

		@Override
		public boolean Execute(Scanner in) {
			int iterations = in.nextInt();
			
			System.out.println("run");
			ProtoGodObject.getInstance().run(iterations);
			return true;
		}
		
		ProtoRun() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	

	
	public static class ProtoListWalls implements IProtoCommand {

		@Override
		public boolean Execute(Scanner in) {
			
			System.out.println("listWalls");
			ProtoGodObject.getInstance().listWalls();
			return true;
		}
		
		ProtoListWalls() {
			/*
			 * Ures fuggvenytorzs
			 */
		}
		
	}
	
	public static class ProtoCommandInterpreter extends CommandInterpreter {

		ProtoCommandInterpreter(Scanner in) {
			super(in);
			
			commands.put("loadMap", new ProtoGodObject.ProtoLoadMap());
			commands.put("run", new ProtoGodObject.ProtoRun());
			commands.put("listWalls", new ProtoGodObject.ProtoListWalls());
		}
	}
	
	public ProtoGodObject() {
		/*
		 * A biztonsag kedveert, hogy hulye bemenet eseten ne szalljon el a program.
		 */
		world = new World();
		gameLoop = new GameLoop(world);
	}
}
