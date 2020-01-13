package view;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import contract.IModel;
import static org.lwjgl.opengl.GL11.*;
import model.element.mobile.IMobileElement;
import model.map.IMap;

public class WindowPanel implements IWindowPanel {

	private IModel model;
	
	private boolean isRunning=false;
	
	public WindowPanel(IModel model) {
		this.setModel(model);
		this.initGL();
	}

	public void start() {
		this.setRunning(true);
	}
	
	public void render() {
			if (Display.isCloseRequested()) {
				this.exit();
			}
			Display.update();
			this.renderContent();
	}
	
	
	public void exit() {
		this.setRunning(false);
		Display.destroy();
		System.exit(0);
	}
	
	private void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, 720, 480, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public void renderContent() {
		int x = 16,y = 16,size=16;
		glBegin(GL_QUADS);
		glColor3f(0x3f, 0x23,0x00);
		glVertex2f(x, y);
		glVertex2f(x+size, y);
		glVertex2f(x+size, y+size);
		glVertex2f(x, y+size);

		glEnd();
	}

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	
}
