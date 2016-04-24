package proto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @brief ez az osztaly felelos azert, hogy a bemeneten erkezo whitespace-ekkel
 * elvalasztott tokeneket parancskent ertelmezze, es ha van hozza beregisztralt
 * parancs, akkor lefuttatja.
 */
class CommandInterpreter {
	
	/*
	 * Attributumok
	 */
	
	protected Scanner in;
	protected boolean isRunning;
	protected Map<String,IProtoCommand> commands = new TreeMap<String,IProtoCommand>();
	
	/*
	 * Metodusok
	 */
	
	/**
	 * @brief Ez a fuggveny felelos a tokenhez tartozo
	 * parancs megkereseseert, es siker eseten a lefuttatasaert.
	 */
	private void Logic(String cmd) {
		
		/*
		 * Ha az exit parancsot kapjuk, kilepunk a ciklusbol, egyebkent
		 * folytatjuk a feldolgozast.
		 */
		if(cmd.equals("exit")) {
			isRunning = false;
		} else {
			/*
			 * Megprobaljuk megkeresni a tokenhez tartozo parancsot.
			 */
			IProtoCommand program = commands.get(cmd);
			
			if(program == null) {
				/*
				 * Ha nem sikerul, akkor kiirjuk a hibat
				 */
				System.out.print(cmd + "\nHibás bemenet\n");
			}
			else {
				/*
				 * Ha sikerul, lefuttatjuk.
				 */
				program.Execute(in);
			}
		}
	}
	
	/**
	 * @brief Ez a fuggveny iterativan beolvassa a parancsokat, es
	 * tovabbitja a logicnak feldolgozasra.
	 */
	public void Menu() {
		
		isRunning = true;
		while(isRunning) {
			//Input
			String command = null;
			/*
			 * Ha van kovetkezo token beolvassa, ha nincs
			 * megtori a ciklust.
			 */
			if(in.hasNext()) {
				/*
				 * A kovetkezo tokent ertelmezi uj utasitasnak.
				 */
				command = in.next();
			} else {
				isRunning = false;
				break;
			}
			
			/*
			 * Ha sikerut beolvasni a kovetkezo tokent, akkor
			 * a Logic fuggvenyben feldolgozzuk.
			 */
			try {
				//Logic
				Logic(command);
			
			} catch (Exception e) {
				/*
				 * Ha barmi error tortenik, akkor kiirja a stack trace-t,
				 * hogy elmondja, hogy hol a hiba.
				 */
				System.out.println("Hiba történt !");
				//System.out.println("Hibakód:" + e.getStackTrace());
				e.printStackTrace();
			}
		}
		
		in.close();
	}
	
	CommandInterpreter(Scanner in) {
		this.in = in;
	}
}
