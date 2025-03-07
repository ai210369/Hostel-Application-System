package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectedPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectedPage frame = new SelectedPage();
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
	public SelectedPage() {
		setResizable(false);
		//Title of the window
		setTitle("Welcome to UTHM Hostel Application System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 638, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblwelcome = new JLabel("Welcome to UTHM Hostel Application System");
		lblwelcome.setBounds(10, 45, 608, 48);
		lblwelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblwelcome);
		
		//Design and function of the Login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(203, 129, 228, 48);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Method to make it disappear and remove the resources it is using
				dispose();
				//Go to the Login page and let it be visible
                LoginPage Lp= new LoginPage();
                Lp.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnLogin);
		
		//Design and function of the Register button
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(203, 200, 228, 48);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Method to make it disappear and remove the resources it is using
				dispose();
				//Go to the Register page and let it be visible
                RegisterPage Rp= new RegisterPage();
                Rp.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnRegister);
		
		//Design and function of the Leave button
		JButton btnLeave = new JButton("Leave");
		btnLeave.setBounds(203, 272, 228, 48);
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Asks a confirming question, like yes/no/cancel for the user
				int a = JOptionPane.showConfirmDialog(null, "Are you sure want to leave?");
				// JOptionPane.setRootFrame(null);
				//If the user click on yes, it will show message to the user
                if (a == JOptionPane.YES_OPTION) {
                	JOptionPane.showMessageDialog(null, "Thank you for using our hostel application system!");
                	//Method to make it disappear and remove the resources it is using
                    dispose();
                }
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnLeave);
	}

}
