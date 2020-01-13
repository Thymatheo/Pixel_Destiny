package view;

import contract.ControllerOrder;

public interface IWindow {

	IWindowFrame getWindowFrame();
	IWindowListener getWindowListener();
	ControllerOrder keyCodeToControllerOrder(final int keyCode);
}
