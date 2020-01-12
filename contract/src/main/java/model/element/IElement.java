package model.element;

public interface IElement {

	ISprite getSprite();
	
	IPosition getPosition();

	boolean isUnPenetrable();
}
