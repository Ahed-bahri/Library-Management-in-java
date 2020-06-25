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
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmprunterLivre extends JFrame {

	private JPanel contentPane;
	private JTextField idetudiant;
	private JTextField prenomE;
	private JTextField idL;
	private JTextField dispo;
	private JTextField nomL;
	private JTextField typeL;
	private JTextField dateE;
	private JFrame frame;

    Connection con = ConnexionDB.getConnexion();
    
    Statement stmt;
    ResultSet rs;
    String query;
    Date date=new Date();
    
    // formatting means converting date to string
    SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
    
    String SName,Address;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprunterLivre frame = new EmprunterLivre();
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
	public EmprunterLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEmprunter = new JLabel("Emprunter un Livre");
		lblEmprunter.setForeground(new Color(255, 69, 0));
		lblEmprunter.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 21));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/tpe1.1.png"));
		
		JLabel lblIdEtudiant = new JLabel("ID Adherant");
		
		idetudiant = new JTextField();
									
									/*============================================================ */
									//	   When you Write the ID Of Adherant and Retriveve Data
									/*============================================================= */	
		
		
		idetudiant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			       try{
//When i type the Student ID I want to have his nom & prenom & adress , prenom we will use it in form and adress and name in saving issue 
			    	   query="select * from adherant where ID ='"+idetudiant.getText()+"';";
			            stmt=con.createStatement(); 
			            rs=stmt.executeQuery(query); 
			            if(rs.next()){
			                SName=rs.getString("Prenom");
			                Address=rs.getString("Adresse");
			                prenomE.setText(SName);
			            }			            
			            else
			            	prenomE.setText("");
			        }
			        catch(Exception exp) {
			            System.out.println(exp);
			        }
			       //Set the date in this format
			       dateE.setText(format.format(date));
			}
		});
		
										/*=============================================== */
										//						END 1
										/*=============================================== */	
									

		idetudiant.setColumns(10);
		
		JLabel lblPrenomEtudiant = new JLabel("Prenom Adherant");
		
		prenomE = new JTextField();
		prenomE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		prenomE.setEnabled(false);
		prenomE.setColumns(10);
		
		JLabel lblIdLivre = new JLabel("ID Livre");
		
		idL = new JTextField();
									/*===================================================== */
									//	When you Type the ID of Book and Retriveve Data
									/*===================================================== */
		
		idL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			    try {
			    	//When i type the book id the dispo, name , type will be shown
		            query="select * from books where BookId='"+idL.getText()+"';";
		            stmt=con.createStatement(); 
		            rs=stmt.executeQuery(query); 
		            if(rs.next()) {
		            	dispo.setText(rs.getString("Available"));
		            	nomL.setText(rs.getString("BookName"));
		            	typeL.setText(rs.getString("Type"));
		            	
		            }
		            else{
		            	
		            	dispo.setText("");
		            	nomL.setText("");
		            	typeL.setText("");
		            }
		        }
		        catch(Exception exp)  {
		            System.out.println(exp);
		        }	
			}
		});
		
												/*=============================================== */
												//						END 2
												/*=============================================== */	
		idL.setColumns(10);
		
		JLabel lblDisponible = new JLabel("Disponible");
		
		dispo = new JTextField();
		dispo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dispo.setEnabled(false);
		dispo.setColumns(10);
		
		JLabel lblNomLivre = new JLabel("Nom Livre");
		
		nomL = new JTextField();
		nomL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nomL.setEnabled(false);
		nomL.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		
		typeL = new JTextField();
		typeL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		typeL.setEnabled(false);
		typeL.setColumns(10);
		
		JLabel lblDateDemprunte = new JLabel("Date d'Emprunte");
		
		dateE = new JTextField();
		dateE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateE.setEnabled(false);
		dateE.setColumns(10);
		
		JButton btnEmprunter = new JButton("Emprunter");
		btnEmprunter.addActionListener(new ActionListener() {

			
								
								/*=============================================== */
								//			When you click on Emprunt Button
								/*=============================================== */	
											
/*=============================================== *						/*=============================================== */
//1-	Insert The Data in Issue									//		2-	Update Availability in Books Table
/*=============================================== */					/*=============================================== */


/* ****************************************************************************************************************************************************** */	

								/*=============================================== */
								//		OR (Book Not Available) OR (Not Found)
								/*=============================================== */	
												
/*=============================================== *								/*=============================================== */
//1-	ShowMessageDialog														//			2-	Reset Fields to Void
/*=============================================== */							/*=============================================== */
			public void actionPerformed(ActionEvent arg0) {//YABDA
							
				if (prenomE.getText().equals("")){
					
					JOptionPane.showMessageDialog(frame, "Vous devez être un adherant pour emprunter","Inscrivez-Vous !",JOptionPane.ERROR_MESSAGE);
					
					idetudiant.setText("");
		            prenomE.setText("");
		            idL.setText("");
		            dispo.setText("");
		            nomL.setText("");
		            typeL.setText("");
		            dateE.setText("");
				}
				
				else{
					try {
						
						//get all books have same id as inserted
			            query="select * from books where BookId='"+idL.getText()+"';";                   
			            stmt=con.createStatement(); //Statement is an interface that represent query result in a table
			            							//and in order to create statement you need connection
			            rs=stmt.executeQuery(query); 
			            if (rs.next()) {
			        	   
			        	   if(dispo.getText().equals("YES")){//if available
			        		   
			        		   //Insert his details to issue table
			        		   query="insert into issue values('"+idetudiant.getText()+"','"+prenomE.getText()+"','"+typeL.getText()+"','"+idL.getText()+"','"+nomL.getText()+"','"+Address+"','"+dateE.getText()+"');";
			        		   stmt.executeUpdate(query);   
			        		   
			        		   //Show msg that is is beend issue.
			        		   JOptionPane.showMessageDialog(frame,"Document Titulaire id = "+idL.getText()+" est emprunter à "+prenomE.getText());
			                
			        		   //update availabilty of book0
			             
			        		   query="update books set Available= 'NO' where BookId='"+idL.getText()+"'; ";
			        		   stmt.executeUpdate(query); 

						
			            	}

			        	   //If not available
			        	   if(dispo.getText().equals("NO")) {
			        		   JOptionPane.showMessageDialog(frame,"Ce Document Selectionné n'est pas disponible ");
			        	    }
			        	   // if there isn't any availability then show there is no book
			        	   if(dispo.getText().equals(""))
			        	   {
			        		   JOptionPane.showMessageDialog(frame,"On n'as pas ce Document dans notre Bibliothéque");
			        	   }
			            
				            // reset to vide
				            idetudiant.setText("");
				            prenomE.setText("");
				            idL.setText("");
				            dispo.setText("");
				            nomL.setText("");
				            typeL.setText("");
				            dateE.setText("");
			            
			           }
					}
					catch(SQLException e) {
						System.out.println(e.getMessage());
						//Maw bech y9olek duplicate primary key ==>Duplicate entry 'AHED26' for key 'PRIMARY'
					//	System.out.println(e.getErrorCode());
						 if(e.getErrorCode()==1062)
							 JOptionPane.showMessageDialog(frame,"L'etudiant doit Emprunter qu'un seul Document à la fois","Désoler",JOptionPane.ERROR_MESSAGE);
					}/*Fin catch*/
				}/*Fin else*/
			}//YOUFA
		});
		btnEmprunter.setForeground(Color.WHITE);
		btnEmprunter.setBackground(new Color(0, 100, 0));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac= new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(255, 250, 250));
		btnAnnuler.setBackground(Color.RED);
		
		JButton btnInscritmoi = new JButton("Inscrit-Moi");
		btnInscritmoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inscritption inscrit = new Inscritption();
				inscrit.setVisible(true);
				dispose();
			}
		});
		btnInscritmoi.setForeground(Color.WHITE);
		btnInscritmoi.setBackground(SystemColor.activeCaption);
		
		JLabel lblDocument = new JLabel("Document");
		lblDocument.setForeground(Color.GRAY);
		
		JLabel lblLivre = new JLabel("Livre/");
		lblLivre.setForeground(Color.GRAY);
		
		JLabel lblMagazines = new JLabel("/Magazines");
		lblMagazines.setForeground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(lblEmprunter, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(98)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEmprunter, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnInscritmoi, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(49)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDateDemprunte, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(dateE, 227, 227, 227))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(142)
											.addComponent(idetudiant, 222, 222, 222))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblIdEtudiant, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblPrenomEtudiant, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblDisponible, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblIdLivre, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(dispo, 222, 222, 222)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(idL)
													.addComponent(prenomE, 222, 222, Short.MAX_VALUE))))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(70)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNomLivre, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(47))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
											.addGap(66)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(typeL, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
										.addComponent(nomL, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblLivre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDocument))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(lblMagazines)))
							.addGap(270)))
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(lblEmprunter, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idetudiant, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdEtudiant))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(prenomE, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrenomEtudiant))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idL, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdLivre))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(dispo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDisponible))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nomL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomLivre))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(typeL, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblLivre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMagazines)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(dateE, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDateDemprunte))
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDocument)
							.addGap(109)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnInscritmoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEmprunter, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
