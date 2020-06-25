package login_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerDocument extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	Connection con= ConnexionDB.getConnexion();
	Statement stmt;
	ResultSet rs;
	String query;
	private JTextField t7;
	private JTextField t6;
	private JTextField t5;
	private JTextField t3;
	private JTextField t4;
	private JTextField t2;
	private JTextField t1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerDocument frame = new SupprimerDocument();
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
	public SupprimerDocument() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Supprimer un document");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("FreeSerif", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.RED);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/delete2.png"));
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

				try {
						query="DELETE FROM books WHERE BookId = '"+t1.getText()+"';";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Supprimer avec succées");
						
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						
					}
					catch(SQLException exp) {
						System.out.println(exp.getMessage());
					}
				
			}
		});
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setFont(new Font("FreeSerif", Font.BOLD, 14));
		btnSupprimer.setBackground(new Color(0, 128, 0));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Accueil ac=new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("FreeSerif", Font.BOLD, 14));
		btnAnnuler.setBackground(Color.RED);
		
		JLabel lblQuantitDexemplaire = new JLabel("Qté d'exemplaire");
		
		t7 = new JTextField();
		t7.setEnabled(false);
		t7.setColumns(10);
		
		JLabel lblIdDeDocument = new JLabel("ID de Document");
		
		JLabel lblNomDeDocument = new JLabel("Nom de Document");
		
		JLabel lblLauteur = new JLabel("Auteur");
		
		JLabel lblType = new JLabel("Type");
		
		JLabel lblDisponibilit = new JLabel("Disponibilité");
		
		JLabel lblLocalisation = new JLabel("Localisation");
		
		t6 = new JTextField();
		t6.setEnabled(false);
		t6.setColumns(10);
		
		t5 = new JTextField();
		t5.setEnabled(false);
		t5.setColumns(10);
		
		t3 = new JTextField();
		t3.setEnabled(false);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setEnabled(false);
		t4.setColumns(10);
		
		t2 = new JTextField();
		t2.setEnabled(false);
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
				catch (SQLException exp) {
					JOptionPane.showMessageDialog(frame, exp.getMessage(), "Erreur de Connexion ",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		t1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuantitDexemplaire, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(t7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(285)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(264, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLocalisation, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(60))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(97))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDisponibilit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(57)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(t4, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addComponent(t5, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(t6, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdDeDocument, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(51))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNomDeDocument, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLauteur, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(90)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addGap(147))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdDeDocument)
							.addGap(20)
							.addComponent(lblNomDeDocument)
							.addGap(24)
							.addComponent(lblLauteur)
							.addGap(4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(t1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(t2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(t3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(1)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblType)
							.addGap(30)
							.addComponent(lblDisponibilit)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(lblLocalisation))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(t4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(t5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(t6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblQuantitDexemplaire))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(t7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(18))))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
