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
import proto.ProtoGodObject.VisitableWriter.VisitableType;
import upper_layer.reactive.ZPM;
import upper_layer.wormhole.Projectile;
import upper_layer.wormhole.SpecWall;
import upper_layer.wormhole.Stargate;
import upper_layer.wormhole.WormHole;

class ProtoGodObject {
	private World world;
	private GameLoop gameLoop;
	private static ProtoGodObject instance = null;
	
	static class VisitableWriter implements IVisitor {
		public static enum VisitableType { zpm,chasm,projectile,neutral}
		VisitableType visiting;
		boolean justVisitedProjectile=false;
		public void visit(IZPM zpm) {	
			IWorldObject zpmWorldObject=((ZPM)zpm).getWorldObject();
			if (visiting==VisitableType.zpm) {
				System.out.println("Pozicio: " + zpmWorldObject.getPosX() + " " + ((ZPM)zpm).getWorldObject().getPosY());
				System.out.println("Zpm szelessege" + zpmWorldObject.getWidth() + ", Magassaga: " + zpmWorldObject.getHeight());
				System.out.println("ZPM allapota: " + (zpm.isPicked()?"felveve":"nincs felveve"));
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
				System.out.println("Lovedek szine: " + projectile.getColour() );
			}
			justVisitedProjectile=true;
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
		//gameFactory.createWall(0, 0, 10, 10);
		//gameFactory.createWall(0, 10, 10, 20);
		//gameFactory.createSpecWall(10, 10, 10, 20);
		LevelLoader levelLoader = new LevelLoader();
		levelLoader.load(map, gameFactory);
		return true;
	}
	
	private void movePlayer(String Player, boolean up, boolean down,
							boolean left, boolean right) {
		
	}
	
	private void listProjectiles() {
		System.out.println("listProjectiles");
		VisitableWriter visitableWriter=new VisitableWriter();
		visitableWriter.visiting=VisitableType.projectile;
		for (WorldObject o : world.objects) {
			IVisitable projectiles=o.getVisitable();
			if (projectiles != null) {
				projectiles.accept(visitableWriter);
			}
			if (visitableWriter.justVisitedProjectile) {
				System.out.println("Pozíció: " + o.getPosX() + "  " + o.getPosY());
				System.out.println("Lövedék szélessége: " + o.getWidth() + ", "	+ o.getHeight());
				System.out.println("");
			}
			visitableWriter.justVisitedProjectile=false;
		}
		System.out.println("");
	}
	
	private void listZpms() {
		System.out.println("listZpms");
		VisitableWriter visitableWriter= new VisitableWriter();
		visitableWriter.visiting=VisitableType.zpm;
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
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			System.out.println("Fal tÃ­pusa: Ã¡ltalÃ¡nos");
			System.out.println("Falhoz tartozÃ³ csillagkapu:");
			System.out.println("");
		}
		
		for(SpecWall s : specWalls) {
			IWorldObject o = s.getWorldObject();
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			System.out.println("Fal tÃ­pusa: speciÃ¡lis");
			System.out.println("Falhoz tartozÃ³ csillagkapu:"); //TODO ezt meg kell csinalni
			System.out.println("");
		}
	}
	
	private void listStargates(String colour) {
		//TODO (map mar letre van hozva
//		SzÃ­n: [portal szÃ­ne]
//		WormHole: [amelyik fÃ©reglyukhoz tartozik (lehet Ã¼res is, az elsÅ‘ lÃ¶vÃ©s utÃ¡n)]
//		Fal koordinÃ¡tÃ¡i: [portÃ¡lhoz tartozÃ³ fal x koordinÃ¡tÃ¡ja, portÃ¡lhoz tartozÃ³ fal y koordinÃ¡tÃ¡ja]
//		MegjegyzÃ©s: Ha van Ã©rvÃ©nyes szÃ­n paramÃ©ter, akkor csak a megadott szÃ­nÅ± csillagkapuk tulajdonsÃ¡gait listÃ¡zza.
	}
	
