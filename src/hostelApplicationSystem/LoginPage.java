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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JButton btnLogin;
	private JButton btnCancel;
	private JLabel lblAdminLoginPage;
	private JLabel lblSelectUser;
	private JComboBox comboBoxUserType;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	//Constructor of the class
	public LoginPage() {
		//Design and title of the window page
		setResizable(false);
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 642, 464);
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
		
		lblAdminLoginPage = new JLabel("Login");
		lblAdminLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginPage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminLoginPage.setBounds(20, 53, 598, 48);
		contentPane.add(lblAdminLoginPage);
		
		//Design and content of the label 
		JLabel lblUserName = new JLabel("User Name: ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(69, 120, 157, 48);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(69, 185, 157, 48);
		contentPane.add(lblPassword);
		
		lblSelectUser = new JLabel("Select User Type:");
		lblSelectUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectUser.setBounds(69, 253, 157, 48);
		contentPane.add(lblSelectUser);
		
		//Design of the box that let user input information
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUserName.setBounds(224, 130, 338, 32);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(224, 195, 338, 32);
		contentPane.add(passwordField);
		
		//Design of the box that let user select information
		comboBoxUserType = new JComboBox();
		comboBoxUserType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Please Select Admin/User", "Admin", "User"}));
		comboBoxUserType.setBounds(224, 263, 338, 32);
		contentPane.add(comboBoxUserType);
		
		//Design and function of the Login button
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Read the Username, password and the user type of the user
				String userName = textFieldUserName.getText();
                String password = passwordField.getText();
                Object usertype = comboBoxUserType.getSelectedItem();
                try {//Connect to MySQL
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem",
                        "root", "123456789");

                    //Insert the data into database
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select * from user where name=? and password=? and usertype=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    st.setString(3, (String) usertype);
                    ResultSet rs = st.executeQuery();
                    
                    boolean result=false, result1=false, result2=false;
               	 	//Check the username has been fill up or not
               	 	if(textFieldUserName.getText().equals("")) {
               	 		result=true;
               	 	}
               	 	//Check the password has been fill up or not
               	 	if(passwordField.getText().equals("")) {
               	 		result1=true;
               	 	}
               	 	//Check the user type is either admin or user
               	 	if(comboBoxUserType.getSelectedItem().equals("Please Select Admin/User")) {
               	 		result2=true;
               	 	}
               	 	
                    if (rs.next()) {
                    	if(comboBoxUserType.getSelectedIndex()==1) {
                    		//If the admin successful login it will close this page and go to the admin page
                    		int userId=rs.getInt("id");
                    		dispose();
                            AdminHome AH = new AdminHome(userId);
                            AH.setVisible(true);
                            //Display message to the admin
                            JOptionPane.showMessageDialog(null, "You have successfully logged in as an Admin");
                    	}
                    	else {
                    		//If the user successful login it will close this page and go to the user page
                    		int userId=rs.getInt("id");
                    		dispose();
                    		UserPage Up = new UserPage(userId);
                            Up.setVisible(true);
                            //Display message to the user
                            JOptionPane.showMessageDialog(null, "You have successfully logged in as a User");
                    	}
                    } else {
                    	//If the username and password has not been fill up it will show message
                    	if(result==true || result1==true) {
                    		JOptionPane.showMessageDialog(null, "Please fill up the username and password!");
                    	}
                    	//If the user type has not been select it will show message
                    	else if(result2==true) {
                    		JOptionPane.showMessageDialog(null, "Please select the user type!");
                    	}
                    	//If the username, password, and user type is not match in the databased
                    	else {
                    		JOptionPane.showMessageDialog(null, "Username, Password and User Type do not matched!");
                            textFieldUserName.setText("");
                            passwordField.setText("");
                            comboBoxUserType.setSelectedItem("Please Select Admin/User");
                    	}
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(154, 362, 121, 42);
		contentPane.add(btnLogin);
		
		//Design and function of the Cancel button
		btnCancel = new JButton("Cancel");
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
		btnCancel.setBounds(341, 362, 121, 42);
		contentPane.add(btnCancel);
	}

}
