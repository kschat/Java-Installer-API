package com.installer.view.basic;

import java.util.*;
import java.awt.*;
import javax.swing.border.*;
import com.installer.view.*;

public class BasicInstallerView extends DefaultInstallerPanel {
	private static final long serialVersionUID = 1L;
	private TitlePanel titlePanel;
	private ButtonPanel buttonPanel;
	private StatusPanel statusPanel;
	private ContentPanel contentPanel;
	
	public BasicInstallerView(String title, Vector<String> statuses) {
		super(new BorderLayout());
		titlePanel.setTitle(title);
		statusPanel.addStatus(statuses);
		this.rebuildPanel();
	}
	
	@Override
	public void initComponent() {
		buttonPanel = new ButtonPanel();
		statusPanel = new StatusPanel();
		titlePanel = new TitlePanel();
		contentPanel = new ContentPanel();
		this.setPadding(0, 0, 0, 10);
	}
	
	@Override
	public void buildPanel() {
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(statusPanel, BorderLayout.WEST);
		this.add(contentPanel, BorderLayout.CENTER);
		
		System.out.println("Status Panel width: " + statusPanel.getPreferredSize().width);
		System.out.println("Cancel button width: " + buttonPanel.getCancelButtonSize().width);
		statusPanel.setPadding(0, 5, 0, Math.abs(statusPanel.getPreferredSize().width-buttonPanel.getCancelButtonSize().width)+5);
	}
	
	public void setStatusVisible(boolean aFlag) {
		statusPanel.setVisible(aFlag);
	}
	
	public void setTitleVisible(boolean aFlag) {
		titlePanel.setVisible(aFlag);
	}
	
	public void setButtonsVisible(boolean aFlag) {
		buttonPanel.setVisible(aFlag);
	}
	
	public void setConentVisible(boolean aFlag) {
		contentPanel.setVisible(aFlag);
	}
	
	
}