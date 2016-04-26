package common;

import java.util.List;

/**
 * Ezen Interface felel a szakadekok listazasaert es torleseert.
 */
public interface IChasm {
	/**
	 * @brief Listazni lehet a szakadekokat ezzen fugvenyen keresztul.
	 * @return List<IWolrdObject>
	 */
	public List<IWorldObject> getChasms();
	
	/**
	 * @brief Torolni lehet szakadekot ezen a fuggvenyen keresztul.
	 * @return void
	 */
	public void remove(IWorldObject obj);
}
