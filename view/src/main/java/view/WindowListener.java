package view;


import org.lwjgl.input.Keyboard;

import contract.IController;

public class WindowListener implements IWindowListener {

	private IController controller;
	
	private IWindow window;
	
	
	public WindowListener(IWindow window) {
		this.setWindow(window);
	}
	
	public void listen() {
		//System.out.print(Keyboard.getEventCharacter());
	}

	public IController getController() {
		return controller;
	}

	public void setController(IController controller) {
		this.controller = controller;
	}

	public IWindow getWindow() {
		return window;
	}

	public void setWindow(IWindow window) {
		this.window = window;
	}

}
