package hostelApplicationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NameList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_name;
	private JTextField textField_Matric;
	private JTextField textField_Siswa;
	private JTextField textField_Faculty;
	private JTextField textField_FP;
	private JTextField textField_PN;
	private JTextField textField_Father;
	private JTextField textField_Gender;
	private JTextField textField_HN;
	private JTextField textField_Block;
	private JTextField textField_Floor;
	private JTextField textField_RN;
	private JTextField textField_Fee;
	private JTextField textField_ID;
	private JTable NameList;
	private JTextField textField_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameList frame = new NameList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor of the class
	public NameList() {
		
	}
	/**Create the frame.*/
	//Constructor of the class
	public NameList(int userId) {
		//Design and title of the window page
		setTitle("Name List");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1119, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Design and content of the label (title of the page)
		JLabel lblNewLabel = new JLabel("Name List");
		lblNewLabel.setBounds(23, 11, 161, 43);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		//Design and content of the label 
		JLabel lblNewLabel_1 = new JLabel("Booking ID");
		lblNewLabel_1.setBounds(23, 67, 96, 24);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setBounds(353, 68, 96, 24);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setBounds(23, 115, 96, 24);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Matric Number");
		lblNewLabel_1_2_1.setBounds(23, 150, 129, 24);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Siswa Email");
		lblNewLabel_1_2_2.setBounds(23, 185, 96, 24);
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Faculty");
		lblNewLabel_1_2_3.setBounds(23, 220, 96, 24);
		lblNewLabel_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Gender");
		lblNewLabel_1_2_4.setBounds(23, 255, 96, 24);
		lblNewLabel_1_2_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Phone Number");
		lblNewLabel_1_2_4_1.setBounds(23, 290, 129, 24);
		lblNewLabel_1_2_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("Father Name");
		lblNewLabel_1_2_4_2.setBounds(23, 325, 129, 24);
		lblNewLabel_1_2_4_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_2);
		
		JLabel lblNewLabel_1_2_4_3 = new JLabel("Father's Phone Number");
		lblNewLabel_1_2_4_3.setBounds(23, 364, 175, 24);
		lblNewLabel_1_2_4_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_3);
		
		JLabel lblNewLabel_1_2_4_4 = new JLabel("Hostel Name");
		lblNewLabel_1_2_4_4.setBounds(23, 399, 96, 24);
		lblNewLabel_1_2_4_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_4);
		
		JLabel lblNewLabel_Block = new JLabel("Block");
		lblNewLabel_Block.setBounds(23, 434, 96, 24);
		lblNewLabel_Block.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_Block);
		
		JLabel lblNewLabel_1_2_4_6 = new JLabel("Room Number");
		lblNewLabel_1_2_4_6.setBounds(23, 469, 161, 24);
		lblNewLabel_1_2_4_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_6);
		
		JLabel lblNewLabel_1_2_4_7 = new JLabel("Status");
		lblNewLabel_1_2_4_7.setBounds(23, 504, 96, 24);
		lblNewLabel_1_2_4_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_7);
		
		JLabel lblNewLabel_1_2_4_8 = new JLabel("Fee");
		lblNewLabel_1_2_4_8.setBounds(23, 545, 96, 24);
		lblNewLabel_1_2_4_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_8);
		
		JLabel lblNewLabel_1_2_4_5_1 = new JLabel("Floor");
		lblNewLabel_1_2_4_5_1.setBounds(341, 434, 96, 24);
		lblNewLabel_1_2_4_5_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2_4_5_1);
		
		JComboBox<?> comboBox1 = new JComboBox();
		comboBox1.setBackground(Color.WHITE);
		comboBox1.setBounds(196, 506, 300, 28);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"", "Processing", "Approve", "Reject"}));
		contentPane.add(comboBox1);
		
		//Design of the box that let user input information
		textField = new JTextField();
		textField.setBounds(125, 65, 110, 32);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_name = new JTextField();
		textField_name.setBounds(196, 114, 300, 28);
		textField_name.setBackground(Color.WHITE);
		textField_name.setEditable(false);
		textField_name.setColumns(10);
		contentPane.add(textField_name);
		
		textField_Matric = new JTextField();
		textField_Matric.setBounds(196, 149, 300, 28);
		textField_Matric.setBackground(Color.WHITE);
		textField_Matric.setEditable(false);
		textField_Matric.setColumns(10);
		contentPane.add(textField_Matric);
		
		textField_Siswa = new JTextField();
		textField_Siswa.setBounds(196, 184, 300, 28);
		textField_Siswa.setBackground(Color.WHITE);
		textField_Siswa.setEditable(false);
		textField_Siswa.setColumns(10);
		contentPane.add(textField_Siswa);
		
		textField_Faculty = new JTextField();
		textField_Faculty.setBounds(196, 219, 300, 28);
		textField_Faculty.setBackground(Color.WHITE);
		textField_Faculty.setEditable(false);
		textField_Faculty.setColumns(10);
		contentPane.add(textField_Faculty);
		
		textField_FP = new JTextField();
		textField_FP.setBounds(196, 363, 300, 28);
		textField_FP.setBackground(Color.WHITE);
		textField_FP.setEditable(false);
		textField_FP.setColumns(10);
		contentPane.add(textField_FP);
		
		textField_PN = new JTextField();
		textField_PN.setBounds(196, 286, 300, 28);
		textField_PN.setBackground(Color.WHITE);
		textField_PN.setEditable(false);
		textField_PN.setColumns(10);
		contentPane.add(textField_PN);
		
		textField_Father = new JTextField();
		textField_Father.setBounds(196, 324, 300, 28);
		textField_Father.setBackground(Color.WHITE);
		textField_Father.setEditable(false);
		textField_Father.setColumns(10);
		contentPane.add(textField_Father);
		
		textField_Gender = new JTextField();
		textField_Gender.setBounds(196, 251, 300, 28);
		textField_Gender.setBackground(Color.WHITE);
		textField_Gender.setEditable(false);
		textField_Gender.setColumns(10);
		contentPane.add(textField_Gender);

		textField_HN = new JTextField();
		textField_HN.setBounds(196, 399, 300, 28);
		textField_HN.setBackground(Color.WHITE);
		textField_HN.setEditable(false);
		textField_HN.setColumns(10);
		contentPane.add(textField_HN);
		
		textField_Block = new JTextField();
		textField_Block.setBounds(125, 434, 110, 28);
		textField_Block.setBackground(Color.WHITE);
		textField_Block.setEditable(false);
		textField_Block.setColumns(10);
		contentPane.add(textField_Block);
		
		textField_Floor = new JTextField();
		textField_Floor.setBounds(386, 434, 110, 28);
		textField_Floor.setBackground(Color.WHITE);
		textField_Floor.setEditable(false);
		textField_Floor.setColumns(10);
		contentPane.add(textField_Floor);
		
		textField_RN = new JTextField();
		textField_RN.setBounds(196, 469, 300, 28);
		textField_RN.setBackground(Color.WHITE);
		textField_RN.setEditable(false);
		textField_RN.setColumns(10);
		contentPane.add(textField_RN);
		
		textField_Fee = new JTextField();
		textField_Fee.setBounds(196, 541, 300, 28);
		textField_Fee.setBackground(Color.WHITE);
		textField_Fee.setEditable(false);
		textField_Fee.setColumns(10);
		contentPane.add(textField_Fee);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(386, 65, 110, 32);
		textField_ID.setBackground(Color.WHITE);
		textField_ID.setEditable(false);
		textField_ID.setColumns(10);
		contentPane.add(textField_ID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(524, 115, 550, 461);
		contentPane.add(scrollPane);
		NameList = new JTable();
		NameList.addMouseListener(new MouseAdapter() {
			//Just click on a row in the table and the data for that row will be displayed .
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = NameList.getSelectedRow();
				TableModel model = NameList.getModel();
				
				textField.setText(model.getValueAt(i, 0).toString());
				textField_ID.setText(model.getValueAt(i, 1).toString());
				textField_name.setText(model.getValueAt(i, 2).toString());
				textField_Matric.setText(model.getValueAt(i, 3).toString());
				textField_Siswa.setText(model.getValueAt(i, 4).toString());
				textField_Faculty.setText(model.getValueAt(i, 5).toString());
				textField_Gender.setText(model.getValueAt(i, 6).toString());
				textField_PN.setText(model.getValueAt(i, 7).toString());
				textField_Father.setText(model.getValueAt(i, 8).toString());
				textField_FP.setText(model.getValueAt(i, 9).toString());
				textField_HN.setText(model.getValueAt(i, 10).toString());
				textField_Block.setText(model.getValueAt(i, 11).toString());
				textField_Floor.setText(model.getValueAt(i, 12).toString());
				textField_RN.setText(model.getValueAt(i, 13).toString());
				String comboBox = model.getValueAt(i, 14).toString();
				switch(comboBox) {
					case" ":
						comboBox1.setSelectedIndex(0);
						break;
					case"Processing":
						comboBox1.setSelectedIndex(1);
						break;
					case"Approve":
						comboBox1.setSelectedIndex(2);
						break;
					case"Reject":
						comboBox1.setSelectedIndex(3);
						break;
				}
				textField_Fee.setText(model.getValueAt(i, 15).toString());
			}
		});
		
		NameList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(NameList);
		
		//Delete Data button - Click to delete the list of the applicant details from the database.
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean result=false;
				
				//It has select a row or not
				int r=NameList.getSelectedRow();
				if(r>=0) {
					result=true;
				}
				
				if(result==false) {
					//If there are no any row be selected it will show message ask user to select a row
					JOptionPane.showMessageDialog(null, "Please select a row first!");
				}
				else {
					try 
			 		{   
			 			//connect with MySQL database
			 			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem","root", "123456789");
			 			
			 			int row = NameList.getSelectedRow();
		                String value =(NameList.getModel().getValueAt(row, 0).toString());
		                 
			 			int a = JOptionPane.showConfirmDialog(null, "Are you sure to cancel this information?");
		                if (a == JOptionPane.YES_OPTION) { 
				 			String query = "DELETE FROM applyinfo WHERE bookingId='"+textField.getText()+"' ";
				 			// PreparedStatement interface that delete the information.
				 			PreparedStatement st = connection.prepareStatement(query);
				 			st.execute();
				 			//Display a message indicating that the status has been deleted.
				 			JOptionPane.showMessageDialog(null, "Data Deleted");
				 			//call out the display() method to refresh the table.
				 			display();
		                }
		             }
			 		catch(Exception ex)
			 		{
			 			//Display a message indicating that failed to delete information.
			 			JOptionPane.showMessageDialog(null, "Failed to delete. Please try again!");
			 		}
					textField.setText("");
					textField_ID.setText("");
					textField_name.setText("");
					textField_Matric.setText("");
					textField_Siswa.setText("");
					textField_Faculty.setText("");
					textField_Gender.setText("");
					textField_PN.setText("");
					textField_Father.setText("");
					textField_FP.setText("");
					textField_HN.setText("");
					textField_Block.setText("");
					textField_Floor.setText("");
					textField_RN.setText("");
					textField_Fee.setText("");
					comboBox1.setSelectedItem("");
				}
			}
		});
		btnNewButton.setBounds(678, 598, 89, 32);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		//Finish Data button - Click to go back to the admin home page.
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdminHome as = new AdminHome(userId);
				dispose();
				as.setVisible(true);
			}
		});
		btnDone.setBounds(987, 598, 89, 32);
		btnDone.setBackground(Color.WHITE);
		btnDone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(btnDone);

		//Update Data button - Click to update the status of the applicant from the database.
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean result=false;
				
				//It has select a row or not
				int r=NameList.getSelectedRow();
				if(r>=0) {
					result=true;
				}
				
				if(result==false) {
					//If there are no any row be selected it will show message ask user to select a row
					JOptionPane.showMessageDialog(null, "Please select a row first!");
				}
				else {
					try 
			 		{   
			 			//connect with MySQL database
			 			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem","root", "123456789");
			 			String query = "UPDATE applyinfo set Status='"+comboBox1.getSelectedItem()+"' WHERE bookingId='"+textField.getText()+"' ";
			 			// PreparedStatement interface that update the status.
			 			PreparedStatement st = connection.prepareStatement(query);
			 			st.execute();
			 			
			 			//Display a message indicating that the status has been updated.
			 			JOptionPane.showMessageDialog(null, "Data Updated");
			 			//call out the display() method to refresh the table.
			 			display();
			 			//if else condition to automate display the hostel fee
			 			if(comboBox1.getSelectedItem().equals("Processing"))
			 			{
			 				String query1 = "UPDATE applyinfo set fee = 'RM 0' WHERE bookingId='"+textField.getText()+"' ";
			 				PreparedStatement st1 = connection.prepareStatement(query1);
				 			st1.execute();
				 			display();
			 			}
			 			else if(comboBox1.getSelectedItem().equals("Approve"))
			 			{
			 				String query2 = "UPDATE applyinfo set fee = 'RM 700' WHERE bookingId='"+textField.getText()+"' ";
			 				PreparedStatement st2 = connection.prepareStatement(query2);
				 			st2.execute();
				 			display();
			 			}
			 			else if(comboBox1.getSelectedItem().equals("Reject"))
			 			{
			 				String query3 = "UPDATE applyinfo set fee = 'RM 0' WHERE bookingId='"+textField.getText()+"' ";
			 				PreparedStatement st3 = connection.prepareStatement(query3);
				 			st3.execute();
				 			display();
			 			}
			 			
			   		}
			 		catch(Exception e3)
			 		{
			 			//Display a message indicating that failed to update status.
			 			JOptionPane.showMessageDialog(null, "Failed to update status. Please try again!");
			 		}
					textField.setText("");
					textField_ID.setText("");
					textField_name.setText("");
					textField_Matric.setText("");
					textField_Siswa.setText("");
					textField_Faculty.setText("");
					textField_Gender.setText("");
					textField_PN.setText("");
					textField_Father.setText("");
					textField_FP.setText("");
					textField_HN.setText("");
					textField_Block.setText("");
					textField_Floor.setText("");
					textField_RN.setText("");
					textField_Fee.setText("");
					comboBox1.setSelectedItem("");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(524, 598, 89, 32);
		contentPane.add(btnNewButton_1);
		
		//clear Data button - Click to clear the data of the applicant in the table
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_ID.setText("");
				textField_name.setText("");
				textField_Matric.setText("");
				textField_Siswa.setText("");
				textField_Faculty.setText("");
				textField_Gender.setText("");
				textField_PN.setText("");
				textField_Father.setText("");
				textField_FP.setText("");
				textField_HN.setText("");
				textField_Block.setText("");
				textField_Floor.setText("");
				textField_RN.setText("");
				textField_Fee.setText("");
				comboBox1.setSelectedItem("");
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(10, 598, 89, 32);
		contentPane.add(btnNewButton_1_1);
		display();
		
		//Reset Data button - Click to reset the data of the applicant in the table
		JButton btnNewButton_1_1_1 = new JButton("Reset");
			btnNewButton_1_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Display a message to re-confirm whether the administrator wants to delete all booking detail records in the database.
				 	int a = JOptionPane.showConfirmDialog(null, "Are you sure to reset the data?");
				       // If the administrator clicks "Yes", all the booking details records will be deleted.
				 	if (a == JOptionPane.YES_OPTION)
				 	{
				 		try
				 		{
				 			//connect with MySQL database
				     		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem","root", "123456789");
				     			
				     		// PreparedStatement interface that retrieve the records of a table.
				     		String query = "DELETE FROM applyinfo";
				         	PreparedStatement st = connection.prepareStatement(query);
				         	st.execute();
				         		
				         	//Display a message indicating that all data has been deleted.
				         	JOptionPane.showMessageDialog(null, "All Data Deleted");
				         	st.close();
				         	display();
				         }catch (Exception e2)
				 		{
				        	 e2.printStackTrace();
				 		}
				 	}
				}
			});
			btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			btnNewButton_1_1_1.setBackground(Color.WHITE);
			btnNewButton_1_1_1.setBounds(837, 598, 89, 32);
			contentPane.add(btnNewButton_1_1_1);
				
			//Search Data button - Use to search the data of the applicant in the table
			textField_search = new JTextField();
			textField_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try
					{
						//connect with MySQL database
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem","root", 
								"123456789");
			     			
						// PreparedStatement interface that retrieve the records of a table.
						String query = "SELECT * FROM applyinfo WHERE Name=? ";
						PreparedStatement st = connection.prepareStatement(query);
						st.setString(1, textField_search.getText());
						ResultSet rs=st.executeQuery();
			         	
						NameList.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model= (DefaultTableModel) NameList.getModel();
			    
						st.close();
			        
					}
					catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
			});
			textField_search.setBounds(859, 58, 215, 42);
			contentPane.add(textField_search);
			textField_search.setColumns(10);
				
			//Refresh Data button - Click to refresh the data of the applicant in the table
			JButton btnNewButton_2 = new JButton("Refresh");
			btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					display();
				}
			});
			btnNewButton_2.setBounds(536, 58, 145, 43);
			contentPane.add(btnNewButton_2);
				
			JLabel lblName = new JLabel("Name ");
			lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblName.setBounds(798, 58, 62, 43);
			contentPane.add(lblName);
			display();
	}
	
	//method to display all the data information of the applicants.
	public void display() {
		try 
 		{
 			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelappsystem","root", "123456789");
 			// SELECT * mean SELECT ALL
 			String query = "SELECT * FROM applyinfo";
 			PreparedStatement st = connection.prepareStatement(query);
			// rs is use to load the table model
 			ResultSet rs = st.executeQuery();
 			//converted with the help of this DbUtils class my result set into a model 
 			NameList.setModel(DbUtils.resultSetToTableModel(rs));
 			// sorting of the rows on a particular column
 			NameList.setAutoCreateRowSorter(true);

 			st.close();
 			rs.close();
 		} 
 		catch (Exception ex) 
 		{
			ex.printStackTrace();
		}
	}

}
