package model.element;

public class GameObject {
	private ISprite sprite;
	private IPosition position;
	private ISize size;
	
	public GameObject(ISprite sprite,IPosition position, ISize size) {
		this.setSprite(sprite);
		this.setPosition(position);
		this.setSize(size);
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
	
	public void setSize(ISize size) {
		this.size = size;
	}
	
	public ISize getSize() {
		return this.size;
	}
}
