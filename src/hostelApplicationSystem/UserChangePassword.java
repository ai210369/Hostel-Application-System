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
import java.awt.event.ActionEvent;


public class UserChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserChangePassword frame = new UserChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Constructor of the class
	public UserChangePassword() {
		
	}

	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public UserChangePassword(int userId) {
		//Design and title of the window page
		setTitle("User Change Password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 661, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblNewLabel = new JLabel("User Change Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 26, 627, 43);
		contentPane.add(lblNewLabel);
		
		//Design and content of the label
		JLabel lblPassword = new JLabel("New Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(74, 92, 169, 48);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmPassword.setBounds(74, 150, 169, 48);
		contentPane.add(lblConfirmPassword);
		
		//Design of the box that let user input information
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(241, 98, 334, 32);
		contentPane.add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordFieldConfirm.setBounds(241, 157, 334, 32);
		contentPane.add(passwordFieldConfirm);
		
		//Design and function of the Update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String confirmPassword = passwordFieldConfirm.getText();
				
				boolean result=false, result1=false, result2=false;
				
				if (password.equals(""))
				{
					result=true;
				}
				if(confirmPassword.equals("")) {
					result1=true;
				}
				if(password.equals(confirmPassword)) {
					result2=true;
				}
				
				//If the password and confirm password has not been fill up it will show message
           	 	if(result==true) { 
           	 		JOptionPane.showMessageDialog(null, "Please fill up the password!");
           	 	}
           	 	else if(result1==true) {
           	 		JOptionPane.showMessageDialog(null, "Please fill up the confirm password!");
           	 	}
           	 	//If the password and confirm password are not same it will show message
           	 	else if(result2==false) {
           	 		JOptionPane.showMessageDialog(null, "Please enter the same password!");
           	 		passwordField.setText("");
           	 		passwordFieldConfirm.setText("");
           	 	}
           	 	else {
           	 		try {//Connect to MySQL
           	 			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");
           	 			//Update the data into database
           	 			PreparedStatement st = (PreparedStatement) connection.prepareStatement("Update user set password=? where id=?");
                  	 
           	 			st.setString(1, password);
           	 			st.setInt(2, userId);
           	 			
           	 			st.executeUpdate();
           	 			JOptionPane.showMessageDialog(null, "Password has been successfully changed!");
           	 			//It will close this window and go back to the previous page
           	 			dispose();
           	 			UserPage Up= new UserPage(userId);
           	 			Up.setVisible(true);
           	 		}
           	 		catch (SQLException sqlException) {
           	 			sqlException.printStackTrace();
           	 		}
           	 	}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(157, 245, 121, 42);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Asks a confirming question, like yes/no/cancel for the user
				int a = JOptionPane.showConfirmDialog(null, "Are you sure want to back to previous page?");
                // JOptionPane.setRootFrame(null);
				//If the user click on yes, it will close this page and go back to previous page
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserPage Up = new UserPage(userId);
                    Up.setVisible(true);
                }
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(371, 245, 121, 42);
		contentPane.add(btnCancel);
	}

}
