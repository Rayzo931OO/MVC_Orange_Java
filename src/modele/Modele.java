package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controleur.Admin;
import controleur.Client;
import controleur.Intervention;
import controleur.Materiel;
import controleur.Technicien;
import controleur.ViewNbIntervention;

public class Modele {
	private static Bdd uneBdd = new Bdd("localhost:3306", "mvc_orange", "root", "");

	/************************* Gestion des Admins ******************/
	/**
	 * Récupère tous les administrateurs de la base de données.
	 *
	 * @return Une ArrayList d'objets Admin.
	 */
	public static Admin selectWhereAdmin(String email, String mot_de_passe) {
		Admin unAdmin = null;
		String requete = "select * from user where email='" + email
				+ "' and mot_de_passe ='" + mot_de_passe + "' and role = 'admin'; ";
		try {
			uneBdd.seConnecter();
			// création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// execution de la requete et récuperation d'un resultat
			ResultSet unRes = unStat.executeQuery(requete);
			// s'il y a un resultat, on récupere les champs
			// System.out.println(unRes);
			if (unRes.next()) {
				unAdmin = new Admin(
						unRes.getInt("id_utilisateur"),
						unRes.getString("nom"),
						unRes.getString("prenom"),
						unRes.getString("email"),
						unRes.getString("code_postal"),
						unRes.getString("adresse"),
						unRes.getString("telephone"),
						unRes.getString("mot_de_passe"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}

		return unAdmin;
	}

	/**
	 * Met à jour les informations d'un administrateur dans la base de données.
	 *
	 * @param unAdmin L'objet Admin contenant les informations mises à jour.
	 */
	public static void updateAdmin(Admin unAdmin) {
		String requete = "update user set nom='" + unAdmin.getNom()
				+ "', prenom = '" + unAdmin.getPrenom()
				+ "', email = '" + unAdmin.getEmail()
				+ "', code_postal = '" + unAdmin.getCodePostal()
				+ "', adresse = '" + unAdmin.getAdresse()
				+ "', telephone = '" + unAdmin.getTel()
				+ "', mot_de_passe = '" + unAdmin.getMdp()
				+ "' where  id_utilisateur = " + unAdmin.getIdAdmin() + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	/**
	 * Crée un nouvel utilisateur administrateur dans la base de données.
	 *
	 * @param newAdmin l'objet Admin représentant le nouvel utilisateur
	 *                 administrateur
	 */
	public static void createAdmin(Admin newAdmin) {
		String requete = "insert into user (nom, prenom, email, code_postal, adresse, telephone, mot_de_passe, role) values ('"
				+ newAdmin.getNom() + "','"
				+ newAdmin.getPrenom() + "','"
				+ newAdmin.getEmail() + "','"
				+ newAdmin.getCodePostal() + "','"
				+ newAdmin.getAdresse() + "','"
				+ newAdmin.getTel() + "','"
				+ newAdmin.getMdp() + "','"
				+ newAdmin.getRole() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	/************************* Gestion des Techniciens ******************/
	/**
	 * Crée un nouvel utilisateur technicien dans la base de données.
	 *
	 * @param unTechnicien l'objet Technicien représentant le nouvel utilisateur
	 *                     technicien
	 */
	public static void createTechnicien(Technicien unTechnicien) {
		String requete = "insert into user (nom, prenom, email, code_postal, adresse, telephone, mot_de_passe, role) values ('"
				+ unTechnicien.getNom() + "','"
				+ unTechnicien.getPrenom() + "','"
				+ unTechnicien.getEmail() + "','"
				+ unTechnicien.getCodePostal() + "','"
				+ unTechnicien.getAdresse() + "','"
				+ unTechnicien.getTel() + "','"
				+ unTechnicien.getMdp() + "','technicien');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
			System.out.println(exp.getMessage());

		}
	}

	public static void updateTechnicien(Technicien unTechnicien) {
		String requete = "update user set nom='" + unTechnicien.getNom()
				+ "', prenom = '" + unTechnicien.getPrenom()
				+ "', email = '" + unTechnicien.getEmail()
				+ "', code_postal = '" + unTechnicien.getCodePostal()
				+ "', adresse = '" + unTechnicien.getAdresse()
				+ "', mot_de_passe = '" + unTechnicien.getMdp()
				+ "' where  id_utilisateur = " + unTechnicien.getIdTechnicien() + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	public static void deleteTechnicien(int idTechnicien) {
		String requete = "delete from user where id_utilisateur = " + idTechnicien + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	/**
	 * Récupère tous les techniciens de la base de données.
	 *
	 * @return Une ArrayList d'objets Technicien.
	 */
	public static ArrayList<Technicien> selectAllTechniciens() {
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "select * from user where role = 'technicien'; ";
		try {
			uneBdd.seConnecter();
			// création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// execution de la requete et récuperation d'un resultat
			ResultSet desRes = unStat.executeQuery(requete);
			// s'il y a un resultat, on récupere les champs
			while (desRes.next()) {
				Technicien unTechnicien = new Technicien(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						desRes.getString("mot_de_passe"));
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesTechniciens;
	}

	public static ArrayList<Technicien> selectAllTechniciens(String filtre) {
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "";
		if (filtre.equals("")) {
			requete = "select * from user where role = 'technicien' ;";
		} else {
			requete = "select * from user where role = 'technicien' and (nom like '%" + filtre
					+ "%' or prenom like '%" + filtre + "%' or email like '%" + filtre + "%' or telephone like '%" + filtre
					+ "%');";
		}
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Technicien unTechnicien = new Technicien(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						"");
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesTechniciens;
	}

	public static Technicien selectWhereTechnicien(String email) {
		String requete = "select * from user where email='" + email
				+ "' and role = 'technicien';";
		Technicien unTechnicien = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unTechnicien = new Technicien(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						desRes.getString("mot_de_passe"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unTechnicien;
	}

	/************************* Gestion des Materiels ******************/
	public static void insertMateriel(Materiel unMateriel) {
		String requete = "insert into materiel values (null, '" + unMateriel.getNom()
				+ "','" + unMateriel.getDescription() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	public static ArrayList<Materiel> selectAllMateriels(String filtre) {
		ArrayList<Materiel> lesMateriels = new ArrayList<Materiel>();
		String requete = "";
		if (filtre.equals("")) {
			requete = "select * from materiel ;";
		} else {
			requete = "select * from materiel where nom like '%" + filtre
					+ "%' or description like '%" + filtre + "%' ; ";
		}
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Materiel unMateriel = new Materiel(
						desRes.getInt("id_materiel"),
						desRes.getString("nom"),
						desRes.getString("description"));
				lesMateriels.add(unMateriel);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesMateriels;
	}

	public static Materiel selectWhereMateriel(int id_materiel) {

		String requete = "select * from materiel where id_materiel =" + id_materiel;
		Materiel unMateriel = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unMateriel = new Materiel(
						desRes.getInt("id_materiel"),
						desRes.getString("nom"),
						desRes.getString("description"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unMateriel;
	}

	public static Materiel selectWhereMateriel(String nom) {

		String requete = "select * from materiel where nom='" + nom
				+ "';";
		Materiel unMateriel = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unMateriel = new Materiel(
						desRes.getInt("id_materiel"),
						desRes.getString("nom"),
						desRes.getString("description"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
			System.out.println(exp.getMessage());
		}
		return unMateriel;
	}

	public static void deleteMateriel(int id_materiel) {
		String requete = "delete from materiel where id_materiel = " + id_materiel + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	public static void updateMateriel(Materiel unMateriel) {
		String requete = "update materiel set nom ='" + unMateriel.getNom()
				+ "', description=' " + unMateriel.getDescription()
				+ "' where id_materiel =" + unMateriel.getIdmateriel() + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	/************************* Gestion des Interventions ******************/
	public static void insertIntervention(Intervention uneIntervention) {
		String requete = "insert into intervention (description, date_Inter, status, id_technicien, id_client, id_materiel) values ('"
				+ uneIntervention.getDescription() + "','"
				+ uneIntervention.getDateinter() + "','"
				// + uneIntervention.getPrix() + "','"
				+ uneIntervention.getStatus() + "','"
				+ uneIntervention.getIdTechnicien() + "','"
				+ uneIntervention.getIdClient() + "','"
				+ uneIntervention.getIdMateriel() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}

	}

	public static ArrayList<Intervention> selectAllInterventions(String filtre) {
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
		String requete = "";
		if (filtre.equals("")) {
			requete = "select * from intervention ;";
		} else {
			requete = "select * from intervention where description like '%" + filtre
					+ "%' or date_inter like '%" + filtre +
					"%'" +
					" or status like '%" + filtre + "%'" +
					// " or prix like '%" + filtre + "%'"+
					" ; ";
		}
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Intervention uneIntervention = new Intervention(
						desRes.getInt("id_intervention"),
						desRes.getString("description"),
						desRes.getString("date_inter"),
						// desRes.getFloat("prix"),
						desRes.getString("status"),
						desRes.getInt("id_technicien"),
						desRes.getInt("id_client"),
						desRes.getInt("id_materiel"));
				lesInterventions.add(uneIntervention);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesInterventions;
	}

	public static ArrayList<ViewNbIntervention> ViewNbIntervention() {
		ArrayList<ViewNbIntervention> lesViewNbIntervention = new ArrayList<ViewNbIntervention>();
		String requete = "select * from  nbinterstechniciens;";
		try {
			uneBdd.seConnecter();
			// création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			// execution de la requete et récuperation d'un resultat
			ResultSet desRes = unStat.executeQuery(requete);
			// s'il y a un resultat, on récupere les champs
			while (desRes.next()) {
				ViewNbIntervention uneViewNbIntervention = new ViewNbIntervention(
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getInt("nbInterventions"));
				lesViewNbIntervention.add(uneViewNbIntervention);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesViewNbIntervention;
	}

	/************************* Gestion des Clients ******************/
	public static ArrayList<Client> selectAllClient(String filtre) {
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "";
		if (filtre.equals("")) {
			requete = "select * from user where role = 'client' ;";
		} else {
			requete = "select * from user where role = 'client' and (nom like '%" + filtre
					+ "%' or prenom like '%" + filtre + "%' or email like '%" + filtre + "%' or telephone like '%" + filtre
					+ "%');";
		}
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Client unClient = new Client(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						"");
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesClients;
	}

	public static Date convertStringToDate(String dateInter) {
		Date date = null;
		try {
			// The constructor Date(String) is deprecated
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInter);
		} catch (Exception exp) {
			System.out.println("Erreur de conversion de la date");
		}
		return date;
	}

	public static Intervention selectWhereIntervention(int idIntervention) {
		String requete = "select * from intervention where id_intervention=" + idIntervention;
		Intervention uneIntervention = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				uneIntervention = new Intervention(
						desRes.getInt("id_intervention"),
						desRes.getString("description"),
						desRes.getString("date_inter"),
						// desRes.getFloat("prix"),
						desRes.getString("status"),
						desRes.getInt("id_technicien"),
						desRes.getInt("id_client"),
						desRes.getInt("id_materiel"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return uneIntervention;
	}

	public static Client selectClientById(String idClient) {
		String requete = "select * from user where id_utilisateur=" + idClient + ";";
		Client unClient = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unClient = new Client(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						"");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unClient;
	}

	public static Technicien selectTechnicienById(String idTechnicien) {
		String requete = "select * from user where id_utilisateur=" + idTechnicien + ";";
		Technicien unTechnicien = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unTechnicien = new Technicien(
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("code_postal"),
						desRes.getString("adresse"),
						desRes.getString("telephone"),
						"");
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unTechnicien;
	}

	public static Materiel selectMaterielById(String idMateriel) {
		String requete = "select * from materiel where id_materiel=" + idMateriel + ";";
		Materiel unMateriel = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				unMateriel = new Materiel(
						desRes.getInt("id_materiel"),
						desRes.getString("nom"),
						desRes.getString("description"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unMateriel;
	}

	public static String convertDateToString(Date date) {
		// dateinter is in this format : "Wed Jun 16 00:00:00 CEST 2021"
		// make it a sql DATETIME format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInter = formatter.format(date);
		return dateInter;
	}

	public static Intervention selectWhereIntervention(String description, String dateinter, String status,
			int idTechnicien, int idClient, int idMateriel) {
		String requete = "select * from intervention where description='" + description
				+ "' and date_inter ='" + dateinter
				+ "' and status ='" + status
				+ "' and id_technicien ='" + idTechnicien
				+ "' and id_client ='" + idClient
				+ "' and id_materiel ='" + idMateriel + "';";
		Intervention uneIntervention = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				uneIntervention = new Intervention(
						desRes.getInt("id_intervention"),
						desRes.getString("description"),
						desRes.getString("date_inter"),
						// desRes.getFloat("prix"),
						desRes.getString("status"),
						desRes.getInt("id_technicien"),
						desRes.getInt("id_client"),
						desRes.getInt("id_materiel"));
			}
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return uneIntervention;
	}

	public static void deleteIntervention(int idIntervention) {
		String requete = "delete from intervention where id_intervention = " + idIntervention + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}

	public static void updateIntervention(Intervention uneIntervention) {
		String requete = "update intervention set description='" + uneIntervention.getDescription()
				+ "', date_inter = '" + uneIntervention.getDateinter()
				+ "', status = '" + uneIntervention.getStatus()
				+ "', id_technicien = '" + uneIntervention.getIdTechnicien()
				+ "', id_client = '" + uneIntervention.getIdClient()
				+ "', id_materiel = '" + uneIntervention.getIdMateriel()
				+ "' where id_intervention = " + uneIntervention.getIdinter() + ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
}
