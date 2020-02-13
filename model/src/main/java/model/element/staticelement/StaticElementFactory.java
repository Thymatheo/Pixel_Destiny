/**
 * 
 */
package model.element.staticelement;

import model.element.ElementType;
import model.element.IElement;
import model.element.IPosition;
import model.element.ISprite;
import model.element.ITextureMapLoader;
import model.element.Sprite;
import model.element.TextureMapLaoder;
import model.element.planet;
import model.element.decorator.IsPenetrable;

/**
 * @author Timoté
 *
 */

public class StaticElementFactory implements IStaticElementFactory{

	private ITextureMapLoader textureMapLoader;
	/**
	 * 
	 */
	public StaticElementFactory() {
		this.setTextureMapLoader(new TextureMapLaoder());
	}

	public IElement createStaticElement(IPosition pos, String consol_log_element,String planet) {
		this.getTextureMapLoader().setPlanetLabel(planet);
		switch(consol_log_element) {
		case("x"):
			return new BorderLevel(new Sprite("x",""+ElementType.BorderLevel,this.getTextureMapLoader().getTextureId("BorderLevel")),pos,new Size(16, 16));
		case("s"):
			return new Spawn(new Sprite("s",""+ElementType.Spawn,this.getTextureMapLoader().getTextureId("Spawn")), pos,new Size(16, 16));
		case("f"):
			return new Floor(new Sprite("f",""+ElementType.Floor,this.getTextureMapLoader().getTextureId("Floor")),pos,new Size(16, 16));
		default:
			return null;
		}
	}

	public ITextureMapLoader getTextureMapLoader() {
		return textureMapLoader;
	}

	public void setTextureMapLoader(ITextureMapLoader textureMapLoader) {
		this.textureMapLoader = textureMapLoader;
	}
}
