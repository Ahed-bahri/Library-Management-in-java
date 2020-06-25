package login_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Accueil extends JFrame{

	private JFrame frame;
	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
					frame.setVisible(true);
				    frame.setLocationRelativeTo(null);  // pr placer au milieu
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblQueVoulezVous = new JLabel("Que voulez vous faire aujourd'hui ?");
		lblQueVoulezVous.setForeground(new Color(255, 102, 0));
		lblQueVoulezVous.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 18));
		
		JButton btnarchive = new JButton("Supprimer un Adherant");
		btnarchive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        SupprimerAdherant sa =new SupprimerAdherant();
		        sa.setVisible(true);
		        setVisible(false);
			}
		});
		btnarchive.setForeground(new Color(245, 245, 245));
		btnarchive.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnarchive.setBackground(new Color(25, 25, 112));
		
		JButton btnemprunter = new JButton("Emprunter");
		btnemprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            	btnemprunterActionPerformed(arg0);

			}
		});
		btnemprunter.setForeground(new Color(245, 245, 245));
		btnemprunter.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnemprunter.setBackground(new Color(0, 100, 0));
		
		JButton btnretourner = new JButton("Retourner");
		btnretourner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Retourner ret = new Retourner();
				ret.setVisible(true);
				dispose();
			}
		});
		btnretourner.setForeground(new Color(245, 245, 245));
		btnretourner.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnretourner.setBackground(new Color(0, 128, 0));
		
		JButton btnajouterDoc = new JButton("Modifier un Adherant");
		btnajouterDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModifierAdherant ma = new ModifierAdherant();
				ma.setVisible(true);
				dispose();
			}
		});
		btnajouterDoc.setForeground(new Color(245, 245, 245));
		btnajouterDoc.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnajouterDoc.setBackground(new Color(0, 0, 139));
		
		JButton btnajouterAdh = new JButton("Ajouter un Adherant");
		btnajouterAdh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inscritption inscrit = new Inscritption();
				inscrit.setVisible(true);
				setVisible(false);
			}
		});
		btnajouterAdh.setForeground(Color.WHITE);
		btnajouterAdh.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnajouterAdh.setBackground(SystemColor.activeCaption);
		
		JButton btnstat = new JButton("Chercher par Type");
		btnstat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RechercheAdherant ra = new RechercheAdherant();
				ra.setVisible(true);
				dispose();
			}
		});
		btnstat.setForeground(new Color(245, 245, 245));
		btnstat.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnstat.setBackground(new Color(25, 25, 112));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/ahed/Desktop/book2.2.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ahed/Desktop/tpe1.1.png"));
		
		JButton btnAjouterUnDocument = new JButton("Ajouter un Document");
		btnAjouterUnDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        AjouterDocument aj =new AjouterDocument();
		        aj.setVisible(true);
		        dispose();
			}
		});
		btnAjouterUnDocument.setForeground(new Color(245, 245, 245));
		btnAjouterUnDocument.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnAjouterUnDocument.setBackground(new Color(165, 42, 42));
		
		JButton btnModifierUnDocument = new JButton("Modifier un Document");
		btnModifierUnDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        ModificationLivre ml =new ModificationLivre();
		        ml.setVisible(true);
		        dispose();
			}
		});
		btnModifierUnDocument.setForeground(new Color(245, 245, 245));
		btnModifierUnDocument.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnModifierUnDocument.setBackground(new Color(165, 42, 42));
		
		JButton btnChercherParType = new JButton("Chercher par Type");
		btnChercherParType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        AffichageDocuments ad =new AffichageDocuments();
		        ad.setVisible(true);
		        dispose();
			}
		});
		btnChercherParType.setForeground(new Color(245, 245, 245));
		btnChercherParType.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnChercherParType.setBackground(new Color(165, 42, 42));
		
		JButton btnSupprimerUnDocument = new JButton("Supprimer un Document");
		btnSupprimerUnDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        SupprimerDocument sd =new SupprimerDocument();
		        sd.setVisible(true);
		        dispose();
			}
		});
		btnSupprimerUnDocument.setForeground(new Color(245, 245, 245));
		btnSupprimerUnDocument.setFont(new Font("FreeSerif", Font.BOLD, 17));
		btnSupprimerUnDocument.setBackground(new Color(165, 42, 42));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/ahed/Desktop/fiche2.2.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(254)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(246)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAjouterUnDocument, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChercherParType, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnemprunter, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnajouterAdh, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnstat, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
							.addGap(92)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnretourner, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnajouterDoc, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnarchive, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModifierUnDocument, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSupprimerUnDocument, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(291)
							.addComponent(lblNewLabel_2)))
					.addGap(59))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(233)
					.addComponent(lblQueVoulezVous, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(267, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblQueVoulezVous, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnemprunter)
							.addGap(43)
							.addComponent(btnajouterAdh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnstat)
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnretourner, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnajouterDoc)
							.addGap(18)
							.addComponent(btnarchive)))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAjouterUnDocument)
						.addComponent(btnModifierUnDocument))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChercherParType)
						.addComponent(btnSupprimerUnDocument))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		}
	private void btnemprunterActionPerformed(ActionEvent evt) {
		EmprunterLivre el = new EmprunterLivre();
		el.setVisible(true);
		dispose();
	}
}
