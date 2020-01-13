package model.level;

import model.element.mobile.IMobileElement;
import model.map.IMap;

public interface ILevel {
	IMap getMap();
	IMobileElement getPlayer();
}
