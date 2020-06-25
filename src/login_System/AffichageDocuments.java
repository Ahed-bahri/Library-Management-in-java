package login_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AffichageDocuments extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					AffichageDocuments frame = new AffichageDocuments();
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
	public AffichageDocuments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/ahed/Desktop/info2.png"));
		
		JLabel lblCatalogueDeLa = new JLabel("Catalogue de la Bibliothéque");
		lblCatalogueDeLa.setForeground(new Color(25, 25, 112));
		lblCatalogueDeLa.setFont(new Font("FreeSerif", Font.BOLD, 30));
		
		JComboBox c1 = new JComboBox();
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		    		
			        query="select * from books where Type='"+c1.getSelectedItem()+"';";
			        stmt=con.createStatement();
			        rs=stmt.executeQuery(query); 
			        DefaultTableModel model=(DefaultTableModel)table.getModel();
			        model.setRowCount(0); // bech kol manseleksiouni yfaskh l9dim w yaawd yafichili jdid
			        while(rs.next())
			        {
			            String BookId=rs.getString("BookId");
			            String BookName=rs.getString("BookName");
			            String Author=rs.getString("Author");
			            String Type=rs.getString("Type");
			            String Available=rs.getString("Available");
			            String Locate=rs.getString("Locate");
			            String NumberExmp=rs.getString("NumberExmp");
			            
			            Object[] row = {BookId,BookName,Author,Type,Available,Locate,NumberExmp};
			            model.addRow(row);
			        }
		        }
		    	
		        catch(Exception e)
		        {
		            System.out.println(e);
		        }
			}
		});
		c1.setModel(new DefaultComboBoxModel(new String[] {"Document", "Livre", "Magazines"}));
		
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
		btnRetour.setFont(new Font("FreeSerif", Font.BOLD, 16));
		btnRetour.setBackground(new Color(25, 25, 112));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(246, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCatalogueDeLa, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(c1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
					.addGap(161))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(378, Short.MAX_VALUE)
					.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(301))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCatalogueDeLa, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(c1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nom", "Auteur", "Type", "Disponibilt\u00E9", "Localisation", "Quantit\u00E9"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
