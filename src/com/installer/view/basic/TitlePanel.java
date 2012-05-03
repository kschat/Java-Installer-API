package com.installer.view.basic;

import java.awt.*;
import javax.swing.*;

import com.installer.view.*;

public class TitlePanel extends DefaultInstallerPanel {
	private static final long serialVersionUID = 1L;
	private String title;
	private JLabel titleLabel;
	
	public TitlePanel() {
		this("");
	}
	
	public TitlePanel(String title) {
		this(title, new FlowLayout());
	}
	
	public TitlePanel(String title, LayoutManager layout) {
		super(layout);
		this.title = title;
		this.rebuildPanel();
	}
	
	public void initComponent() {
		titleLabel = new JLabel(title);
		this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void buildPanel() {
		this.add(titleLabel, BorderLayout.CENTER);
	}
	
	public void setTitle(String title) {
		if(title != null) {
			this.title = title;
			titleLabel.setText(title);
			this.rebuildPanel();
		}
	}
	
	public String getTitle() {
		return this.title;
	}
}
