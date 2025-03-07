package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Constructor of the class
	public UserPage() {
		
	}
	
	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public UserPage(int userId) {
		//Design and title of the window page
		setResizable(false);
		setTitle("User Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 110, 702, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lbluserMenu = new JLabel("USER MENU");
		lbluserMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lbluserMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbluserMenu.setBounds(37, 10, 623, 62);
		contentPane.add(lbluserMenu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(37, 70, 623, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Design and function of the Apply Room button
		JButton btnApplyRoom = new JButton("Apply Room");
		btnApplyRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This page will be close and will go to the apply room page
				dispose();
                ApplyRoom AR = new ApplyRoom(userId);
                AR.setVisible(true);
			}
		});
		btnApplyRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnApplyRoom.setBounds(336, 48, 245, 60);
		panel.add(btnApplyRoom);
		
		//Design and function of the Update/Check Status button
		JButton btnUpdateorCheck = new JButton("Update/Check Status");
		btnUpdateorCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This page will be close and will go to the Update/Check Status page
				dispose();
				DisplayAI DA = new DisplayAI(userId);
				DA.setVisible(true);
			}
		});
		btnUpdateorCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateorCheck.setBounds(49, 160, 245, 60);
		panel.add(btnUpdateorCheck);
		
		//Design and function of the Change Password button
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This page will be close and will go to the Change Password page
				dispose();
				UserChangePassword Ucp= new UserChangePassword(userId);
                Ucp.setVisible(true);
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChangePassword.setBounds(336, 160, 245, 60);
		panel.add(btnChangePassword);
		
		//Design and function of the Logout button
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Asks a confirming question, like yes/no/cancel for the user
				int a = JOptionPane.showConfirmDialog(null, "Are you sure want to logout?");
                // JOptionPane.setRootFrame(null);
				//If the user click on yes, it will show message to the user and back to the first page
                if (a == JOptionPane.YES_OPTION) {
                	dispose();
                    SelectedPage obj = new SelectedPage();
                    obj.setVisible(true);
                }
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.setBounds(197, 266, 245, 60);
		panel.add(btnLogout);
		
		//Design and function of the Hostel Information button
		JButton btnHostelInfo = new JButton("Hostel Information");
		btnHostelInfo.setBounds(49, 48, 245, 60);
		panel.add(btnHostelInfo);
		btnHostelInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This page will be close and will go to the Hostel Information page
				dispose();
				DisplayHostel DH = new DisplayHostel(userId);
				DH.setVisible(true);
			}
		});
		btnHostelInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

}
