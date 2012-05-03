package com.installer.core;

/* Class used to build a state with a integer key and a
 * label of type T.
 */
public abstract class AbstractState<T> {
	private T label;
	private int key;
	
	/* Constructor that takes a label of type T and
	 * an integer key.
	 */
	public AbstractState(T label, int key) {
		this.label = label;
		this.key = key;
	}
	
	/* Copy constructor
	 */
	public AbstractState(AbstractState<T> state) {
		this(state.getLabel(), state.getKey());
	}
	
	public T getLabel() {
		return this.label;
	}
	
	public int getKey() {
		return this.key;
	}
	
	/* Abstract method used to return a deep copy of
	 * the object. Should be implemented to call the copy
	 * constructor of the subclass.
	 */
	public abstract AbstractState<T> getNewInstance();
	
	public String toString() {
		return "[" + key + ", " + label.toString() + "]";
	}
}
