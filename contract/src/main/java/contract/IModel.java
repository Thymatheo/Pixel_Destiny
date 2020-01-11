package contract;

import java.util.Observable;

import model.map.IMap;

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

	IMap getMap();
}
