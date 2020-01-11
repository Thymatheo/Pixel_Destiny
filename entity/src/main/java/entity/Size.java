package entity;

public class Size extends Entity{

	private int width;
	private int lenght;


	public Size(int lenght,int width) {
		this.setWidth(width);
		this.setLenght(lenght);
	}

	public Size() {
		this.setLenght(0);
		this.setWidth(0);
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

}
