package controleur;

public class Categorie {
	private int id_categorie ;
	private String nom, description ;

	public Categorie(int id_categorie, String nom, String description) {
		super();
		this.id_categorie = id_categorie;
		this.nom = nom;
		this.description = description;
	}

	public Categorie( String nom, String description) {
		super();
		this.id_categorie = 0;
		this.nom = nom;
		this.description = description;
	}

	public int getIdCategorie() {
		return id_categorie;
	}

	public void setIdCategorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
