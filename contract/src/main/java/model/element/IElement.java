package model.element;

public interface IElement {

	ISprite getSprite();
	
	IPosition getPosition();

	boolean isUnPenetrable();
	
	ISize getSize();
	
	int width = 16;
	
	int lenght = 16;
}
