package controleur;

public class Admin {
	private int idAdmin; 
	private String nom, prenom, email, mdp;
	
	public Admin(int idAdmin, String nom, String prenom, String qualification, String email, String mdp) {
		super();
		this.idAdmin = idAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	} 
	
	public Admin( String nom, String prenom, String qualification, String email, String mdp) {
		super();
		this.idAdmin = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdtechnicien(int idAdmin) {
		this.idAdmin = idAdmin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	} 
	
	
}
