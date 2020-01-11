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
	
	public IMap makeAMap(UnLoadedMap mapLoaded,Size mapSize) {
		System.out.println(mapLoaded);
		System.out.println(mapSize);
		System.out.println(mapLoaded.getOnTheMap(0,0));
		System.out.println("map lenght : "+mapSize.getLenght());
		System.out.println("map width : "+mapSize.getWidth());
		IMap map = new Map(mapSize.getLenght(),mapSize.getWidth());
		for(int x = 0; x< mapSize.getLenght();++x) {
			for(int y = 0; y< mapSize.getWidth();++y) {
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
