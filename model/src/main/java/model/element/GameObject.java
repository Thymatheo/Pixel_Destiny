package model.element;

public class GameObject {
	private ISprite sprite;
	private IPosition position;
	
	public GameObject(ISprite sprite,IPosition position) {
		this.setSprite(sprite);
		this.setPosition(position);
	}

	public ISprite getSprite() {
		return sprite;
	}

	public void setSprite(ISprite sprite) {
		this.sprite = sprite;
	}

	public IPosition getPosition() {
		return position;
	}

	public void setPosition(IPosition position) {
		this.position = position;
	}
}
