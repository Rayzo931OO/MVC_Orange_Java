package controleur;

public class ViewAdmin {
	private String nom, prenom; 
	private int nbInters ;
	
	public ViewAdmin(String nom, String prenom, int nbInters) {
		this.nom = nom;
		this.prenom = prenom;
		this.nbInters = nbInters;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNbInters() {
		return nbInters;
	}
	public void setNbInters(int nbInters) {
		this.nbInters = nbInters;
	} 
	
	
}
