package proto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bottom_layer.GameLoop;

/*
 * TODO Meg kell csinálni a door és a scale betöltőjét!
 * TODO Meg kell csinálni a ZPM_RandPos betöltőjét!
 */

class LevelLoader {
	
	static class LevelParser extends CommandInterpreter {
		private GameFactory gameFactory;
		
		static abstract class ObjectParser implements IProtoCommand {
			
			enum State {
				BEGIN,
				LOADING,
			}
			
			protected LevelParser levelParser;
			
			ObjectParser(LevelParser levelParser) {
				this.levelParser = levelParser;
			}
			
			abstract protected void parseAttrib(String name,Scanner in);
			abstract protected boolean Construct();
			
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

		
		static abstract class PosDimParser extends ObjectParser {

			boolean posLoaded = false;
			boolean dimLoaded = false;
			double	posX,posY,
					width,height;

			PosDimParser(LevelParser levelParser) {
				super(levelParser);
			}
			
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
		
		class BoxParser extends PosDimParser {
			
			boolean massLoaded = false;
			double mass;
			
			BoxParser(LevelParser levelParser) {
				super(levelParser);
			}
			
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("mass")) {
					mass = in.nextDouble();
					massLoaded = true;
				}
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && massLoaded) {
					levelParser.gameFactory.createBox(posX,posY,width,height,mass);
					return true;
				}
				
				return false;
			}
		}
		
		class PlayerParser extends BoxParser {
			boolean nameLoaded = false;
			String name;
			
			PlayerParser(LevelParser levelParser) {
				super(levelParser);
			}
			
			@Override
			protected void parseAttrib(String name, Scanner in) {
				super.parseAttrib(name, in);
				if(name.equals("type")) {
					this.name = in.next();
					nameLoaded = true;
				}
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded && massLoaded && nameLoaded) {
					levelParser.gameFactory.createPlayer(name,posX,posY,width,height,mass);
					return true;
				}
				
				return false;
			}
		}

		static class ChasmParser extends PosDimParser {

			ChasmParser(LevelParser levelParser) {
				super(levelParser);
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createChasm(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		static class WallParser extends PosDimParser {

			WallParser(LevelParser levelParser) {
				super(levelParser);
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createWall(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
			
		};

		
		static class SpecWallParser extends PosDimParser {

			SpecWallParser(LevelParser levelParser) {
				super(levelParser);
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createSpecWall(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		static class ZPMParser extends PosDimParser {

			ZPMParser(LevelParser levelParser) {
				super(levelParser);
			}

			@Override
			protected boolean Construct() {
				if(posLoaded && dimLoaded) {
					levelParser.gameFactory.createZpm(posX,posY,width,height);
					return true;
				}
				
				return false;
			}
		}
		
		LevelParser(Scanner in,GameFactory gameFactory) {
			super(in);
			this.gameFactory = gameFactory;
			
			commands.put("Box",(new BoxParser(this)));
			commands.put("Player",(new PlayerParser(this)));
			commands.put("Wall",(new WallParser(this)));
			commands.put("SpecWall",(new SpecWallParser(this)));
			commands.put("Chasm",(new ChasmParser(this)));
			commands.put("ZPM",(new ZPMParser(this)));
		}
	}
	
	private GameFactory gameFactory;
	
	/*
	 * Itt elterunk a specifikaciotol, itt parameterkent kap egy gameLoopot
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
			return false;
		}
		
		return true;
	}
	
	LevelLoader() {
			
	}
	
}