package mainsystem;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login {

	private JFrame frmSoftHoops;
	private JTextField user;
	private JPasswordField pass;
	Connection conn = DBController.getConnection();

	/**
	 * Launch the application.
	 */
	public static void open() {
		
					Login window = new Login();
					window.frmSoftHoops.setVisible(true);
			
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSoftHoops = new JFrame();
		frmSoftHoops.getContentPane().setBackground(new Color(248, 248, 255));
		frmSoftHoops.setTitle("Soft Hoops");
		frmSoftHoops.setBounds(100, 100, 930, 537);
		frmSoftHoops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoftHoops.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = user.getText();
				String password = new String(pass.getPassword());

				String vusername;
				String vpassword;
				String role;
				
				if(username == null || password == null){
					JOptionPane.showMessageDialog(null, "Please enter info");
				}
				else {
				try
				{
					if (username != null && password != null) {
						 
		                 String query = "Select * from users Where Username='" + username + "' and Password='" + password + "'";
		                 Statement st = conn.createStatement();
		     			 ResultSet rst = st.executeQuery(query);

		                rst.next();
		                vusername = rst.getString("username");
		                vpassword = rst.getString("password");
		                role = rst.getString("Role");
		                
		                if (username.equals(vusername) && password.equals(vpassword)) {
		                	
		                	if(role.equals("Admin")) {
		                		usermanagement userm = new usermanagement();
		                		userm.open();
		                		
		                		frmSoftHoops.setVisible(false);
		                		frmSoftHoops.dispose();
		                	}
		                	else if(role.equals("Coach")) {
		                		playermanagement play = new playermanagement();
		                		play.open();
		                		
		                		frmSoftHoops.setVisible(false);
		                		frmSoftHoops.dispose();
		                	}
		                	else if(role.equals("Stats")){
		                		game game = new game();
		                		game.open();
		                		
		                		frmSoftHoops.setVisible(false);
		                		frmSoftHoops.dispose();
		                	}
		                }
					}
					
					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(406, 307, 89, 23);
		frmSoftHoops.getContentPane().add(btnLogin);
		
		JLabel lblSoftHoops = new JLabel("Soft Hoops");
		lblSoftHoops.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSoftHoops.setBounds(396, 32, 122, 64);
		frmSoftHoops.getContentPane().add(lblSoftHoops);
		
		user = new JTextField();
		user.setBounds(318, 233, 89, 23);
		frmSoftHoops.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(235, 237, 73, 14);
		frmSoftHoops.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(475, 237, 95, 14);
		frmSoftHoops.getContentPane().add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(583, 234, 102, 21);
		frmSoftHoops.getContentPane().add(pass);
	}
}
