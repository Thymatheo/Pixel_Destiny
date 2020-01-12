package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.LevelData;
import entity.Size;
import model.DAO.DAOLevelData;
import model.DAO.DAOSize;
import model.level.ILevel;
import model.level.Level;
import model.map.IMap;
import model.map.MapLoader;
import model.physicsengine.IPhysicsEngine;
import model.physicsengine.PhysicsEngine;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private ILevel level;
	
	private MapLoader maploader;
	private IPhysicsEngine physicsEngine;
	
	private int idMap;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.setIdMap(22);
		this.levelBuilder();
		this.setPhysicsEngine(new PhysicsEngine(this.getLevel()));
	}

	public void levelBuilder() {
		this.setMaploader(new MapLoader());
		this.buildMap(this.getIdMap());
		LevelData data = new LevelData();
		try {
			final DAOLevelData daodata = new DAOLevelData(DBConnection.getInstance().getConnection());
			data = daodata.find(idMap);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		this.setLevel(new Level(data,this.getMaploader().getMapmaker().makeAMap(this.getMaploader().getMapUnLoad(), this.getMaploader().getMapSize())));
	}
	
	public void  buildMap(int idMap) {
		this.getMaploader().setMapSize(idMap);
		this.getMaploader().setMapUnLoad(idMap);
	}
	
	public void refresh() {
		this.setChanged();
		this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}

	public MapLoader getMaploader() {
		return maploader;
	}



	public void setMaploader(MapLoader maploader) {
		this.maploader = maploader;
	}

	public ILevel getLevel() {
		return level;
	}

	public void setLevel(ILevel level) {
		this.level = level;
	}

	public int getIdMap() {
		return idMap;
	}

	public void setIdMap(int idMap) {
		this.idMap = idMap;
	}

	public IPhysicsEngine getPhysicsEngine() {
		return physicsEngine;
	}

	public void setPhysicsEngine(IPhysicsEngine physicsEngine) {
		this.physicsEngine = physicsEngine;
	}
}
