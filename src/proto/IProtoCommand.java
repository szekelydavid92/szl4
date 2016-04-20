package proto;

import java.util.Scanner;

/**
 * Az oka annak, hogy ez NEM az interfaces package-be kerul, az az, hogy kerdeses, hogy bennemarad-e a
 * vegso programban, es ha igen, akkor is egy masik absztrakcios retegben van a helye, mint a modellnek.
 */
public interface IProtoCommand {
	public void Execute(Scanner in);
}
