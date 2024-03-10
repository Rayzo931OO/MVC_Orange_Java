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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controleur.Client;
import controleur.Controleur;
import controleur.Intervention;
import controleur.Materiel;
import controleur.Tableau;
import controleur.Technicien;

public class PanelInterventions extends PanelPrincipal implements ActionListener {
	private int idIntervention;
	private JTextArea txtDescription = new JTextArea();
	// private JTextField txtPrix = new JTextField();
	private JComboBox<String> txtStatus = new JComboBox<String>();
	private JComboBox<String> txtIdTechnicien = new JComboBox<String>();
	private JComboBox<String> txtIdClient = new JComboBox<String>();
	private JComboBox<String> txtIdMateriel = new JComboBox<String>();
	private JDateChooser txtDateInter = new JDateChooser();

	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");

	private JTable tableInterventions;
	private JScrollPane uneScroll;
	private Tableau unTableau;

	private JPanel panelRech = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltre = new JButton("Filtrer");

	private JPanel panelForm = new JPanel();
	private JLabel lbInterventions;

	public PanelInterventions() {
		super(new Color(181, 135, 79));
		// placement du panel formulaire
		this.panelForm.setBounds(50, 50, 300, 250);
		this.panelForm.setBackground(new Color(181, 135, 79));
		this.panelForm.setLayout(new GridLayout(7, 2));
		this.panelForm.add(new JLabel("Description : "));
		this.panelForm.add(this.txtDescription);
		this.panelForm.add(new JLabel("Date Inter : "));
		this.panelForm.add(this.txtDateInter);
		// this.panelForm.add(new JLabel("Prix Inter : "));
		// this.panelForm.add(this.txtPrix);
		this.panelForm.add(new JLabel("Status "));
		this.panelForm.add(this.txtStatus);
		this.panelForm.add(new JLabel("Le Technicien "));
		this.panelForm.add(this.txtIdTechnicien);
		this.panelForm.add(new JLabel("Le Client "));
		this.panelForm.add(this.txtIdClient);
		this.panelForm.add(new JLabel("Le Matériel "));
		this.panelForm.add(this.txtIdMateriel);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.add(this.panelForm);
		this.panelForm.setVisible(true);

		// remplir lesCBX Materiels et Admins
		this.remplirCBX();

		// construction de la Jtable des techniciens
		String entetes[] = { "ID Intervention", "Status", "Description", "Date Intervention", "ID Technicien",
				"ID Client", "ID Materiel" };
		this.unTableau = new Tableau(entetes, this.obtenirDonnees(""));
		this.idIntervention = 0;
		this.tableInterventions = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(this.tableInterventions);
		this.uneScroll.setBounds(400, 80, 400, 220);
		this.add(this.uneScroll);

		// placement du panel filtre
		this.panelRech.setBounds(450, 10, 300, 20);
		this.panelRech.setBackground(new Color(181, 135, 79));
		this.panelRech.setLayout(new GridLayout(1, 3));
		this.panelRech.add(new JLabel("Filtrer par : "));
		this.panelRech.add(this.txtFiltre);
		this.panelRech.add(this.btFiltre);
		this.panelRech.setVisible(true);
		this.add(this.panelRech);

		// rendre les deux boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btFiltre.addActionListener(this);

		// interdiction de déplacement des colonnes
		this.tableInterventions.getTableHeader().setReorderingAllowed(false);
		this.tableInterventions.addMouseListener(new MouseListener() {

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
				if (e.getClickCount() >= 2) {
					numLigne = tableInterventions.getSelectedRow();
					idIntervention = Integer.parseInt(tableInterventions.getValueAt(numLigne, 0).toString());
					int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Technicien",
							"Suppression Technicien", JOptionPane.YES_NO_OPTION);
					if (reponse == 0) {
						// suppression dans la BDD
						Controleur.deleteIntervention(idIntervention);
						// suppression dans l'affichage de la table
						unTableau.supprimerLigne(numLigne);
						lbInterventions.setText("Nombre de Techniciens disponibles :" + unTableau.getRowCount());
					}
				} else {
					numLigne = tableInterventions.getSelectedRow();
					idIntervention = Integer.parseInt(tableInterventions.getValueAt(numLigne, 0).toString());
					String status = tableInterventions.getValueAt(numLigne, 1).toString();
					String description = tableInterventions.getValueAt(numLigne, 2).toString();
					String dateInter = tableInterventions.getValueAt(numLigne, 3).toString();
					String idTechnicien = new String(tableInterventions.getValueAt(numLigne, 4).toString());
					String nomTechnicien = Controleur.selectTechnicienById(idTechnicien).getNom();
					String technicien = idTechnicien + "-" + nomTechnicien;

					String idClient = tableInterventions.getValueAt(numLigne, 5).toString();
					String nomClient = Controleur.selectClientById(idClient).getNom();
					String client = idClient + "-" + nomClient;
					System.out.println("idClient : " + idClient);

					String idMateriel = tableInterventions.getValueAt(numLigne, 6).toString();
					String nomMateriel = Controleur.selectMaterielById(idMateriel).getNom();
					String materiel = idMateriel + "-" + nomMateriel;
					// String mdp = tableTechniciens.getValueAt(numLigne, 2).toString();
					// String categorie = tableTechniciens.getValueAt(numLigne, 4).toString();
					// remplissage du formulaire
					// convert idTechnicien to string
					txtDescription.setText(description);
					txtDateInter.setDate(Controleur.convertStringToDate(dateInter));
					txtStatus.setSelectedItem(status);
					txtIdTechnicien.setSelectedItem(technicien);
					txtIdClient.setSelectedItem(client);
					txtIdMateriel.setSelectedItem(materiel);
					btEnregistrer.setText("Modifier");
				}

			}
		});

	}

	public Object[][] obtenirDonnees(String filtre) {
		ArrayList<Intervention> lesInterventions = Controleur.selectAllInterventions(filtre);
		Object[][] matrice = new Object[lesInterventions.size()][7];
		int i = 0;
		for (Intervention unIntervention : lesInterventions) {
			matrice[i][0] = unIntervention.getIdinter();
			matrice[i][1] = unIntervention.getStatus();
			matrice[i][2] = unIntervention.getDescription();
			matrice[i][3] = unIntervention.getDateinter();
			matrice[i][4] = unIntervention.getIdTechnicien();
			matrice[i][5] = unIntervention.getIdClient();
			matrice[i][6] = unIntervention.getIdMateriel();
			i++;
		}
		return matrice;
	}

	public void remplirCBX() {
		// make a list of status to add to the combobox one "en cours" and one "terminé"
		String[] lesStatus = { "En cours", "Terminé", "Annulé" };
		for (String unStatus : lesStatus) {
			this.txtStatus.addItem(unStatus);
		}

		ArrayList<Client> lesClients = Controleur.selectAllClient("");

		for (Client unClient : lesClients) {
			System.out.println(unClient.getIdClient() + "-" + unClient.getNom());
			this.txtIdClient.addItem(unClient.getIdClient() + "-" + unClient.getNom());
		}
		ArrayList<Materiel> lesMateriels = Controleur.selectAllMateriels("");
		for (Materiel unMateriel : lesMateriels) {
			this.txtIdMateriel.addItem(unMateriel.getIdmateriel() + "-" + unMateriel.getNom());
		}

		ArrayList<Technicien> lesTechniciens = Controleur.selectAllTechniciens("");
		for (Technicien unTechnicien : lesTechniciens) {
			this.txtIdTechnicien.addItem(unTechnicien.getIdTechnicien() + "-"
					+ unTechnicien.getNom());
		}
	}

	public void viderChamps() {
		this.txtDescription.setText("");
		this.txtDateInter.setDate(Controleur.convertStringToDate("2021-01-01"));
		// this.txtPrix.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtDescription.setText("");
			this.txtDateInter.setDate(Controleur.convertStringToDate("2021-01-01"));
			this.btEnregistrer.setText("Enregistrer");
			// this.txtPrix.setText("");
		} else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")) {
			String description = this.txtDescription.getText();
			String dateinter = this.txtDateInter.getDate().toString();
			dateinter = Controleur.convertDateToString(this.txtDateInter.getDate());
			String chaine = this.txtIdTechnicien.getSelectedItem().toString();

			String tab[] = chaine.split("-");
			int idTechnicien = Integer.parseInt(tab[0]);

			chaine = this.txtIdMateriel.getSelectedItem().toString();
			tab = chaine.split("-");
			int idMateriel = Integer.parseInt(tab[0]);

			chaine = this.txtIdClient.getSelectedItem().toString();
			tab = chaine.split("-");
			int idClient = Integer.parseInt(tab[0]);

			String status = this.txtStatus.getSelectedItem().toString();

			// instancier une intervention
			Intervention uneIntervention = new Intervention(description, dateinter,
					// prix,
					status, idTechnicien, idClient, idMateriel);
			// Intervention uneIntervention = new Intervention(description, dateinter,
			// prix, idAdmin, idMateriel);
			// on l'insère dans la BDD
			Controleur.insertIntervention(uneIntervention);
			JOptionPane.showMessageDialog(this, "Insertion réussie de l'intervention");
			Intervention uneIntervention2 = Controleur.selectWhereIntervention(description, dateinter, status,
					idTechnicien, idClient, idMateriel);
			Object ligne[] = { uneIntervention2.getIdinter(), status, description, dateinter, idTechnicien, idClient,
					idMateriel };
			this.unTableau.ajouterLigne(ligne);

			this.viderChamps();
			// this.txtPrix.setText("");
		}
		else if (e.getSource()== this.btFiltre)
		{
			String filtre = this.txtFiltre.getText();
			Object matrice [][ ] = this.obtenirDonnees(filtre);
			this.unTableau.setDonnees(matrice);
		}
		else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")) {
			String description = this.txtDescription.getText();
			String dateinter = this.txtDateInter.getDate().toString();
			dateinter = Controleur.convertDateToString(this.txtDateInter.getDate());
			String chaine = this.txtIdTechnicien.getSelectedItem().toString();

			String tab[] = chaine.split("-");
			int idTechnicien = Integer.parseInt(tab[0]);

			chaine = this.txtIdMateriel.getSelectedItem().toString();
			tab = chaine.split("-");
			int idMateriel = Integer.parseInt(tab[0]);

			chaine = this.txtIdClient.getSelectedItem().toString();
			tab = chaine.split("-");
			int idClient = Integer.parseInt(tab[0]);

			String status = this.txtStatus.getSelectedItem().toString();
			int numLigne = 0 ;
			numLigne = tableInterventions.getSelectedRow();
			// instancier une intervention with idIntervention
			Intervention uneIntervention = new Intervention(idIntervention, description, dateinter,
					// prix,
					status, idTechnicien, idClient, idMateriel);
			Controleur.updateIntervention(uneIntervention);
			Object ligne[] = { idIntervention, status, description, dateinter, idTechnicien, idClient,
				idMateriel };
			this.unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification effectuée");
			this.viderChamps();
		}
	}
}