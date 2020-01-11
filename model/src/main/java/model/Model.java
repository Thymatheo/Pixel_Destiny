package model;

import java.util.Observable;

import contract.IModel;
import model.map.IMap;
import model.map.MapLoader;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private IMap map;
	
	private MapLoader maploader;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.setMaploader(new MapLoader());
		this.buildMap(22);
	}

	public void buildMap(int idMap) {
		this.getMaploader().setMapSize(idMap);
		this.getMaploader().setMapUnLoad(idMap);
		this.setMap(this.getMaploader().getMapmaker().makeAMap(this.getMaploader().getMapUnLoad(), this.getMaploader().getMapSize()));
	}

	public Observable getObservable() {
		return this;
	}



	public IMap getMap() {
		return map;
	}



	public void setMap(IMap map) {
		this.map = map;
	}



	public MapLoader getMaploader() {
		return maploader;
	}



	public void setMaploader(MapLoader maploader) {
		this.maploader = maploader;
	}
}
