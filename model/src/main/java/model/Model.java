package model;

import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */

	/**
	 * Instantiates a new model.
	 */
	public Model() {
	}



	public Observable getObservable() {
		return this;
	}
}
