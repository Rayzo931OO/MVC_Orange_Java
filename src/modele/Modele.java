package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Admin;
import controleur.ViewAdmin;
import controleur.Intervention;
import controleur.Materiel;

public class Modele {
	private static Bdd uneBdd = new Bdd ("localhost:3306","mvc_orange","root","root");
	
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
			if (unRes.next()) {
				unAdmin = new Admin (
						unRes.getInt("id_utilisateur"),   
						unRes.getString("nom"), 
						unRes.getString("prenom"), 
						unRes.getString("qualification"), 
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
						desRes.getString("qualification"), 
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
		 	+"', mot_de_passe = '"+unAdmin.getmot_de_passe()
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
		 String requete = "insert into materiel values (null, '"+unMateriel.getDesignation()
		 	+ "', ' "+unMateriel.getDateAchat()+"','"+ unMateriel.getPrixAchat ()+"','"+unMateriel.getCategorie()+"');";
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
			requete = "select * from materiel where designation like '%"+filtre
					+"%' or dateAchat like '%"+filtre 
					+"%' or categorie like '%"+filtre +"%' ; ";
		}
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 ResultSet desRes = unStat.executeQuery(requete);
			 while (desRes.next()) {
				 Materiel unMateriel = new Materiel(
						 desRes.getInt("idmateriel"), 
						 desRes.getString("designation"), 
						 desRes.getString("dateAchat"), 
						 desRes.getFloat("prixAchat"), 
						 desRes.getString("categorie")
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
	public static  Materiel selectWhereMateriel (int idmateriel){
		 
		String requete = "select * from materiel where idmateriel =" + idmateriel; 
		Materiel unMateriel = null; 
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 ResultSet desRes = unStat.executeQuery(requete);
			 if (desRes.next()) {
				  unMateriel = new Materiel(
						 desRes.getInt("idmateriel"), 
						 desRes.getString("designation"), 
						 desRes.getString("dateAchat"), 
						 desRes.getFloat("prixAchat"), 
						 desRes.getString("categorie")
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
	
	public static  Materiel selectWhereMateriel (String designation, String dateAchat){
		 
		String requete = "select * from materiel where designation='"+designation
				+ "' and  dateAchat ='"+dateAchat+"';";
		Materiel unMateriel = null; 
		 try {
			 uneBdd.seConnecter();
			 Statement unStat = uneBdd.getMaConnexion().createStatement();
			 ResultSet desRes = unStat.executeQuery(requete);
			 if (desRes.next()) {
				  unMateriel = new Materiel(
						 desRes.getInt("idmateriel"), 
						 desRes.getString("designation"), 
						 desRes.getString("dateAchat"), 
						 desRes.getFloat("prixAchat"), 
						 desRes.getString("categorie")
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
	public static void deleteMateriel(int idMateriel) {
		 String requete = "delete from materiel where idmateriel = " + idMateriel+";";
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
		 String requete = "update materiel set designation ='"+unMateriel.getDesignation()
		 	+ "', dateAchat=' "+unMateriel.getDateAchat()
		 	+"',prixAchat='"+ unMateriel.getPrixAchat ()
		 	+"', categorie='"+unMateriel.getCategorie()
		 	+"' where idmateriel ="+unMateriel.getIdmateriel()+";";
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
				+uneIntervention.getIdAdmin()+"','"
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
}
















