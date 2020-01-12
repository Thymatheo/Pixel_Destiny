package model.element.mobile;


import model.element.Element;
import model.element.IPosition;
import model.element.ISprite;

public class MobileElement extends Element implements IMobileElements{
	
	private int moveSpeed =  3;
	
	private IMobilePosition mobileposition;

	public MobileElement(Element element) {
		super(element);
		
		// TODO Auto-generated constructor stub
	}

	public MobileElement(ISprite sprite, IPosition position) {
		super(sprite, position);
		this.setMobileposition(new MobilePosition(position.getX()*10,position.getY()*10));
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMoveSpeed() {
		return this.moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public IMobilePosition getMobileposition() {
		return this.mobileposition;
	}

	public void setMobileposition(IMobilePosition mobileposition) {
		this.mobileposition = mobileposition;
	}

}
