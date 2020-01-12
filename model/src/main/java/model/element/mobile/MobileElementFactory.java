package model.element.mobile;

import model.element.IPosition;
import model.element.Sprite;

public class MobileElementFactory {

	public MobileElementFactory() {
		
	}
	
	public IMobileElements createMobileElement(MobileElementType element,IPosition position) {
		
		switch(element) {
		case Player: 
			return new Player(new Sprite("p"),position);
		default:
			return null;
		}
	}
	

}
