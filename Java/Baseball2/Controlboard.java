package Baseball2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class Controlboard extends JFrame {

	private JPanel contentPane;
	private JTextField txtTeam1;
	private JTextField txtTeam2;
	private int inning = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * logic for innings
	 */
	
	private void addInning() {
		inning++;
	}
	
	private void subtractInning() {
		if (inning > 1)
		inning--;
	}	
	
	/**
	 * Create the frame.
	 */
	public Controlboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 410, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		final JLabel lblInningNum = new JLabel("1");
		lblInningNum.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GridBagConstraints gbc_lblInningNum = new GridBagConstraints();
		gbc_lblInningNum.insets = new Insets(0, 0, 5, 5);
		gbc_lblInningNum.gridx = 1;
		gbc_lblInningNum.gridy = 1;
		contentPane.add(lblInningNum, gbc_lblInningNum);
		
		JButton btnInnPlus = new JButton("INN +");
		btnInnPlus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addInning();
				lblInningNum.setText(Integer.toString(inning));
			}
		}
		);
		GridBagConstraints gbc_btnInnPlus = new GridBagConstraints();
		gbc_btnInnPlus.insets = new Insets(0, 0, 5, 5);
		gbc_btnInnPlus.gridx = 2;
		gbc_btnInnPlus.gridy = 1;
		contentPane.add(btnInnPlus, gbc_btnInnPlus);
		
		JButton btnInnMinus = new JButton("INN -");
		btnInnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subtractInning();
				lblInningNum.setText(Integer.toString(inning));
			}
		});
		btnInnMinus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnInnMinus = new GridBagConstraints();
		gbc_btnInnMinus.insets = new Insets(0, 0, 5, 5);
		gbc_btnInnMinus.gridx = 4;
		gbc_btnInnMinus.gridy = 1;
		contentPane.add(btnInnMinus, gbc_btnInnMinus);
		
		txtTeam1 = new JTextField();
		txtTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scoreboard.change_name(1, txtTeam1.getText());
			}
		}
		);				
		txtTeam1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTeam1.setText("TEAM 1");
		GridBagConstraints gbc_txtTeam1 = new GridBagConstraints();
		gbc_txtTeam1.insets = new Insets(0, 0, 5, 5);
		gbc_txtTeam1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTeam1.gridx = 1;
		gbc_txtTeam1.gridy = 4;
		contentPane.add(txtTeam1, gbc_txtTeam1);
		txtTeam1.setColumns(10);
		
		JButton btnR_1Plus = new JButton("R+");
		btnR_1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// innings wrap around after 10
				Scoreboard.add_runs(1, inning % 10);
			}
		}
		);
		GridBagConstraints gbc_btnR_1Plus = new GridBagConstraints();
		gbc_btnR_1Plus.anchor = GridBagConstraints.EAST;
		gbc_btnR_1Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnR_1Plus.gridx = 2;
		gbc_btnR_1Plus.gridy = 4;
		contentPane.add(btnR_1Plus, gbc_btnR_1Plus);
		
		JButton btnH_1Plus = new JButton("H+");
		GridBagConstraints gbc_btnH_1Plus = new GridBagConstraints();
		gbc_btnH_1Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnH_1Plus.gridx = 3;
		gbc_btnH_1Plus.gridy = 4;
		contentPane.add(btnH_1Plus, gbc_btnH_1Plus);
		
		JButton btnE_1Plus = new JButton("E+");
		GridBagConstraints gbc_btnE_1Plus = new GridBagConstraints();
		gbc_btnE_1Plus.anchor = GridBagConstraints.WEST;
		gbc_btnE_1Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnE_1Plus.gridx = 4;
		gbc_btnE_1Plus.gridy = 4;
		contentPane.add(btnE_1Plus, gbc_btnE_1Plus);
		
		JButton btnR_1Minus = new JButton("R-");
		btnR_1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// innings wrap around after 10
				Scoreboard.subtract_runs(1, inning % 10);
			}
		}
		);		
		GridBagConstraints gbc_btnR_1Minus = new GridBagConstraints();
		gbc_btnR_1Minus.anchor = GridBagConstraints.EAST;
		gbc_btnR_1Minus.insets = new Insets(0, 0, 5, 5);
		gbc_btnR_1Minus.gridx = 2;
		gbc_btnR_1Minus.gridy = 5;
		contentPane.add(btnR_1Minus, gbc_btnR_1Minus);
		
		JButton btnH_1Minus = new JButton("H-");
		GridBagConstraints gbc_btnH_1Minus = new GridBagConstraints();
		gbc_btnH_1Minus.insets = new Insets(0, 0, 5, 5);
		gbc_btnH_1Minus.gridx = 3;
		gbc_btnH_1Minus.gridy = 5;
		contentPane.add(btnH_1Minus, gbc_btnH_1Minus);
		
		JButton btnE_1Minus = new JButton("E-");
		GridBagConstraints gbc_btnE_1Minus = new GridBagConstraints();
		gbc_btnE_1Minus.anchor = GridBagConstraints.WEST;
		gbc_btnE_1Minus.insets = new Insets(0, 0, 5, 5);
		gbc_btnE_1Minus.gridx = 4;
		gbc_btnE_1Minus.gridy = 5;
		contentPane.add(btnE_1Minus, gbc_btnE_1Minus);
		
		txtTeam2 = new JTextField();
		txtTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scoreboard.change_name(2, txtTeam2.getText());
			}
		}
		);						
		txtTeam2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTeam2.setText("TEAM 2");
		GridBagConstraints gbc_txtTeam2 = new GridBagConstraints();
		gbc_txtTeam2.insets = new Insets(0, 0, 5, 5);
		gbc_txtTeam2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTeam2.gridx = 1;
		gbc_txtTeam2.gridy = 7;
		contentPane.add(txtTeam2, gbc_txtTeam2);
		txtTeam2.setColumns(10);
		
		JButton btnR_2Plus = new JButton("R+");
		btnR_2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// innings wrap around after 10
				Scoreboard.add_runs(2, inning % 10);
			}
		}
		);		
		GridBagConstraints gbc_btnR_2Plus = new GridBagConstraints();
		gbc_btnR_2Plus.anchor = GridBagConstraints.EAST;
		gbc_btnR_2Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnR_2Plus.gridx = 2;
		gbc_btnR_2Plus.gridy = 7;
		contentPane.add(btnR_2Plus, gbc_btnR_2Plus);
		
		JButton btnH_2Plus = new JButton("H+");
		GridBagConstraints gbc_btnH_2Plus = new GridBagConstraints();
		gbc_btnH_2Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnH_2Plus.gridx = 3;
		gbc_btnH_2Plus.gridy = 7;
		contentPane.add(btnH_2Plus, gbc_btnH_2Plus);
		
		JButton btnE_2Plus = new JButton("E+");
		GridBagConstraints gbc_btnE_2Plus = new GridBagConstraints();
		gbc_btnE_2Plus.anchor = GridBagConstraints.WEST;
		gbc_btnE_2Plus.insets = new Insets(0, 0, 5, 5);
		gbc_btnE_2Plus.gridx = 4;
		gbc_btnE_2Plus.gridy = 7;
		contentPane.add(btnE_2Plus, gbc_btnE_2Plus);
		
		JButton btnR_2Minus = new JButton("R-");
		btnR_2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// innings wrap around after 10
				Scoreboard.subtract_runs(2, inning % 10);
			}
		}
		);				
		GridBagConstraints gbc_btnR_2Minus = new GridBagConstraints();
		gbc_btnR_2Minus.anchor = GridBagConstraints.EAST;
		gbc_btnR_2Minus.insets = new Insets(0, 0, 0, 5);
		gbc_btnR_2Minus.gridx = 2;
		gbc_btnR_2Minus.gridy = 8;
		contentPane.add(btnR_2Minus, gbc_btnR_2Minus);
		
		JButton btnH_2Minus = new JButton("H-");
		GridBagConstraints gbc_btnH_2Minus = new GridBagConstraints();
		gbc_btnH_2Minus.insets = new Insets(0, 0, 0, 5);
		gbc_btnH_2Minus.gridx = 3;
		gbc_btnH_2Minus.gridy = 8;
		contentPane.add(btnH_2Minus, gbc_btnH_2Minus);
		
		JButton btnE_2Minus = new JButton("E-");
		GridBagConstraints gbc_btnE_2Minus = new GridBagConstraints();
		gbc_btnE_2Minus.anchor = GridBagConstraints.WEST;
		gbc_btnE_2Minus.insets = new Insets(0, 0, 0, 5);
		gbc_btnE_2Minus.gridx = 4;
		gbc_btnE_2Minus.gridy = 8;
		contentPane.add(btnE_2Minus, gbc_btnE_2Minus);
				
	}

}
