package edu.njit.Cryp71c;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***************************
 * 
 * @author Zach Grossi
 * ID#:21839997
 * CS-288
 * Sect.: 102
 * Started On: 1/30/2012
 * "Finished" On: 2/13/2012
 *
 **************************/

@SuppressWarnings("serial")
public class GraphicalUserInterface extends JFrame {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new GraphicalUserInterface();
			}
		});
	}

	public GraphicalUserInterface() {

		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int width  = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		//asks for the standard variables to solve with
		int boardSizeX = 8;
		int boardSizeY = 8;
		int startX = 0;
		int startY = 0;
		int totalNum = boardSizeX * boardSizeY;
		//String buttonNumber = null;
		
		//set main frame parameters
		Container c = getContentPane();
		setBounds(width / 2 - 500, height / 2 - 500, 1000, 1000);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setJMenuBar(createJMenuBar());
		c.setLayout(new BorderLayout());
		setResizable(false);                 
		
		//create a new panel and add it to the east side. contains the text area
		JPanel eastPanel = new JPanel();
		JTextArea outputArea = new JTextArea(55,10);
		outputArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		eastPanel.add(scrollPane);
		c.add(eastPanel, BorderLayout.EAST);
		
		//create a new panel and add it to the south side. contains the text area
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,3));
		JLabel xLabel = new JLabel("Starting X position: ");
		JTextField xTextField = new JTextField("",5);
		xTextField.setToolTipText("Starting X Position");
		
		JLabel yLabel = new JLabel("Starting Y position: ");
		JTextField yTextField = new JTextField("",5);
		yTextField.setToolTipText("Starting Y Position");
		JButton theButton = new JButton("OK");

		//add label, textfield, and button to the panel
		southPanel.add(xLabel);
		southPanel.add(xTextField);
		southPanel.add(yLabel);
		southPanel.add(yTextField);
		southPanel.add(theButton);
		
		//add panel to the container
		c.add(southPanel, BorderLayout.SOUTH);
		
		//create a new panel and add it to the center. contains the buttons
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(boardSizeX,0));
		JButton[] buttonArray = new JButton[totalNum];
		
		for(int i=0; i<totalNum; i++){
			buttonArray[i] = new JButton();
			buttonArray[i].setText("" + i);
			//buttonArray[i].addActionListener(new ButtonListener(buttonArray[i], outputArea));
			centerPanel.add(buttonArray[i]);
		}
		
		c.add(centerPanel, BorderLayout.CENTER);
		//outputArea.append(buttonNumber);
		
		//create a new Warnsdorff object and solves for a solution
		Warnsdorff executeAlgorithm = new Warnsdorff();
		int[][] algorithmResults = new int[boardSizeX*boardSizeY][2];
		algorithmResults = executeAlgorithm.TourSolve(boardSizeX,boardSizeY,startX,startY);
		
		for (int i=(algorithmResults.length-1); i>=0; i--) {
			//create a string buffer and concatenate all the necessary data together
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("Move #");
			strBuf.append(new Integer(algorithmResults.length-1-i).toString());
			strBuf.append(": (");
			strBuf.append(new Integer(algorithmResults[i][0]).toString());
			strBuf.append(", ");
			strBuf.append(new Integer(algorithmResults[i][1]).toString());
			strBuf.append(")\n");
			
			//convert the string buffer into a string
			String newLine = strBuf.toString();
			
			//append the above string to the text area
			outputArea.append(newLine);
		}		
					
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				performQuitAction();
			}
		});
		
		setVisible(true);
	}
	
	//create the menu bar with options to perform various actions 
	private JMenuBar createJMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		//file menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performQuitAction();
			}
		});
		
		fileMenu.add(quitItem);
		
		//size menu
		JMenu sizeMenu = new JMenu("Size");
		menuBar.add(sizeMenu);
		
		JMenuItem eightItem = new JMenuItem("8 X 8");
		sizeMenu.add(eightItem);
		eightItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warningPopup();
			}
		});
		
		JMenuItem tenItem = new JMenuItem("10 X 10");
		sizeMenu.add(tenItem);
		tenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warningPopup();
			}
		});
		
		JMenuItem twentyfourItem = new JMenuItem("24 X 24");
		sizeMenu.add(twentyfourItem);
		twentyfourItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warningPopup();
			}
		});
		
		JMenuItem weirdItem = new JMenuItem("24 X 8");
		sizeMenu.add(weirdItem);
		weirdItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warningPopup();
			}
		});
		
		//size menu
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
	
		//about button
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPopup();
			}
		});
		
		helpMenu.add(aboutItem);
		
		return menuBar;
	}
	
	//create a popup with info about the creator
	public void aboutPopup() {
		JOptionPane.showConfirmDialog(this, "Knight's Tour Solver - using Warnsdorff's Algorithm\nCreated By: Zach Grossi\nCreated: 2012\nCourse: NJIT CS288-102\n\nThanks!" +
				"\n\nThis is as far as I got...\nI'm still haing trouble figuring out\nhow the listeners work.\nI would like to be able to finish this\nbut for now, here's what"
				+ " I have.\nThe algorithm works perfectly, it's just\nproblems with the GUI stuff.", "About", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}
	
	//create a popup with a warning about this part not being finished
	public void warningPopup() {
		JOptionPane.showConfirmDialog(this, "Unfortunately, this part hasn't implemented yet...\nSorry. :(", "Sorry..", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	//custom pop-up asking if the user would like to exit
	private void performQuitAction() {

		int choice = JOptionPane.showConfirmDialog(this, "Are you sure?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}