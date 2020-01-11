package entity;

public class UnLoadedMap extends Entity{


	private int lenght;
	private int width;
	
	private String[][] map;
	
	public UnLoadedMap(int lenght,int width){
		this.setLenght(lenght);
		this.setWidth(width);
		this.setMap(new String[this.getLenght()][this.getWidth()]);
	}
	
	public UnLoadedMap(){

	}

	public String[][] getMap() {
		return map;
	}

	public void setMap(String[][] map) {
		this.map = map;
	}
	
	public void setOnTheMap(String element, int x,int y) {
		this.getMap()[x][y] = element;
	}
	
	public String getOnTheMap(int x, int y) {
		return this.getMap()[x][y];
		
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
	

}
