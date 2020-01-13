package view;

public interface IWindowFrame {
	int lenght = 720;
	float rapport =  1.5f;
	int width = (int) (lenght/rapport);
	boolean fullscreen = false;
	boolean reSizeable = true;
	String Title = "Pixel destiny";
	
	IWindowPanel getWindowPanel();
}
