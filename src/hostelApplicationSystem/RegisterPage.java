package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public RegisterPage() {
		//Design and title of the window page
		setResizable(false);
		setTitle("New User Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 637, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblwelcome = new JLabel("Welcome to UTHM Hostel Application System");
		lblwelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblwelcome.setBounds(10, 10, 608, 48);
		contentPane.add(lblwelcome);
		
		JLabel lblNewUserRegistration = new JLabel("New User Register");
		lblNewUserRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewUserRegistration.setBounds(10, 53, 598, 48);
		contentPane.add(lblNewUserRegistration);
		
		//Design and content of the label 
		JLabel lblUserName = new JLabel("Username: ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(57, 142, 169, 48);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(57, 200, 169, 48);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(57, 258, 169, 48);
		contentPane.add(lblConfirmPassword);

		
		//Design of the box that let user input information
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(224, 148, 334, 32);
		contentPane.add(textFieldUserName);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(224, 206, 334, 32);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordFieldConfirm.setBounds(224, 265, 334, 32);
		contentPane.add(passwordFieldConfirm);
		
		//Design and function of the Register button
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Read the Username, password, Confirm Password, and set that it only can be register as user
				String userName = textFieldUserName.getText();
				String password = passwordField.getText();
				String confirmPassword = passwordFieldConfirm.getText();
				String usertype = "User";
                
				//Get the username that has been register
				String msg = "" + userName;
                msg += " \n";
				
                try {//Connect to MySQL
                	 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");
                	 
                	 //Insert the data into database
                	 PreparedStatement st = (PreparedStatement) connection
                             .prepareStatement("INSERT INTO user (name, password, usertype) values (?,?,?)");
                	 
                	 st.setString(1, userName);
                	 st.setString(2, password);
                	 st.setString(3, (String) usertype);
                	 
                	 boolean result=false, result1=false, result2=false, result3=false;
                	 //Check the username has been fill up or not
                	 //Set the result as true if it has not been fill
                	 if(textFieldUserName.getText().equals("")) {
                		 result=true;
                	 }
                	//Check the password has been fill up or not
                	//Set the result as true if it has not been fill
                	 if(passwordField.getText().equals("")) {
                		 result1=true;
                	 }
                	//Check the confirm password has been fill up or not
                	//Set the result as true if it has not been fill
                	 if(passwordFieldConfirm.getText().equals("")) {
                		 result2=true;
                	 }
                	 //Check the password and confirm password are the same or not
                	 //Set the result as true if they are same
                	 if(password.equals(confirmPassword)) {
                		 result3=true;
                	 }
                	 
                	 //If the username has not been fill up it will show message
                	 if(result==true) {
                		 JOptionPane.showMessageDialog(null, "Please fill up the username!");
                	 }
                	 //If the password and confirm password has not been fill up it will show message
                	 else if(result1==true || result2==true) { 
                		 JOptionPane.showMessageDialog(null, "Please fill up the password!");
                	 }
                	 //If the password and confirm password are not same it will show message
                	 else if(result3==false) {
                		 JOptionPane.showMessageDialog(null, "Please enter the same password!");
                		 passwordField.setText("");
                		 passwordFieldConfirm.setText("");
                	 }
                	 //If all the information has been fill up and the password and confirm password are the same
                	 else {
                		 //Execute the insert of data
                		 st.execute(); 
                		 //Display message to the user and go to the login page
                		 JOptionPane.showMessageDialog(null, "Welcome, " + msg + "Your have sucessfully registered as a User");
                		 dispose();
                		 LoginPage Lp= new LoginPage();
                         Lp.setVisible(true);
                	 }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBounds(140, 344, 121, 42);
		contentPane.add(btnRegister);
		
		//Design and function of the cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Asks a confirming question, like yes/no/cancel for the user
				int a = JOptionPane.showConfirmDialog(null, "Are you sure want to cancel?");
                // JOptionPane.setRootFrame(null);
				//If the user click on yes, it will close this page and go back to previous page
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    SelectedPage obj = new SelectedPage();
                    obj.setVisible(true);
                }
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(354, 344, 121, 42);
		contentPane.add(btnCancel);
	}

}
