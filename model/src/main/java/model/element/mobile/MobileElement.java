package model.element.mobile;

import model.element.Element;
import model.element.IPosition;
import model.element.ISprite;

public class MobileElement extends Element implements IMobileElements{
	
	private float moveSpeed = (float) 0.30;

	public MobileElement(Element element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public MobileElement(ISprite sprite, IPosition position) {
		super(sprite, position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(float moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

}
