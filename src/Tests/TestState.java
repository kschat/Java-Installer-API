package Tests;

import com.installer.core.*;

public class TestState extends AbstractState<String> {
	
	public TestState(String label, int key) {
		super(label, key);
	}
	
	public TestState(TestState instance) {
		super(instance);
	}
	
	public TestState getNewInstance() {
		return new TestState(this);
	}
}