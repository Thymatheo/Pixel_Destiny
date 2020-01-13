package model.element.mobile;

import model.element.IPosition;
import model.element.ISprite;

public interface IMobileElement {

	int getMoveSpeed();

	IPosition getPosition();

	ISprite getSprite();
	
	IPosition getMobilePosition();

}