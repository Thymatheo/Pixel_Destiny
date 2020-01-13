package model.physicsengine;

import model.element.IPosition;
import model.element.mobile.IMobileElement;
import model.level.ILevel;
import model.map.IMap;

public class PhysicsEngine implements IPhysicsEngine{

	private ILevel level;

	public PhysicsEngine(ILevel level) {
		this.setLevel(level);
	}

	public void MoveMobile(int x,int y, IMobileElement element) {
		IMap map = this.getLevel().getMap();
		IPosition pos = element.getPosition();
		IPosition mobpos = element.getMobilePosition();
		System.out.println((int)(mobpos.getX()+(element.getMoveSpeed()*x))%1000);
		System.out.println((int)(mobpos.getY()+(element.getMoveSpeed()*y))%1000);
		if ((mobpos.getX()%1000==0)) {
			System.out.println("coucou x");
			if((analyse((pos.getX()+x),(pos.getY()+y),map)==true)) {
				this.move(mobpos, pos, element, x, y);
			}
		}else if((mobpos.getY()%1000==0)) {
			System.out.println("coucou y");
			if((analyse((pos.getX()+x),(pos.getY()+y),map)==true)) {
				this.move(mobpos, pos, element, x, y);
			}
		}else if(((mobpos.getY()%1000!=0)&&(mobpos.getX()%1000!=0))){
			this.move(mobpos, pos, element, x, y);
		}
 
	}
	
	private boolean analyse(int x , int y,IMap map) {
		if (map.getOnTheMap(x, y) != null ) {
			if (map.getOnTheMap(x, y).isUnPenetrable() == true) {
				System.out.println("il y a un mur");
				return false;
			}
		}
		return true;
	}
	
	private void move(IPosition mobpos,IPosition pos,IMobileElement element,int x, int y) {
		mobpos.setX(mobpos.getX()+(element.getMoveSpeed()*x));
		mobpos.setY(mobpos.getY()+(element.getMoveSpeed()*y));
		if((x<0) || (y<0)) {
			if (mobpos.getX() == ((pos.getX()+x)*1000)) {
				pos.setX(pos.getX()+x);
			}else if (mobpos.getY() == ((pos.getY()+y)*1000)) {
				pos.setY(pos.getY()+y);
			}
		}else if ((x>0) || (y>0)) {
			if (mobpos.getX() == ((pos.getX()+x)*1000)) {
				pos.setX(pos.getX()+x);
			}else if (mobpos.getY() == ((pos.getY()+y)*1000)) {
				pos.setY(pos.getY()+y);
			}
		}
	}
	
	private ILevel getLevel() {
		return level;
	}

	private void setLevel(ILevel level) {
		this.level = level;
	}

}
