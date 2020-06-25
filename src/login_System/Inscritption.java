package login_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Inscritption extends JFrame {

	private JPanel contentPane;
	private JTextField t5;
	private JTextField t3;
	private JTextField t2;
	private JTextField t1;
	private JTextField t4;

	private JFrame frame;
	Connection con = ConnexionDB.getConnexion();
	String query;
	Statement stmt;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscritption frame = new Inscritption();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inscritption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Liberation Serif", Font.BOLD, 23));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/b.png"));
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNom = new JLabel("Nom");
		
		JLabel lblType = new JLabel("Type");
		
		JLabel lblAdresse = new JLabel("Adresse");
		
		JLabel lblPrenom = new JLabel("Prenom");
		
		t5 = new JTextField();
		t5.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setColumns(10);
		
		t4 = new JTextField();
		t4.setColumns(10);
		
		JLabel lbletudiantenseignantvisiteur = new JLabel("(Etudiant/Enseignant/Visiteur)");
		lbletudiantenseignantvisiteur.setForeground(new Color(105, 105, 105));
		
		JButton btnInscritmoi = new JButton("Inscrit-Moi");
		btnInscritmoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Votre ID.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t2.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Votre Nom.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t3.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Votre Prenom.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t4.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Votre Adresse.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else if (t5.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Votre Type.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else {
					try {
						query="insert into adherant values ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"');";
						stmt=con.createStatement();
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(frame, "Merci d'Inscrire Voila Votre ID='"+t1.getText()+"'");
						
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						
					}
					catch(SQLException exp) {
						if (exp.getErrorCode()==1062) {
							JOptionPane.showMessageDialog(frame, "Ce ID exite déja","Erreur ID",JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(frame,exp.getMessage());
						}
					}
					
				}
			}
		});
		btnInscritmoi.setForeground(Color.WHITE);
		btnInscritmoi.setBackground(new Color(0, 100, 0));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac= new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(71))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPrenom, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(t1, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
												.addComponent(t3, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
												.addComponent(t2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblAdresse, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(15)
													.addComponent(lbletudiantenseignantvisiteur, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(t5, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
														.addComponent(t4, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))))))
									.addGap(36))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(btnInscritmoi, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNom))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrenom))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(t4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresse))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(t5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbletudiantenseignantvisiteur, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInscritmoi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
