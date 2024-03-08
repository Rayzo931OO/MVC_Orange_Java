package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {

	public static Admin selectWhereAdmin (String email, String mdp) {
		//Controler l'email
		//controler la complexité du mdp
		return Modele.selectWhereAdmin(email, mdp);
	}

	public static ArrayList<Admin> selectAllAdmins (){
		return Modele.selectAllAdmins();
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

	public static ArrayList<ViewTechnicien> selectAllViewTechniciens() {

		return Modele.selectAllViewTechniciens();
	}

	public static void createAdmin(Admin newAdmin) {

		Modele.createAdmin(newAdmin);

	}
}










































