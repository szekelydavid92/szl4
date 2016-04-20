package proto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class CommandInterpreter {
	
	protected Scanner in;
	protected boolean isRunning;
	protected Map<String,IProtoCommand> commands = new TreeMap<String,IProtoCommand>();
	
	/*
	 * Át kell formázni a kódot a konvencióknak megfelelően.
	 */
	
	private void Logic(String cmd)
	{
		if(cmd.equals("exit"))
		{
			isRunning = false;
		}
		else
		{
			IProtoCommand program = commands.get(cmd);
			
			if(program == null)
			{
				System.out.print(cmd + ": command not found\n");
			}
			else
			{
				program.Execute(in);
			}
		}
	}
	/*
	public void Init()
	{
		//pwd = System.getProperty("user.dir");
		
		//commands.put("loadMap", new ProtoGodObject.ProtoLoadMap());
		//commands.put("run", new ProtoGodObject.ProtoRun());
		
		/*
		Programs.put("reclist",new Reclist());
		Programs.put("pwd",new Pwd());
		Programs.put("cd",new Cd());
		Programs.put("ls",new Ls());
		Programs.put("rm",new Rm());
		Programs.put("mkdir",new Mkdir());
		Programs.put("cp",new Cp());
		Programs.put("head",new Head());
		Programs.put("mv",new Mv());
		Programs.put("cat",new Cat());
		Programs.put("wc",new Wc());
		Programs.put("length",new Length());
		Programs.put("tail",new Tail());
		Programs.put("grep",new Grep());
		* /
	}
	*/
	
	public void Menu()
	{
		//Init();
		
		//Scanner In = new Scanner(System.in);
		
		isRunning = true;
		
		while(isRunning)
		{
			//Input
			String Szercsylavcsy = in.next();
			
			//Logic
			Logic(Szercsylavcsy);
			
		}
		System.out.print("Exiting\n");
		
		in.close();
		System.exit(0);
	}
	
	CommandInterpreter(Scanner in) {
		this.in = in;
	}
}