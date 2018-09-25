package edu.njit.Cryp71c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ButtonListener implements ActionListener {
	
	public ButtonListener(JButton button, JTextArea textArea) {
		String name = button.getText();
		textArea.append(name);
	}

	public void actionPerformed(ActionEvent evt) {
		String num = evt.getActionCommand();
	}
}
