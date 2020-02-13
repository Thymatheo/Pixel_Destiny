package model.element;

import java.util.ArrayList;

public interface ITextureMapLoader {

	void loadTexture();

	ArrayList<ITexture> getTexturePack();

	void setPlanetLabel(String planetLabel);
	
	ITexture getTextureId(String ElementType);

}