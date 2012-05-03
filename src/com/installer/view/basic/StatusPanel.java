package com.installer.view.basic;

import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.installer.view.*;

public class StatusPanel extends DefaultInstallerPanel {
	private static final long serialVersionUID = 1L;
	private Vector<String> statuses;
	private Vector<JLabel> statusLabels;
	
	public StatusPanel() {
		this(new Vector<String>());
	}
	
	public StatusPanel(Vector<String> statuses) {
		super(new GridLayout(statuses.size(), 1));
		this.statuses = statuses;
		this.rebuildPanel();
	}
	
	@Override
	public void initComponent() {
		this.statuses = new Vector<String>();
		this.statusLabels = new Vector<JLabel>();
		this.setPadding(0, 5, 0, 10);
	}
	
	@Override
	public void buildPanel() {
		for(int i=0; i<statuses.size(); i++) {
			statusLabels.add(new JLabel(statuses.get(i)));
			this.add(statusLabels.get(i));
		}
	}
	
	public void addStatus(String status) {
		statuses.add(status);
		this.rebuildPanel();
	}
	
	public void addStatus(Vector<String> status) {
		for(int i=0; i<status.size(); i++) {
			statuses.add(status.get(i));
		}
		this.rebuildPanel();
	}
}
