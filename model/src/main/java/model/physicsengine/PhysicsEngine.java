package model.physicsengine;

import model.element.IElement;
import model.element.IPosition;
import model.element.mobile.IMobileElements;
import model.element.mobile.IMobilePosition;
import model.level.ILevel;
import model.map.IMap;

public class PhysicsEngine implements IPhysicsEngine{

	private ILevel level;

	public PhysicsEngine(ILevel level) {
		this.setLevel(level);
	}

	public void MoveMobile(int x,int y, IMobileElements element) {
		IMap map = this.getLevel().getMap();
		IPosition pos = element.getPosition();
		if(analyse(pos.getX()+x,pos.getY()+y,map)==true) {
			IMobilePosition mobpos= element.getMobileposition();
			mobpos.setMobilex(mobpos.getMobilex()+(element.getMoveSpeed()*x));
			mobpos.setMobiley(mobpos.getMobiley()+(element.getMoveSpeed()*y));
			if((x<0) || (y<0)) {
				if ((float)mobpos.getMobilex() < (pos.getX()+x)*10) {
					pos.setX(pos.getX()+x);
				}else if ((float)mobpos.getMobiley() < (pos.getY() + y)*10) {
					pos.setY(pos.getY()+y);
				}
			}else if ((x>0) || (y>0)) {
				if ((float)mobpos.getMobilex() > (pos.getX()+x)*10) {
					pos.setX(pos.getX()+x);
				}else if ((float)mobpos.getMobiley() > (pos.getY() + y)*10) {
					pos.setY(pos.getY()+y);
				}
			}
		}
	}
	private boolean analyse(int x , int y,IMap map) {
		if (map.getOnTheMap(x, y) != null ) {
			if (map.getOnTheMap(x, y).isUnPenetrable() == true) {
				return false;
			}
		}
		return true;
	}
	
	private ILevel getLevel() {
		return level;
	}

	private void setLevel(ILevel level) {
		this.level = level;
	}

}
