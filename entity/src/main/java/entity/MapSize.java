package entity;

public class MapSize extends Entity{

	private int width;
	private int lenght;


	public MapSize(int lenght,int width) {
		this.setWidth(width);
		this.setLenght(lenght);
	}

	public MapSize() {
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
