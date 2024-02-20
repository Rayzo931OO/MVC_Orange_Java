package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Technicien;
import controleur.ViewTech;
import controleur.Intervention;
import controleur.Materiel;

public class Modele {
	private static Bdd uneBdd = new Bdd ("localhost:8889","orange_event_266","root","root");
	
	/************************* Gestion des techniciens ******************/
	public static Technicien selectWhereTechnicien (String email, String mdp)
	{
		Technicien unTechnicien = null; 
		String requete = "select * from technicien where email='"+email
				+ "' and mdp ='"+mdp+"'; ";
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			ResultSet unRes = unStat.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			if (unRes.next()) {
				unTechnicien = new Technicien (
						unRes.getInt("idtechnicien"),   
						unRes.getString("nom"), 
						unRes.getString("prenom"), 
						unRes.getString("qualification"), 
						unRes.getString("email"), 
						unRes.getString("mdp")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		
		return unTechnicien; 
	}

	public static ArrayList<Technicien> selectAllTechniciens ()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>(); 
		String requete = "select * from technicien ; "; 
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			ResultSet desRes = unStat.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			while (desRes.next()) {
				Technicien unTechnicien = new Technicien (
						desRes.getInt("idtechnicien"),   
						desRes.getString("nom"), 
						desRes.getString("prenom"), 
						desRes.getString("qualification"), 
						desRes.getString("email"), 
						desRes.getString("mdp")
						);
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		return lesTechniciens; 
	}
	
	public static ArrayList<ViewTech> selectAllViewTechs ()
	{
		ArrayList<ViewTech> lesViewTechs = new ArrayList<ViewTech>(); 
		String requete = "select * from  nbIntersTechniciens ; "; 
		try {
			uneBdd.seConnecter();
			//création d'un curseur pour exécuter la requete 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			ResultSet desRes = unStat.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			while (desRes.next()) {
				ViewTech unViewTech = new ViewTech (
						desRes.getString("nom"), 
						desRes.getString("prenom"), 
						desRes.getInt("nbInterventions")
						);
				lesViewTechs.add(unViewTech);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		return lesViewTechs; 
	}

	public static void updateTechnicien(Technicien unTechnicien) {
		 String requete = "update technicien set nom='"+unTechnicien.getNom()
		 	+"', prenom = '"+unTechnicien.getPrenom()
		 	+"', qualification = '"+unTechnicien.getQualification()
		 	+"', email = '"+unTechnicien.getEmail()
		 	+"', mdp = '"+unTechnicien.getMdp()
		 	+"' where  idtechnicien = "+unTechnicien.getIdtechnicien()+";";
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
				+uneIntervention.getIdtechnicien()+"','"
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
















