package model.map;

import java.util.ArrayList;

import model.element.IElement;

public class Map implements IMap{

	private ArrayList<IElement> map;

	public Map() {
		this.setMap(new ArrayList<IElement>());
	}


	public ArrayList<IElement> getMap() {
		return map;
	}

	public void setMap(ArrayList<IElement> map) {
		this.map = map;
	}

	public void addOnTheMap(IElement element) {
		this.getMap().add(element);
	}
	
	public ArrayList<IElement> getContent(){
		return this.getMap();
	}
	
	
}
