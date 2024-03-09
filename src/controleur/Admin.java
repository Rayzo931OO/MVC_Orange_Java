package controleur;

/**
 * La classe Admin représente un administrateur dans le système.
 * Elle contient des informations telles que l'ID, le nom, l'email, l'adresse et le rôle de l'administrateur.
 */
/**
 * The Admin class represents an administrator in the system.
 * It contains information such as the admin's ID, name, email, address, and
 * role.
 */
public class Admin {
	private int idAdmin;
	private String nom, prenom, email, mdp, codePostal, adresse, tel, role;

	/**
	 * Construit un nouvel objet Admin avec les détails spécifiés.
	 *
	 * @param idAdmin    l'ID de l'administrateur
	 * @param nom        le nom de famille de l'administrateur
	 * @param prenom     le prénom de l'administrateur
	 * @param email      l'adresse email de l'administrateur
	 * @param codePostal le code postal de l'administrateur
	 * @param adresse    l'adresse de l'administrateur
	 * @param tel        le numéro de téléphone de l'administrateur
	 * @param mdp        le mot de passe de l'administrateur
	 */
	public Admin(int idAdmin, String nom, String prenom, String email, String codePostal, String adresse, String tel,
			String mdp) {
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

	/**
	 * Construit un nouvel objet Admin avec les détails spécifiés.
	 *
	 * @param nom        le nom de famille de l'administrateur
	 * @param prenom     le prénom de l'administrateur
	 * @param email      l'adresse email de l'administrateur
	 * @param codePostal le code postal de l'administrateur
	 * @param adresse    l'adresse de l'administrateur
	 * @param tel        le numéro de téléphone de l'administrateur
	 * @param mdp        le mot de passe de l'administrateur
	 */
	public Admin(String nom, String prenom, String email, String codePostal, String adresse, String tel, String mdp) {
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

	/**
	 * Obtient l'ID de l'administrateur.
	 *
	 * @return l'ID de l'administrateur
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * Définit l'ID de l'administrateur.
	 *
	 * @param idAdmin l'ID de l'administrateur
	 */
	public void setIdadmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * Obtient le nom de famille de l'administrateur.
	 *
	 * @return le nom de famille de l'administrateur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Définit le nom de famille de l'administrateur.
	 *
	 * @param nom le nom de famille de l'administrateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtient le prénom de l'administrateur.
	 *
	 * @return le prénom de l'administrateur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Définit le prénom de l'administrateur.
	 *
	 * @param prenom le prénom de l'administrateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Obtient l'adresse email de l'administrateur.
	 *
	 * @return l'adresse email de l'administrateur
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Définit l'adresse email de l'administrateur.
	 *
	 * @param email l'adresse email de l'administrateur
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtient le mot de passe de l'administrateur.
	 *
	 * @return le mot de passe de l'administrateur
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Définit le mot de passe de l'administrateur.
	 *
	 * @param mdp le mot de passe de l'administrateur
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Obtient le code postal de l'administrateur.
	 *
	 * @return le code postal de l'administrateur
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	/**
	 * Obtient le code postal de l'administrateur.
	 *
	 * @return le code postal de l'administrateur
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Définit le code postal de l'administrateur.
	 *
	 * @param codePostal le code postal de l'administrateur
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Obtient l'adresse de l'administrateur.
	 *
	 * @return l'adresse de l'administrateur
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Définit l'adresse de l'administrateur.
	 *
	 * @param adresse l'adresse de l'administrateur
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Obtient le numéro de téléphone de l'administrateur.
	 *
	 * @return le numéro de téléphone de l'administrateur
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Définit le numéro de téléphone de l'administrateur.
	 *
	 * @param tel le numéro de téléphone de l'administrateur
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Obtient le rôle de l'administrateur.
	 *
	 * @return le rôle de l'administrateur
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Définit le rôle de l'administrateur.
	 *
	 * @param role le rôle de l'administrateur
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
