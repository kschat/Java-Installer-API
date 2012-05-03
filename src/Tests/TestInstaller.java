package Tests;

import java.io.*;
import java.util.*;
import com.installer.core.*;

public class TestInstaller extends AbstractInstaller<TestState> {

	public TestInstaller(Stack<TestState> states, File installDir) {
		super(states, installDir);
	}
	
	public TestInstaller(Vector<TestState> states, File installDir) {
		super(states, installDir);
	}
	
	public void setSettingsForInstall() {
		
	}
	
	public void setInstallType() {
		
	}
}
