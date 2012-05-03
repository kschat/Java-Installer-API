package com.installer.core;

import java.util.*;
import java.io.*;

/* A class meant to be the super class of all installer objects
 * used with the Installer API.
 */
public abstract class AbstractInstaller<T extends AbstractState<?>> {
	private File installDirectory;
	private Stack<T> stateStack, backStack;
	private T currentState;
	
	/* Constructor that takes a Stack of type T and a File that points
	 * to the desired install directory.
	 */
	public AbstractInstaller(Stack<T> states, File installDir) {
		this.stateStack = states;
		this.installDirectory = installDir;
		this.currentState = stateStack.pop();
		this.backStack = new Stack<T>();
	}
	
	/* Constructor that takes a Vector of type T and a File that points
	 * to the desired install directory.
	 */
	public AbstractInstaller(Vector<T> states, File installDir) {
		this.stateStack = new Stack<T>();
		for(int i=states.size()-1; i>0; i--) {
			stateStack.push(states.get(i));
		}
		
		this.installDirectory = installDir;
		this.currentState = stateStack.pop();
		this.backStack = new Stack<T>();
	}
	
	/* Sets the installDirectory parameter to the value passed in 
	 * by installDir
	 */
	public void setInstallDirectroy(File installDir) {
		this.installDirectory = installDir;
	}
	
	/* Returns a new File object with pointing to the directory 
	 * in installDirectory.
	 */
	public File getInstallDirectory() {
		return new File(this.installDirectory.getPath());
	}
	
	/* Adds the current value of currentState to the backStack,
	 * adds the next value from stateStack to currentState and
	 * returns the value in currentValue. Throws an IndexOutOfBounds
	 * exception if stateStack is empty. 
	 */
	public T goForward() throws IndexOutOfBoundsException {
		try {
			stateStack.peek();
			backStack.push(currentState);
			currentState = stateStack.pop();
		}
		catch(EmptyStackException ex) {
			throw new IndexOutOfBoundsException("Can't go forward");
		}
		
		return currentState;
	}
	
	/* Adds the current value of currentState to the stateStack,
	 * adds the next value from backStack to currentState and
	 * returns the value in currentValue. Throws an IndexOutOfBounds
	 * exception if backStack is empty. 
	 */
	public T goBackward() throws IndexOutOfBoundsException {
		try {
			backStack.peek();
			stateStack.push(currentState);
			currentState = backStack.pop();
		}
		catch(EmptyStackException ex) {
			throw new IndexOutOfBoundsException("Can't go backward");
		}
		
		return currentState;
	}
	
	/*Returns a reference to the object in the current state.
	 */
	@SuppressWarnings("unchecked")
	public T getCurrentState() {
		return (T) currentState.getNewInstance();
	}
	
	/* Abstract method that should be implemented to set the
	 * settings for the installer to use when installing the
	 * file.
	 */
	public abstract void setSettingsForInstall();
	
	/* Abstract method that should be implemented to set the
	 * install type of the file.
	 */
	public abstract void setInstallType();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "State Stack: " + stateStack.toString() + "\nBack Stack: " + backStack.toString() + 
		"\nCurrent State: " + getCurrentState() + "\nInstall Directory: " + installDirectory.getPath();
	}
}
