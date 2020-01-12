package model.element.mobile;

public class MobilePosition implements IMobilePosition{

	private float mobilex;
	
	private float mobiley;
	
	public MobilePosition(float x , float y) {
		this.setMobilex(x);
		this.setMobiley(y);
	}

	public float getMobiley() {
		return this.mobiley;
	}

	public void setMobiley(float mobiley) {
		this.mobiley = mobiley;
	}

	public float getMobilex() {
		return this.mobilex;
	}

	public void setMobilex(float mobilex) {
		this.mobilex = mobilex;
	}
}
