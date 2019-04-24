package mainsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class game {

	private JFrame frmGame;
	private JTextField name;
	private JTextField point;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void open() {
		
					game window = new game();
					window.frmGame.setVisible(true);
			
	}

	/**
	 * Create the application.
	 */
	public game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGame = new JFrame();
		frmGame.setTitle("Game ");
		frmGame.getContentPane().setBackground(new Color(248, 248, 255));
		frmGame.setBounds(100, 100, 1021, 586);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.getContentPane().setLayout(null);
		
		JLabel lblTeam = new JLabel("St. Jago");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTeam.setBounds(46, 30, 159, 58);
		frmGame.getContentPane().add(lblTeam);
		
		JLabel lblTeam_1 = new JLabel("Calabar");
		lblTeam_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTeam_1.setBounds(845, 30, 105, 58);
		frmGame.getContentPane().add(lblTeam_1);
		
		JLabel lblPoints = new JLabel("Score");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPoints.setBounds(468, 162, 68, 41);
		frmGame.getContentPane().add(lblPoints);
		
		JLabel lblFoul = new JLabel("Foul");
		lblFoul.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFoul.setBounds(468, 261, 68, 41);
		frmGame.getContentPane().add(lblFoul);
		
		JLabel lblPosession = new JLabel("Posession");
		lblPosession.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPosession.setBounds(447, 364, 111, 41);
		frmGame.getContentPane().add(lblPosession);
		
		JLabel lblNewLabel = new JLabel("50");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(583, 151, 68, 61);
		frmGame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("50");
		label.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label.setBounds(344, 151, 68, 61);
		frmGame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("5");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label_1.setBounds(344, 252, 68, 61);
		frmGame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("1");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label_2.setBounds(583, 252, 68, 61);
		frmGame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("60%");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label_3.setBounds(583, 356, 111, 61);
		frmGame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("40%");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label_4.setBounds(307, 356, 105, 61);
		frmGame.getContentPane().add(label_4);
		
		JButton t1point = new JButton("Add Point");
		t1point.setBounds(54, 159, 89, 23);
		frmGame.getContentPane().add(t1point);
		
		name = new JTextField();
		name.setBounds(10, 128, 86, 20);
		frmGame.getContentPane().add(name);
		name.setColumns(10);
		
		point = new JTextField();
		point.setBounds(106, 128, 86, 20);
		frmGame.getContentPane().add(point);
		point.setColumns(10);
		
		JLabel lblName = new JLabel("Player Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 107, 86, 14);
		frmGame.getContentPane().add(lblName);
		
		JLabel lblPoints_1 = new JLabel("Points");
		lblPoints_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints_1.setBounds(106, 107, 86, 14);
		frmGame.getContentPane().add(lblPoints_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(57, 252, 86, 20);
		frmGame.getContentPane().add(textField);
		
		JLabel label_5 = new JLabel("Player Name");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(57, 226, 86, 14);
		frmGame.getContentPane().add(label_5);
		
		JButton t1foul = new JButton("Foul");
		t1foul.setBounds(56, 279, 89, 23);
		frmGame.getContentPane().add(t1foul);
		
		JLabel label_6 = new JLabel("Player Name");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(813, 107, 86, 14);
		frmGame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Points");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(909, 107, 86, 14);
		frmGame.getContentPane().add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(813, 128, 86, 20);
		frmGame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(909, 128, 86, 20);
		frmGame.getContentPane().add(textField_2);
		
		JButton t2point = new JButton("Add Point");
		t2point.setBounds(857, 159, 89, 23);
		frmGame.getContentPane().add(t2point);
		
		JLabel label_8 = new JLabel("Player Name");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(860, 226, 86, 14);
		frmGame.getContentPane().add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(860, 252, 86, 20);
		frmGame.getContentPane().add(textField_3);
		
		JButton t2foul = new JButton("Foul");
		t2foul.setBounds(859, 279, 89, 23);
		frmGame.getContentPane().add(t2foul);
		
		JLabel clock = new JLabel("35m:45s");
		clock.setFont(new Font("Tahoma", Font.PLAIN, 30));
		clock.setBounds(423, 45, 135, 28);
		frmGame.getContentPane().add(clock);
		
		JButton button = new JButton("Logout");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login log = new Login();
				log.open();
				frmGame.setVisible(false);
				frmGame.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(906, 513, 89, 23);
		frmGame.getContentPane().add(button);
		
		

	}
	
	
}
