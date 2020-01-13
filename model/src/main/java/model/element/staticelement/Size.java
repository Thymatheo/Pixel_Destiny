package model.element.staticelement;

import model.element.ISize;

public class Size implements ISize{
 
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

	@Override
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

}
