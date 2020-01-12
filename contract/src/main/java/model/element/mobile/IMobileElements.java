package model.element.mobile;

import model.element.IPosition;
import model.element.ISprite;

public interface IMobileElements {

	int getMoveSpeed();
	IPosition getPosition();
	IMobilePosition getMobileposition();
	ISprite getSprite();

}