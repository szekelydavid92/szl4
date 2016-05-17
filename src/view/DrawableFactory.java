package view;

import java.awt.Color;

import common.IDoor;
import common.IDrawableFactory;
import common.IStargate;
import common.IView;
import common.IWorldObject;

/**
 * Ez az osztály felelős a grafikus primitívek létrehozásáért.
 */
public class DrawableFactory implements IDrawableFactory{
	
	protected View view;
	
	DrawableFactory(View v){
		view = v;
	}
	
	/**
	 * @brief Létrehoz egy grafikus primitívet az adott pozícióval, szélességgel és magassággal.
	 */
	@Override
	public void createObjectDrawable(IWorldObject worldObject, DrawableColor color) {
		Drawable d = new Drawable(worldObject, new Color(color.r, color.g, color.b));
		
		view.add(d);
	}
	
	/**
	 * @brief Létrehoz egy grafikus primitívet a csillagkapunak az adott pozícióval,
	 * szélességgel, magassággal és színnel.
	 */
	@Override
	public void createStargateDrawable(IStargate stargate, DrawableColor color) {
		StargateDrawable sd = new StargateDrawable(null, stargate, new Color(color.r, color.g, color.b));
		
		view.add(sd);
	}
	
	/**
	 * @brief Létrehoz egy grafikus primitívet az adott pozícióval, szélességgel és magassággal.
	 */
	@Override
	public void createDoorDrawable(IWorldObject worldObject, IDoor door, DrawableColor color) {
		DoorDrawable dd = new DoorDrawable(worldObject, door, new Color(color.r, color.g, color.b));
		
		view.add(dd);
	}
}
