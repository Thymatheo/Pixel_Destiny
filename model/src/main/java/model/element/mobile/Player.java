package model.element.mobile;

import model.element.Element;
import model.element.IPosition;
import model.element.ISize;
import model.element.ISprite;

public class Player extends MobileElement {

	public Player(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public Player(ISprite sprite, IPosition position,ISize size) {
		super(sprite, position, size);
		// TODO Auto-generated constructor stub
		this.getPosition().setX(this.getPosition().getX());
		this.getPosition().setY(this.getPosition().getY());
	}
	
	

}
