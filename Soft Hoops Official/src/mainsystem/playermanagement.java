package mainsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class playermanagement {
	Connection conn = DBController.getConnection();
	private JFrame frame;
	private JTextField fname;
	private JTextField lname;
	private JTextField team;
	private JTextField status;
	private JTextField height;
	private JTextField fouls;
	private JTextField points;
	private JTextField frthrw;
	private JTextField age;
	private JTextField thrp;
	private JTable players;
	private JTextField id;
	private JTextField position;

	/**
	 * Launch the application.
	 */
	public static void open() {
		
					playermanagement window = new playermanagement();
					window.frame.setVisible(true);
			
	}

	/**
	 * Create the application.
	 */
	public playermanagement() {
		initialize();
		showdata();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayerManagement = new JLabel("Player Management");
		lblPlayerManagement.setForeground(Color.BLACK);
		lblPlayerManagement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlayerManagement.setBounds(386, 11, 237, 64);
		frame.getContentPane().add(lblPlayerManagement);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 117, 955, 132);
		frame.getContentPane().add(scrollPane);
		
		players = new JTable();
		players.setShowHorizontalLines(false);
		players.setShowGrid(false);
		players.setForeground(new Color(248, 248, 255));
		players.setBackground(new Color(0, 100, 0));
		scrollPane.setViewportView(players);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(27, 319, 86, 20);
		frame.getContentPane().add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(160, 319, 86, 20);
		frame.getContentPane().add(lname);
		
		team = new JTextField();
		team.setColumns(10);
		team.setBounds(286, 319, 86, 20);
		frame.getContentPane().add(team);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(402, 319, 86, 20);
		frame.getContentPane().add(status);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(535, 319, 86, 20);
		frame.getContentPane().add(height);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(654, 412, 86, 20);
		frame.getContentPane().add(id);
		
		fouls = new JTextField();
		fouls.setColumns(10);
		fouls.setBounds(402, 412, 86, 20);
		frame.getContentPane().add(fouls);
		
		points = new JTextField();
		points.setColumns(10);
		points.setBounds(286, 412, 86, 20);
		frame.getContentPane().add(points);
		
		frthrw = new JTextField();
		frthrw.setColumns(10);
		frthrw.setBounds(160, 412, 86, 20);
		frame.getContentPane().add(frthrw);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(654, 319, 86, 20);
		frame.getContentPane().add(age);
		
		thrp = new JTextField();
		thrp.setColumns(10);
		thrp.setBounds(27, 412, 86, 20);
		frame.getContentPane().add(thrp);
		

		position = new JTextField();
		position.setColumns(10);
		position.setBounds(535, 412, 86, 20);
		frame.getContentPane().add(position);
		
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAddPlayer.setBounds(773, 310, 105, 38);
		frame.getContentPane().add(btnAddPlayer);
		
		JLabel label_1 = new JLabel("Firstname");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(31, 281, 79, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Lastname");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(164, 281, 79, 21);
		frame.getContentPane().add(label_2);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam.setForeground(Color.BLACK);
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTeam.setBounds(290, 281, 79, 21);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(405, 281, 79, 21);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setForeground(Color.BLACK);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeight.setBounds(538, 281, 79, 21);
		frame.getContentPane().add(lblHeight);
		
		JButton button_1 = new JButton("Logout");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login log = new Login();
				log.open();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(910, 476, 89, 23);
		frame.getContentPane().add(button_1);
		
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(658, 281, 79, 21);
		frame.getContentPane().add(lblAge);
		
		JLabel lblThreePointers = new JLabel("Three Pointers");
		lblThreePointers.setHorizontalAlignment(SwingConstants.CENTER);
		lblThreePointers.setForeground(Color.BLACK);
		lblThreePointers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThreePointers.setBounds(12, 380, 116, 21);
		frame.getContentPane().add(lblThreePointers);
		
		JLabel lblFreeThrows = new JLabel("Free Throws");
		lblFreeThrows.setHorizontalAlignment(SwingConstants.CENTER);
		lblFreeThrows.setForeground(Color.BLACK);
		lblFreeThrows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFreeThrows.setBounds(151, 380, 105, 21);
		frame.getContentPane().add(lblFreeThrows);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.BLACK);
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPoints.setBounds(290, 380, 79, 21);
		frame.getContentPane().add(lblPoints);
		
		JLabel lblPosition = new JLabel("Fouls");
		lblPosition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition.setForeground(Color.BLACK);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition.setBounds(405, 380, 79, 21);
		frame.getContentPane().add(lblPosition);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(658, 380, 79, 21);
		frame.getContentPane().add(lblId);
		
		
		JLabel lblPosition_1 = new JLabel("Position");
		lblPosition_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosition_1.setForeground(Color.BLACK);
		lblPosition_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition_1.setBounds(538, 380, 79, 21);
		frame.getContentPane().add(lblPosition_1);
		
		
		btnAddPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String fn = fname.getText();
				String ln = lname.getText();
				String te = team.getText();
				String st = status.getText();
				String he = height.getText();
				int ag = Integer.parseInt(age.getText());
				int threes = Integer.parseInt(thrp.getText());
				int fthrows = Integer.parseInt(frthrw.getText());
				int point = Integer.parseInt(points.getText());
				int foul = Integer.parseInt(fouls.getText());
				String po = position.getText();
				int pid = Integer.parseInt(id.getText());
				
				
				
				PlayerManagementFacade ManagePlayer = new PlayerManagementFacade();
				
				ManagePlayer.CreatePlayer(fn, ln, te, st, he, ag, threes, fthrows, point, foul, po, pid);
				showdata();
				
				fname.setText("");
				lname.setText("");
				team.setText("");
				status.setText("");
				height.setText("");
				age.setText("");
				thrp.setText("");
				frthrw.setText("");
				points.setText("");
				fouls.setText("");
				position.setText("");
				id.setText("");
			}
		});
	}
	
	private void showdata() {
		try {
			
			
		    PreparedStatement st = null;
			ResultSet rst = null;

			String query = "Select * from players";
			st = conn.prepareStatement(query);
			rst = st.executeQuery();
			players.setModel(DbUtils.resultSetToTableModel(rst));
			players.repaint();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
