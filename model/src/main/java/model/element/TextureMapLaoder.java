package model.element;

import java.util.ArrayList;
import java.util.Iterator;

public class TextureMapLaoder implements ITextureMapLoader {

	private ArrayList<ITexture> TexturePack;

	private String planetLabel;

	public TextureMapLaoder(String planetLabel) {
		this.setPlanetLabel(planetLabel);
		this.setTexturePack(new ArrayList<ITexture>());
	}

	public TextureMapLaoder() {
		this.setTexturePack(new ArrayList<ITexture>());
	}

	@Override
	public void loadTexture() {
		this.getTexturePack().add(new Texture("BorderLevel",this.getPlanetLabel()));
		//this.getTexturePack().add(new Texture("/"+this.getPlanetLabel()+"/Player.png"));
		this.getTexturePack().add(new Texture("Spawn",this.getPlanetLabel()));
		this.getTexturePack().add(new Texture("Floor",this.getPlanetLabel()));
	}

	@Override
	public ArrayList<ITexture> getTexturePack() {
		return TexturePack;
	}

	public void setTexturePack(ArrayList<ITexture> texturePack) {
		TexturePack = texturePack;
	}

	public ITexture getTextureId(String ElementType) {
		for (ITexture texture : TexturePack) {
			if (texture.getTextureLabel() == ElementType) {
			System.out.println(ElementType +" | "+texture.getTextureLabel()+" | "+texture.getId());
			return texture;
			}
		}
		return null;
	}

	public String getPlanetLabel() {
		return planetLabel;
	}

	@Override
	public void setPlanetLabel(String planetLabel) {
		this.planetLabel = planetLabel;
	}
}
