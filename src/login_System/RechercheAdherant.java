package login_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercheAdherant extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
    Connection con=ConnexionDB.getConnexion();
    Statement stmt;
    ResultSet rs;
    String query;
    private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheAdherant frame = new RechercheAdherant();
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
	public RechercheAdherant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Rechercher un Adherant par Type");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("FreeSerif", Font.BOLD, 27));
		
		JComboBox c1 = new JComboBox();
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		    	try {
		    		
			        query="select * from adherant where Type='"+c1.getSelectedItem()+"';";
			        stmt=con.createStatement();
			        rs=stmt.executeQuery(query); 
			        DefaultTableModel model=(DefaultTableModel)table.getModel();
			        model.setRowCount(0); // bech kol manseleksiouni yfaskh l9dim w yaawd yafichili jdid
			        while(rs.next()) {
			            String ID=rs.getString("ID");
			            String Nom=rs.getString("Nom");
			            String Prenom=rs.getString("Prenom");
			            String Adresse=rs.getString("Adresse");
			            String Type=rs.getString("Type");
			            Object[] row = {ID,Nom,Prenom,Adresse,Type};
			            model.addRow(row);
			        }
		        }
		    	
		        catch(Exception e)
		        {
		            System.out.println(e);
		        }
				
			}
		});
		c1.setModel(new DefaultComboBoxModel(new String[] {"Etudiant", "Enseignant", "Visiteur"}));
		c1.setForeground(Color.BLACK);
		c1.setFont(new Font("FreeSerif", Font.BOLD, 14));
		c1.setBackground(new Color(176, 196, 222));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/searchME.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Accueil ac=new Accueil();
				ac.setVisible(true);
				dispose();
			}
		});
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnRetour.setBackground(new Color(255, 127, 80));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(277, Short.MAX_VALUE)
					.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(268))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(173)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(c1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(c1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nom", "Prenom", "Adresse", "Type"
			}
		));
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
