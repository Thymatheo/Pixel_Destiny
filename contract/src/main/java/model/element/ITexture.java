package model.element;

public interface ITexture {
	
	ITexture loadImage(String imagNname);
	
	void bind();
	void unBind();
}
