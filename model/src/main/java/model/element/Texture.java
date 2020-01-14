package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import org.lwjgl.BufferUtils;

public class Texture implements ITexture {

	private BufferedImage image;
	
	private int lenght;
	private int width;
	private int id;
	
	public Texture (int lenght, int width, int id ) {
		this.setLenght(lenght);
		this.setWidth(width);
		this.setId(id);
	}
	
	public Texture () {
		 
	}
	public Texture loadImage(String imageName) {
		 try {
			this.setImage(ImageIO.read(getClass().getResource("/"+ imageName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLenght(this.getImage().getHeight());
		this.setWidth(this.getImage().getWidth());
		
		int[] pixels = new int[this.getLenght()*this.getWidth()];
		image.getRGB(0, 0,this.getLenght(),this.getWidth(),pixels,0,this.getLenght());
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(this.getLenght()*this.getWidth()*4);
		

		for (int y = 0; y < this.getWidth(); y++) {
			for (int x = 0; x < this.getLenght(); x++) {
				int i = pixels[x + y * this.getWidth()];
				buffer.put((byte) ((i >> 16) & 0xFF));
				buffer.put((byte) ((i >> 8) & 0xFF));
				buffer.put((byte) ((i) & 0xFF));
				buffer.put((byte) ((i >> 24) & 0xFF));
			}
		}
		
		buffer.flip();
		
		int id = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, id);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, this.getWidth(), this.getLenght(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		
		return new Texture(this.getWidth(), this.getLenght(), id);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
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
}
