package controller;

import contract.ControllerOrder;

public class GameLoop implements IGameLoop{

	private Controller controller;

	public GameLoop(Controller controller) {
		this.setController(controller);
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(loopSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (this.getController().getPlayerOrder()) {
			case Up:
				System.out.println("En haut");
				break;
			case Down:
				System.out.println("En bas");
				break;
			case Left:
				System.out.println("A Gauche");
				break;
			case Right:
				System.out.println("A Droite");
				break;
			case Super: 
				System.out.println("utilisation du super");
			default:
				break;
			}
			this.getController().setPlayerOrder(ControllerOrder.Nothing);
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

}
