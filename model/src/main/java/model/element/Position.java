package model.element;

public class Position implements IPosition {
	private float x;
	private float y;
	
	public Position(float x,float y) {
		this.setX(x);
		this.setY(y);
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}
