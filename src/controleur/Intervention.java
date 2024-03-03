package controleur;

public class Intervention {
	private int idinter;
	private String description, dateinter;
	private float prix;
	private int idTechnicien, id_materiel;

	public Intervention(int idinter, String description, String dateinter, float prix, int idTechnicien,
			int id_materiel) {
		super();
		this.idinter = idinter;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idTechnicien = idTechnicien;
		this.id_materiel = id_materiel;
	}
	public Intervention( String description, String dateinter, float prix, int idTechnicien,
			int id_materiel) {
		super();
		this.idinter = 0;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idTechnicien = idTechnicien;
		this.id_materiel = id_materiel;
	}
	public int getIdinter() {
		return idinter;
	}
	public void setIdinter(int idinter) {
		this.idinter = idinter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateinter() {
		return dateinter;
	}
	public void setDateinter(String dateinter) {
		this.dateinter = dateinter;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getIdTechnicien() {
		return idTechnicien;
	}
	public void setIdTechnicien(int idTechnicien) {
		this.idTechnicien = idTechnicien;
	}
	public int getIdmateriel() {
		return id_materiel;
	}
	public void setIdmateriel(int id_materiel) {
		this.id_materiel = id_materiel;
	}

}
