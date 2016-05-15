package proto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bottom_layer.GameLoop;
import upper_layer.GameFactory;

/**
 * @brief Ez az osztaly felelos a palya betolteseert.
 */
public class LevelLoader {
	
	/**
	 * @brief Ez az osztaly felelos a parameterkent kapott Scannerbol a palya elemeinek
	 * a beolvasasaert.
	 */
	static class LevelParser extends CommandInterpreter {
		private GameFactory gameFactory;
		
		/**
		 * @brief Ez az osztaly felelos egy konkret palyaelem betolteseert.
		 */
		static abstract class ObjectParser implements IProtoCommand {
			
			enum State {
				BEGIN,
				LOADING,
			}
			
			protected LevelParser levelParser;
			
			ObjectParser(LevelParser levelParser) {
				this.levelParser = levelParser;
			}
			
			/**
			 * @brief Ez a fuggveny felelos egy konkret tulajdonsag beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			abstract protected void parseAttrib(String name,Scanner in);
			
			/**
			 * @brief Ez a fuggveny felelos az objektum GameFactoryn keresztul torteno
			 * megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			abstract protected boolean Construct();
			
			/**
			 * @brief Ez a fuggveny futtatja az allapotgepet, ami beolvassa a palyaelemet.
			 * 
			 * @param in egy Scanner, ami csomagolja a bemenetet. Innen olvassuk be a palyaelemet
			 * 
			 * @return boolean - true, ha sikerrel beolvastuk es megkonstrualtuk
			 * a palyaelemet, false egyebkent.
			 */
			@Override
			public boolean Execute(Scanner in) {
				boolean isRunning = true;
				State state = State.BEGIN;
				while(isRunning) {
					String nextToken = in.next();
					switch(state) {
					case BEGIN:
						if(nextToken.equals("begin")) {
							state = State.LOADING;
						} else {
							return false;
						}
						
						break;
					case LOADING:
						if(nextToken.equals("end")) {
							isRunning = false;
						} else {
							parseAttrib(nextToken,in);
						}
						
						break;
					}
				}
				return Construct();
			}
		}
		
		/**
		 * @brief Ez az osztaly felelos a pozicioval es szelesseggel meg hosszusaggal
		 * rendelkezo objektumok betolteseert.
		 */
		static abstract class PosDimParser extends ObjectParser {

			boolean posLoaded = false;
			boolean dimLoaded = false;
			double	posX,posY,
					width,height;

			PosDimParser(LevelParser levelParser) {
				super(levelParser);
			}
			
			/**
			 * @brief Ez a fuggveny felelos a pozicio es a szelesseg beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			@Override
			protected void parseAttrib(String name, Scanner in) {
				if(name.equals("pos")) {
					posX = in.nextDouble();
					posY = in.nextDouble();
					posLoaded = true;
				} else if(name.equals("dim")) {
					width = in.nextDouble();
					height = in.nextDouble();
					dimLoaded = true;
				}
			}
			
		};
		
		/**
		 * @brief Ez az objektum felelos az ajto beolvasasaert.
		 */
		class DoorParser extends PosDimParser{
			
			int id;
			boolean idLoaded = false;
			
			DoorParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos az id beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("id")) {
					id = (int)in.nextDouble();
					idLoaded = true;
				}
			}
			
			/**
			 * @brief Ez a fuggveny felelos az ajto megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && idLoaded) {
					levelParser.gameFactory.createDoor(posX,posY,width,height,id);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a merleg beolvasasaert.
		 */
		class ScaleParser extends DoorParser{
			
			boolean massLoaded = false;
			double mass;
			
			ScaleParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a maximalis tomeg beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("mass")) {
					mass = in.nextDouble();
					massLoaded = true;
				}
			}
			
			/**
			 * @brief Ez a fuggveny felelos a merleg megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && massLoaded && idLoaded) {
					levelParser.gameFactory.createScale(posX,posY,width,height,mass, id);
					return true;
				}
				
				return false;
			}
			
		}
		
		/**
		 * @brief Ez az objektum felelos a doboz beolvasasaert.
		 */
		class BoxParser extends PosDimParser {
			
