package mainsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.util.Vector;
public class usermanagement {

	private JFrame frmUserManagement;
	private JTable userstable;

	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermanagement window = new usermanagement();
					window.frmUserManagement.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public usermanagement() {
		initialize();
		showdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserManagement = new JFrame();
		frmUserManagement.setTitle("User Management");
		frmUserManagement.setBounds(100, 100, 1025, 549);
		frmUserManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserManagement.getContentPane().setLayout(null);
		
		JLabel lblUserManagement = new JLabel("User Management");
		lblUserManagement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserManagement.setBounds(386, 11, 237, 64);
		frmUserManagement.getContentPane().add(lblUserManagement);
		
		userstable = new JTable();
		userstable.setBackground(UIManager.getColor("CheckBox.background"));
		userstable.setBounds(20, 137, 469, 192);
		frmUserManagement.getContentPane().add(userstable);

	}
	
	private void showdata() {
		try {
			Connection conn = DBController.getConnection();
			
		    PreparedStatement st = null;
			ResultSet rst = null;

			String query = "Select * from users";
			st = conn.prepareStatement(query);
			rst = st.executeQuery();
			userstable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Shakeane", "Hinds", "Admin", "Admin", "Admin"},
				},
				new String[] {
					"Firstname", "Lastname", "Role", "Username", "Password"
				}
			));
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
