package com.installer.core;

public abstract class AbstractState<T> {
	private T label;
	private int key;
	
	public AbstractState(T label, int key) {
		this.label = label;
		this.key = key;
	}
	
	public AbstractState(AbstractState<T> state) {
		this(state.getLabel(), state.getKey());
	}
	
	public T getLabel() {
		return this.label;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public abstract AbstractState<T> getNewInstance();
	
	public String toString() {
		return "[" + key + ", " + label.toString() + "]";
	}
}
