package model.level;

import java.util.ArrayList;

import entity.LevelData;
import model.element.IElement;
import model.element.IPosition;
import model.element.mobile.IMobileElements;
import model.element.mobile.MobileElementFactory;
import model.element.mobile.MobileElementType;
import model.element.mobile.Player;
import model.element.staticelement.Spawn;
import model.map.IMap;

public class Level implements ILevel{

	private IMap map;

	private LevelData data;
	
	private IMobileElements player;
	
	private ArrayList<IMobileElements> mobileElements;
	
	private MobileElementFactory mobileElementFactory;

	public Level(LevelData data, IMap iMap) {
		this.setData(data);
		this.setMap(iMap);
		this.setMobileElementFactory(new MobileElementFactory());
		this.addMobile();
	}
	
	private IPosition findSpawnPosition() {
		
		for (int x = 0; x < this.getMap().getLenght();++x) {
			for (int y = 0; y < this.getMap().getWidth();++y) {
				if(this.getMap().getOnTheMap(x, y) !=null) {
					if(this.getMap().getOnTheMap(x, y).getClass() == Spawn.class) {
						return this.getMap().getOnTheMap(x, y).getPosition();
					}
				}
			}
		}
		return null;
	}
	
	private void addMobile() {
		IPosition spawnpoint = findSpawnPosition();
		System.out.println("coord x spawn : " +spawnpoint.getX()+" coord y spawn : " +spawnpoint.getY());
		if(spawnpoint!=null) {
			this.setPlayer(this.getMobileElementFactory().createMobileElement(MobileElementType.Player, spawnpoint));
			System.out.println
			(
				"coord x player spawn : " +
				this.getPlayer().getMobileposition().getMobilex() +
				" coord y player spawn : " +
				this.getPlayer().getMobileposition().getMobiley()
			);
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


	public IMobileElements getPlayer() {
		return player;
	}


	public void setPlayer(IMobileElements player) {
		this.player = player;
	}


	public ArrayList<IMobileElements> getMobileElements() {
		return mobileElements;
	}


	public void setMobileElements(ArrayList<IMobileElements> mobileElements) {
		this.mobileElements = mobileElements;
	}

	public MobileElementFactory getMobileElementFactory() {
		return mobileElementFactory;
	}

	public void setMobileElementFactory(MobileElementFactory mobileElementFactory) {
		this.mobileElementFactory = mobileElementFactory;
	}

}
