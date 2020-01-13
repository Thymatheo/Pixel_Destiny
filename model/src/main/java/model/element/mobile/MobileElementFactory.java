package model.element.mobile;

import model.element.IElement;
import model.element.IPosition;
import model.element.Sprite;
import model.element.staticelement.Size;

public class MobileElementFactory {

	public MobileElementFactory() {
		
	}
	
	public IMobileElement createMobileElement(MobileElementType element,IPosition position) {
		
		switch(element) {
		case Player: 
			return new Player(new Sprite("p"),position,new Size(IElement.lenght, IElement.width));
		default:
			return null;
		}
	}
	

}
