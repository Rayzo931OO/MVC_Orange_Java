package controleur;

/**
 * La classe ViewTechnicien représente une vue technicien dans une architecture MVC.
 * Elle stocke des informations sur le nom, l'email et le numéro de téléphone du technicien.
 */
public class ViewTechnicien {
	private int id;

	private String nom, prenom, email, tel;

	/**
	 * Construit un objet ViewTechnicien avec le nom, l'email et le numéro de téléphone spécifiés.
	 *	@param id   le id du technicien
	 * @param nom   le nom du technicien
	 * @param prenom   le prénom du technicien
	 * @param email   l'adresse email du technicien
	 * @param tel   le numéro de téléphone du technicien
	 */
	public ViewTechnicien(int id, String nom, String prenom, String email, String tel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
	}


	/**
	 * Renvoie le id du technicien.
	 *
	 * @return le id du technicien
	 */
	public int getId() {
		return id;
	}

	/**
	 * Définit le id du technicien.
	 *
	 * @param id   le id du technicien
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Renvoie le nom du technicien.
	 *
	 * @return le nom du technicien
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom du technicien.
	 *
	 * @param nom   le nom du technicien
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Renvoie le prénom du technicien.
	 *
	 * @return le prénom du technicien
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Définit le prénom du technicien.
	 *
	 * @param prenom   le prénom du technicien
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Renvoie l'adresse email du technicien.
	 *
	 * @return l'adresse email du technicien
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Définit l'adresse email du technicien.
	 *
	 * @param email   l'adresse email du technicien
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Renvoie le numéro de téléphone du technicien.
	 *
	 * @return le numéro de téléphone du technicien
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Définit le numéro de téléphone du technicien.
	 *
	 * @param tel   le numéro de téléphone du technicien
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
}
