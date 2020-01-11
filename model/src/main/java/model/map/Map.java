package model.map;

import model.element.IElement;

public class Map implements IMap{

	private int lenght;
	private int width;
	private IElement[][] map;


	public Map() {
		// TODO Auto-generated constructor stub
	}

	public Map(int lenght, int width) {
		this.setLenght(lenght);
		this.setWidth(width);
		this.setMap(new IElement[this.getLenght()][this.getWidth()]);
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

	public IElement[][] getMap() {
		return map;
	}

	public void setMap(IElement[][] map) {
		this.map = map;
	}

	public void setOnTheMap(IElement element, int x, int y) {
		this.getMap()[x][y] = element;
	}

	@Override
	public IElement getOnTheMap(int x, int y) {
		// TODO Auto-generated method stub
		return this.getMap()[x][y];
	}

}
