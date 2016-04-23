package proto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

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
import upper_layer.entity.Replicator;
import upper_layer.entity.ReplicatorController;
import upper_layer.reactive.Chasm;
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
	public Replicator replicator=null;
	public PlayerController oneillController=new PlayerController() ;
	public PlayerController jaffaController=new PlayerController() ;
	public ReplicatorController replicatorController=null ;
	
	
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
		Chasm.getInstance().getChasms().clear();
		
		GameFactory gameFactory = new GameFactory(gameLoop);
		//gameFactory.createWall(0, 0, 10, 10);
		//gameFactory.createWall(0, 10, 10, 20);
		//gameFactory.createSpecWall(10, 10, 10, 20);
		
		LevelLoader levelLoader = new LevelLoader();
		levelLoader.load(map, gameFactory);
		return true;
	}
	
	private void movePlayer(String player, boolean up, boolean down,
							boolean left, boolean right) {
		if (player.equals("oneill")) {
			oneillController.move(up, down, left, right);
		}
		else if (player.equals("jaffa")) {
			jaffaController.move(up, down, left, right);
		}
		else if (player.equals("replikator")) {
			replicatorController.move(up, down, left, right);
		}
		else {
			System.out.println(" Rossz player név! Kérjük jaffa, oneill és replikator" +
							   "közül válassz! ");
		}
		System.out.println("");
	}
	
	private void listProjectiles() {
		VisitableWriter visitableWriter=new VisitableWriter();
		visitableWriter.visiting=VisitableType.projectile;
		for (WorldObject o : world.objects) {
			IVisitable projectiles=o.getVisitable();
			if (projectiles != null) {
				projectiles.accept(visitableWriter);
			}
			if (visitableWriter.justVisitedProjectile) {
				System.out.println("Pozicio: " + o.getPosX() + "  " + o.getPosY());
				System.out.println("Lövedék szélessége: " + o.getWidth() + ", "	+ o.getHeight());
				System.out.println("");
			}
			visitableWriter.justVisitedProjectile=false;
		}
		System.out.println("");
	}
	
	private void listZpms() {
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
			System.out.println("Pozicio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szelessege: " + o.getWidth() + ", magassaga: " + o.getHeight());
			System.out.println("Fal tipusa: altalanos");
			System.out.println("Falhoz tartozo csillagkapu:");
			System.out.println("");
		}
		
		for(SpecWall s : specWalls) {
			IWorldObject o = s.getWorldObject();
			System.out.println("Pozicio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Fal szelessege: " + o.getWidth() + ", magassaga: " + o.getHeight());
			System.out.println("Fal tipusa: altalanos");
			System.out.println("Falhoz tartozo csillagkapu:");
			System.out.println("");
		}
	}
	
	private void listStargates(String colour) {
		//TODO (map mar letre van hozva
//		Szi­n: [portal szi­ne]
//		WormHole: [amelyik fereglyukhoz tartozik (lehet ures is, az elso lovess utan)]
//		Fal koordinatai: [portalhoz tartozo fal x koordinataja, portalhoz tartozo fal y koordinataja]
//		Megjegyzes: Ha van ervenyes szi­n parameter, akkor csak a megadott szi­nÅ± csillagkapuk tulajdonsagait listazza.
	}
	
	private void listBoxes() {
		for(Box b : boxes) {
			IWorldObject o = b.getWorldObject();
			System.out.println("Pozi­cio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Doboz szelessege: " + o.getWidth() + ", Magassaga: " + o.getHeight());
			System.out.println("Cipelo jatekos neve: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println("Doboz siulya: " + b.getMass());
			System.out.println("Megsemmisult-e: " + b.isKilled());
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
			System.out.println("Pozi­cio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Merleg szelessege: " + o.getWidth() + ", Magassaga: " + o.getHeight());
			System.out.println("Hozzatartozo ajto pozi­cioja: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.print("Merleg ajtonyito siulykorlat: " + s.getMassThreshold());
			String state="felengedve";
			if(s.getMassThreshold() <= s.getAccumulatedMass()) {
				state="lenyomva";
			}
			System.out.println("Merleg allapota: " + state);
			System.out.println("Merlegen levo aktualis siulyok osszege: " + s.getAccumulatedMass());
			System.out.println("Merlegen levo dobozok szama: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		System.out.println("");
	}
	
	public void listCollosions(String state) {
		// TODO Auto-generated method stub
		//TODO
		System.out.println("Collosions listing...");
		System.out.println("");
		return;
	}
	
	public void setCursor(String ply, double x, double y) {
		
		
		return;
	}

	public void listWormhole(String nev) {
		// TODO Auto-generated method stub
		//TODO
		System.out.println("Wormholes listing...");
		System.out.println("");
		return;	
	}
	
	public void shoot(String player, boolean proj1, boolean proj2) {
		if (player.equals("oneill")) {
			
		}
		else if (player.equals("jaffa")) {
			
		}
		return;	
	}
	
	private void listDoors() {
		for(Door d : doors) {
			IWorldObject o = d.getWorldObject();
			System.out.println("Pozi­cio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Ajto szelessege: " + o.getWidth() + ", Magassaga: " + o.getHeight());
			if (d.isClosed()) {
				System.out.println("Az ajto allapota: zart");
			}
			else {
				System.out.println("Az ajto allapota: nyitott");
			}
		}
	}
	
	private void listPlayers(String player) {
		if (player == null) {
			Set<String> keySet = players.keySet();
			for(String s : keySet) {
				Player p = players.get(s);
				IWorldObject o = p.getWorldObject();
				System.out.println("Jatekos neve/ti­pusa: " + s);
				System.out.println("Pozi­cio: " + o.getPosX() + " " + o.getPosY());
				System.out.println("Iranyvektor: " + p.getDirX() + " " + p.getDirY());
				System.out.println("Jatekos szelessege: " + o.getWidth() + ", Magassaga: " + o.getHeight());
				System.out.println("Felvett ZPM-ek szama: " + p.getZpmNumber());
				System.out.println("Cipelt dobozok van-e: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				String isDead = "nem";
				if (p.isKilled()) {
					isDead = "igen";
				}
				System.out.println("Halott-e: " + isDead);
			}
		} else {
			Player p = players.get(player);
			IWorldObject o = p.getWorldObject();
			System.out.println("Jatekos neve/ti­pusa: " + player);
			System.out.println("Pozi­cio: " + o.getPosX() + " " + o.getPosY());
			System.out.println("Iranyvektor: " + p.getDirX() + " " + p.getDirY());
			System.out.println("Jatekos szelessege: " + o.getWidth() + ", Magassaga: " + o.getHeight());
			System.out.println("Felvett ZPM-ek szama: " + p.getZpmNumber());
			System.out.println("Cipelt dobozok van-e: "); //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			String isDead = "igen";
			if (p.isKilled()) {
				isDead = "nem";
			}
			System.out.println("Halott-e: " + isDead);
			System.out.println("");
		}
	}
//		Jatekos neve: [jatekos neve]
//		Pozi­cio: [x koordinata, y koordinata]
//		Iranyvektor: [x koordinata,y koordinata]
//		Jatekos szelessege: [szelesseg] , Magassaga: [magassag]
//		ZPMek: [felvett ZPMek szama]
//		Cipelt doboz: [van-e/nincs-e]
//		Halott: [igen/nem]
//		Megjegyzes: Ha van ervenyes nev parameter, akkor csak a megadott jatekos tulajdonsagait listazza.
	
	
	
	
	public static class ProtoLoadMap implements IProtoCommand {
		/*
		 * VIGYAZAT! A palyanevbe implementacios okokbol NE keruljon szokoz!
		 */
		@Override
		public boolean Execute(Scanner in) {
			String mapName = in.next();
			/*
			 * TODO Ki kell uriteni a ProtoGodObject listait.
			 */
			ProtoGodObject.getInstance().loadMap(mapName);
			System.out.println("loadMap");
			return true;
		}	
		ProtoLoadMap() {}
	}
	
	public static class ProtoRun implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			int iterations = in.nextInt();
			System.out.println(in);
			ProtoGodObject.getInstance().run(iterations);
			return true;
		}
		ProtoRun() {}
	}

	
	public static class ProtoPlayerMove implements IProtoCommand {
		
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			in.useDelimiter("\\s*");
			String cmd = in.next();
			String player=in.next();
			Boolean[] directions=new Boolean[4];
			int nextInt;
			for (int i=0;in.hasNextInt();i++) {
				nextInt=in.nextInt();
				if (nextInt == 1)
					directions[i]=true;
				else if (nextInt == 0)		
					directions[i]=false;
				else {
					System.out.println("Hibás paraméter a move parancsnál" +
									   "Az irány paraméterek értéke 1 vagy 0 legyen");
				}
					
			}
			boolean up=directions[0],down=directions[1],left=directions[2],
					right=directions[3];
			ProtoGodObject.getInstance().movePlayer(player,up,down,left,right);
			
			return true;
		}
		
		ProtoPlayerMove() {}
	}
	

	public static class ProtoListWalls implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listWalls();
			return true;
		}
		ProtoListWalls() {}
	}
	
	public static class ProtoListStargates implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			String col = in.next();
			ProtoGodObject.getInstance().listStargates(col);
			return true;
		}
		ProtoListStargates() {}
	}
	
	
	public static class ProtoListZPM implements IProtoCommand{
		void ProtoLidtZPM() {}
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listZpms();
			return true;
		}
	}
	
	public static class ProtoListWormHoles implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			String nev = in.next();
			ProtoGodObject.getInstance().listWormhole(nev);
			return true;
		}
	}
	
	public static class ProtoListCollosions implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			String state = in.next();
			ProtoGodObject.getInstance().listCollosions(state);
			return true;
		}
	}
	
	public static class ProtoListChasms implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listChasms();
			return true;
		}
		
	}
	
	public static class ProtoListProjectiles implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listProjectiles();
			return true;
		}
		ProtoListProjectiles() {}
	}
	
	public static class ProtoShoot implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			in.next(); // Az elso sztring maga a parancs lesz 
			String ply = in.next();
			int color1 = in.nextInt();
			int color2 = in.nextInt();
			boolean color1Bool = false, color2Bool=false;
			boolean wrongInput=false;;
			
			if (color1==1) {
				color1Bool=true;
			}
			else if (color1==0) {
				color1Bool=false;
			}
			else {
				wrongInput=true;
			}
			
			if (color2==1) {
				color2Bool=true;
			}
			else if (color2==0) {
				color2Bool=false;
			}
			else {
				wrongInput=true;
			}
			
			if (wrongInput) {
				System.out.println("Hibas bemenet a shoot parancsnal! " +
					     "Kérlek az 1/0 paramétereket használd!");
				return false;
			}
			
			ProtoGodObject.getInstance().shoot(ply, color1Bool, color2Bool);
			return false;
		}
		ProtoShoot() {}
	}
	
	public static class ProtoListBoxes implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listBoxes();
			return true;
		}
		ProtoListBoxes() {}
	}
	
	public static class ProtoListScales implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listScales();
			return true;
		}
		ProtoListScales() {}
	}
	
	public static class ProtoListPlayers implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			//Ezt mintaillesztéssel kell megoldani.
			Pattern pattern = Pattern.compile("(\\w)?");
			String nev = in.findInLine(pattern);
			ProtoGodObject.getInstance().listPlayers(nev);
			return true;
		}
		ProtoListPlayers() {}
	}
	
	public static class ProtoListDoors implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			ProtoGodObject.getInstance().listDoors();
			return true;
		}
		ProtoListDoors() {}
	}
	
	public static class ProtoSetCursor implements IProtoCommand {
		@Override
		public boolean Execute(Scanner in) {
			System.out.println(in);
			in.next();
			String ply = in.next();
			double x = in.nextDouble();
			double y = in.nextDouble();
			ProtoGodObject.getInstance().setCursor(ply, x, y);
			return true;
		}
		ProtoSetCursor() {}
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
			commands.put("listPlayers", new ProtoGodObject.ProtoListPlayers());
			commands.put("shoot", new ProtoGodObject.ProtoShoot()); //TODO
			commands.put("setCursor", new ProtoGodObject.ProtoSetCursor()); //TODO
			
			//setCursor, shoot,


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
