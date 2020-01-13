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
	
	private long startTime;
	

	public GameLoop(IController controller) {
		this.setController(controller);
	}

	public void run() {
		IWindowPanel panel = this.getController().getWindow().getWindowFrame().getWindowPanel();
		panel.start();
		while(panel.isRunning()) {
			//System.out.println("coucou");
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

			/*System.out.println
			(
				"coord player map : x :" + 
				player.getPosition().getX() +
				" | y : "+ 
				player.getPosition().getY()
			);
			
			System.out.println
			(
				"coord mobile player map : x :" + 
				player.getMobilePosition().getX() +
				" | y : "+ 
				player.getMobilePosition().getY()
			);*/

			this.getController().setPlayerOrder(ControllerOrder.Nothing);
			panel.render();
		}
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

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
