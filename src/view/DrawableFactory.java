package view;

import common.IDoor;
import common.IDrawableFactory;
import common.IStargate;
import common.IWorldObject;

/**
 * Ez az osztály felelős a grafikus primitívek létrehozásáért.
 */
public class DrawableFactory implements IDrawableFactory{
	
	protected View view;

	@Override
	public void createDoorDrawable(IDoor door, DrawableColor color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createObjectDrawable(IWorldObject worldObject, DrawableColor color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createStargateDrawable(IStargate stargate, DrawableColor color) {
		// TODO Auto-generated method stub
		
	}
	
}
