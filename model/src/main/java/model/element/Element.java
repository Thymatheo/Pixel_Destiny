package model.element;

public abstract class Element extends GameObject implements IElement{

	protected boolean unPenetrable = false;

	public Element(Element element) {
		super(element.getSprite(), element.getPosition());
		this.setUnPenetrable(element.isUnPenetrable());
	}



	public Element(ISprite sprite, IPosition position) {
		super(sprite, position);
	}



	public boolean isUnPenetrable() {
		return unPenetrable;
	}



	public void setUnPenetrable(boolean unPenetrable) {
		this.unPenetrable = unPenetrable;
	}
}
