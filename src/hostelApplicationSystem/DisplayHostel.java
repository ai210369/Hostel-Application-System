package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class DisplayHostel extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayHostel frame = new DisplayHostel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Inheritance of InsideH class to the HostelInfo class
	class InsideH extends HostelInfo{
		
		private int total;
		
		public void setTotal(int tt) {
			total = tt;
		}
		
		public int getTotal() {
			return total;
		}
	}
	
	//Inheritance of OutsideH class to the HostelInfo class
	class OutsideH extends HostelInfo{
		
	}
	
	//Constructor of the class
	public DisplayHostel() {
		
	}

	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public DisplayHostel(int userId) {
		//Design and title of the window page
		setResizable(false);
		setTitle("Hostel Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 799, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblHostelInformation = new JLabel("Hostel Information");
		lblHostelInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblHostelInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHostelInformation.setBounds(10, 32, 765, 58);
		contentPane.add(lblHostelInformation);
		
		//Design and function of the Back button
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(53, 364, 228, 48);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 109, 433, 341);
		contentPane.add(scrollPane);
		
		//Design of the box that design the message
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		//Design and function of the Inside Campus button
		JButton btnInside = new JButton("Inside Campus");
		btnInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Array to store the hostel name
				String hostel[]= new String[3];
				hostel[0] = "KOLEJ KEDIAMAN TUN FATIMAH";
				hostel[1] = "KOLEJ KEDIAMAN TUN DR. ISMAIL";
				hostel[2] = "KOLEJ KEDIAMAN TUN SYED NASIR";
				
				InsideH IH = new InsideH();
				IH.setTotal(hostel.length);
				IH.setType("inside campus");

				//The message that will show inside the textArea
				textArea.setText("\n **********************************************"
									+ "\n\t     Welcome to UTHM Hostel!!!"
									+ "\n **********************************************"
									+ "\n\n UTHM hostel has devided into two type which is \n inside and outside campus hostel.\n"
									+ "\n There are " + IH.getTotal()+ " hostels " + IH.getType() + "."
									+ "\n\n Here is the name of the inside campus hostel: "
									+ "\n\n 1. " + hostel[0]
									+ "\n 2. " + hostel[1]
									+ "\n 3. " + hostel[2]);
			}
		});
		btnInside.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInside.setBounds(53, 133, 228, 48);
		contentPane.add(btnInside);
		
		//Design and function of the Outside Campus button
		JButton btnOutside = new JButton("Outside Campus");
		btnOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutsideH OH = new OutsideH();
				OH.setType("outside campus");
				OH.setName("KOLEJ KEDIAMAN PEWIRA");
				
				//The message that will show inside the textArea
				textArea.setText("\n **********************************************"
									+ "\n\t     Welcome to UTHM Hostel!!!"
									+ "\n **********************************************"
									+"\n\n UTHM hostel has devided into two type which is \n inside and outside campus hostel."
									+"\n\n There is only one hostel " + OH.getType() + "."
									+"\n\n The name of the " + OH.getType() + " hostel: "
									+ "\n\n 1. " + OH.getName());
				}
		});
		btnOutside.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOutside.setBounds(53, 210, 228, 48);
		contentPane.add(btnOutside);
		
		//Design and function of the Clear button
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Clear all the information inside the textArea
				textArea.setText(" ");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(53, 287, 228, 48);
		contentPane.add(btnClear);
	}

}
