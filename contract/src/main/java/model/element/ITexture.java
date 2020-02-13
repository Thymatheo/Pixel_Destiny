package model.element;

public interface ITexture {
	
	void loadImage(String imagNname);
	
	void bind();
	
	void unBind();

	int getId();
	
	int getHeight();
	
	int getWidth();
	
	String getTextureLabel();
	
	void render();
	
	
}
