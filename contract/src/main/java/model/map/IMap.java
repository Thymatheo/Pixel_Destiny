package model.map;

import java.util.ArrayList;

import model.element.IElement;

public interface IMap {
	void addOnTheMap(IElement element);
	ArrayList<IElement> getContent();
}