			boolean massLoaded = false;
			double mass;
			
			BoxParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a tomeg beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("mass")) {
					mass = in.nextDouble();
					massLoaded = true;
				}
			}

			/**
			 * @brief Ez a fuggveny felelos a doboz megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && massLoaded) {
					levelParser.gameFactory.createBox(posX,posY,width,height,mass);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a jatekos beolvasasaert.
		 */
		class PlayerParser extends BoxParser {
			boolean nameLoaded = false;
			String name;
			
			PlayerParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a player nevenek a beolvasasaert.
			 * 
			 * @param name az attributum neve
			 * @param in a bemenet, ahonnan beolvassuk az attributum ertekeit.
			 */
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("type")) {
					this.name = in.next();
					nameLoaded = true;
				}
			}

			/**
			 * @brief Ez a fuggveny felelos a jatekos megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && massLoaded && nameLoaded) {
					levelParser.gameFactory.createPlayer(name,posX,posY,width,height,mass);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a szakadek beolvasasaert.
		 */
		static class ChasmParser extends PosDimParser {

			ChasmParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a szakadek megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createChasm(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a fal beolvasasaert.
		 */
		static class WallParser extends PosDimParser {

			WallParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a fal megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createWall(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
			
		};
		
		/**
		 * @brief Ez az objektum felelos a specialis fal beolvasasaert.
		 */
		static class SpecWallParser extends PosDimParser {

			SpecWallParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a specialis fal megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createSpecWall(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a ZPM beolvasasaert.
		 */
		static class ZPMParser extends PosDimParser {

			ZPMParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a ZPM megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createZpm(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		/**
		 * @brief Ez az objektum felelos a ZPM random poziciojanak beolvasasaert.
		 */
		class ZPM_RandPosParser extends PosDimParser{

			ZPM_RandPosParser(LevelParser levelParser) {
				super(levelParser);
			}

			/**
			 * @brief Ez a fuggveny felelos a ZPM random poziciojanak megkonstrualasaert.
			 * 
			 * @return bool true, ha minden letfontossagu attributum betoltodott, es
			 * sikerult megkonstrualni az objektumot, false egyebkent.
			 */
			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createZpmRandPos(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
			
		}
		
		LevelParser(Scanner in,GameFactory gameFactory) {
			super(in);
			this.gameFactory = gameFactory;
			
			commands.put("Scale",(new ScaleParser(this)));
			commands.put("Door",(new DoorParser(this)));
			commands.put("Box",(new BoxParser(this)));
			commands.put("Player",(new PlayerParser(this)));
			commands.put("Wall",(new WallParser(this)));
			commands.put("SpecWall",(new SpecWallParser(this)));
			commands.put("Chasm",(new ChasmParser(this)));
			commands.put("ZPM",(new ZPMParser(this)));
			commands.put("ZPM_RandPos",(new ZPM_RandPosParser(this)));
		}
	}
	
	private GameFactory gameFactory;
	
	/*
	 * Itt elterunk a specifikaciotol, itt parameterkent kap egy gameFactoryt
	 */
	
	/**
	 * @brief Ez a fuggveny felelos az utvonalon talalhato fajlbol a palya betolteseert.
	 * 
	 * @param path a palya eleresi utvonala
	 * @param gameFactory a GameFactory, amelyen keresztul letrehozzuk a palyaelemeket
	 * 
	 * @return true, ha sikerult megnyitni a fajlt, false egyebkent
	 */
	public boolean load(String path,GameFactory gameFactory) {
		this.gameFactory=gameFactory;
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
			Scanner in = new Scanner(fis);
			LevelParser levelParser = new LevelParser(in,gameFactory);
			levelParser.Menu();
		} catch (FileNotFoundException e) {
			System.out.print("Error: could not load map");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public LevelLoader() {
			
	}
	
}