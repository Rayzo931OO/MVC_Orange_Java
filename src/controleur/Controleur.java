package controleur;

import java.util.ArrayList;
import java.util.Date;

import modele.Modele;

public class Controleur {

	public static Admin selectWhereAdmin (String email, String mdp) {
		//Controler l'email
		//controler la complexité du mdp
		return Modele.selectWhereAdmin(email, mdp);
	}

	public static ArrayList<Technicien> selectAllTechniciens (){
		return Modele.selectAllTechniciens();
	}

	public static void updateAdmin (Admin unAdmin)
	{
		Modele.updateAdmin (unAdmin);
	}
	public static void insertMateriel (Materiel unMateriel)
	{
		Modele.insertMateriel (unMateriel);
	}

	public static ArrayList<Materiel> selectAllMateriels(String filtre){
		return Modele.selectAllMateriels(filtre);
	}

	public static Materiel selectWhereMateriel (int id_materiel) {
		return Modele.selectWhereMateriel(id_materiel);
	}

	public static Materiel selectWhereMateriel (String nom) {
		return Modele.selectWhereMateriel(nom);
	}

	public static void deleteMateriel (int id_materiel)
	{
		Modele.deleteMateriel (id_materiel);
	}

	public static void updateMateriel (Materiel unMateriel)
	{
		Modele.updateMateriel (unMateriel);
	}

	public static void insertIntervention (Intervention uneIntervention) {
		Modele.insertIntervention (uneIntervention);
	}

	public static ArrayList<ViewNbIntervention> ViewNbIntervention() {

		return Modele.ViewNbIntervention();
	}

	public static void createAdmin(Admin newAdmin) {

		Modele.createAdmin(newAdmin);

	}

	public static void deleteTechnicien(int idTechnicien) {
		Modele.deleteTechnicien(idTechnicien);
	}

   public static ArrayList<Technicien> selectAllTechniciens(String filtre) {
		return Modele.selectAllTechniciens(filtre);
   }

	public static void updateTechnicien(Technicien unTechnicien) {
		Modele.updateTechnicien(unTechnicien);
	}

	public static Technicien selectWhereTechnicien(String email) {
		return Modele.selectWhereTechnicien(email);
	}

	public static void createTechnicien(Technicien unTechnicien) {
		Modele.createTechnicien(unTechnicien);
	}

	public static ArrayList<Client> selectAllClient (String filtre){
		return Modele.selectAllClient(filtre);
	}
	// selectAllInterventions
	public static ArrayList<Intervention> selectAllInterventions (String filtre){
		return Modele.selectAllInterventions(filtre);
	}

   public static Date convertStringToDate(String dateInter) {
		return Modele.convertStringToDate(dateInter);
   }

   public static Intervention selectWhereIntervention(int idIntervention) {
		return Modele.selectWhereIntervention(idIntervention);
   }

   public static Client selectClientById(String idClient) {
		return Modele.selectClientById(idClient);
   }

   public static Technicien selectTechnicienById(String idTechnicien) {
		return Modele.selectTechnicienById(idTechnicien);
   }

	public static Materiel selectMaterielById(String idMateriel) {
		return Modele.selectMaterielById(idMateriel);
	}

   public static String convertDateToString(Date date) {
		return Modele.convertDateToString(date);
   }

	public static Intervention selectWhereIntervention(String description, String dateinter, String status,
			int idTechnicien, int idClient, int idMateriel) {
		return Modele.selectWhereIntervention(description, dateinter, status, idTechnicien, idClient, idMateriel);
	}

	public static void deleteIntervention(int idIntervention) {
		Modele.deleteIntervention(idIntervention);
	}

   public static void updateIntervention(Intervention uneIntervention) {
		Modele.updateIntervention(uneIntervention);
   }
}










































