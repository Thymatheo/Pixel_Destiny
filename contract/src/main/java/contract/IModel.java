package contract;

import java.util.Observable;

import model.level.ILevel;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	ILevel getLevel();
}
