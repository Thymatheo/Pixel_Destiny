package controller;

import contract.ControllerOrder;
import contract.IController;
import model.element.mobile.IMobileElement;
import model.physicsengine.IPhysicsEngine;
import view.IWindowPanel;

public class GameLoop implements IGameLoop{

	private IController controller;

	public GameLoop(IController controller) {
		this.setController(controller);
	}

	public void run() {

		IWindowPanel panel = this.getController().getWindow().getWindowFrame().getWindowPanel();
		panel.start();
		while(panel.isRunning()) {
			panel.render();
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
		}
	}



	public IController getController() {
		return controller;
	}

	public void setController(IController controller2) {
		this.controller = controller2;
	}

}
