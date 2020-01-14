package view;

public interface IWindowPanel {
	
	int millis = 1000;
	int resetFrames = 0;
	int resetTicks = 0;
	
	void start();
	boolean isRunning();
	void render();
	int getTicks();
	void setTicks(int ticks);
	int getFrames();
	void setFrames(int frames);
	
	long getTimer();
	void showFrameRate(long timer);
	
}
