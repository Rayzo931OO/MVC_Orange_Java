package controleur;

public class Materiel {
	private int idmateriel ; 
	private String designation, dateAchat, categorie ; 
	private float prixAchat; 
	
	public Materiel(int idmateriel, String designation, String dateAchat, float prixAchat, String categorie) {
		super();
		this.idmateriel = idmateriel;
		this.designation = designation;
		this.dateAchat = dateAchat;
		this.prixAchat = prixAchat;
		this.categorie = categorie;
	} 
	
	public Materiel( String designation, String dateAchat, float prixAchat, String categorie) {
		super();
		this.idmateriel = 0;
		this.designation = designation;
		this.dateAchat = dateAchat;
		this.prixAchat = prixAchat;
		this.categorie = categorie;
	}

	public int getIdmateriel() {
		return idmateriel;
	}

	public void setIdmateriel(int idmateriel) {
		this.idmateriel = idmateriel;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}

	public float getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	} 
	
}
