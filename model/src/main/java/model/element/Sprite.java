package model.element;

public class Sprite implements ISprite {

		private String ConsoleImage;
		
		private String ImageName;
		
		private ITexture texture;
		
		public Sprite(String consoleImage,String imageName) {
			this.setConsoleImage(consoleImage);
			this.setImageName(imageName);
			this.setTexture(new Texture());
			this.setTexture(this.getTexture().loadImage(this.getImageName()));
		}
		
		public Sprite(String consoleImage) {
			this.setConsoleImage(consoleImage);
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

		public ITexture getTexture() {
			return texture;
		}

		public void setTexture(ITexture texture) {
			this.texture = texture;
		}
}
