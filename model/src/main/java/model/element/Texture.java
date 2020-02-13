package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import javax.imageio.ImageIO;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;


import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;

public class Texture implements ITexture {

	private BufferedImage image;

	private String TextureLabel;

	private String TexturePath;

	private int height;
	private int width;
	private int id;

	public Texture (int height, int width, int id) {
		this.setHeight(height);
		this.setWidth(width);
		this.setId(id);
	}

	public Texture () {

	}

	public Texture(String textureLabel, String planet) {
		this.setTextureLabel(textureLabel);
		this.setTexturePath("/"+planet+"/"+this.getTextureLabel()+".png");
		System.out.println(this.getTextureLabel());
		this.loadImage(this.getTextureLabel());
	}

	public void loadImage(String imageName) {
		int textureID = glGenTextures();
		this.setId(textureID);
		System.out.println(this.getId());
		glBindTexture(GL_TEXTURE_2D, textureID);
		try {

			BufferedImage img = ImageIO.read(this.getClass().getResource(this.getTexturePath()));
			int[] pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
			FloatBuffer pixelsBuffer = BufferUtils.createByteBuffer(pixels.length * 4 * 4).asFloatBuffer();


			for(int y = img.getHeight()-1;y>=0;--y)
			{
				for(int x = 0;x <img.getWidth();++x){
					int pixel = pixels[y*img.getWidth()+x];
					float a = ((pixel >> 24) & 0xFF)/255f;
					float r = ((pixel >> 16) & 0xFF)/255f;
					float g = ((pixel >> 8) & 0xFF)/255f;
					float b = ((pixel >> 0) & 0xFF)/255f;

					pixelsBuffer.put(r);
					pixelsBuffer.put(g);
					pixelsBuffer.put(b);
					pixelsBuffer.put(a);
				}
			}
			pixelsBuffer.flip();
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER,GL_LINEAR);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, this.getWidth(), this.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, pixelsBuffer);

			this.setId(textureID);
			this.setHeight(img.getHeight());
			this.setWidth(img.getWidth());


		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fails to load images");
		}

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void bind() {
		System.out.println(this.getId());
		glBindTexture(GL_TEXTURE_2D, this.getId());
	}

	public void unBind() {
		glBindTexture(GL_TEXTURE_2D, 0);
	}

	public String getTextureLabel() {
		return TextureLabel;
	}

	public void setTextureLabel(String textureLabel) {
		TextureLabel = textureLabel;
	}

	public String getTexturePath() {
		return TexturePath;
	}

	public void setTexturePath(String texturePath) {
		TexturePath = texturePath;
	}

	public void render() {
		this.bind();
		glPushMatrix(); 
		glBegin(GL_QUADS);
		glTexCoord2d(0, 0);
		glVertex2d(0, 0);

		glTexCoord2d(0, 1);
		glVertex2d(0, 32);

		glTexCoord2d(1, 1);
		glVertex2d(32, 32);

		glTexCoord2d(1, 0);
		glVertex2d(32, 0);
		glEnd();
		glPopMatrix();
		Display.sync(60);
	}
}
