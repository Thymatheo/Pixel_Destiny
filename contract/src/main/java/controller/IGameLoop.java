package controller;

public interface IGameLoop {

	int framesRate = 60;
	
	double nanoSeconds = Math.pow(10, 9);
	
	double framesByNano = nanoSeconds/framesRate;
	
	void run();
}
