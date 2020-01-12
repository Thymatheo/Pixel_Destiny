package controller;

import contract.ControllerOrder;
import contract.IController;
import model.element.mobile.IMobileElements;
import model.physicsengine.IPhysicsEngine;

public class GameLoop implements IGameLoop{

	private IController controller;

	public GameLoop(IController controller) {
		this.setController(controller);
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(loopSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			IMobileElements player = this.getController().getModel().getLevel().getPlayer();
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

			System.out.println
			(
				"coord player map : x :" + 
				player.getPosition().getX() +
				" | y : "+ 
				player.getPosition().getY()
			);
			System.out.println
			(
				"coord player mobile : x :" +
				player.getMobileposition().getMobilex() +
				" | y : " +
				player.getMobileposition().getMobiley()
			);

			this.getController().setPlayerOrder(ControllerOrder.Nothing);
			this.getController().getModel().refresh();
		}
	}

	public IController getController() {
		return controller;
	}

	public void setController(IController controller2) {
		this.controller = controller2;
	}

}
