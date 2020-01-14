package controller;

import contract.ControllerOrder;
import contract.IController;
import model.element.mobile.IMobileElement;
import model.physicsengine.IPhysicsEngine;
import view.IWindowPanel;

public class GameLoop implements IGameLoop{

	private IController controller;
	
	private boolean tick;
	
	private boolean render;
	
	private long before;
	
	public GameLoop(IController controller) {
		this.setController(controller);
	}

	public void run() {
		
		IWindowPanel panel = this.getController().getWindow().getWindowFrame().getWindowPanel();
		panel.start();
		this.setBefore(System.nanoTime());
		while(panel.isRunning()) {
			if(verifTimer()==true) {
				panel.render();
				panel.setTicks(panel.getTicks()+1);
			}else if (verifTimer()==false){
				System.out.println("update game");
				IMobileElement player = this.getController().getModel().getLevel().getPlayer();
				IPhysicsEngine engine = this.getController().getModel().getPhysicsEngine();
				switch (this.getController().getPlayerOrder()) {
				case Up:
					engine.MoveMobile(0, -1, player);
					System.out.println("En haut");
					break;
				case Down:
					engine.MoveMobile(0, 1, player);
					break;
				case Left:
					engine.MoveMobile(-1, 0, player);
					break;
				case Right:
					engine.MoveMobile(1, 0, player);
					System.out.println("A Droite");
					break;
				case Super: 
					System.out.println("utilisation du super");
				default:
					break;
				}
				this.getController().getWindow().getWindowListener().listen();
				this.getController().setPlayerOrder(ControllerOrder.Nothing);
				panel.setFrames(panel.getFrames()+1);
			}
			panel.showFrameRate(panel.getTimer());
		}
	}
	
	private boolean verifTimer() {
		long now = System.nanoTime();
		if (now - this.getBefore() > framesByNano) {
			this.before += framesByNano;
			return true;
		}
		return false;
	}
	
	//private bool

	public IController getController() {
		return controller;
	}

	public void setController(IController controller2) {
		this.controller = controller2;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public boolean isTick() {
		return tick;
	}

	public void setTick(boolean tick) {
		this.tick = tick;
	}

	public long getBefore() {
		return before;
	}

	public void setBefore(long before) {
		this.before = before;
	}
}
