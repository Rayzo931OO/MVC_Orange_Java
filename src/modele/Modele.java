package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Admin;
import controleur.Intervention;
import controleur.Materiel;
import controleur.ViewAdmin;

public class Modele {
	private static Bdd uneBdd = new Bdd ("localhost:3306","mvc_orange","root","");

	/************************* Gestion des Admins ******************/
	public static Admin selectWhereAdmin (String email, String mot_de_passe)
	{
		Admin unAdmin = null;
		String requete = "select * from user where email='"+email
				+ "' and mot_de_passe ='"+mot_de_passe+"' and role = 'admin'; ";
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//execution de la requete et récuperation d'un resultat
			ResultSet unRes = unStat.executeQuery(requete);
			//s'il y a un resultat, on récupere les champs
			//System.out.println(unRes);
			if (unRes.next()) {
				unAdmin = new Admin (
						unRes.getInt("id_utilisateur"),
						unRes.getString("nom"),
						unRes.getString("prenom"),
						unRes.getString("email"),
						unRes.getString("mot_de_passe")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}

		return unAdmin;
	}

	public static ArrayList<Admin> selectAllAdmins ()
	{
		ArrayList<Admin> lesAdmins = new ArrayList<Admin>();
		String requete = "select * from user where role = 'admin'; ";
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//execution de la requete et récuperation d'un resultat
			ResultSet desRes = unStat.executeQuery(requete);
			//s'il y a un resultat, on récupere les champs
			while (desRes.next()) {
				Admin unAdmin = new Admin (
						desRes.getInt("id_utilisateur"),
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getString("email"),
						desRes.getString("mot_de_passe")
						);
				lesAdmins.add(unAdmin);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		return lesAdmins;
	}

	public static ArrayList<ViewAdmin> selectAllViewAdmins ()
	{
		ArrayList<ViewAdmin> lesViewAdmins = new ArrayList<ViewAdmin>();
		String requete = "select * from  nbIntersAdmins ; ";
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			//execution de la requete et récuperation d'un resultat
			ResultSet desRes = unStat.executeQuery(requete);
			//s'il y a un resultat, on récupere les champs
			while (desRes.next()) {
				ViewAdmin unViewAdmin = new ViewAdmin (
						desRes.getString("nom"),
						desRes.getString("prenom"),
						desRes.getInt("nbInterventions")
						);
				lesViewAdmins.add(unViewAdmin);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		return lesViewAdmins;
	}

	public static void updateAdmin(Admin unAdmin) {
		 String requete = "update user set nom='"+unAdmin.getNom()
		 	+"', prenom = '"+unAdmin.getPrenom()
		 	+"', email = '"+unAdmin.getEmail()
		 	+"', mot_de_passe = '"+unAdmin.getMdp()
		 	+"' where  id_utilisateur = "+unAdmin.getIdAdmin()+";";
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }

	}

	public static void insertMateriel(Materiel unMateriel) {
		 String requete = "insert into materiel values (null, '"+unMateriel.getDescription()
		 	+ "','"+unMateriel.getDescription()+"');";
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
	}

	public static ArrayList<Materiel> selectAllMateriels (String filtre){
		ArrayList <Materiel> lesMateriels = new ArrayList<Materiel>();
		String requete ="";
		if (filtre.equals("")) {
			requete = "select * from materiel ;";
		}else {
			requete = "select * from materiel where nom like '%"+filtre
					+"%' or description like '%"+filtre+"%' ; ";
		}
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 ResultSet desRes = unStat.executeQuery(requete);
			 while (desRes.next()) {
				 Materiel unMateriel = new Materiel(
						 desRes.getInt("id_materiel"),
						 desRes.getString("nom"),
						 desRes.getString("description")
						 );
			    lesMateriels.add(unMateriel);
			 }
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
		return lesMateriels;
	}
	public static  Materiel selectWhereMateriel (int id_materiel){

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
						 desRes.getString("description")
						 );
			 }
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
		return unMateriel;
	}

	public static  Materiel selectWhereMateriel (String nom){

		String requete = "select * from materiel where nom='"+nom
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
						 desRes.getString("description")
						 );
			 }
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
		return unMateriel;
	}
	public static void deleteMateriel(int id_materiel) {
		 String requete = "delete from materiel where id_materiel = " + id_materiel+";";
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
	}
	public static void updateMateriel(Materiel unMateriel) {
		 String requete = "update materiel set nom ='"+unMateriel.getNom()
		 	+ "', description=' "+unMateriel.getDescription()
		 	+"' where id_materiel ="+unMateriel.getIdmateriel()+";";
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
	}

	public static void insertIntervention(Intervention uneIntervention) {
		String requete = "insert into intervention values (null, '"
				+ uneIntervention.getDescription()+"','"
				+uneIntervention.getDateinter()+"','"
				+ uneIntervention.getPrix()+"','"
				+uneIntervention.getIdmateriel()+"');";
		try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }

	}

	public static void createAdmin(Admin newAdmin) {
		String requete = "insert into user values (null, '"
				+newAdmin.getNom()+"','"
				+newAdmin.getPrenom()+"','"
				+newAdmin.getEmail()+"','"
				+newAdmin.getMdp()+"';";
		try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 unStat.execute(requete);
			 unStat.close();
			 uneBdd.seDeConnecter();
		 }
		 catch (SQLException exp) {
			 System.out.println("Erreur de requete : " +requete);
		 }
	}
}
















