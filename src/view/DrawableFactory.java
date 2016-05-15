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
	public void createObjectDrawable(IWorldObject worldObject, Color color) {
		Drawable d = new Drawable(worldObject, color);
		
		view.add(d);
	}

	@Override
	public void createStargateDrawable(IStargate stargate, Color color) {
		StargateDrawable sd = new StargateDrawable(stargate.getMasked().getWorldObject(), stargate, color);
		
		view.add(sd);
	}

	@Override
	public void createDoorDrawable(IWorldObject worldObject, IDoor door, Color color) {
		DoorDrawable dd = new DoorDrawable(worldObject, door, color);
		
		view.add(dd);
	}
}
