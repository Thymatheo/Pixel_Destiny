/**
 * 
 */
package model.element.staticelement;

import model.element.IElement;
import model.element.IPosition;
import model.element.Sprite;
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

	public IElement createStaticElement(IPosition pos, String consol_log_element) {
		switch(consol_log_element) {
		case("x"):
			return new BorderLevel(new Sprite("x"),pos);
		case("s"):
			return new Spawn(new Sprite("s"), pos);
		case("f"):
			return new Floor(new Sprite("f"),pos);
		default:
			return null;
		}
	}
}
