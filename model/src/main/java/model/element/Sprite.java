package model.element;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite implements ISprite {

		private String ConsoleImage;
		
		private String ImageName;
		
		private Image image;
		
		public Sprite(String consoleImage,String imageName) {
			this.setConsoleImage(consoleImage);
			this.setImageName(imageName);
			this.loadImage(this.getImageName());
		}

		public String getConsoleImage() {
			return ConsoleImage;
		}

		public void setConsoleImage(String consoleImage) {
			ConsoleImage = consoleImage;
		}

		public String getImageName() {
			return ImageName;
		}

		public void setImageName(String imageName) {
			ImageName = imageName;
		}
		
		public void loadImage(String imageName) {
			 try {
				this.setImage(ImageIO.read(getClass().getResource("/"+ this.getImageName())));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public Image getImage() {
			return image;
		}

		public void setImage(Image image) {
			this.image = image;
		}
}
