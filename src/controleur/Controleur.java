package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {

	public static Technicien selectWhereTechnicien (String email, String mdp) {
		//Controler l'email 
		//controler la complexité du mdp 
		return Modele.selectWhereTechnicien(email, mdp);
	}
	
	public static ArrayList<Technicien> selectAllTechniciens (){
		return Modele.selectAllTechniciens(); 
	}
	
	public static void updateTechnicien (Technicien unTechnicien)
	{
		Modele.updateTechnicien (unTechnicien); 
	}
	public static void insertMateriel (Materiel unMateriel)
	{
		Modele.insertMateriel (unMateriel); 
	}
	
	public static ArrayList<Materiel> selectAllMateriels(String filtre){
		return Modele.selectAllMateriels(filtre); 
	}
	
	public static Materiel selectWhereMateriel (int idmateriel) {
		return Modele.selectWhereMateriel(idmateriel);
	}
	
	public static Materiel selectWhereMateriel (String designation, String dateAchat) {
		return Modele.selectWhereMateriel(designation, dateAchat);
	}
	
	public static void deleteMateriel (int idMateriel)
	{
		Modele.deleteMateriel (idMateriel); 
	}
	
	public static void updateMateriel (Materiel unMateriel)
	{
		Modele.updateMateriel (unMateriel); 
	}
	
	public static void insertIntervention (Intervention uneIntervention) {
		Modele.insertIntervention (uneIntervention);
	}

	public static ArrayList<ViewTech> selectAllViewTechs() {
		 
		return Modele.selectAllViewTechs(); 
	}
}










































