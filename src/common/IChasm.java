package common;

import java.util.List;

/**
 * Ezen Interface felel a szakadekok listazasaert es torleseert.
 */
public interface IChasm {
	public List<IWorldObject> getChasms();
	public void remove(IWorldObject obj);
}
