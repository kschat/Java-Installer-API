package com.installer.view;

import java.awt.*;
import javax.swing.*;

/* Class to be used as the base class for all Installer UIs
 */
public abstract class AbstractInstallerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	protected int WIDTH, HEIGHT;
	protected JPanel mainPanel;
	
	/* Default constructor that sets the title blank and the
	 * size of the window to 100 by 100
	 */
	public AbstractInstallerFrame() {
		this("");
	}
	
	/* Constructor that sets the title to the value passed in title
	 * and sets the size of the window to 100 by 100
	 */
	public AbstractInstallerFrame(String title) {
		this(title, 100, 100);
	}
	
	/* Constructor that sets the title to the value passed in title
	 * and sets the size to w and h.
	 */
	public AbstractInstallerFrame(String title, int w, int h) {
		super(title);
		
		/*
		 * Sets the look and feel to the current systems default look and feel
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (UnsupportedLookAndFeelException ex) {ex.printStackTrace();} 
		catch (ClassNotFoundException ex) {ex.printStackTrace();} 
		catch (InstantiationException ex) {ex.printStackTrace();} 
		catch (IllegalAccessException ex) {ex.printStackTrace();}
		
		
		this.setupFrame(w, h, JFrame.EXIT_ON_CLOSE);
		this.mainPanel = new JPanel();
	}
	
	/* Method used to setup the frame to display in the center of
	 * the users screen and sets the default close operation to the
	 * value passed in by closeOperation.
	 */
	protected void setupFrame(int w, int h, int closeOperation) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDimensions(w, h);
		this.setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));
		this.setDefaultCloseOperation(closeOperation);
		this.setResizable(false);
	}
	
	/* Sets the width of the InstallerFrame
	 */
	public void setWidth(int w) {
		this.setDimensions(this.WIDTH = w, this.HEIGHT);
	}
	
	/* Sets the height of the InstallerFrame
	 */
	public void setHeight(int h) {
		this.setDimensions(this.WIDTH, this.HEIGHT = h);
	}
	
	/* Sets the height and width of the InstallerFrame
	 */
	public void setDimensions(int w, int h) {
		this.WIDTH = w;
		this.HEIGHT = h;
		this.setSize(this.WIDTH, this.HEIGHT);
	}
	
	/* Overloaded function that sets the height and width
	 * of the InstallerFrame with a Dimension rather than
	 * two ints.
	 */
	public void setDimensions(Dimension dim) {
		this.setDimensions(dim.width, dim.height);
	}
	
	/* Abstract method that should be implemented to initiate
	 * all the components that will be used in the JFrame.
	 */
	abstract protected void initComponents();
	
	/* Abstract method that should be implemented to build the
	 * main JPanel being used to display the components. panel
	 * should be the main panel for the JFrame.
	 */
	abstract protected void buildMainPanel(AbstractInstallerPanel mainPanel);
}
