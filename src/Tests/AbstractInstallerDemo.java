package Tests;

import java.io.*;
import java.util.*;
import com.installer.core.*;

public class AbstractInstallerDemo {

	public static void main(String[] args) {
		Stack<TestState> stack = new Stack<TestState>();
		stack.push(new TestState("State 4", 3));
		stack.push(new TestState("State 3", 2));
		stack.push(new TestState("State 2", 1));
		stack.push(new TestState("State 1", 0));
		
		Vector<TestState> vector = new Vector<TestState>();
		vector.add(new TestState("0", 0));
		vector.add(new TestState("1", 1));
		vector.add(new TestState("2", 2));
		vector.add(new TestState("3", 3));
		vector.add(new TestState("4", 4));
		
		TestInstaller installer0 = new TestInstaller(stack, new File(AbstractInstallerDemo.class.getResource("/dir").getPath()));
		TestInstaller installer1 = new TestInstaller(vector, new File(AbstractInstallerDemo.class.getResource("/dir").getPath()));
		
		System.out.println("Test Stack constructor- \nForward:\n");
		System.out.println(installer0.toString() + "\n");
		System.out.println();
		int size0 = stack.size();
		for(int i=0; i<size0; i++) {
			System.out.println(installer0.goForward() + "\n");
			System.out.println(installer0.toString() + "\n");
		}
		
		System.out.println("Backward:\n");
		System.out.println(installer0.toString() + "\n");
		for(int i=0; i<size0; i++) {
			System.out.println(installer0.goBackward() + "\n");
			System.out.println(installer0.toString() + "\n");
		}
		
		System.out.println("\nTest Vector constructor: \nForward:\n");
		System.out.println(installer1.toString() + "\n");
		
		System.out.println(installer1.toString() + "\n");
		int size1 = stack.size();
		for(int i=0; i<size1; i++) {
			System.out.println(installer1.goForward() + "\n");
			System.out.println(installer1.toString() + "\n");
		}
		
		System.out.println("Backward:\n");
		System.out.println(installer1.toString() + "\n");
		for(int i=0; i<size1; i++) {
			System.out.println(installer1.goBackward() + "\n");
			System.out.println(installer1.toString() + "\n");
		}
	}
}
