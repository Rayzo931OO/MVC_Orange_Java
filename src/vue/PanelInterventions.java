package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.Intervention;
import controleur.Materiel;
import controleur.Admin;

public class PanelInterventions extends PanelPrincipal implements ActionListener
{

	private JTextArea txtDescription = new JTextArea(); 
	private JTextField txtDateInter = new JTextField(); 
	private JTextField txtPrix = new JTextField(); 
	private JComboBox<String> txtIdTechnicien = new JComboBox<String>(); 
	private JComboBox<String> txtIdMateriel = new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer= new JButton("Enregistrer");
	
	private JPanel panelForm = new JPanel(); 
	
	public PanelInterventions( ) {
		super(Color.blue);
		//placement du panel formulaire 
		this.panelForm.setBounds(50, 50, 300, 250);
		this.panelForm.setBackground(new Color ( 181, 135, 79  ));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Description : ")); 
		this.panelForm.add(this.txtDescription); 
		this.panelForm.add(new JLabel("Date Inter : ")); 
		this.panelForm.add(this.txtDateInter);
		this.panelForm.add(new JLabel("Prix Inter : ")); 
		this.panelForm.add(this.txtPrix);
		this.panelForm.add(new JLabel("Le Technicien ")); 
		this.panelForm.add(this.txtIdTechnicien);
		this.panelForm.add(new JLabel("Le Matériel ")); 
		this.panelForm.add(this.txtIdMateriel);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm); 
		this.panelForm.setVisible(true);
		
		//remplir lesCBX Materiels et techniciens 
		this.remplirCBX();
		
		//rendre les deux boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}
	public void remplirCBX () {
		ArrayList<Materiel> lesMateriels = Controleur.selectAllMateriels(""); 
		for (Materiel unMateriel : lesMateriels) {
			this.txtIdMateriel.addItem(unMateriel.getIdmateriel()+"-"+unMateriel.getDesignation());
		}
		
		ArrayList<Admin> lesTechniciens = Controleur.selectAllTechniciens(); 
		for (Admin unTechnicien : lesTechniciens) {
			this.txtIdTechnicien.addItem(unTechnicien.getIdtechnicien()+"-"
					+ unTechnicien.getNom());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtDescription.setText("");
			this.txtDateInter.setText("");
			this.txtPrix.setText("");
		}
		else if (e.getSource() == this.btEnregistrer) {
			String description = this.txtDescription.getText(); 
			String dateinter = this.txtDateInter.getText();
			float prix = 0; 
			try {
				prix = Float.parseFloat(this.txtPrix.getText()); 
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Erreur prix");
			}
			//recupération des ID :
			String chaine = this.txtIdTechnicien.getSelectedItem().toString(); 
			String tab [] = chaine.split("-"); 
			int idTechnicien = Integer.parseInt(tab[0]);
			
			chaine = this.txtIdMateriel.getSelectedItem().toString(); 
			tab = chaine.split("-"); 
			int idMateriel = Integer.parseInt(tab[0]);
			
			//instancier une intervention
			Intervention uneIntervention = new Intervention(description, dateinter, 
												prix, idTechnicien, idMateriel);
			//on l'insère dans la BDD 
			Controleur.insertIntervention (uneIntervention); 
			JOptionPane.showMessageDialog(this, "Insertion réussie de l'intervention");
			this.txtDescription.setText("");
			this.txtDateInter.setText("");
			this.txtPrix.setText("");
		}
	}
}



















 