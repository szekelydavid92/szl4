package proto;

import java.util.Scanner;

/*
 * Az oka annak, hogy ez NEM az interfaces package-be kerul, az az, hogy kerdeses, hogy bennemarad-e a
 * vegso programban, es ha igen, akkor is egy masik absztrakcios retegben van a helye, mint a modellnek.
 */

/**
 * @brief Ezt az interfeszt megvalosito osztalyok peldanyai
 * lefuttathatoak CommandInterpreterbol parancskent
 */
public interface IProtoCommand {
	
	/**
	 * @brief Ez a fuggveny tartalmazza a CommandInterpreter altal lefuttathato
	 * logikat.
	 * 
	 * @param in a bemenet, ahonnan az esetleges parametereket kapnia kell.
	 * 
	 * @return boolean true, ha a parancs sikeresen lefutott, false egyebkent
	 */
	public boolean Execute(Scanner in);
}
