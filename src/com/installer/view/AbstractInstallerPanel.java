package com.installer.view;

import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AbstractInstallerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int PADDING_LENGTH = 4;
	private int[] padding = new int[PADDING_LENGTH];
	
	//private Vector<? extends Component> components;
	
	public AbstractInstallerPanel() {
		this(new FlowLayout());
	}
	
	public AbstractInstallerPanel(LayoutManager layout) {
		this(layout, true);
	}
	
	public AbstractInstallerPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		
		for(int i=0; i<padding.length; i++) {
			padding[i] = 0;
		}
		
		initComponent();
		buildPanel();
		
		//components = new Vector<Component>();
	}
	
	public void rebuildPanel() {
		this.removeAll();
		this.buildPanel();
		this.validate();
	}
	
	/*
	protected void addListeners() {
		for(int i=0; i<components.size(); i++) {
			ActionListener[] listeners = components.get(i).getListeners(ActionListener.class);
			if(listeners.length != 0) {
				listeners[0].
			}
		}
	}
	*/
	
	public void setTopPadding(int top) {
		this.setPadding(top, padding[1], padding[2], padding[3]);
	}
	
	public void setLeftPadding(int left) {
		this.setPadding(padding[0], left, padding[2], padding[3]);
	}
	
	public void setBottomPadding(int bottom) {
		this.setPadding(padding[0], padding[1], bottom, padding[3]);
	}
	
	public void setRightPadding(int right) {
		this.setPadding(padding[0], padding[1], padding[2], right);
	}
	
	public void setPadding(int top, int left, int bottom, int right) {
		if(top > -1 && left > -1 && bottom > -1 && right > -1) {
			padding[0] = top;
			padding[1] = left;
			padding[2] = bottom;
			padding[3] = right;
			this.setBorder(new EmptyBorder(top, left, bottom, right));
		}
	}
	
	public int getTopPadding() {
		return padding[0];
	}
	
	public int getLeftPadding() {
		return padding[2];
	}
	
	public int getBottomPadding() {
		return padding[3];
	}
	
	public int getRightPadding() {
		return padding[4];
	}
	
	public int[] getPadding() {
		int[] temp = new int[] {padding[0], padding[1], padding[2], padding[3]};
		return temp;
	}
	
	public abstract void initComponent();
	
	public abstract void buildPanel();
}
