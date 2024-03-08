package controleur;

public class Admin {
	private int idAdmin;
	private String nom, prenom, email, mdp, codePostal, adresse, tel, role;

	public Admin(int idAdmin, String nom, String prenom, String email, String mdp, String codePostal, String adresse, String tel) {
		super();
		this.idAdmin = idAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.codePostal = codePostal;
		this.adresse = adresse;
		this.tel = tel;
		this.mdp = mdp;
		this.role = "admin";
	}

	public Admin( String nom, String prenom, String email, String mdp,String codePostal, String adresse, String tel) {
		super();
		this.idAdmin = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.codePostal = codePostal;
		this.adresse = adresse;
		this.tel = tel;
		this.mdp = mdp;
		this.role = "admin";
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdadmin(int idAdmin) {
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

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
