package model.map;

import model.element.IElement;

public interface IMap {
	void setOnTheMap(IElement element, int x, int y);

	int getLenght();

	int getWidth();

	IElement getOnTheMap(int x, int y);
}
