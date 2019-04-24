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

	private JFrame frmUserManagement;
	private JTable userstable;
	private JScrollPane scrollPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField role;
	private JTextField username;
	private JTextField password;
	private JButton btnLogout;
	private JButton update;
	private JTextField upassword;
	private JTextField uuser;
	private JTextField urole;
	private JTextField ufname;
	private JTextField ulname;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

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
		lblUserManagement.setBounds(772, 67, 237, 64);
		frmUserManagement.getContentPane().add(lblUserManagement);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 67, 503, 75);
		frmUserManagement.getContentPane().add(scrollPane);
		
		userstable = new JTable();
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
		
		update = new JButton("Update");
		update.setBounds(662, 411, 105, 38);
		frmUserManagement.getContentPane().add(update);
		
		upassword = new JTextField();
		upassword.setColumns(10);
		upassword.setBounds(528, 429, 86, 20);
		frmUserManagement.getContentPane().add(upassword);
		
		uuser = new JTextField();
		uuser.setColumns(10);
		uuser.setBounds(395, 429, 86, 20);
		frmUserManagement.getContentPane().add(uuser);
		
		urole = new JTextField();
		urole.setColumns(10);
		urole.setBounds(279, 429, 86, 20);
		frmUserManagement.getContentPane().add(urole);
		
		ufname = new JTextField();
		ufname.setColumns(10);
		ufname.setBounds(20, 429, 86, 20);
		frmUserManagement.getContentPane().add(ufname);
		
		ulname = new JTextField();
		ulname.setColumns(10);
		ulname.setBounds(153, 429, 86, 20);
		frmUserManagement.getContentPane().add(ulname);
		
		label = new JLabel("Firstname");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(24, 391, 79, 21);
		frmUserManagement.getContentPane().add(label);
		
		label_1 = new JLabel("Lastname");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(157, 391, 79, 21);
		frmUserManagement.getContentPane().add(label_1);
		
		label_2 = new JLabel("Role");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(283, 391, 79, 21);
		frmUserManagement.getContentPane().add(label_2);
		
		label_3 = new JLabel("Username");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(398, 391, 79, 21);
		frmUserManagement.getContentPane().add(label_3);
		
		label_4 = new JLabel("Password");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(531, 391, 79, 21);
		frmUserManagement.getContentPane().add(label_4);

	}
	
	private void showdata() {
		try {
			Connection conn = DBController.getConnection();
			
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
		Connection jon = DBController.getConnection();
		PreparedStatement gst = null;
		try {
			String sql = "insert into users values(?, ?, ?, ?, ?)";
			gst = jon.prepareStatement(sql);
					
			gst.setString(1, f);
			gst.setString(2, l);
			gst.setString(3, r);
			gst.setString(4, u);
			gst.setString(5, p);
			gst.execute();
			
			JOptionPane.showMessageDialog(null, "User Added");
			userstable.repaint();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
