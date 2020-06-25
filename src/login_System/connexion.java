package login_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class connexion extends JFrame {

	private JFrame frame;
	private JPasswordField mdp;
	private JTextField id;
	Connection cn= ConnexionDB.getConnexion();
	PreparedStatement ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
					window.frame.setVisible(true);
				    window.frame.setLocationRelativeTo(null);  // pr placer au milieu

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public connexion(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Connectez Vous");
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 601, 368);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel message = new JLabel("");
		message.setFont(new Font("Kinnari", Font.BOLD | Font.ITALIC, 16));
		
		id = new JTextField();
		id.setColumns(10);
		
		mdp = new JPasswordField();
		
		JButton btnConnexion = new JButton("Connexion >");
		btnConnexion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					//A SQL statement is precompiled and stored in a PreparedStatement object.
					ps=cn.prepareStatement("SELECT login, password FROM connect WHERE login = ? AND password = ?");
					
					ps.setString(1, id.getText());	
					ps.setString(2, String.valueOf(mdp.getPassword()));
					
					ResultSet rs= ps.executeQuery();
					if (rs.next()) {
						//Preloader preload= new Preloader();
						Accueil ac=new Accueil();
						ac.setVisible(true);
						ac.setLocationRelativeTo(null);
						frame.dispose();
						
					}
					else {
						message.setText("Invalide Coordonnées, Veuillez verifier");
						message.setForeground(Color.RED);
					}
					
				}
				catch(Exception exep) {
					JOptionPane.showMessageDialog(frame, exep.getMessage());
				}

			}
		});
		btnConnexion.setForeground(new Color(255, 255, 255));
		btnConnexion.setBackground(new Color(0, 0, 128));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try {
					//A SQL statement is precompiled and stored in a PreparedStatement object.
					ps=cn.prepareStatement("SELECT login, password FROM connect WHERE login = ? AND password = ?");
					
					ps.setString(1, id.getText());	
					ps.setString(2, String.valueOf(mdp.getPassword()));
					
					ResultSet rs= ps.executeQuery();
					if (rs.next()) {
						//Preloader preload= new Preloader();
						Accueil ac=new Accueil();
						ac.setVisible(true);
						ac.setLocationRelativeTo(null);
						frame.dispose();
						
					}
					else {
						message.setText("Invalide Coordonnées, Veuillez verifier");
						message.setForeground(Color.RED);
					}
					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
				
			}
		});
		
		JLabel lblIdBibliotcaire = new JLabel("ID Bibliothécaire");
		lblIdBibliotcaire.setFont(new Font("FreeSerif", Font.BOLD, 15));
		
		JLabel lblMotDePasse = new JLabel("Mot De Passe");
		lblMotDePasse.setFont(new Font("FreeSerif", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ahed/Desktop/biblio1.png"));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("/home/ahed/Desktop/biblio1.png"));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("/home/ahed/Desktop/polytech.png"));
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
									.addGap(50)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(115)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIdBibliotcaire)
										.addComponent(lblMotDePasse))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(id)
										.addComponent(mdp, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
							.addGap(114))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(258))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(message, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
							.addGap(175))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdBibliotcaire))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMotDePasse)
						.addComponent(mdp, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(message, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
