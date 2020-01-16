/**
 * 
 */
package model.element.staticelement;

import model.element.ElementType;
import model.element.IElement;
import model.element.IPosition;
import model.element.ISprite;
import model.element.Sprite;
import model.element.planet;
import model.element.decorator.IsPenetrable;

/**
 * @author Timoté
 *
 */
public class StaticElementFactory implements IStaticElementFactory{

	/**
	 * 
	 */
	public StaticElementFactory() {
		// TODO Auto-generated constructor stub
	}

	public IElement createStaticElement(IPosition pos, String consol_log_element,planet planet) {
		switch(consol_log_element) {
		case("x"):
			return new IsPenetrable(new BorderLevel(new Sprite("x",planet+"/"+ElementType.BorderLevel+ISprite.imageExtention),pos,new Size(16, 16)));
		case("s"):
			return new Spawn(new Sprite("s",planet+"/"+ElementType.Spawn+ISprite.imageExtention), pos,new Size(16, 16));
		case("f"):
			return new Floor(new Sprite("f",planet+"/"+ElementType.Floor+ISprite.imageExtention),pos,new Size(16, 16));
		default:
			return null;
		}
	}
}
