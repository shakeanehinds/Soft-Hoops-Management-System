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
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class usermanagement {
	Connection conn = DBController.getConnection();
	private JFrame frmUserManagement;
	private JTable userstable;
	private JScrollPane scrollPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField role;
	private JTextField username;
	private JTextField password;
	private JButton btnLogout;
	private JButton delete;
	private JTextField deluser;
	private JLabel lblDeleteUser;

	/**
	 * Launch the application.
	 */
	public static void open() {
		
					usermanagement window = new usermanagement();
					window.frmUserManagement.setVisible(true);
					
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
		frmUserManagement.getContentPane().setForeground(new Color(248, 248, 255));
		frmUserManagement.getContentPane().setBackground(new Color(248, 248, 255));
		frmUserManagement.setTitle("User Management");
		frmUserManagement.setBounds(100, 100, 1025, 549);
		frmUserManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserManagement.getContentPane().setLayout(null);
		
		JLabel lblUserManagement = new JLabel("User Management");
		lblUserManagement.setForeground(new Color(0, 0, 0));
		lblUserManagement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserManagement.setBounds(386, 11, 237, 64);
		frmUserManagement.getContentPane().add(lblUserManagement);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setBounds(10, 85, 978, 124);
		frmUserManagement.getContentPane().add(scrollPane);
		
		userstable = new JTable();
		userstable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(userstable);
		userstable.setForeground(new Color(248, 248, 255));
		userstable.setBackground(new Color(0, 100, 0));
		
		fname = new JTextField();
		fname.setBounds(20, 336, 86, 20);
		frmUserManagement.getContentPane().add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(153, 336, 86, 20);
		frmUserManagement.getContentPane().add(lname);
		lname.setColumns(10);
		
		role = new JTextField();
		role.setBounds(279, 336, 86, 20);
		frmUserManagement.getContentPane().add(role);
		role.setColumns(10);
		
		username = new JTextField();
		username.setBounds(395, 336, 86, 20);
		frmUserManagement.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(528, 336, 86, 20);
		frmUserManagement.getContentPane().add(password);
		password.setColumns(10);
		
		JButton add = new JButton("Add User");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String f = fname.getText();
				String l = lname.getText();
				String r = role.getText();
				String u = username.getText();
				String p = password.getText();
				createuser(f, l, r, u, p);
				
				
			}
		});
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add.setBounds(662, 318, 105, 38);
		frmUserManagement.getContentPane().add(add);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(24, 298, 79, 21);
		frmUserManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setForeground(new Color(0, 0, 0));
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastname.setBounds(157, 298, 79, 21);
		frmUserManagement.getContentPane().add(lblLastname);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setForeground(new Color(0, 0, 0));
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRole.setBounds(283, 298, 79, 21);
		frmUserManagement.getContentPane().add(lblRole);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(398, 298, 79, 21);
		frmUserManagement.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(531, 298, 79, 21);
		frmUserManagement.getContentPane().add(lblPassword);
		
		btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Login log = new Login();
				log.open();
        		frmUserManagement.setVisible(false);
        		frmUserManagement.dispose();
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.setBounds(882, 459, 89, 23);
		frmUserManagement.getContentPane().add(btnLogout);
		
		delete = new JButton("Delete");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String username = deluser.getText();
				deleteuser(username);
				
			}
		});
		delete.setBounds(662, 411, 105, 38);
		frmUserManagement.getContentPane().add(delete);
		
		deluser = new JTextField();
		deluser.setColumns(10);
		deluser.setBounds(505, 429, 118, 20);
		frmUserManagement.getContentPane().add(deluser);
		
		lblDeleteUser = new JLabel("Delete User");
		lblDeleteUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteUser.setForeground(Color.BLACK);
		lblDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeleteUser.setBounds(505, 391, 105, 21);
		frmUserManagement.getContentPane().add(lblDeleteUser);

	}
	
	private void showdata() {
		try {
			
			
		    PreparedStatement st = null;
			ResultSet rst = null;

			String query = "Select * from users";
			st = conn.prepareStatement(query);
			rst = st.executeQuery();
			userstable.setModel(DbUtils.resultSetToTableModel(rst));
			userstable.repaint();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void createuser(String f, String l, String r, String u, String p) {
		
		PreparedStatement gst = null;
		try {
			String sql = "insert into users values(?, ?, ?, ?, ?)";
			gst = conn.prepareStatement(sql);
					
			gst.setString(1, f);
			gst.setString(2, l);
			gst.setString(3, r);
			gst.setString(4, u);
			gst.setString(5, p);
			gst.execute();
			
			JOptionPane.showMessageDialog(null, "User Added");
			showdata();
			
			fname.setText("");
			lname.setText("");
			role.setText("");
			username.setText("");
			password.setText("");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void deleteuser(String user) {
		PreparedStatement st = null;
		try {
			String sql = "delete from users where Username = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, user);
			st.execute();
			JOptionPane.showMessageDialog(null, "User Deleted");
			showdata();
			deluser.setText("");
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
