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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class ApplyRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldN;
	private JTextField textFieldMN;
	private JTextField textFieldSE;
	private JTextField textFieldF;
	private JTextField textFieldPN;
	private JTextField textFieldFN;
	private JTextField textFieldFPN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyRoom frame = new ApplyRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApplyRoom() {
		
	}

	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public ApplyRoom(int userId) {
		//Design and title of the window page
		setResizable(false);
		setTitle("Apply Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, -10, 1155, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblApplyInformation = new JLabel("Apply Information");
		lblApplyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplyInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApplyInformation.setBounds(23, 10, 1076, 56);
		contentPane.add(lblApplyInformation);
		
		JPanel panelPI = new JPanel();
		panelPI.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPI.setBounds(23, 76, 1076, 520);
		contentPane.add(panelPI);
		panelPI.setLayout(null);
		
		//Design and content of the label 
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 22, 210, 48);
		panelPI.add(lblName);
		
		JLabel lblMatricNumber = new JLabel("Matric Number: ");
		lblMatricNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatricNumber.setBounds(10, 78, 210, 48);
		panelPI.add(lblMatricNumber);
		
		JLabel lblSiswaEmail = new JLabel("Siswa Email:");
		lblSiswaEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSiswaEmail.setBounds(10, 136, 210, 48);
		panelPI.add(lblSiswaEmail);
		
		JLabel lblFaculty = new JLabel("Faculty: ");
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFaculty.setBounds(10, 194, 210, 48);
		panelPI.add(lblFaculty);
		
		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(10, 252, 210, 48);
		panelPI.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(10, 310, 210, 48);
		panelPI.add(lblPhoneNumber);
		
		JLabel lblFatherName = new JLabel("Father Name:");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFatherName.setBounds(10, 368, 210, 48);
		panelPI.add(lblFatherName);
		
		JLabel lblFathersPhoneNumber = new JLabel("Father's Phone Number:");
		lblFathersPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFathersPhoneNumber.setBounds(10, 426, 210, 48);
		panelPI.add(lblFathersPhoneNumber);
		
		JLabel lblHostelName = new JLabel("Hostel Name:");
		lblHostelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHostelName.setBounds(562, 22, 135, 48);
		panelPI.add(lblHostelName);
		
		JLabel lblBlock = new JLabel("Block: ");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBlock.setBounds(562, 80, 135, 48);
		panelPI.add(lblBlock);
		
		JLabel lblFloor = new JLabel("Floor: ");
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFloor.setBounds(562, 138, 135, 48);
		panelPI.add(lblFloor);
		
		JLabel lblRoomNumber = new JLabel("Room Number: ");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomNumber.setBounds(562, 196, 135, 48);
		panelPI.add(lblRoomNumber);
		
		//Design of the box that let user input information
		textFieldN = new JTextField();
		textFieldN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldN.setColumns(10);
		textFieldN.setBounds(219, 28, 292, 32);
		panelPI.add(textFieldN);
		
		textFieldMN = new JTextField();
		textFieldMN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldMN.setColumns(10);
		textFieldMN.setBounds(219, 86, 292, 32);
		panelPI.add(textFieldMN);
		
		textFieldSE = new JTextField();
		textFieldSE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSE.setColumns(10);
		textFieldSE.setBounds(219, 144, 292, 32);
		panelPI.add(textFieldSE);
		
		textFieldF = new JTextField();
		textFieldF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldF.setColumns(10);
		textFieldF.setBounds(219, 200, 292, 32);
		panelPI.add(textFieldF);
		
		textFieldPN = new JTextField();
		textFieldPN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPN.setColumns(10);
		textFieldPN.setBounds(219, 316, 292, 32);
		panelPI.add(textFieldPN);
		
		textFieldFN = new JTextField();
		textFieldFN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFN.setColumns(10);
		textFieldFN.setBounds(219, 374, 292, 32);
		panelPI.add(textFieldFN);
		
		textFieldFPN = new JTextField();
		textFieldFPN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFPN.setColumns(10);
		textFieldFPN.setBounds(219, 432, 292, 32);
		panelPI.add(textFieldFPN);
		
		//Design of the box that let user select information
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxGender.setBounds(219, 258, 292, 32);
		panelPI.add(comboBoxGender);
		
		JComboBox comboBoxHN = new JComboBox();
		comboBoxHN.setModel(new DefaultComboBoxModel(new String[] {"", "KOLEJ KEDIAMAN TUN FATIMAH", "KOLEJ KEDIAMAN TUN DR. ISMAIL", 
				"KOLEJ KEDIAMAN TUN SYED NASIR", "KOLEJ KEDIAMAN PEWIRA"}));
		comboBoxHN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxHN.setBounds(695, 28, 356, 32);
		panelPI.add(comboBoxHN);
		
		JComboBox comboBoxBlock = new JComboBox();
		comboBoxBlock.setModel(new DefaultComboBoxModel(new String[] {"", "Block A", "Block B", "Block C", "Block D"}));
		comboBoxBlock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxBlock.setBounds(695, 86, 356, 32);
		panelPI.add(comboBoxBlock);
		
		JComboBox comboBoxFloor = new JComboBox();
		comboBoxFloor.setModel(new DefaultComboBoxModel(new String[] {"", "Floor 1", "Floor 2", "Floor 3", "Floor 4"}));
		comboBoxFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxFloor.setBounds(695, 144, 356, 32);
		panelPI.add(comboBoxFloor);
		
		JComboBox comboBoxRN = new JComboBox();
		comboBoxRN.setModel(new DefaultComboBoxModel(new String[] {"", "Room 1", "Room 2", "Room 3", "Room 4"}));
		comboBoxRN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxRN.setBounds(695, 202, 356, 32);
		panelPI.add(comboBoxRN);
		
		//Design and function of the Apply button
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Read the information that need to be inside and choose
				int id = userId;
				String name = textFieldN.getText();
				String matricNum = textFieldMN.getText();
				String siswaEmail = textFieldSE.getText();
				String faculty = textFieldF.getText();
				String gender = comboBoxGender.getSelectedItem().toString();				
				String phoneNum = textFieldPN.getText();
				String fatherN = textFieldFN.getText();
				String fatherPNum = textFieldFPN.getText();
				String hostel = comboBoxHN.getSelectedItem().toString();
				String block = comboBoxBlock.getSelectedItem().toString();
				String floor = comboBoxFloor.getSelectedItem().toString();
				String room = comboBoxRN.getSelectedItem().toString();
				String status = "Processing";
                
				String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
          		String specialCharactersStringAndSpace = "!@#$%&*()'+,-./:;<=>?[]^_` {|}";
          		String number = "01234567890";
          		
				boolean result=false, result1=false, result2=false, result3=false, result4=false,
						result5=false, result6=false;
				
				//Check the all the textfield has been fill up or not
				//Set the result as true if it has not been fill
				if(textFieldN.getText().equals("") || textFieldMN.getText().equals("") || textFieldSE.getText().equals("")
						|| textFieldF.getText().equals("") || textFieldPN.getText().equals("") || textFieldFN.getText().equals("")
						|| textFieldFPN.getText().equals("")) {
					result=true;
				}
				//Check the all the combobox has been pick up or not
				//Set the result as true if it has not been fill
				if(comboBoxGender.getSelectedItem().toString().equals("") || comboBoxHN.getSelectedItem().toString().equals("") 
						|| comboBoxBlock.getSelectedItem().toString().equals("") || comboBoxFloor.getSelectedItem().toString().equals("")
						|| comboBoxRN.getSelectedItem().toString().equals("")) {
					result1=true;
				}
				//check have punctuation or number,if yes, cannot insert to the database
				for (int i=0; i < name.length() ; i++)
	   	        {
	   	            char ch = name.charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result2 = true;
	   	            	break;
	   	            }
	   	            else if(i == name.length()-1) { 
	   	            	result2 = false;
	   	            }
	          	} 
				//check have punctuation or number,if yes, cannot insert to the database
				for (int i=0; i < faculty.length() ; i++)
	   	        {
	   	            char ch = faculty.charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result3 = true;
	   	            	break;
	   	            }
	   	            else if(i == faculty.length()-1) { 
	   	            	result3 = false;
	   	            }
	          	}
				//check have punctuation or number,if yes, cannot insert to the database
				for (int i=0; i < fatherN.length() ; i++)
	   	        { 
	   	            char ch = fatherN.charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result4 = true;
	   	            	break;
	   	            }
	   	            else if(i == fatherN.length()-1) { 
	   	            	result4 = false;
	   	            }
	          	}
				//check have punctuation or alphabet,if yes, cannot insert to the database
   	        	//the length of phone number is set as 10 and 11
				for (int i=0; i < phoneNum.length() ; i++)
	   	        {	
	   	            char ch = phoneNum.charAt(i);
	   	            int no = phoneNum.length();
	   	            if(no < 10 || no > 11)
	   	            {
	   	            	result5=true;
	   	            	break;
	   	            }
	   	            else if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
	   	            	result5 = true;
	   	            	break;
	   	            }
	   	            else if(i == phoneNum.length()-1 ) {    
	   	            	result5 = false;
	   	            }
	   	            
	          	}
				//check have punctuation or alphabet,if yes, cannot insert to the database
   	        	//the length of phone number is set as 10 and 11
				for (int i=0; i < fatherPNum.length() ; i++)
	   	        {	
	   	            char ch = fatherPNum.charAt(i);
	   	            int no = fatherPNum.length();
	   	            if(no < 10 || no > 11)
	   	            {
	   	            	result6=true;
	   	            	break;
	   	            }
	   	            else if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
	   	            	result6 = true;
	   	            	break;
	   	            }
	   	            else if(i == fatherPNum.length()-1 ) {    
	   	            	result6 = false;
	   	            }
	   	            
	          	}
				
				if(result==true) {
					//If the information has not been fill up it will show message
					JOptionPane.showMessageDialog(null, "Please fill up all the information!");
				}
				else if (result1==true) {
					//If the information has not been pick it will show message
					JOptionPane.showMessageDialog(null, "Please pick all the information!");
				}
				else if (result2 == true || result3 == true || result4 == true || result5 == true || result6 == true) 
	   	        {
	   	        	//pop up to warn user input correct information
					JOptionPane.showMessageDialog(null, "Error! Please input correct information!");
	          	}
				else {
					try {//Connect to MySQL
	                	 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");

	                	 //Insert the data into database
	                	 PreparedStatement st = (PreparedStatement) connection
	                             .prepareStatement("INSERT INTO applyinfo (id, name, matricNumber, siswaEmail, faculty, gender, phone, fatherN, fatherP, hostelN, block, floor, roomN, status)"
	                             		+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	                	 
	                	 st.setInt(1, id);
	                	 st.setString(2, name);
	                	 st.setString(3, matricNum);
	                	 st.setString(4, siswaEmail);
	                	 st.setString(5, faculty);
	                	 st.setString(6, (String) gender);
	                	 st.setString(7, phoneNum);
	                	 st.setString(8, fatherN);
	                	 st.setString(9, fatherPNum);
	                	 st.setString(10, (String) hostel);
	                	 st.setString(11, (String) block);
	                	 st.setString(12, (String) floor);
	                	 st.setString(13, (String) room);
	                	 st.setString(14, status);
	                	 st.execute();
	                	 //Display message to the user when apply sucessfull
		                 JOptionPane.showMessageDialog(null, "Apply successfully! Your request is processing");   
		                 //It will close this page and go to the previous page
		                 dispose();
		                 UserPage Up = new UserPage(userId);
		                 Up.setVisible(true);
	                	
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				}
			}
		});
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnApply.setBounds(656, 616, 121, 42);
		contentPane.add(btnApply);
		
		//Design and function of the Black button
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
		btnBack.setBounds(978, 616, 121, 42);
		contentPane.add(btnBack);
		
		//Design and function of the Clear button
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Clear all the information inside the textfield and combobox
				textFieldN.setText("");
				textFieldMN.setText("");
				textFieldSE.setText("");
				textFieldF.setText("");
				textFieldPN.setText("");
				textFieldFN.setText("");
				textFieldFPN.setText("");
				comboBoxGender.setSelectedItem("");
				comboBoxHN.setSelectedItem("");
				comboBoxBlock.setSelectedItem("");
				comboBoxFloor.setSelectedItem("");
				comboBoxRN.setSelectedItem("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(817, 616, 121, 42);
		contentPane.add(btnClear);
	}

}
