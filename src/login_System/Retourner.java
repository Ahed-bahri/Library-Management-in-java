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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Retourner extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t7;
	private JTextField t5;
	private JFrame frame;

	Connection con= ConnexionDB.getConnexion();
	Statement stmt;
	ResultSet rs;
	String query;
	String SName, SBook,SBname,SIssue,SType;
	Date date= new Date();
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retourner frame = new Retourner();
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
	public Retourner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRetrourner = new JLabel("Retrourner");
		lblRetrourner.setForeground(new Color(255, 69, 0));
		lblRetrourner.setFont(new Font("Georgia", Font.BOLD, 22));
		
		JLabel lblIdEtudiant = new JLabel("ID");
		
		JLabel lblPrenomEtudiant = new JLabel("Prenom");
		
		JLabel lblIdDocument = new JLabel("ID Document");
		
		JLabel lblNomDocument = new JLabel("Nom Document");
		
		JLabel lblDateDemprunt = new JLabel("Date d'emprunt");
		
		JLabel lblDateRetour = new JLabel("Date Retour");
		
		t1 = new JTextField();
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {	
					//1- "		//2- '"+ +"'   //3- ;"
					query="SELECT * FROM issue WHERE ID='"+t1.getText() +"'; ";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);

					while (rs.next()){
						
						SName=rs.getString("Prenom");
						SType=rs.getString("Type");
						SBook=rs.getString("BookId");
						SBname=rs.getString("BookName");
						SIssue=rs.getString("IssueDate");
						t2.setText(SName);
						t3.setText(SType);
						t4.setText(SBook);
						t5.setText(SBname);
						t6.setText(SIssue);
					}
						
				}
				catch(SQLException exp) {
					System.out.println(exp.getMessage());
				}
				
				t7.setText(format.format(date));
			} 
		});
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setForeground(new Color(165, 42, 42));
		t2.setEnabled(false);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setEnabled(false);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setEnabled(false);
		t4.setColumns(10);
		
		t6 = new JTextField();
		t6.setEnabled(false);
		t6.setColumns(10);
		
		t7 = new JTextField();
		t7.setEnabled(false);
		t7.setColumns(10);
		
		JButton btnRetourner = new JButton("Retourner");
		btnRetourner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					query="select * from issue where ID ='"+t1.getText()+"'; ";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);
					
					if (rs.next()) {
																																							    	
						query="insert into returndetail values('"+t1.getText()+"','"+t2.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"');";
						stmt.executeUpdate(query);

						query="delete from issue where ID='"+t1.getText()+"';";
						stmt.executeUpdate(query);
						
						query="update books set Available= 'YES' where BookId='"+t4.getText()+"'; ";
						stmt.executeUpdate(query);
						
						JOptionPane.showMessageDialog(frame,"Merci Pour Votre Visite");
						
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						
					}
					else{
						JOptionPane.showMessageDialog(frame,"Ce Document n'est pas emprunter !");
					}
				}
								
				catch(Exception e) {
					JOptionPane.showMessageDialog(frame,e.getMessage());
				}
			}
		});
		btnRetourner.setForeground(new Color(253, 245, 230));
		btnRetourner.setBackground(new Color(0, 100, 0));
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac=new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(253, 245, 230));
		btnAnnuler.setBackground(Color.RED);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/1.png"));
		
		JLabel lblTypeDocument = new JLabel("Type Doc");
		
		t5 = new JTextField();
		t5.setEnabled(false);
		t5.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(156)
									.addComponent(t6, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblIdDocument, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDateDemprunt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNomDocument, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTypeDocument, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblIdEtudiant, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPrenomEtudiant, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addGap(33)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(t3, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
										.addComponent(t2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
										.addComponent(t1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
										.addComponent(t4, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
										.addComponent(t5, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDateRetour, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addGap(33)
											.addComponent(t7, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnRetourner, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
											.addGap(38)
											.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap(118, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRetrourner, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(83)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(38))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblRetrourner, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdEtudiant))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrenomEtudiant))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTypeDocument))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdDocument)
						.addComponent(t4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomDocument))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateDemprunt))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(t7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateRetour))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRetourner, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
