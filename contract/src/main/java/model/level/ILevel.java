package model.level;

import model.element.mobile.IMobileElements;
import model.map.IMap;

public interface ILevel {
	IMap getMap();
	IMobileElements getPlayer();
}
