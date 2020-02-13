package view;

public interface IWindowPanel {
	
	int millis = 1000;
	int resetFrames = 0;
	int resetTicks = 0;
	int scale = 400;

	void start();
	boolean isRunning();
	void render();

	
}
