package model.element.mobile;


import model.element.Element;
import model.element.IPosition;
import model.element.ISize;
import model.element.ISprite;
import model.element.Position;

public class MobileElement extends Element implements IMobileElement{
	
	private int moveSpeed =  100;
	
	private IPosition mobilePosition;
	
	public MobileElement(Element element) {
		super(element);
		
		// TODO Auto-generated constructor stub
	}

	public MobileElement(ISprite sprite, IPosition position,ISize size) {
		super(sprite, position, size);
		this.setMobilePosition(new Position(position.getX()*1000,position.getY()*1000));
	}

	@Override
	public int getMoveSpeed() {
		return this.moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public IPosition getMobilePosition() {
		return mobilePosition;
	}

	public void setMobilePosition(IPosition mobilePosition) {
		this.mobilePosition = mobilePosition;
	}
}
