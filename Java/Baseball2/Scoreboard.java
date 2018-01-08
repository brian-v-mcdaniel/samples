package Baseball2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard extends JFrame {

	private static JLabel lblTeam_1;
	private static JLabel team1_inn1;
	private static JLabel team1_inn2;
	private static JLabel team1_inn3;
	private static JLabel team1_inn4;
	private static JLabel team1_inn5;
	private static JLabel team1_inn6;
	private static JLabel team1_inn7;
	private static JLabel team1_inn8;
	private static JLabel team1_inn9;
	private static JLabel team1_inn10;
	private static JLabel team2_inn1;
	private static JLabel team2_inn2;
	private static JLabel team2_inn3;	
	private static JLabel team2_inn4;
	private static JLabel team2_inn5;
	private static JLabel team2_inn6;
	private static JLabel team2_inn7;
	private static JLabel team2_inn8;
	private static JLabel team2_inn9;
	private static JLabel team2_inn10;
	private static JLabel lblTeam_2;
	
	private static int runs[][] = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public Scoreboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = 
				new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label_1 = new JLabel("1");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 2;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("2");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 2;
		contentPane.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("3");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 2;
		contentPane.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("4");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 2;
		contentPane.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("5");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 6;
		gbc_label_5.gridy = 2;
		contentPane.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("6");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 7;
		gbc_label_6.gridy = 2;
		contentPane.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("7");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 8;
		gbc_label_7.gridy = 2;
		contentPane.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("8");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 9;
		gbc_label_8.gridy = 2;
		contentPane.add(label_8, gbc_label_8);
		
		JLabel label_9 = new JLabel("9");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 10;
		gbc_label_9.gridy = 2;
		contentPane.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("10");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 11;
		gbc_label_10.gridy = 2;
		contentPane.add(label_10, gbc_label_10);
		
		lblTeam_1 = new JLabel("TEAM 1");
		lblTeam_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTeam_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTeam_1 = new GridBagConstraints();
		gbc_lblTeam_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_1.gridx = 0;
		gbc_lblTeam_1.gridy = 3;
		contentPane.add(lblTeam_1, gbc_lblTeam_1);
		
		JLabel lblR = new JLabel("R");
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.gridx = 15;
		gbc_lblR.gridy = 2;
		contentPane.add(lblR, gbc_lblR);
		
		JLabel lblH = new JLabel("H");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 16;
		gbc_lblH.gridy = 2;
		contentPane.add(lblH, gbc_lblH);
		
		JLabel lblE = new JLabel("E");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblE = new GridBagConstraints();
		gbc_lblE.insets = new Insets(0, 0, 5, 5);
		gbc_lblE.gridx = 17;
		gbc_lblE.gridy = 2;
		contentPane.add(lblE, gbc_lblE);		
		
		team1_inn1 = new JLabel("   ");
		team1_inn1.setOpaque(isOpaque());
		team1_inn1.setBackground(Color.BLACK);
		team1_inn1.setForeground(Color.WHITE);
		team1_inn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_team1_inn1 = new GridBagConstraints();
		gbc_team1_inn1.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn1.gridx = 2;
		gbc_team1_inn1.gridy = 3;
		contentPane.add(team1_inn1, gbc_team1_inn1);
		
		team1_inn2 = new JLabel("   ");
		team1_inn2.setOpaque(isOpaque());		
		team1_inn2.setBackground(Color.BLACK);
		team1_inn2.setForeground(Color.WHITE);		
		team1_inn2.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn2 = new GridBagConstraints();
		gbc_team1_inn2.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn2.gridx = 3;
		gbc_team1_inn2.gridy = 3;
		contentPane.add(team1_inn2, gbc_team1_inn2);
		
		team1_inn3 = new JLabel("   ");
		team1_inn3.setOpaque(isOpaque());		
		team1_inn3.setBackground(Color.BLACK);
		team1_inn3.setForeground(Color.WHITE);		
		team1_inn3.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn3 = new GridBagConstraints();
		gbc_team1_inn3.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn3.gridx = 4;
		gbc_team1_inn3.gridy = 3;
		contentPane.add(team1_inn3, gbc_team1_inn3);		

		team1_inn4 = new JLabel("   ");
		team1_inn4.setOpaque(isOpaque());		
		team1_inn4.setBackground(Color.BLACK);
		team1_inn4.setForeground(Color.WHITE);		
		team1_inn4.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn4 = new GridBagConstraints();
		gbc_team1_inn4.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn4.gridx = 5;
		gbc_team1_inn4.gridy = 3;
		contentPane.add(team1_inn4, gbc_team1_inn4);			
		
		team1_inn5 = new JLabel("   ");
		team1_inn5.setOpaque(isOpaque());		
		team1_inn5.setBackground(Color.BLACK);
		team1_inn5.setForeground(Color.WHITE);		
		team1_inn5.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn5 = new GridBagConstraints();
		gbc_team1_inn5.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn5.gridx = 6;
		gbc_team1_inn5.gridy = 3;
		contentPane.add(team1_inn5, gbc_team1_inn5);		
		
		team1_inn6 = new JLabel("   ");
		team1_inn6.setOpaque(isOpaque());		
		team1_inn6.setBackground(Color.BLACK);
		team1_inn6.setForeground(Color.WHITE);		
		team1_inn6.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn6 = new GridBagConstraints();
		gbc_team1_inn6.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn6.gridx = 7;
		gbc_team1_inn6.gridy = 3;
		contentPane.add(team1_inn6, gbc_team1_inn6);			
		
		team1_inn7 = new JLabel("   ");
		team1_inn7.setOpaque(isOpaque());		
		team1_inn7.setBackground(Color.BLACK);
		team1_inn7.setForeground(Color.WHITE);		
		team1_inn7.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn7 = new GridBagConstraints();
		gbc_team1_inn7.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn7.gridx = 8;
		gbc_team1_inn7.gridy = 3;
		contentPane.add(team1_inn7, gbc_team1_inn7);		
		
		team1_inn8 = new JLabel("   ");
		team1_inn8.setOpaque(isOpaque());		
		team1_inn8.setBackground(Color.BLACK);
		team1_inn8.setForeground(Color.WHITE);		
		team1_inn8.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn8 = new GridBagConstraints();
		gbc_team1_inn8.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn8.gridx = 9;
		gbc_team1_inn8.gridy = 3;
		contentPane.add(team1_inn8, gbc_team1_inn8);		
		
		team1_inn9 = new JLabel("   ");
		team1_inn9.setOpaque(isOpaque());		
		team1_inn9.setBackground(Color.BLACK);
		team1_inn9.setForeground(Color.WHITE);		
		team1_inn9.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn9 = new GridBagConstraints();
		gbc_team1_inn9.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn9.gridx = 10;
		gbc_team1_inn9.gridy = 3;
		contentPane.add(team1_inn9, gbc_team1_inn9);	
		
		team1_inn10 = new JLabel("   ");
		team1_inn10.setOpaque(isOpaque());		
		team1_inn10.setBackground(Color.BLACK);
		team1_inn10.setForeground(Color.WHITE);		
		team1_inn10.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team1_inn10 = new GridBagConstraints();
		gbc_team1_inn10.insets = new Insets(0, 0, 5, 5);
		gbc_team1_inn10.gridx = 11;
		gbc_team1_inn10.gridy = 3;
		contentPane.add(team1_inn10, gbc_team1_inn10);	

		JLabel team1_runs = new JLabel("   ");
		team1_runs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team1_runs.setOpaque(isOpaque());			
		team1_runs.setBackground(Color.BLACK);
		GridBagConstraints gbc_team1_runs = new GridBagConstraints();
		gbc_team1_runs.insets = new Insets(0, 0, 5, 5);
		gbc_team1_runs.gridx = 15;
		gbc_team1_runs.gridy = 3;
		contentPane.add(team1_runs, gbc_team1_runs);
		
		JLabel team1_hits = new JLabel("  ");
		team1_hits.setBackground(Color.BLACK);
		team1_hits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team1_hits.setOpaque(isOpaque());		
		GridBagConstraints gbc_team1_hits = new GridBagConstraints();
		gbc_team1_hits.insets = new Insets(0, 0, 5, 5);
		gbc_team1_hits.gridx = 16;
		gbc_team1_hits.gridy = 3;
		contentPane.add(team1_hits, gbc_team1_hits);
		
		JLabel team1_errors = new JLabel("  ");
		team1_errors.setBackground(Color.BLACK);
		team1_errors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team1_errors.setOpaque(isOpaque());		
		GridBagConstraints gbc_team1_errors = new GridBagConstraints();
		gbc_team1_errors.insets = new Insets(0, 0, 5, 5);
		gbc_team1_errors.gridx = 17;
		gbc_team1_errors.gridy = 3;
		contentPane.add(team1_errors, gbc_team1_errors);		
		
		team2_inn1 = new JLabel("   ");
		team2_inn1.setOpaque(isOpaque());
		team2_inn1.setBackground(Color.BLACK);
		team2_inn1.setForeground(Color.WHITE);		
		team2_inn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_team2_inn1 = new GridBagConstraints();
		gbc_team2_inn1.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn1.gridx = 2;
		gbc_team2_inn1.gridy = 5;
		contentPane.add(team2_inn1, gbc_team2_inn1);
		
		team2_inn2 = new JLabel("   ");
		team2_inn2.setOpaque(isOpaque());		
		team2_inn2.setBackground(Color.BLACK);
		team2_inn2.setForeground(Color.WHITE);		
		team2_inn2.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn2 = new GridBagConstraints();
		gbc_team2_inn2.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn2.gridx = 3;
		gbc_team2_inn2.gridy = 5;
		contentPane.add(team2_inn2, gbc_team2_inn2);
		
		team2_inn3 = new JLabel("   ");
		team2_inn3.setOpaque(isOpaque());		
		team2_inn3.setBackground(Color.BLACK);
		team2_inn3.setForeground(Color.WHITE);		
		team2_inn3.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn3 = new GridBagConstraints();
		gbc_team2_inn3.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn3.gridx = 4;
		gbc_team2_inn3.gridy = 5;
		contentPane.add(team2_inn3, gbc_team2_inn3);		

		team2_inn4 = new JLabel("   ");
		team2_inn4.setOpaque(isOpaque());		
		team2_inn4.setBackground(Color.BLACK);
		team2_inn4.setForeground(Color.WHITE);		
		team2_inn4.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn4 = new GridBagConstraints();
		gbc_team2_inn4.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn4.gridx = 5;
		gbc_team2_inn4.gridy = 5;
		contentPane.add(team2_inn4, gbc_team2_inn4);			
		
		team2_inn5 = new JLabel("   ");
		team2_inn5.setOpaque(isOpaque());		
		team2_inn5.setBackground(Color.BLACK);
		team2_inn5.setForeground(Color.WHITE);		
		team2_inn5.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn5 = new GridBagConstraints();
		gbc_team2_inn5.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn5.gridx = 6;
		gbc_team2_inn5.gridy = 5;
		contentPane.add(team2_inn5, gbc_team2_inn5);		
		
		team2_inn6 = new JLabel("   ");
		team2_inn6.setOpaque(isOpaque());		
		team2_inn6.setBackground(Color.BLACK);
		team2_inn6.setForeground(Color.WHITE);		
		team2_inn6.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn6 = new GridBagConstraints();
		gbc_team2_inn6.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn6.gridx = 7;
		gbc_team2_inn6.gridy = 5;
		contentPane.add(team2_inn6, gbc_team2_inn6);			
		
		team2_inn7 = new JLabel("   ");
		team2_inn7.setOpaque(isOpaque());		
		team2_inn7.setBackground(Color.BLACK);
		team2_inn7.setForeground(Color.WHITE);		
		team2_inn7.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn7 = new GridBagConstraints();
		gbc_team2_inn7.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn7.gridx = 8;
		gbc_team2_inn7.gridy = 5;
		contentPane.add(team2_inn7, gbc_team2_inn7);		
		
		team2_inn8 = new JLabel("   ");
		team2_inn8.setOpaque(isOpaque());		
		team2_inn8.setBackground(Color.BLACK);
		team2_inn8.setForeground(Color.WHITE);		
		team2_inn8.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn8 = new GridBagConstraints();
		gbc_team2_inn8.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn8.gridx = 9;
		gbc_team2_inn8.gridy = 5;
		contentPane.add(team2_inn8, gbc_team2_inn8);		
		
		team2_inn9 = new JLabel("   ");
		team2_inn9.setOpaque(isOpaque());		
		team2_inn9.setBackground(Color.BLACK);
		team2_inn9.setForeground(Color.WHITE);		
		team2_inn9.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn9 = new GridBagConstraints();
		gbc_team2_inn9.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn9.gridx = 10;
		gbc_team2_inn9.gridy = 5;
		contentPane.add(team2_inn9, gbc_team2_inn9);	
		
		team2_inn10 = new JLabel("   ");
		team2_inn10.setOpaque(isOpaque());		
		team2_inn10.setBackground(Color.BLACK);
		team2_inn10.setForeground(Color.WHITE);		
		team2_inn10.setFont(new Font("Tahoma", Font.PLAIN, 20));		
		GridBagConstraints gbc_team2_inn10 = new GridBagConstraints();
		gbc_team2_inn10.insets = new Insets(0, 0, 5, 5);
		gbc_team2_inn10.gridx = 11;
		gbc_team2_inn10.gridy = 5;
		contentPane.add(team2_inn10, gbc_team2_inn10);			
		
		lblTeam_2 = new JLabel("TEAM 2");
		lblTeam_2.setForeground(new Color(255, 255, 255));
		lblTeam_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTeam_2 = new GridBagConstraints();
		gbc_lblTeam_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblTeam_2.gridx = 0;
		gbc_lblTeam_2.gridy = 5;
		contentPane.add(lblTeam_2, gbc_lblTeam_2);

		JLabel team2_runs = new JLabel("  ");
		team2_runs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team2_runs.setOpaque(isOpaque());		
		team2_runs.setBackground(Color.BLACK);
		GridBagConstraints gbc_team2_runs = new GridBagConstraints();
		gbc_team2_runs.insets = new Insets(0, 0, 5, 5);
		gbc_team2_runs.gridx = 15;
		gbc_team2_runs.gridy = 5;
		contentPane.add(team2_runs, gbc_team2_runs);
		
		JLabel team2_hits = new JLabel("  ");
		team2_hits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team2_hits.setOpaque(isOpaque());		
		team2_hits.setBackground(Color.BLACK);
		GridBagConstraints gbc_team2_hits = new GridBagConstraints();
		gbc_team2_hits.insets = new Insets(0, 0, 5, 5);
		gbc_team2_hits.gridx = 16;
		gbc_team2_hits.gridy = 5;
		contentPane.add(team2_hits, gbc_team2_hits);
		
		JLabel team2_errors = new JLabel("  ");
		team2_errors.setBackground(Color.BLACK);
		team2_errors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		team2_errors.setOpaque(isOpaque());		
		GridBagConstraints gbc_team2_errors = new GridBagConstraints();
		gbc_team2_errors.insets = new Insets(0, 0, 5, 5);
		gbc_team2_errors.gridx = 17;
		gbc_team2_errors.gridy = 5;
		contentPane.add(team2_errors, gbc_team2_errors);		
	}
	
	public static void add_runs(int team, int inn) 
	{
		int i = team - 1;
		int j = inn - 1;
		if (i < 0 || i > 1) return;
		if (j < 0 || j > 9) return;
		runs[i][j]++;
		String runs_str = " " + runs[i][j];
		if (team == 1) {
			switch (inn) {
			case 1: team1_inn1.setText(runs_str); break;
			case 2: team1_inn2.setText(runs_str); break;
			case 3: team1_inn3.setText(runs_str); break;
			case 4: team1_inn4.setText(runs_str); break;
			case 5: team1_inn5.setText(runs_str); break;
			case 6: team1_inn6.setText(runs_str); break;
			case 7: team1_inn7.setText(runs_str); break;
			case 8: team1_inn8.setText(runs_str); break;
			case 9: team1_inn9.setText(runs_str); break;
			case 10: team1_inn10.setText(runs_str);			
			}
		} else if (team == 2) {
			switch (inn) {
			case 1: team2_inn1.setText(runs_str); break;
			case 2: team2_inn2.setText(runs_str); break;
			case 3: team2_inn3.setText(runs_str); break;
			case 4: team2_inn4.setText(runs_str); break;
			case 5: team2_inn5.setText(runs_str); break;
			case 6: team2_inn6.setText(runs_str); break;
			case 7: team2_inn7.setText(runs_str); break;
			case 8: team2_inn8.setText(runs_str); break;
			case 9: team2_inn9.setText(runs_str); break;
			case 10: team2_inn10.setText(runs_str);			
			}			
		}
	}
	
	// Some would say this is wasteful, but I wanted to be orthogonal 
	// for the sake of the users of this class.
	public static void subtract_runs(int team, int inn) 
	{
		if (team < 1 || team > 2) return;
		if (inn < 1 || inn > 10) return;		
		int i = team - 1;
		int j = inn - 1;
		if (runs[i][j] > 0) runs[i][j]--;
		String runs_str = " " + runs[i][j];
		if (team == 1) {
			switch (inn) {
			case 1: team1_inn1.setText(runs_str); break;
			case 2: team1_inn2.setText(runs_str); break;
			case 3: team1_inn3.setText(runs_str); break;
			case 4: team1_inn4.setText(runs_str); break;
			case 5: team1_inn5.setText(runs_str); break;
			case 6: team1_inn6.setText(runs_str); break;
			case 7: team1_inn7.setText(runs_str); break;
			case 8: team1_inn8.setText(runs_str); break;
			case 9: team1_inn9.setText(runs_str); break;
			case 10: team1_inn10.setText(runs_str);			
			}
		} else if (team == 2) {
			switch (inn) {
			case 1: team2_inn1.setText(runs_str); break;
			case 2: team2_inn2.setText(runs_str); break;
			case 3: team2_inn3.setText(runs_str); break;
			case 4: team2_inn4.setText(runs_str); break;
			case 5: team2_inn5.setText(runs_str); break;
			case 6: team2_inn6.setText(runs_str); break;
			case 7: team2_inn7.setText(runs_str); break;
			case 8: team2_inn8.setText(runs_str); break;
			case 9: team2_inn9.setText(runs_str); break;
			case 10: team2_inn10.setText(runs_str);			
			}			
		}
	}
	
	public static void change_name(int team, String name)  {
		if (team == 1)
			lblTeam_1.setText(name);
		else if (team == 2) 
			lblTeam_2.setText(name);
	}
}