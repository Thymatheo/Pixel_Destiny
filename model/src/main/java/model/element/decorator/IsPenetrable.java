package model.element.decorator;

import model.element.Element;

public class IsPenetrable extends Decorator {

	public IsPenetrable(Element object) {
		super(object);
		unPenetrable = true;
	}

}
