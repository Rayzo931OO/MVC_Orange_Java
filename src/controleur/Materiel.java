package controleur;

public class Materiel {
	private int id_materiel ;
	private String nom, description ;

	public Materiel(int id_materiel, String nom, String description) {
		super();
		this.id_materiel = id_materiel;
		this.nom = nom;
		this.description = description;
	}

	public Materiel( String nom, String description) {
		super();
		this.id_materiel = 0;
		this.nom = nom;
		this.description = description;
	}

	public int getIdmateriel() {
		return id_materiel;
	}

	public void setIdmateriel(int id_materiel) {
		this.id_materiel = id_materiel;
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
