package vue;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.TabExpander;

import controleur.Controleur;
import controleur.Materiel;
import controleur.Tableau;

public class PanelMateriels extends PanelPrincipal implements ActionListener
{

	private JPanel panelForm = new JPanel();
	private JTextField txtNom = new JTextField();
	private JTextField txtDescription = new JTextField();
	// private JComboBox<String> txtCategorie = new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer= new JButton("Enregistrer");

	private JTable tableMateriels ;
	private JScrollPane uneScroll ;
	private Tableau unTableau ;

	private JPanel panelRech = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltre = new JButton("Filtrer");

	private JLabel lbMateriels;

	public PanelMateriels( ) {
		super(new Color ( 181, 135, 79  ));
		//remplir le Combox de la catégorie
		// this.txtCategorie.addItem("Téléphonie");
		// this.txtCategorie.addItem("Box Internet");
		// this.txtCategorie.addItem("Télévision");
		// this.txtCategorie.addItem("Autres");

		//placement du panel formulaire
		this.panelForm.setBounds(50, 50, 300, 250);
		this.panelForm.setBackground(new Color ( 181, 135, 79  ));
		this.panelForm.setLayout(new GridLayout(3,2));
		this.panelForm.add(new JLabel("Désignation : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Description : "));
		this.panelForm.add(this.txtDescription);
		// this.panelForm.add(new JLabel("Categorie : "));
		// this.panelForm.add(this.txtCategorie);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm);
		this.panelForm.setVisible(true);

		//construction de la Jtable des materiels
		String entetes [] = {"ID Matériel", "Nom", "Description"};
		this.unTableau = new Tableau (entetes, this.obtenirDonnees(""));
		this.tableMateriels = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(this.tableMateriels);
		this.uneScroll.setBounds(400, 80,400, 220);
		this.add(this.uneScroll);

		//placement du panel filtre
		this.panelRech.setBounds(450, 10, 300, 20);
		this.panelRech.setBackground(new Color ( 181, 135, 79  ));
		this.panelRech.setLayout(new GridLayout(1,3));
		this.panelRech.add(new JLabel("Filtrer par : "));
		this.panelRech.add(this.txtFiltre);
		this.panelRech.add(this.btFiltre);
		this.panelRech.setVisible(true);
		this.add(this.panelRech);

		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltre.addActionListener(this);

		//interdiction de déplacement des colonnes
		this.tableMateriels.getTableHeader().setReorderingAllowed(false);

		//ajout d'un MouseListener pour suppression et modification.
		this.tableMateriels.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne = 0;
				int idMateriel = 0;
				if (e.getClickCount()>=2) {
					numLigne = tableMateriels.getSelectedRow();
					idMateriel= Integer.parseInt(tableMateriels.getValueAt(numLigne, 0).toString());
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce materiel",
							"Suppression Matérielle", JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						//suppression dans la BDD
						Controleur.deleteMateriel(idMateriel);
						//suppression dans l'affichage de la table
						unTableau.supprimerLigne(numLigne);
						lbMateriels.setText("Nombre de matériels disponibles :"+unTableau.getRowCount());
					}
				}
				else {
					numLigne = tableMateriels.getSelectedRow();
					idMateriel= Integer.parseInt(tableMateriels.getValueAt(numLigne, 0).toString());
					String nom = tableMateriels.getValueAt(numLigne, 1).toString();
					String description = tableMateriels.getValueAt(numLigne, 2).toString();
					// String categorie = tableMateriels.getValueAt(numLigne, 4).toString();
					//remplissage du formulaire
					txtNom.setText(nom);
					txtDescription.setText(description);
					// txtCategorie.setText(categorie);
					btEnregistrer.setText("Modifier");
				}

			}
		});

		//Nombre de matériels dans la table :
		int nbMatriels = this.unTableau.getRowCount();
		lbMateriels = new JLabel("Nombre de matériels disponibles : " + nbMatriels);
		lbMateriels.setBounds(300, 360, 300, 20);
		this.add(lbMateriels);
	}

	public Object [][] obtenirDonnees (String filtre){
		ArrayList<Materiel> lesMateriels = Controleur.selectAllMateriels(filtre);
		Object [][] matrice = new Object[lesMateriels.size()][5];
		int i = 0;
		for (Materiel unMateriel : lesMateriels) {
			matrice [i][0] = unMateriel.getIdmateriel();
			matrice [i][1] = unMateriel.getNom();
			matrice [i][2] = unMateriel.getDescription();
			// matrice [i][3] = unMateriel.getPrixAchat();
			// matrice [i][4] = unMateriel.getCategorie();
			i++;
		}
		return matrice;
	}
	public void viderChamps () {
		//this.txtCategorie.setText("");
		this.txtNom.setText("");
		this.txtDescription.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.btAnnuler) {
			this.viderChamps();
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			boolean ok = true;
			String nom = this.txtNom.getText();
			String description = this.txtDescription.getText();
			// String categorie = this.txtCategorie.getSelectedItem().toString();
			// float prix = 0;
			// try {
			// 	prix = Float.parseFloat(this.txtPrix.getText());
			// }
			// catch (NumberFormatException exp) {
			// 	JOptionPane.showMessageDialog(this, "Erreur format du prix");
			// }
			//on vérifie les données avant insertion dans la base
			// if (prix <=0) {
			// 	JOptionPane.showMessageDialog(this, "Erreur prix (Nombre > 0) ");
			// 	this.txtPrix.setBackground(Color.red);
			// 	ok = false ;
			// }else {
			// 	this.txtPrix.setBackground(Color.white);
			// }
			if (ok) {
				//on enregistre le new materiel dans la base
				Materiel unMateriel = new Materiel(nom, description);
				Controleur.insertMateriel (unMateriel);

				//récupération de l'ID donné par mysql
				unMateriel = Controleur.selectWhereMateriel(nom);



				JOptionPane.showMessageDialog(this, "Matériel inséré avec succés dans la BDD");
				//insertion dans l'affichage graphique
				Object ligne[]= {unMateriel.getIdmateriel(), nom, description};
				this.unTableau.ajouterLigne(ligne);
				lbMateriels.setText("Nombre de matériels disponibles :"+unTableau.getRowCount());

				this.viderChamps();
			}
		}
		else if (e.getSource()== this.btFiltre)
		{
			String filtre = this.txtFiltre.getText();
			Object matrice [][ ] = this.obtenirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
		}

		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String nom = this.txtNom.getText();
			String description = this.txtDescription.getText();
			// String categorie = this.txtCategorie.getSelectedItem().toString();
			// float prix = 0;
			// try {
			// 	prix = Float.parseFloat(this.txtPrix.getText());
			// }
			// catch (NumberFormatException exp) {
			// 	JOptionPane.showMessageDialog(this, "Erreur format du prix");
			// }
			int numLigne = 0 ;
			int idMateriel = 0;
			numLigne = tableMateriels.getSelectedRow();
			idMateriel= Integer.parseInt(tableMateriels.getValueAt(numLigne, 0).toString());

			//Instanciation d'un materiel
			Materiel unMateriel = new Materiel(idMateriel, nom, description);
			//modification dans la base de données
			Controleur.updateMateriel(unMateriel);
			//modification dans l'affichage
			Object ligne []= {idMateriel, nom, description};
			this.unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification effectuée");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}

	}
}









