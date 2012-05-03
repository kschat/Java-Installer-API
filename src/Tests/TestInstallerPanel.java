package Tests;

import javax.swing.*;
import com.installer.view.*;

public class TestInstallerPanel extends AbstractInstallerPanel {
	private static final long serialVersionUID = 1L;
	private JButton button;
	
	public TestInstallerPanel() {
		this.initComponent();
		this.buildPanel();
	}
	
	@Override
	public void initComponent() {
		button = new JButton("Button");
	}

	@Override
	public void buildPanel() {
		this.add(button);
	}

}
