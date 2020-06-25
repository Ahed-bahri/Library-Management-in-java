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

public class AjouterDocument extends JFrame {

	private JPanel contentPane;
	private JTextField t7;
	private JTextField t6;
	private JTextField t5;
	private JTextField t4;
	private JTextField t3;
	private JTextField t2;
	private JTextField t1;
	private JFrame frame;
	Connection con = ConnexionDB.getConnexion();
	String query;
	Statement stmt;
	ResultSet rs;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterDocument frame = new AjouterDocument();
					frame.setVisible(true);
				    frame.setLocationRelativeTo(null);  // pr placer au milieu
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AjouterDocument() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 672);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAjouterUnDocument = new JLabel("Ajouter Un Document");
		lblAjouterUnDocument.setForeground(new Color(139, 69, 19));
		lblAjouterUnDocument.setFont(new Font("FreeSerif", Font.BOLD, 22));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/add2.png"));
		
		JLabel lblIdDeDocument = new JLabel("ID de document");
		
		JLabel lblNomDeDocument = new JLabel("Nom de document");
		
		JLabel lblAuteur = new JLabel("Auteur");
		
		JLabel lblType = new JLabel("Type");
		lblType.setToolTipText("");
		
		JLabel lblDisponibilit = new JLabel("Disponibilité");
		
		JLabel lblLocalisation = new JLabel("Localisation");
		
		JLabel lblQuantitDexemplaire = new JLabel("Quantité d'exemplaire");
		
		t7 = new JTextField();
		t7.setColumns(10);
		
		t6 = new JTextField();
		t6.setColumns(10);
		
		t5 = new JTextField();
		t5.setText("YES / NO");
		t5.setForeground(Color.GRAY);
		t5.setColumns(10);
		
		t4 = new JTextField();
		t4.setForeground(Color.GRAY);
		t4.setText("Document, Livre, Magazines");
		t4.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer L'ID de Document.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t2.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Le Nom de Document.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t3.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Le Prenom d'auteur.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);
				}
				else if (t4.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Le Type de Document.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else if (t5.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer La Disponiblité Type.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else if (t6.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer La Localisation exacte.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else if (t7.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Veuillez Inserer Quantité d'exemplaire.", "Erreur de Remplissage", JOptionPane.WARNING_MESSAGE);

				}
				else {
					try {
						query="insert into books values ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"');";
						stmt=con.createStatement();
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(frame, "Document Ajouter Votre ID='"+t1.getText()+"'");
						
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						
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
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnAjouter.setBackground(new Color(0, 128, 0));
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac=new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnNewButton.setBackground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(72))
								.addComponent(lblAjouterUnDocument, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblIdDeDocument, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(t1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNomDeDocument, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(t2, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
										.addComponent(t4, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblAuteur, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(t3, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblLocalisation, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDisponibilit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(t5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
											.addComponent(t6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQuantitDexemplaire, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(t7, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjouterUnDocument, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdDeDocument)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomDeDocument))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAuteur)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisponibilit))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocalisation))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantitDexemplaire))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
