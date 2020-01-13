package model.element;

public abstract class Element extends GameObject implements IElement{

	protected boolean unPenetrable = false;

	public Element(Element element) {
		super(element.getSprite(), element.getPosition(), element.getSize());
		this.setUnPenetrable(element.isUnPenetrable());
	}



	public Element(ISprite sprite, IPosition position,ISize size) {
		super(sprite, position,size);
	}



	public boolean isUnPenetrable() {
		return unPenetrable;
	}



	public void setUnPenetrable(boolean unPenetrable) {
		this.unPenetrable = unPenetrable;
	}
}
