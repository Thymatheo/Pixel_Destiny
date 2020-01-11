package model.level;

import entity.LevelData;
import model.map.IMap;

public class Level implements ILevel{

	private IMap map;

	private LevelData data;

	public Level(LevelData data, IMap iMap) {
		this.setData(data);
		this.setMap(iMap);
	}


	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}


	public LevelData getData() {
		return data;
	}


	public void setData(LevelData data) {
		this.data = data;
	}

}
