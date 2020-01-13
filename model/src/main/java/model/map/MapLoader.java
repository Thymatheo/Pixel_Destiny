package model.map;

import java.sql.SQLException;

import entity.MapSize;
import entity.UnLoadedMap;
import model.DAO.DAOSize;
import model.DAO.DAOUnLoadedMap;
import model.DBConnection;

public class MapLoader {

	private MapSize mapSize;
	private UnLoadedMap mapUnLoad;
	private MapMaker mapmaker;
	
	public MapLoader() {
		this.setMapmaker(new MapMaker());
	}
	
	public void setMapSize(int idMap) {
		try {
			this.setMapSize(new MapSize());
			final DAOSize daoSize = new DAOSize(DBConnection.getInstance().getConnection());
			this.setMapSize(daoSize.find(idMap));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setMapUnLoad(int idMap) {
		this.setMapUnLoad(new UnLoadedMap(this.getMapSize().getLenght(),this.getMapSize().getWidth()));
		try {
			final DAOUnLoadedMap daoMap = new DAOUnLoadedMap(DBConnection.getInstance().getConnection());
			this.setMapUnLoad(daoMap.findAndFile(idMap,this.getMapSize()));
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MapSize getMapSize() {
		return mapSize;
	}

	public void setMapSize(MapSize mapSize) {
		this.mapSize = mapSize;
	}

	public MapMaker getMapmaker() {
		return mapmaker;
	}

	public void setMapmaker(MapMaker mapmaker) {
		this.mapmaker = mapmaker;
	}

	public UnLoadedMap getMapUnLoad() {
		return mapUnLoad;
	}

	public void setMapUnLoad(UnLoadedMap mapUnLoad) {
		this.mapUnLoad = mapUnLoad;
	}

}
