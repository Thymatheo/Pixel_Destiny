package view;


import java.awt.event.KeyEvent;

import contract.ControllerOrder;
import contract.IModel;

public class Window implements IWindow{

	private IModel model;
	private IWindowListener windowListener;
	private IWindowFrame windowFrame;

	public Window(IModel model) {
		this.setModel(model);
		this.setWindowFrame(new WindowFrame(this.getModel()));
		this.setWindowListener(new WindowListener(this));

	}
	
	public ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_Z:
			return ControllerOrder.Up;
		case KeyEvent.VK_S:
			return ControllerOrder.Down;
		case KeyEvent.VK_Q:
			return ControllerOrder.Left;
		case KeyEvent.VK_D:
			return ControllerOrder.Right;
		case KeyEvent.VK_F:
			return ControllerOrder.Super;
		default:
			return ControllerOrder.Nothing;
		}
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}
	
	public IWindowFrame getWindowFrame() {
		return windowFrame;
	}
	
	public void setWindowFrame(IWindowFrame windowFrame) {
		this.windowFrame = windowFrame;
	}

	public IWindowListener getWindowListener() {
		return windowListener;
	}

	public void setWindowListener(IWindowListener windowListener) {
		this.windowListener = windowListener;
	}


}
