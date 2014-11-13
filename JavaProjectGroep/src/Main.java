import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Interface is built here.
 * 
 * @author Erik-Jan Krielen erik-jan.krielen@atos.net
 * @version 0.1 Current version number of program
 * @since October 2nd 2014 Creation of this file
 * @update October 31th 2014 Latest update of this file
 * 
 */
@SuppressWarnings("serial")
public class Main extends JFrame {

	public static void main(String[] args) {
		new Main();
		
	}

	// panel where elements can be put in
	private JPanel panel = new JPanel();
	// panel elements

	JLabel statusStaticLabel = new JLabel("Status: ");
	JLabel statusLabel = new JLabel("Program started succesfully");
	JSeparator statusLine = new JSeparator();

	JLabel userNameLabel = new JLabel("Username: ");
	JTextField userNameField = new JTextField("");
	JButton createUserButton = new JButton("Create User");

	JButton manageUsersButton = new JButton("Manage existing users");

	JTextField userHistoryNameField = new JTextField("");
	JButton requestHistoryButton = new JButton("Request User History");
	JScrollPane pane = new JScrollPane();
	JTextArea historyResultTextArea = new JTextArea("");

	/**
	 * Constructor to make the interface
	 */
	Main() {
		// info about the app
		// title of the window
		super("DevLab App");
		// width and height of the panel (inclusive title bar and borders)
		setSize(800, 600);
		setLocation(250, 50);
		panel.setLayout(null);

		// set pos x, pos y, width and height of each element
		statusStaticLabel.setBounds(5, 5, 50, 20);
		statusLabel.setBounds(52, 5, 600, 20);
		statusLine.setBounds(0, 27, 800, 2);

		userNameLabel.setBounds(10, 35, 70, 20);
		userNameField.setBounds(80, 35, 150, 20);
		createUserButton.setBounds(235, 35, 130, 20);

		manageUsersButton.setBounds(10, 70, 180, 20);

		userHistoryNameField.setBounds(10, 100, 150, 20);
		requestHistoryButton.setBounds(165, 100, 180, 20);
		pane.setBounds(10, 125, 300, 100);
		historyResultTextArea.setLineWrap(true);
		historyResultTextArea.setWrapStyleWord(true);

		// add elementals to the panel layout
		panel.add(statusStaticLabel);
		panel.add(statusLabel);
		panel.add(statusLine);

		panel.add(userNameLabel);
		panel.add(userNameField);
		panel.add(createUserButton);

		panel.add(manageUsersButton);

		panel.add(userHistoryNameField);
		panel.add(requestHistoryButton);
		pane.getViewport().add(historyResultTextArea);
		panel.add(pane);

		// methods needed for default interface behavior
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		interfaceControls();

	}

//	private Utility repository = Utility.getInstance();
	
//	public void actionPerformed(ActionEvent ae)  {
//		if(ae.getSource() == createUserButton) {
//			BufferedReader br = new BufferedReader( new InputStreamReader(User.class.getResourceAsStream("user_definition.txt")));
//			br.readLine();
//		}
//	}
	
	/**
	 * Behavior of interface elements are defined here
	 */
	public void interfaceControls() {

		// Behavior of the createUserButton
		//createUserButton.addActionListener(this);
		
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!userNameField.getText().isEmpty()) {
					String userName = userNameField.getText();
					
					controls.Utility.createUser(userName);
					userNameField.setText("");
					statusLabel.setForeground(Color.black);
					statusLabel.setText("User succesfully created");
				} else {
					statusLabel.setForeground(Color.red);
					statusLabel.setText("Enter a name first");
				}
			}
		});// Behavior of the createUserButton

		// Behavior of the manageUsersButton
		manageUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				statusLabel.setForeground(Color.black);
				statusLabel.setText("Yay button pressed!");
				// TODO open new frame with different options
			}
		});// Behavior of the manageUsersButton

		// Behavior of the requestHistoryButton
		requestHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String userName = userHistoryNameField.getText();
				if (controls.Utility.requestUserHistory(userName).equals(
						"user not found")) {
					statusLabel.setForeground(Color.red);
					statusLabel.setText("User not found, try again.");

				} else {
					statusLabel.setForeground(Color.black);
					statusLabel.setText("Succesfully retrieved users log.");
					historyResultTextArea.setText(controls.Utility
							.requestUserHistory(userName));
				}

			}
		});// Behavior of the requestHistoryButton

	}
}
