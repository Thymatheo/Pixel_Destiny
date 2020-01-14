package view;

import contract.IController;

public interface IWindowListener {
	void setController(IController controller);
	void listen();
}