	private void listBoxes() {
		for(Box b : boxes) {
			IWorldObject o = b.getWorldObject();
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Doboz szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			System.out.println("CipelÅ‘ jÃ¡tÃ©kos neve: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println("Doboz sÃºlya: " + b.getMass());
			System.out.println("MegsemmisÃ¼lt-e: " + b.isKilled());
			System.out.println("");
		}
	}
	
	private void listChasms(){
		//TODO
		System.out.println("Test Chams [1] ...");
		System.out.println("Test Chams [2] ...");
		System.out.println("Test Chams [3] ...");
		System.out.println("");
		return;
	}
	
	private void listScales() {
		for(Scale s : scales) {
			IWorldObject o = s.getWorldObject();
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("MÃ©rleg szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			System.out.println("HozzÃ¡tartozÃ³ ajtÃ³ pozÃ­ciÃ³ja: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.print("MÃ©rleg ajtÃ³nyitÃ³ sÃºlykorlÃ¡t: " + s.getMassThreshold());
			String state="felengedve";
			if(s.getMassThreshold() <= s.getAccumulatedMass()) {
				state="lenyomva";
			}
			System.out.println("MÃ©rleg Ã¡llapota: " + state);
			System.out.println("MÃ©rlegen lÃ©vÅ‘ aktuÃ¡lis sÃºlyok Ã¶sszege: " + s.getAccumulatedMass());
			System.out.println("MÃ©rlegen lÃ©vÅ‘ dobozok szÃ¡ma: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}
	
	public void listCollosions(String state) {
		// TODO Auto-generated method stub
		//TODO
		System.out.println("Collosions listing...");
		System.out.println("");
		return;
	}

	public void listWormhole(String nev) {
		// TODO Auto-generated method stub
		//TODO
		System.out.println("Wormholes listing...");
		System.out.println("");
		return;
		
	}
	
	private void listDoors() {
		for(Door d : doors) {
			IWorldObject o = d.getWorldObject();
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("AjtÃ³ szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			if (d.isClosed()) {
				System.out.println("Az ajtÃ³ Ã¡llapota: zÃ¡rt");
			}
			else {
				System.out.println("Az ajtÃ³ Ã¡llapota: nyitott");
			}
		}
	}
	
	private void listPlayers(String player) {
		if (player == null) {
			Set<String> keySet = players.keySet();
			for(String s : keySet) {
				Player p = players.get(s);
				IWorldObject o = p.getWorldObject();
				System.out.println("JÃ¡tÃ©kos neve/tÃ­pusa: " + s);
				System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
				System.out.println("IrÃ¡nyvektor: " + p.getDirX() + " " + p.getDirY());
				System.out.println("JÃ¡tÃ©kos szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
				System.out.println("Felvett ZPM-ek szÃ¡ma: " + p.getZpmNumber());
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
			System.out.println("JÃ¡tÃ©kos neve/tÃ­pusa: " + player);
			System.out.println("PozÃ­ciÃ³: " + o.getPosX() + " " + o.getPosY());
			System.out.println("IrÃ¡nyvektor: " + p.getDirX() + " " + p.getDirY());
			System.out.println("JÃ¡tÃ©kos szÃ©lessÃ©ge: " + o.getWidth() + ", MagassÃ¡ga: " + o.getHeight());
			System.out.println("Felvett ZPM-ek szÃ¡ma: " + p.getZpmNumber());
			System.out.println("Cipelt dobozok van-e: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String isDead = "igen";
			if (p.isKilled()) {
				isDead = "nem";
			}
			System.out.println("Halott-e: " + isDead);
		}
	}
//		JÃ¡tÃ©kos neve: [jÃ¡tÃ©kos neve]
//		PozÃ­ciÃ³: [x koordinÃ¡ta, y koordinÃ¡ta]
//		IrÃ¡nyvektor: [x koordinÃ¡ta,y koordinÃ¡ta]
//		JÃ¡tÃ©kos szÃ©lessÃ©ge: [szÃ©lessÃ©g] , MagassÃ¡ga: [magassÃ¡g]
//		ZPMek: [felvett ZPMek szÃ¡ma]
//		Cipelt doboz: [van-e/nincs-e]
//		Halott: [igen/nem]
//		MegjegyzÃ©s: Ha van Ã©rvÃ©nyes nÃ©v paramÃ©ter, akkor csak a megadott jÃ¡tÃ©kos tulajdonsÃ¡gait listÃ¡zza.
	
	
	
	
	public static class ProtoLoadMap implements IProtoCommand {
		/*
		 * VIGYAZAT! A palyanevbe implementacios okokbol NE keruljon szokoz!
		 */
		@Override
		public boolean Execute(Scanner in) {
			String mapName = in.next();
			/*
			 * TODO Ki kell üríteni a ProtoGodObject listáit.
			 */
			System.out.println("loadMap");
			ProtoGodObject.getInstance().loadMap(mapName);
			return true;
		}	
		ProtoLoadMap() {}
	}
	
	public static class ProtoRun implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			int iterations = in.nextInt();
			System.out.println("run");
			ProtoGodObject.getInstance().run(iterations);
			return true;
		}
		ProtoRun() {}
	}

	
	public static class ProtoPlayerMove implements IProtoCommand {
		
		@Override
		public boolean Execute(Scanner in) {
			in.useDelimiter("\\s*");
			String cmd = in.next();
			String player=in.next();
			Boolean[] directions=new Boolean[4];
			for (int i=0;in.hasNextInt();i++) {
				if (in.nextInt() == 1)
					directions[i]=true;
				else
					directions[i]=false;		
			}
			boolean up=directions[0],down=directions[1],left=directions[2],
					right=directions[3];
			ProtoGodObject.getInstance().movePlayer(player,up,down,left,right);
			
			
			
			if (player.equals("oneill")) {
				
			}
			else if (player.equals("jaffa")) {
				
			}
			else if (player.equals("replikator")) {
				
			}
			
			return true;
		}
	}
	

	public static class ProtoListWalls implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listWalls");
			ProtoGodObject.getInstance().listWalls();
			return true;
		}
		ProtoListWalls() {}
	}
	
	public static class ProtoListStargates implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listStargates");
			String col = in.next();
			ProtoGodObject.getInstance().listStargates(col);
			return false;
		}
	}
	
	
	public static class ProtoListZPM implements IProtoCommand{
		void ProtoLidtZPM() {}
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listZPM");
			ProtoGodObject.getInstance().listZpms();
			return false;
		}
	}
	
	public static class ProtoListWormHoles implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listWormHoles");
			String nev = in.next();
			ProtoGodObject.getInstance().listWormhole(nev);
			return false;
		}
	}
	
	public static class ProtoListCollosions implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listCollosions");
			String state = in.next();
			ProtoGodObject.getInstance().listCollosions(state);
			return false;
		}
	}
	
	public static class ProtoListChasms implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listChasms");
			ProtoGodObject.getInstance().listChasms();
			return false;
		}
		
	}
	
	public static class ProtoListProjectiles implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listProjectiles");
			ProtoGodObject.getInstance().listProjectiles();
			return false;
		}
		ProtoListProjectiles() {}
	}
	
	public static class ProtoListBoxes implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listBoxes");
			ProtoGodObject.getInstance().listBoxes();
			return false;
		}
		ProtoListBoxes() {}
	}
	
	public static class ProtoListScales implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listScales");
			ProtoGodObject.getInstance().listScales();
			return false;
		}
		ProtoListScales() {}
	}
	
	public static class ProtoListDoors implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println("listDoors");
			ProtoGodObject.getInstance().listDoors();
			return false;
		}
		ProtoListDoors() {}
	}
	
	public static class ProtoCommandInterpreter extends CommandInterpreter {
		ProtoCommandInterpreter(Scanner in) {
			super(in);
			commands.put("loadMap", new ProtoGodObject.ProtoLoadMap());
			commands.put("run", new ProtoGodObject.ProtoRun());
			commands.put("listWalls", new ProtoGodObject.ProtoListWalls());
			commands.put("listProjectiles",new ProtoGodObject.ProtoListProjectiles());
			commands.put("listZPM",new ProtoGodObject.ProtoListZPM());
			commands.put("listStargates",new ProtoGodObject.ProtoListStargates());
			commands.put("listWormHoles",new ProtoGodObject.ProtoListWormHoles());
			commands.put("listCollisions",new ProtoGodObject.ProtoListCollosions());
			commands.put("listChasms",new ProtoGodObject.ProtoListChasms());
			commands.put("listBoxes", new ProtoGodObject.ProtoListBoxes());
			commands.put("listScales", new ProtoGodObject.ProtoListScales());
			commands.put("listDoors", new ProtoGodObject.ProtoListDoors());
			commands.put("move", new ProtoGodObject.ProtoPlayerMove());
			//setCursor, shoot, listPlayers, 


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
