package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import view.IWindow;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IWindow		window;

	/** The model. */
	private IModel	model;
	
	private IGameLoop gameLoop;
	
	private ControllerOrder playerOrder = ControllerOrder.Nothing;

	/**
	 * Instantiates a new controller.
	 *
	 * @param window
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IWindow window, final IModel model) {
		this.setWindow(window);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setWindow(final IWindow window) {
		this.window = window ;
	}
	
	public IWindow getWindow() {
		return this.window;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public IModel getModel() {
		return this.model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	
	public void play() {
		this.setGameLoop(new GameLoop(this));
		this.getGameLoop().run();
	}
	
	
	public void orderPerform(final ControllerOrder controllerOrder) {

	}

	public ControllerOrder getPlayerOrder() {
		return playerOrder;
	}

	public void setPlayerOrder(ControllerOrder playerOrder) {
		this.playerOrder = playerOrder;
	}

	public IGameLoop getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(IGameLoop gameLoop) {
		this.gameLoop = gameLoop;
	}

}
