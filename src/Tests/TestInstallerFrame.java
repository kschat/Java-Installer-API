package Tests;

import java.util.*;
import com.installer.view.*;
import com.installer.view.basic.*;

public class TestInstallerFrame extends AbstractInstallerFrame {
	private static final long serialVersionUID = 1L;
	private BasicInstallerView installerView;
	private Vector<String> statuses = new Vector<String>();
	
	public TestInstallerFrame(String title, int w, int h) {
		super(title, w, h);
		this.initComponents();
		this.buildMainPanel(installerView);
		this.setVisible(true);
		installerView.setStatusVisible(true);
	}
	
	@Override
	protected void initComponents() {
		statuses.add("Status1");
		statuses.add("Status2");
		statuses.add("Status3");
		installerView = new BasicInstallerView("Title", statuses);
	}

	@Override
	protected void buildMainPanel(AbstractInstallerPanel panel) {
		this.getContentPane().add(panel);
	}
	
	public static void main(String[] args) {
		new TestInstallerFrame("Test", 700, 450);
	}
}
