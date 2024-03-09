package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.Tableau;
import controleur.Technicien;

public class PanelTechniciens extends PanelPrincipal implements ActionListener
{
	private int idTechnicien;
	private JPanel panelForm = new JPanel();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtCodePostal = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtTelephone = new JTextField();
	private JTextField txtMDP = new JTextField();
	// private JComboBox<String> txtCategorie = new JComboBox<String>();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer= new JButton("Enregistrer");

	private JTable tableTechniciens ;
	private JScrollPane uneScroll ;
	private Tableau unTableau ;

	private JPanel panelRech = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltre = new JButton("Filtrer");

	private JLabel lbTechniciens;
	public PanelTechniciens( ) {
		super(new Color ( 181, 135, 79  ));
		//remplir le Combox de la catégorie
		// this.txtCategorie.addItem("Téléphonie");
		// this.txtCategorie.addItem("Box Internet");
		// this.txtCategorie.addItem("Télévision");
		// this.txtCategorie.addItem("Autres");

		//placement du panel formulaire
		this.panelForm.setBounds(50, 50, 300, 250);
		this.panelForm.setBackground(new Color ( 181, 135, 79  ));
		this.panelForm.setLayout(new GridLayout(8,2));
		this.panelForm.add(new JLabel("Nom : "));
		this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Prenom : "));
		this.panelForm.add(this.txtPrenom);
		this.panelForm.add(new JLabel("Email : "));
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("Code postal : "));
		this.panelForm.add(this.txtCodePostal);
		this.panelForm.add(new JLabel("Adresse : "));
		this.panelForm.add(this.txtAdresse);
		this.panelForm.add(new JLabel("Telephone : "));
		this.panelForm.add(this.txtTelephone);
		this.panelForm.add(new JLabel("Mot de passe : "));
		this.panelForm.add(this.txtMDP);
		// this.panelForm.add(new JLabel("Categorie : "));
		// this.panelForm.add(this.txtCategorie);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm);
		this.panelForm.setVisible(true);

		//construction de la Jtable des techniciens
		String entetes [] = {"ID Technicien", "Nom", "prenom", "Email", "Code Postal", "Adresse","Telephone"};
		this.unTableau = new Tableau (entetes, this.obtenirDonnees(""));
		this.idTechnicien = 0;
		this.tableTechniciens = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(this.tableTechniciens);
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
		this.tableTechniciens.getTableHeader().setReorderingAllowed(false);

