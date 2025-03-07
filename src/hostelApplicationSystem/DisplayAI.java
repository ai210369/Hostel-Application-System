package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class DisplayAI extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldN;
	private JTextField textFieldMN;
	private JTextField textFieldSE;
	private JTextField textFieldF;
	private JTextField textFieldPN;
	private JTextField textFieldFN;
	private JTextField textFieldFPN;
	private JTextField textFieldStatus;
	private JTextField textFieldFee;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAI frame = new DisplayAI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DisplayAI() {
		
	}

	/**
	 * Create the frame.
	 */
	//Constructor of the class
	public DisplayAI(int userId) {
		//Design and title of the window page
		setTitle("Apply Information");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1381, 835);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblApplyInformation = new JLabel("Apply Information");
		lblApplyInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplyInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApplyInformation.setBounds(118, -16, 1097, 61);
		contentPane.add(lblApplyInformation);
		
		JPanel panelPI = new JPanel();
		panelPI.setLayout(null);
		panelPI.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPI.setBounds(32, 56, 540, 620);
		contentPane.add(panelPI);
		
		//Design and content of the label
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 11, 179, 32);
		panelPI.add(lblName);
		
		JLabel lblMatricNumber = new JLabel("Matric Number: ");
		lblMatricNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatricNumber.setBounds(10, 53, 179, 32);
		panelPI.add(lblMatricNumber);
		
		JLabel lblSiswaEmail = new JLabel("Siswa Email:");
		lblSiswaEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSiswaEmail.setBounds(10, 96, 179, 30);
		panelPI.add(lblSiswaEmail);
		
		JLabel lblFaculty = new JLabel("Faculty: ");
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFaculty.setBounds(10, 137, 210, 32);
		panelPI.add(lblFaculty);
		
		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(10, 178, 210, 35);
		panelPI.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(10, 225, 210, 32);
		panelPI.add(lblPhoneNumber);
		
		JLabel lblFatherName = new JLabel("Father Name:");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFatherName.setBounds(10, 271, 210, 32);
		panelPI.add(lblFatherName);
		
		JLabel lblFathersPhoneNumber = new JLabel("Father's Phone Number:");
		lblFathersPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFathersPhoneNumber.setBounds(10, 304, 210, 48);
		panelPI.add(lblFathersPhoneNumber);
		
		JLabel lblHostelName = new JLabel("Hostel Name:");
		lblHostelName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHostelName.setBounds(10, 343, 210, 48);
		panelPI.add(lblHostelName);
		
		JLabel lblBlock = new JLabel("Block: ");
		lblBlock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBlock.setBounds(10, 394, 210, 32);
		panelPI.add(lblBlock);
		
		JLabel lblFloor = new JLabel("Floor: ");
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFloor.setBounds(10, 432, 210, 36);
		panelPI.add(lblFloor);
		
		JLabel lblRoomNumber = new JLabel("Room Number: ");
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomNumber.setBounds(10, 472, 210, 48);
		panelPI.add(lblRoomNumber);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(10, 523, 210, 48);
		panelPI.add(lblStatus);
		
		JLabel lblFee = new JLabel("Fee Per Semester: ");
		lblFee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFee.setBounds(10, 574, 210, 48);
		panelPI.add(lblFee);
		
		//Design of the box that let user input information
		textFieldN = new JTextField();
		textFieldN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldN.setColumns(10);
		textFieldN.setBounds(219, 10, 292, 32);
		panelPI.add(textFieldN);
		
		textFieldMN = new JTextField();
		textFieldMN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldMN.setColumns(10);
		textFieldMN.setBounds(219, 52, 292, 32);
		panelPI.add(textFieldMN);
		
		textFieldSE = new JTextField();
		textFieldSE.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSE.setColumns(10);
		textFieldSE.setBounds(219, 94, 292, 32);
		panelPI.add(textFieldSE);
		
		textFieldF = new JTextField();
		textFieldF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldF.setColumns(10);
		textFieldF.setBounds(219, 137, 292, 32);
		panelPI.add(textFieldF);
		
		textFieldPN = new JTextField();
		textFieldPN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPN.setColumns(10);
		textFieldPN.setBounds(219, 224, 292, 32);
		panelPI.add(textFieldPN);
		
		textFieldFN = new JTextField();
		textFieldFN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFN.setColumns(10);
		textFieldFN.setBounds(219, 268, 292, 32);
		panelPI.add(textFieldFN);
		
		textFieldFPN = new JTextField();
		textFieldFPN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFPN.setColumns(10);
		textFieldFPN.setBounds(219, 311, 292, 32);
		panelPI.add(textFieldFPN);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setEditable(false);
		textFieldStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(219, 531, 292, 32);
		panelPI.add(textFieldStatus);
		
		textFieldFee = new JTextField();
		textFieldFee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldFee.setEditable(false);
		textFieldFee.setColumns(10);
		textFieldFee.setBounds(219, 582, 292, 32);
		panelPI.add(textFieldFee);
		
		//Design of the box that let user select information
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxGender.setBounds(219, 180, 292, 32);
		panelPI.add(comboBoxGender);
		
		JComboBox comboBoxHN = new JComboBox();
		comboBoxHN.setModel(new DefaultComboBoxModel(new String[] {"", "KOLEJ KEDIAMAN TUN FATIMAH", "KOLEJ KEDIAMAN TUN DR. ISMAIL", "KOLEJ KEDIAMAN TUN SYED NASIR",
				"KOLEJ KEDIAMAN PEWIRA"}));
		comboBoxHN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxHN.setBounds(219, 350, 292, 32);
		panelPI.add(comboBoxHN);
		
		JComboBox comboBoxBlock = new JComboBox();
		comboBoxBlock.setModel(new DefaultComboBoxModel(new String[] {"", "Block A", "Block B", "Block C", "Block D"}));
		comboBoxBlock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxBlock.setBounds(219, 393, 292, 32);
		panelPI.add(comboBoxBlock);
		
		JComboBox comboBoxFloor = new JComboBox();
		comboBoxFloor.setModel(new DefaultComboBoxModel(new String[] {"", "Floor 1", "Floor 2", "Floor 3", "Floor 4"}));
		comboBoxFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxFloor.setBounds(219, 437, 292, 32);
		panelPI.add(comboBoxFloor);
		
		JComboBox comboBoxRN = new JComboBox();
		comboBoxRN.setModel(new DefaultComboBoxModel(new String[] {"", "Room 1", "Room 2", "Room 3", "Room 4"}));
		comboBoxRN.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxRN.setBounds(219, 480, 292, 32);
		panelPI.add(comboBoxRN);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(619, 54, 641, 578);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 609, 488);
		panel.add(scrollPane);
		
		//Table that show all the apply information that user apply
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//The function when the mouse click on the table it will show to the correct textfile
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				//Set the correct place that the data into go
				textFieldN.setText(model.getValueAt(i, 2).toString());
				textFieldMN.setText(model.getValueAt(i, 3).toString());
				textFieldSE.setText(model.getValueAt(i, 4).toString());
				textFieldF.setText(model.getValueAt(i, 5).toString());
				String comboBoxGender1 = model.getValueAt(i, 6).toString();
					switch(comboBoxGender1) {
					case" ":
						comboBoxGender.setSelectedIndex(0);
						break;
					case"Male":
						comboBoxGender.setSelectedIndex(1);
						break;
					case"Female":
						comboBoxGender.setSelectedIndex(2);
						break;
					}
				textFieldPN.setText(model.getValueAt(i, 7).toString());
				textFieldFN.setText(model.getValueAt(i, 8).toString());
				textFieldFPN.setText(model.getValueAt(i, 9).toString());
				String comboBoxHN1 = model.getValueAt(i, 10).toString();
					switch(comboBoxHN1) {
					case" ":
						comboBoxHN.setSelectedIndex(0);
						break;
					case"KOLEJ KEDIAMAN TUN FATIMAH":
						comboBoxHN.setSelectedIndex(1);
						break;
					case"KOLEJ KEDIAMAN TUN DR. ISMAIL":
						comboBoxHN.setSelectedIndex(2);
						break;
					case"KOLEJ KEDIAMAN TUN SYED NASIR":
						comboBoxHN.setSelectedIndex(3);
						break;
					case"KOLEJ KEDIAMAN PEWIRA":
						comboBoxHN.setSelectedIndex(4);
						break;
					}
				String comboBoxBlock1 = model.getValueAt(i, 11).toString();
					switch(comboBoxBlock1) {
					case" ":
						comboBoxBlock.setSelectedIndex(0);
						break;
					case"Block A":
						comboBoxBlock.setSelectedIndex(1);
						break;
					case"Block B":
						comboBoxBlock.setSelectedIndex(2);
						break;
					case"Block C":
						comboBoxBlock.setSelectedIndex(3);
						break;
					case"Block D":
						comboBoxBlock.setSelectedIndex(4);
						break;
					}
				String comboBoxFloor1 = model.getValueAt(i, 12).toString();
					switch(comboBoxFloor1) {
					case" ":
						comboBoxFloor.setSelectedIndex(0);
						break;
					case"Floor 1":
						comboBoxFloor.setSelectedIndex(1);
						break;
					case"Floor 2":
						comboBoxFloor.setSelectedIndex(2);
						break;
					case"Floor 3":
						comboBoxFloor.setSelectedIndex(3);
						break;
					case"Floor 4":
						comboBoxFloor.setSelectedIndex(4);
						break;
					}
				String comboBoxRN1 = model.getValueAt(i, 13).toString();
					switch(comboBoxRN1) {
					case" ":
						comboBoxRN.setSelectedIndex(0);
						break;
					case"Room 1":
						comboBoxRN.setSelectedIndex(1);
						break;
					case"Room 2":
						comboBoxRN.setSelectedIndex(2);
						break;
					case"Room 3":
						comboBoxRN.setSelectedIndex(3);
						break;
					case"Room 4":
						comboBoxRN.setSelectedIndex(4);
						break;
					}
				textFieldStatus.setText(model.getValueAt(i, 14).toString());
				textFieldFee.setText(model.getValueAt(i, 15).toString());
			}
		});
		//The table can be scroll if it is over the range of the display box
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"bookingId", "id", "Name", "Matric Number", "Siswa Email", "Faculty", "Gender", "Phone Number", "Father Name", "Father's Phone", "Hostel Name", 
				"Block", "Floor", "Room Number", "Status", "Fee"
			}
		));
		
		//Design and function of the Display Data button
		JButton btnDisplayData = new JButton("Display Data");
		btnDisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call out the display method
				display(userId);
			}
		});
		btnDisplayData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDisplayData.setBounds(235, 527, 198, 42);
		panel.add(btnDisplayData);
		
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
		btnBack.setBounds(1127, 643, 121, 43);
		contentPane.add(btnBack);
		
		//Design and function of the Update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
          		String specialCharactersStringAndSpace = "!@#$%&*()'+,-./:;<=>?[]^_` {|}";
          		String number = "01234567890";
          		
				boolean result=false, result1=false, result2=false, result3=false, result4=false,
						result5=false, result6=false, result7=false, result8=false;
				
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
				for (int i=0; i < textFieldN.getText().length() ; i++)
	   	        {
	   	            char ch = textFieldN.getText().charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result2 = true;
	   	            	break;
	   	            }
	   	            else if(i == textFieldN.getText().length()-1) { 
	   	            	result2 = false;
	   	            }
	          	} 
				//check have punctuation or number,if yes, cannot insert to the database
				for (int i=0; i < textFieldF.getText().length() ; i++)
	   	        {
	   	            char ch = textFieldF.getText().charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result3 = true;
	   	            	break;
	   	            }
	   	            else if(i == textFieldF.getText().length()-1) { 
	   	            	result3 = false;
	   	            }
	          	}
				//check have punctuation or number,if yes, cannot insert to the database
				for (int i=0; i < textFieldFN.getText().length() ; i++)
	   	        { 
	   	            char ch = textFieldFN.getText().charAt(i);
	   	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
	   	            	result4 = true;
	   	            	break;
	   	            }
	   	            else if(i == textFieldFN.getText().length()-1) { 
	   	            	result4 = false;
	   	            }
	          	}
				//check have punctuation or alphabet,if yes, cannot insert to the database
   	        	//the length of phone number is set as 10 and 11
				for (int i=0; i < textFieldPN.getText().length() ; i++)
	   	        {	
	   	            char ch = textFieldPN.getText().charAt(i);
	   	            int no = textFieldPN.getText().length();
	   	            if(no < 10 || no > 11)
	   	            {
	   	            	result5=true;
	   	            	break;
	   	            }
	   	            else if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
	   	            	result5 = true;
	   	            	break;
	   	            }
	   	            else if(i == textFieldPN.getText().length()-1 ) {    
	   	            	result5 = false;
	   	            }
	   	            
	          	}
				//check have punctuation or alphabet,if yes, cannot insert to the database
   	        	//the length of phone number is set as 10 and 11
				for (int i=0; i < textFieldFPN.getText().length() ; i++)
	   	        {	
	   	            char ch = textFieldFPN.getText().charAt(i);
	   	            int no = textFieldFPN.getText().length();
	   	            if(no < 10 || no > 11)
	   	            {
	   	            	result6=true;
	   	            	break;
	   	            }
	   	            else if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
	   	            	result6 = true;
	   	            	break;
	   	            }
	   	            else if(i == textFieldFPN.getText().length()-1 ) {    
	   	            	result6 = false;
	   	            }
	   	            
	          	}
				//Check the status 
				if(textFieldStatus.getText().equals("Processing")) {
					result7=true;
				}
				//It has select a row or not
				int r=table.getSelectedRow();
				if(r>=0) {
					result8=true;
				}
				
				
				if(result8==false) {
					//If there are no any row be selected it will show message ask user to select a row
					JOptionPane.showMessageDialog(null, "Please select a row first!");
				}
				else if(result==true) {
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
				else if(result7==false) {
					//It will show the message cannot change the information if status not "Processing"
					JOptionPane.showMessageDialog(null, "Sorry, you cannot update the information.");
				}
				else {
					try {//Connect to MySQL
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");
						//Update the data into database
						int row = table.getSelectedRow();
						String value = table.getModel().getValueAt(row, 0).toString();
						String query = "UPDATE applyinfo SET name=?, matricNumber=?, siswaEmail=?, faculty=?, gender=?, phone=?, fatherN=?, fatherP=?, hostelN=?, block=?, floor=?, roomN=? where bookingId= " + value;
					
						PreparedStatement st = con.prepareStatement(query);

               	 		st.setString(1, textFieldN.getText());
               	 		st.setString(2, textFieldMN.getText());
               	 		st.setString(3, textFieldSE.getText());
               	 		st.setString(4, textFieldF.getText());
               	 		st.setString(5, comboBoxGender.getSelectedItem().toString());
               	 		st.setString(6, textFieldPN.getText());
               	 		st.setString(7, textFieldFN.getText());
               	 		st.setString(8, textFieldFPN.getText());
               	 		st.setString(9, comboBoxHN.getSelectedItem().toString());
               	 		st.setString(10, comboBoxBlock.getSelectedItem().toString());
               	 		st.setString(11, comboBoxFloor.getSelectedItem().toString());
               	 		st.setString(12, comboBoxRN.getSelectedItem().toString());
               	 	
               	 		st.execute();
               	 		DefaultTableModel model = (DefaultTableModel)table.getModel();
               	 		model.setRowCount(0);
               	 		JOptionPane.showMessageDialog(null, "Update successfully! Your request is processing");
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Failed!");
					}
					//Clear all the information inside the textfield and combobox
					textFieldN.setText("");
					textFieldMN.setText("");
					textFieldSE.setText("");
					textFieldF.setText("");
					textFieldPN.setText("");
					textFieldFN.setText("");
					textFieldFPN.setText("");
					textFieldStatus.setText("");
					textFieldFee.setText("");
					comboBoxGender.setSelectedItem("");
					comboBoxHN.setSelectedItem("");
					comboBoxBlock.setSelectedItem("");
					comboBoxFloor.setSelectedItem("");
					comboBoxRN.setSelectedItem("");
					display(userId); //Call out the display method
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(619, 646, 121, 43);
		contentPane.add(btnUpdate);
		
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
				textFieldStatus.setText("");
				textFieldFee.setText("");
				comboBoxGender.setSelectedItem("");
				comboBoxHN.setSelectedItem("");
				comboBoxBlock.setSelectedItem("");
				comboBoxFloor.setSelectedItem("");
				comboBoxRN.setSelectedItem("");
				display(userId); //Call out the display method
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(967, 643, 121, 43);
		contentPane.add(btnClear);
		

		
		//Design and function of the Delete Apply button
		JButton btnDeleteApply = new JButton("Delete Apply");
		btnDeleteApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean result=false, result1=false;
				
				//It has select a row or not
				int r=table.getSelectedRow();
				if(r>=0) {
					result=true;
				}
				//Check the status 
				if(textFieldStatus.getText().equals("Processing")) {
					result1=true;
				}
				
				if(result==false) {
					//If there are no any row be selected it will show message ask user to select a row
					JOptionPane.showMessageDialog(null, "Please select a row first!");
				}
				else if(result1==false) {
					//It will show the message cannot delete the information if status not "Processing"
					JOptionPane.showMessageDialog(null, "Sorry, you cannot delete the apply.");
				}
				else {
					try {//Connect to MySQL
		                 Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");
		                 int row = table.getSelectedRow();
		                 String value =(table.getModel().getValueAt(row, 0).toString());
		                 //Asks a confirming question, like yes/no/cancel for the user
		                 int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete this apply?");
		                 // JOptionPane.setRootFrame(null);
		                 //If the user click on yes, it will delete the apply
		                 if (a == JOptionPane.YES_OPTION) {
		                 //Delete the data from the database
		                 String query = "DELETE FROM applyinfo where bookingId = "+value;
		                 PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
		                 st.executeUpdate();
		                 JOptionPane.showMessageDialog(null, "Delete successfully!");
		                 }
		                 
		         	} catch (SQLException sqlException) {
		     			sqlException.printStackTrace();
		         	}
					//Clear all the information inside the textfield and combobox
					textFieldN.setText("");
					textFieldMN.setText("");
					textFieldSE.setText("");
					textFieldF.setText("");
					textFieldPN.setText("");
					textFieldFN.setText("");
					textFieldFPN.setText("");
					textFieldStatus.setText("");
					textFieldFee.setText("");
					comboBoxGender.setSelectedItem("");
					comboBoxHN.setSelectedItem("");
					comboBoxBlock.setSelectedItem("");
					comboBoxFloor.setSelectedItem("");
					comboBoxRN.setSelectedItem("");
					display(userId); //Call out the display method
				}
			}
		});
		btnDeleteApply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteApply.setBounds(768, 643, 158, 43);
		contentPane.add(btnDeleteApply);
	}
	
	//Method of display the information from database into the table for the logined user
	public void display(int userId) {
		try {
			//Connect to MySQL
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem", "root", "123456789");
			
			//Choose the data which to display when the id is same with the logined user
			String sql = "Select * from applyinfo where id=?";
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
 			rs.close();
			
		} catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
	}
}
