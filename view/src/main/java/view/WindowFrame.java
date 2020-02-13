package view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import contract.IController;
import contract.IModel;



public class WindowFrame implements IWindowFrame{

	private IController controller;
	
	private IModel model;
	
	private DisplayMode displayMode;
	
	private IWindowPanel windowPanel; 
	
	
	public WindowFrame(IModel model) {
		this.setModel(model);
		this.setDisplayMode(new DisplayMode(lenght, width));
		try {
			this.buildWindowFrame();
			this.setWindowPanel(new WindowPanel(model));
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buildWindowFrame() throws LWJGLException {
		Display.setDisplayMode(this.getDisplayMode());
		Display.setResizable(reSizeable);
		Display.setFullscreen(fullscreen);
		Display.setTitle(Title);
		Display.setIcon(null);
		Display.setInitialBackground(0xFF,0xFF, 0xFF);
		Display.create();
		
	}

	public IController getController() {
		return controller;
	}

	public void setController(IController controller) {
		this.controller = controller;
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(DisplayMode displayMode) {
		this.displayMode = displayMode;
	}

	public IWindowPanel getWindowPanel() {
		return windowPanel;
	}

	public void setWindowPanel(IWindowPanel windowPanel) {
		this.windowPanel = windowPanel;
	}
	
	

}
