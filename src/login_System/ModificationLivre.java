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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificationLivre extends JFrame {

	private JPanel contentPane;
	private JTextField t7;
	private JTextField t6;
	private JTextField t5;
	private JTextField t4;
	private JTextField t3;
	private JTextField t2;
	private JTextField t1;
	private JFrame frame;
	Connection con=ConnexionDB.getConnexion();
	Statement stmt;
	ResultSet rs;
	String query;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificationLivre frame = new ModificationLivre();
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
	public ModificationLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/opo.png"));
		
		JLabel lblDocumentId = new JLabel("ID de document");
		
		JLabel lblNomDeDocument = new JLabel("Nom de document");
		
		JLabel lblLauteur = new JLabel("Auteur");
		
		JLabel lblTypeDeDocument = new JLabel("Type de document");
		
		JLabel lblDisponibilit = new JLabel("Disponibilité");
		
		JLabel lblLocalisation = new JLabel("Localisation");
		
		JLabel lblQuantitDexemplaire = new JLabel("Qté d'exemplaire");
		
		t7 = new JTextField();
		t7.setColumns(10);
		
		t6 = new JTextField();
		t6.setColumns(10);
		
		t5 = new JTextField();
		t5.setColumns(10);
		
		t4 = new JTextField();
		t4.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
					query="SELECT * FROM books WHERE BookId = '"+t1.getText()+"'";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);
					while (rs.next()) {
						
						String BookName=rs.getString("BookName");
						String Author=rs.getString("Author");
						String Type=rs.getString("Type");
						String Available=rs.getString("Available");
						String Locate=rs.getString("Locate");
						int NumberExmp=rs.getInt("NumberExmp");
							
						t2.setText(BookName);
						t3.setText(Author);
						t4.setText(Type);
						t5.setText(Available);
						t6.setText(Locate);
						t7.setText(String.valueOf(NumberExmp)); //to convert into string
								
					}
				}
				catch(SQLException exp) {
					JOptionPane.showMessageDialog(frame, exp.getMessage(), "Erreur de Connexion ",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		t1.setColumns(10);
		
		JButton btnMajDocument = new JButton("MAJ Document");
		btnMajDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					query="UPDATE books SET BookId='"+t1.getText()+"',BookName='"+t2.getText()+"', Author='"+t3.getText()+"',Type='"+t4.getText()+"',Available='"+t5.getText()+"',Locate='"+t6.getText()+"',NumberExmp='"+t7.getText()+"' WHERE bookId='"+t1.getText()+"'; "; 
					stmt.executeUpdate(query);
					
					JOptionPane.showMessageDialog(frame,"Document est MAJ avec succées.", "C'est fait ",JOptionPane.INFORMATION_MESSAGE);
					
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					
					
				}
				catch(SQLException e) {
					JOptionPane.showMessageDialog(frame, e.getMessage(), "Erreur de Connexion ",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		btnMajDocument.setForeground(Color.WHITE);
		btnMajDocument.setFont(new Font("FreeSerif", Font.BOLD, 14));
		btnMajDocument.setBackground(new Color(0, 128, 0));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac= new Accueil();
				ac.setVisible(true);
				dispose();		
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("FreeSerif", Font.BOLD, 14));
		btnAnnuler.setBackground(Color.RED);
		
		JLabel lblModification = new JLabel("Modification les donnees des documents");
		lblModification.setForeground(new Color(65, 105, 225));
		lblModification.setFont(new Font("Liberation Serif", Font.BOLD, 19));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(242)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModification, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNomDeDocument, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(9)
											.addComponent(lblLauteur, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblTypeDeDocument, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDisponibilit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLocalisation, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuantitDexemplaire, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDocumentId, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(t1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t7, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t6, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t5, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
										.addComponent(t3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(btnMajDocument, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblModification, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumentId)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomDeDocument)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLauteur))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeDeDocument)
						.addComponent(t4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDisponibilit)
						.addComponent(t5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalisation)
						.addComponent(t6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantitDexemplaire)
						.addComponent(t7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMajDocument, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
