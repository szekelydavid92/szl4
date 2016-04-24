package proto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class CommandInterpreter {
	
	protected Scanner in;
	protected boolean isRunning;
	protected Map<String,IProtoCommand> commands = new TreeMap<String,IProtoCommand>();
	
	private void Logic(String cmd) {
		if(cmd.equals("exit")) {
			isRunning = false;
		} else {
			IProtoCommand program = commands.get(cmd);
			
			if(program == null) {
				System.out.print(cmd + "\nHibás bemenet\n");
			}
			else {
				program.Execute(in);
			}
		}
	}
	
	public void Menu() {
		
		isRunning = true;
		
		while(isRunning) {
			//Input
			String command = null;
			if(in.hasNext()) {
				command = in.next(); //miafasz?
			} else {
				isRunning = false;
				break;
			}
			
			try {
			//Logic
				Logic(command);
			
			} catch (Exception e) {
				System.out.println("Hiba történt !");
				System.out.println("Hibakód: " + e.getMessage());
			}
		}
		//System.out.print("Exiting\n");
		
		in.close();
	}
	
	CommandInterpreter(Scanner in) {
		this.in = in;
	}
}
