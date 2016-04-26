package common;

public interface IControllable {
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * mozogjon-e felfele az objektum.
	 * 
	 * @param up: megadja mozogjon-e felfele az objektum
	 *
	 * @return void
	 */
	public void moveUp(boolean up); 
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * mozogjon-e lefele az objektum.
	 * 
	 * @param down: megadja mozogjon-e lefele az objektum
	 *
	 * @return void
	 */
	public void moveDown(boolean down);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * mozogjon-e balra az objektum.
	 * 
	 * @param left: megadja mozogjon-e balra az objektum
	 *
	 * @return void
	 */
	public void moveLeft(boolean left);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * mozogjon-e jobbra az objektum.
	 * 
	 * @param right megadja mozogjon-e jobbra az objektum
	 *
	 * @return void
	 */
	public void moveRight(boolean right);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * vegyen-e fel, tegyen-e le carriable objektumot.
	 * 
	 * @param pick: tegyen-e le, vegyen-e fel carriable objektumot
	 *
	 * @return void
	 */
	public void pickUp(boolean pick);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * az objektum iranyvektorat.
	 * 
	 * @param double x: iranyvektor x koordinataja
	 * double y: iranyvektor y koordinataja
	 *
	 * @return void
	 */
	public void lookAt(double x, double y);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * lojon-e sarga lovedeket az objektum.
	 * 
	 * @param shootingYellow lojon/ne lojon sarga lovedeket
	 *
	 * @return void
	 */
	public void shootYellow(boolean shootingYellow);
	
	
	/**
	 * @brief Beallitja, hogy a kovetkezo iteracioban
	 * lojon-e kek lovedeket az objektum.
	 * 
	 * @param shootingBlue: lojon/ne lojon kek lovedeket
	 *
	 * @return void
	 */
	public void shootBlue(boolean shootingBlue);
	
}
