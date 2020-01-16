package view;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import contract.IModel;
import static org.lwjgl.opengl.GL11.*;

import model.element.IElement;
import model.element.ISize;
import model.map.IMap;

public class WindowPanel implements IWindowPanel {

	private IModel model;
	
	private boolean isRunning=false;
	
	private int ticks;
	
	private int frames;
	
	private long timer; 
	
	private float x,y;
	
	public WindowPanel(IModel model) {
		this.setModel(model);
		this.initGL();
		this.setTimer(System.currentTimeMillis());
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
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, IWindowFrame.lenght, IWindowFrame.width, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public void renderContent() {
		initGL();
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		this.scrolling(0.5f, 0.5f); //player coord
		IMap map = this.getModel().getLevel().getMap();
		for (int x = 0; x < map.getLenght();++x) {
			for (int y = 0; y<map.getWidth();++y) {
				ISize size = map.getOnTheMap(x, y).getSize();
				glBegin(GL_QUADS);
				if (map.getOnTheMap(x, y).getSprite().getConsoleImage() =="f") {
					glColor3f(0xFF, 0xFF,0xFF);
				} else if (map.getOnTheMap(x, y).getSprite().getConsoleImage() =="s") {
					glColor3f(0x00, 0xFF,0x00);
				} else if (map.getOnTheMap(x, y).getSprite().getConsoleImage() =="x") {
					glColor3f(0x00, 0x00,0x00);
				}
				glVertex2f(x*size.getLenght(), y*size.getWidth());
				glVertex2f(x*size.getLenght()+scale, y*size.getWidth());
				glVertex2f(x*size.getLenght()+scale, y*size.getWidth()+scale);
				glVertex2f(x*size.getLenght(), y*size.getWidth()+scale);

			}
		}
		glEnd();
	}
	
	private void renderTexture(IElement element) {
		ISize size = element.getSize();
		glBegin(GL_QUADS);
		glTexCoord2f(x*size.getLenght(), y*size.getWidth());
		glVertex2f(x*size.getLenght(), y*size.getWidth());
		glTexCoord2f(x*size.getLenght()+scale, y*size.getWidth());
		glVertex2f(x*size.getLenght()+scale, y*size.getWidth());
		glTexCoord2f(x*size.getLenght()+scale, y*size.getWidth()+scale);
		glVertex2f(x*size.getLenght()+scale, y*size.getWidth()+scale);
		glTexCoord2f(x*size.getLenght(), y*size.getWidth()+scale);
		glVertex2f(x*size.getLenght(), y*size.getWidth()+scale);
	 	glEnd();
		
	}
	
	public void showFrameRate(long timer) {
		if (System.currentTimeMillis() - timer >= millis) {
			this.setTimer(this.getTimer()+millis);
			Display.setTitle(IWindowFrame.Title + "|| ticks " + this.getTicks()+ "|| fps" + this.getFrames());
			this.setFrames(resetFrames);
			this.setTicks(resetTicks);
		}
	}
	
	public void scrolling(float xScroll, float yScroll) {
		x+=xScroll;
		y+=yScroll;
		GL11.glTranslatef(x, y, 0);
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

	public int getFrames() {
		return frames;
	}

	public void setFrames(int frames) {
		this.frames = frames;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}
}
