package model.map;

import entity.Size;
import entity.UnLoadedMap;
import model.element.Position;
import model.element.staticelement.StaticElementFactory;

public class MapMaker {
	
private StaticElementFactory staticFactory;
	
	public MapMaker() {
		this.setStaticFactory(new StaticElementFactory());
	}
	
	public Map makeAMap(UnLoadedMap mapLoaded,Size mapSize) {
		Map map = new Map(mapSize.getLenght(),mapSize.getWidth());
		for(int y = 0; y<mapSize.getWidth();++y) {
			for(int x = 0; x<mapSize.getWidth();++x) {
				map.setOnTheMap(this.getStaticFactory().createStaticElement(new Position(x,y), mapLoaded.getOnTheMap(x, y)), x, y);
			}
		}
		return map;
	}

	public StaticElementFactory getStaticFactory() {
		return staticFactory;
	}

	public void setStaticFactory(StaticElementFactory staticFactory) {
		this.staticFactory = staticFactory;
	}


}
