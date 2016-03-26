package bottom_layer;

import common.CollisionResponse;
import common.ICollisionObserver;
import common.IVisitable;
import common.IWorldObject;

/**
 * Minden egyes oszt�ly, amelynek az id� f�ggv�ny�ben v�ltozhat az �llapota, lesz�rmazik ebb�l az oszt�lyb�l.
 */
public class WorldObject implements IWorldObject {
	
	double posX;			//Az objectum X tengely menti poz�ci�.
	double posY; 			//Az objectum  Y tengely menti poz�ci�.
	double displacementX;	//Az objectum elmozdul�s vektor�nak X komponense.
	double displacementY;	//Az objectum elmozdul�s vektor�nak Y komponense.
	double width; 			//Az objektum sz�less�ge.
	double height; 			//Az objektum magass�ga.
	CollisionResponse colResp;	//a WorldObject bels� �llapota: ha 
								//MOVABLE, akkor �tk�z�s eset�n 
								//elmozdul, ha IMMOVABLE, akkor 
								//�tk�z�s eset�n nem mozdul el, ha pedig PASS, 
								//akkor kereszt�l engedi mag�n a m�sik objektumot.
	ICollisionObserver observer; // Az objektum �tk�z�s�r�l �rtes�l� observer.
	
	/**
	 * A poz�ci� X �s Y koordin�t�j�hoz hozz�adja az elmozdul�s X �s Y koordin�t�j�t,
	 * el�rel�ptetve az objektumot az id� f�ggv�ny�ben.
	 * @return void
	 */
	public void step() {}
	
	
	/**
	 * A vil�gbeli objektum  sz�less�g�t (width attributum) adja vissza.
	 * @return double
	 */
	public double getWidth() {return width;}
	
	/**
	 * A vil�gbeli objektum  magass�g�t (height attributum) adja vissza.
	 * @return double
	 */
	public double getHeight() {return height;}
	
		
	/**
	 * Ezzel a f�ggv�nnyel lehet be�ll�tani a megval�s�t� objektum �llapot�t, hogy elmozd�that� legyen,
	 * mozd�thatatlan legyen vagy �tereszt� (azaz m�s objektumok kereszt�l tudjanak rajta menni).
	 * @param colResp ??????????????
	 * @return void
	 */
	public void setCollisionResponse(CollisionResponse colResp) {}
	
	
	/**
	 * A vil�gbeli objektum  X koordin�t�j�t �ll�tja be a vil�g koordin�ta rendszer�ben.
	 * @param x Az x koordin�ta.
	 * @return void
	 */
	public void setPosX(double x) {posX=x;}
	
	
	/**
	 * A vil�gbeli objektum Y koordin�t�j�t �ll�tja be a vil�g koordin�ta rendszer�ben.
	 * @param y Az y koordin�ta.
	 * @return void
	 */
	public void setPosY(double y) {posY=y;}
	
	
	/**
	 * A (dx,dy) vektor hozz�ad�sa az elmozdul�s vektorhoz.
	 * @param dx A vektor x koordin�t�ja.
	 * @param dy A vektor y koordin�t�ja.
	 * @return void
	 */
	public void addDisplacement(double dx, double dy) 
	{displacementX+=dx; displacementY+=dy;}
	
	
	/**
	 * A vil�gbeli objektum X tengely menti poz�ci�j�t adja vissza eredm�ny�l.
	 * @return double
	 */
	public double getPosX() {return posX;}
	
	
	/**
	 * A vil�gbeli objektum Y tengely menti poz�ci�j�t adja vissza eredm�ny�l.
	 * @return double
	 */
	public double getPosY() {return posY;}
	
	
	/**
	 * Visszaadja a vil�gbeli objektum fels� r�tegbeli reprezent�ci�j�nak az IVisitable interf�sz�t,
	 * ha van fels� r�tegbeli reprezent�ci�ja, ha nincs, akkor null-t ad.
	 * @return IVisitable
	 */
	public IVisitable getIVisitable() {return null;}
	
	
	/**
	 * Ez a met�dus felel�s az�rt, hogy leellen�rizze, hogy k�t WorldObject �tk�z�tt-e.
	 * @param o A m�sik WorldObject.
	 * @return boolean
	 */
	public boolean checkCollision(WorldObject o) {return true;}
	
	
	/**
	 * Az objektum poz�ci�j�hoz hozz�adja a (dx,dy) vektort.
	 * @param dx Az objektum poz�ci�j�hoz hozz�adand� vektor x koordin�t�ja.
	 * @param dy Az objektum poz�ci�j�hoz hozz�adand� vektor y koordin�t�ja.
	 * @return void
	 */
	public void displace(double dx, double dy) {posX+=dx; posY+=dy;}
	
	
	/**
	 * Az elmozdul�s vektor X komponens�nek be�ll�t�sa.
	 * @param x Az x komponens be�ll�tand� �rt�ke.
	 * @return void
	 */
	public void setDisplacementX(double x) {displacementX=x;}
	
	
	/**
	 * Az elmozdul�s vektor Y komponens�nek be�ll�t�sa.
	 * @param y Az y komponens be�ll�tand� �rt�ke.
	 * @return void
	 */
	public void setDisplacementY(double y) {displacementY=y;}
	
	
	/**
	 * Eredm�ny�l adja az elmozdul�s vektor X ir�ny� �rt�k�t.
	 * @return double
	 */
	public double getDisplacementX() {return displacementX;}
	
	
	/**
	 * Eredm�ny�l adja az elmozdul�s vektor Y ir�ny� �rt�k�t.
	 * @return double
	 */
	public double getDisplacementY() {return displacementY;}
	
	
	/**
	 * Be�ll�tja a megval�s�t� objektumra feliratkoz� observert.
	 * @param observer A feliratkoz� observer.
	 * @return void
	 */
	public void setCollisionObserver(ICollisionObserver observer) {this.observer=observer;}
	
	
	/**
	 * Ez a f�ggv�ny h�v�dik meg a World checkCollision() f�ggv�ny�ben,
	 * ha ez az objektum �tk�z�tt a param�terben megadott objektummal.
	 * @param obj Param�terben megadott WorldObject objektum.
	 * @return void
	 */
	public void notify(WorldObject obj) {}

}
