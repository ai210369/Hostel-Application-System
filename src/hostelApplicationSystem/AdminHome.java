package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Constructor of the class
	public AdminHome() {
		
	}
	
	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public AdminHome(int userId) {
		//Design and title of the window page
		setTitle("Admin Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1072, 605);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(73, 89, 931, 442);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblNewLabel = new JLabel("Admin Menu");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(437, 39, 202, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		//Hostel Applicants data button - Click to direct to the applicants list.
		JButton btnNameList = new JButton("Name List");
		btnNameList.setForeground(new Color(0, 0, 0));
		btnNameList.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNameList.setBounds(148, 165, 235, 108);
		panel.add(btnNameList);
		btnNameList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameList as = new NameList(userId);
				dispose();
				as.setVisible(true);
			}

		});
		
		//Logout button - Click to exit the program.
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(0, 0, 0));
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
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnLogout.setBounds(556, 165, 224, 108);
		panel.add(btnLogout);
	}
}