		//ajout d'un MouseListener pour suppression et modification.
		this.tableTechniciens.addMouseListener(new MouseListener() {

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
				if (e.getClickCount()>=2) {
					numLigne = tableTechniciens.getSelectedRow();
					idTechnicien= Integer.parseInt(tableTechniciens.getValueAt(numLigne, 0).toString());
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Technicien",
							"Suppression Technicien", JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						//suppression dans la BDD
						Controleur.deleteTechnicien(idTechnicien);
						//suppression dans l'affichage de la table
						unTableau.supprimerLigne(numLigne);
						lbTechniciens.setText("Nombre de Techniciens disponibles :"+unTableau.getRowCount());
					}
				}
				else {
					numLigne = tableTechniciens.getSelectedRow();
					idTechnicien= Integer.parseInt(tableTechniciens.getValueAt(numLigne, 0).toString());
					String nom = tableTechniciens.getValueAt(numLigne, 1).toString();
					String prenom = tableTechniciens.getValueAt(numLigne, 2).toString();
					String email = tableTechniciens.getValueAt(numLigne, 3).toString();
					String codePostal = tableTechniciens.getValueAt(numLigne, 4).toString();
					String Adresse = tableTechniciens.getValueAt(numLigne, 5).toString();
					String tel = tableTechniciens.getValueAt(numLigne, 6).toString();
					// String mdp = tableTechniciens.getValueAt(numLigne, 2).toString();
					// String categorie = tableTechniciens.getValueAt(numLigne, 4).toString();
					//remplissage du formulaire
					// convert idTechnicien to string
					txtNom.setText(nom);
					txtPrenom.setText(prenom);
					txtEmail.setText(email);
					txtAdresse.setText(Adresse);
					txtTelephone.setText(tel);
					txtCodePostal.setText(codePostal);
					btEnregistrer.setText("Modifier");
				}

			}
		});

		//Nombre de Techniciens dans la table :
		int nbTechniciens = this.unTableau.getRowCount();
		lbTechniciens = new JLabel("Nombre de Techniciens disponibles : " + nbTechniciens);
		lbTechniciens.setBounds(300, 360, 300, 20);
		this.add(lbTechniciens);
	}
	public Object [][] obtenirDonnees (String filtre){
		ArrayList<Technicien> lesTechniciens = Controleur.selectAllTechniciens(filtre);
		Object [][] matrice = new Object[lesTechniciens.size()][7];
		int i = 0;
		for (Technicien unTechnicien : lesTechniciens) {
			matrice [i][0] = unTechnicien.getIdTechnicien();
			matrice [i][1] = unTechnicien.getNom();
			matrice [i][2] = unTechnicien.getPrenom();
			matrice [i][3] = unTechnicien.getEmail();
			matrice [i][4] = unTechnicien.getCodePostal();
			matrice [i][5] = unTechnicien.getAdresse();
			matrice [i][6] = unTechnicien.getTel();
			i++;
		}
		return matrice;
	}
	public void viderChamps () {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtCodePostal.setText("");
		this.txtAdresse.setText("");
		this.txtTelephone.setText("");
		this.txtMDP.setText("");
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
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String adresse = this.txtAdresse.getText();
			String codePostal = this.txtCodePostal.getText();
			String mdp = this.txtMDP.getText();
			String tel = this.txtTelephone.getText();
			// String description = this.txtDescription.getText();
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
				//on enregistre le new technicien dans la base
				Technicien unTechnicien = new Technicien(nom, prenom, email, codePostal, adresse, tel, mdp);
				Controleur.createTechnicien (unTechnicien);

				//récupération de l'ID donné par mysql
				unTechnicien = Controleur.selectWhereTechnicien(email);

				JOptionPane.showMessageDialog(this, "Technicien inséré avec succés dans la BDD");
				//insertion dans l'affichage graphique
				Object ligne[]= {unTechnicien.getIdTechnicien(), nom, prenom, email, codePostal, adresse, tel};
				this.unTableau.ajouterLigne(ligne);
				lbTechniciens.setText("Nombre de Techniciens disponibles :"+unTableau.getRowCount());

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
			String prenom = this.txtPrenom.getText();
			String email = this.txtEmail.getText();
			String adresse = this.txtAdresse.getText();
			String codePostal = this.txtCodePostal.getText();
			String mdp = this.txtMDP.getText();
			String tel = this.txtTelephone.getText();

			// String description = this.txtDescription.getText();
			// String categorie = this.txtCategorie.getSelectedItem().toString();
			// float prix = 0;
			// try {
			// 	prix = Float.parseFloat(this.txtPrix.getText());
			// }
			// catch (NumberFormatException exp) {
			// 	JOptionPane.showMessageDialog(this, "Erreur format du prix");
			// }
			int numLigne = 0 ;
			numLigne = tableTechniciens.getSelectedRow();

			//Instanciation d'un technicien
			Technicien unTechnicien = new Technicien(idTechnicien, nom, prenom, email, codePostal, adresse, tel, mdp);
			//modification dans la base de données
			Controleur.updateTechnicien(unTechnicien);
			//modification dans l'affichage
			Object ligne []= {idTechnicien, nom, prenom, email, codePostal, adresse, tel};
			this.unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification effectuée");
			this.viderChamps();
			this.btEnregistrer.setText("Enregistrer");
		}

	}

}
