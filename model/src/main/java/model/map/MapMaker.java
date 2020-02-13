package model.map;

import entity.MapSize;
import entity.UnLoadedMap;
import model.element.Position;
import model.element.planet;
import model.element.staticelement.StaticElementFactory;

public class MapMaker {
	
private StaticElementFactory staticFactory;
	
	public MapMaker() {
		this.setStaticFactory(new StaticElementFactory());
		
	}
	
	public IMap makeAMap(UnLoadedMap mapLoaded,MapSize mapSize, String planetlabel) {
		System.out.println(mapLoaded);
		System.out.println(mapSize);
		System.out.println(mapLoaded.getOnTheMap(0,0));
		System.out.println("map lenght : "+mapSize.getLenght());
		System.out.println("map width : "+mapSize.getWidth());
		this.getStaticFactory().getTextureMapLoader().setPlanetLabel(planetlabel);
		this.getStaticFactory().getTextureMapLoader().loadTexture();
		IMap map = new Map(mapSize.getLenght(),mapSize.getWidth());
		for(int x = 0; x< mapSize.getLenght();++x) {
			for(int y = 0; y< mapSize.getWidth();++y) {
				if (mapLoaded.getOnTheMap(x, y)!=null) {
					map.setOnTheMap(this.getStaticFactory().createStaticElement(new Position(x,y), mapLoaded.getOnTheMap(x, y),planetlabel), x, y);

				}
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
