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

	@Override
	public void createObjectDrawable(IWorldObject worldObject, DrawableColor color) {
		Drawable d = new Drawable(worldObject, new Color(color.r, color.g, color.b));
		
		view.add(d);
	}

	@Override
	public void createStargateDrawable(IStargate stargate, DrawableColor color) {
		StargateDrawable sd = new StargateDrawable(stargate.getMasked().getWorldObject(), stargate, new Color(color.r, color.g, color.b));
		
		view.add(sd);
	}

	@Override
	public void createDoorDrawable(IWorldObject worldObject, IDoor door, DrawableColor color) {
		DoorDrawable dd = new DoorDrawable(worldObject, door, new Color(color.r, color.g, color.b));
		
		view.add(dd);
	}
}
