package com.installer.view.basic;

import java.awt.*;

import javax.swing.BorderFactory;

import com.installer.view.*;

public class ContentPanel extends DefaultInstallerPanel {
	private static final long serialVersionUID = 1L;
	
	public ContentPanel() {
		this(new FlowLayout());
	}

	public ContentPanel(LayoutManager layout) {
		super(layout);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	
}
