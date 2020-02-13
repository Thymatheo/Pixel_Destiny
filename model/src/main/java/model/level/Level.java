package model.level;

import java.util.ArrayList;

import entity.LevelData;
import model.element.IElement;
import model.element.IPosition;
import model.element.mobile.IMobileElement;
import model.element.mobile.MobileElementFactory;
import model.element.mobile.MobileElementType;
import model.element.staticelement.Spawn;
import model.map.IMap;

public class Level implements ILevel{

	private IMap map;

	private LevelData data;
	
	private IMobileElement player;
	
	private ArrayList<IMobileElement> mobileElements;
	
	private MobileElementFactory mobileElementFactory;

	public Level(LevelData data, IMap iMap) {
		this.setData(data);
		this.setMap(iMap);
		this.setMobileElementFactory(new MobileElementFactory());
		this.addMobile();
	}
	
	private IPosition findSpawnPosition() {
		for (IElement element : this.getMap().getContent()) {
			if(element.getClass() == Spawn.class) {
				return element.getPosition();
			}
		}
		return null;
	}
	
	private void addMobile() {
		IPosition spawnpoint = findSpawnPosition();
		System.out.println("coord x spawn : " +spawnpoint.getX()+" coord y spawn : " +spawnpoint.getY());
		if(spawnpoint!=null) {
			this.setPlayer(this.getMobileElementFactory().createMobileElement(MobileElementType.Player, spawnpoint));
		}
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


	public IMobileElement getPlayer() {
		return player;
	}


	public void setPlayer(IMobileElement player) {
		this.player = player;
	}


	public ArrayList<IMobileElement> getMobileElements() {
		return mobileElements;
	}


	public void setMobileElements(ArrayList<IMobileElement> mobileElements) {
		this.mobileElements = mobileElements;
	}

	public MobileElementFactory getMobileElementFactory() {
		return mobileElementFactory;
	}

	public void setMobileElementFactory(MobileElementFactory mobileElementFactory) {
		this.mobileElementFactory = mobileElementFactory;
	}

}
