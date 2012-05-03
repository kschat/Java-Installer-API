package com.installer.view.basic;

import com.installer.view.*;
import javax.swing.*;
import java.awt.*;

/* Class used to build and display the default buttons in the
 * installer. 
 */
public class ButtonPanel extends DefaultInstallerPanel {
	private static final long serialVersionUID = 1L;
	private DefaultInstallerPanel eastPanel, westPanel;
	private JButton nextButton, backButton, cancelButton;
	
	/* Only constructor, sets the LayoutManager to a BorderLayout
	 */
	public ButtonPanel() {
		super(new BorderLayout());
	}
	
	/* Initiates all the components being used by the panel.
	 * (non-Javadoc)
	 * @see com.installer.view.DefaultInstallerPanel#initComponent()
	 */
	@Override
	public void initComponent() {
		eastPanel = new DefaultInstallerPanel();
		westPanel = new DefaultInstallerPanel();
		nextButton = new JButton("Next");
		backButton = new JButton("Back");
		cancelButton = new JButton("Cancel");
	}
	
	/* Sets up all the components that will be used by the panel.
	 * (non-Javadoc)
	 * @see com.installer.view.DefaultInstallerPanel#buildPanel()
	 */
	@Override
	public void buildPanel() {
		eastPanel.add(backButton);
		eastPanel.add(nextButton);
		westPanel.add(cancelButton);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);
	}
	
	/* Sets the text of the cancel button. If the value
	 * in text is null, don't do anything.
	 */
	public void setCancelButtonText(String text) {
		if(text != null) {
			cancelButton.setText(text);
		}
	}
	
	/* Sets the text of the next button. If the value
	 * in text is null, don't do anything.
	 */
	public void setNextButtonText(String text) {
		if(text != null) {
			nextButton.setText(text);
		}
	}
	
	/* Sets the text of the back button. If the value
	 * in text is null, don't do anything.
	 */
	public void setBackButtonText(String text) {
		if(text != null) {
			backButton.setText(text);
		}
	}
	
	/* Returns the label being displayed on the 
	 * cancel button
	 */
	public String getCancelButtonText() {
		return this.cancelButton.getText();
	}
	
	/* Returns the label being displayed on the 
	 * next button
	 */
	public String getNextButtonText() {
		return this.nextButton.getText();
	}
	
	/* Returns the label being displayed on the 
	 * back button
	 */
	public String getBackButtonText() {
		return this.backButton.getText();
	}
	
	/* Sets both the size and preferred size of the
	 * cancel button.
	 */
	public void setCancelButtonSize(Dimension dim) {
		this.cancelButton.setSize(dim);
		this.cancelButton.setPreferredSize(dim);
	}
	
	/* Sets both the size and preferred size of the
	 * next button.
	 */
	public void setNextButtonSize(Dimension dim) {
		this.nextButton.setSize(dim);
		this.nextButton.setPreferredSize(dim);
	}

	/* Sets both the size and preferred size of the
	 * back button.
	 */
	public void setBackButtonSize(Dimension dim) {
		this.backButton.setSize(dim);
		this.backButton.setPreferredSize(dim);
	}
	
	/* Returns the preferred size of the button
	 */
	public Dimension getCancelButtonSize() {
		return this.cancelButton.getPreferredSize();
	}
	
	/* Returns the preferred size of the button
	 */
	public Dimension getNextButtonSize() {
		return this.nextButton.getPreferredSize();
	}
	
	/* Returns the preferred size of the button
	 */
	public Dimension getBackButtonSize() {
		return this.backButton.getPreferredSize();
	}
}
