package controleur;

public class Intervention {
	private int idinter; 
	private String description, dateinter;
	private float prix;
	private int idtechnicien, idmateriel;
	
	public Intervention(int idinter, String description, String dateinter, float prix, int idtechnicien,
			int idmateriel) {
		super();
		this.idinter = idinter;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idtechnicien = idtechnicien;
		this.idmateriel = idmateriel;
	} 
	public Intervention( String description, String dateinter, float prix, int idtechnicien,
			int idmateriel) {
		super();
		this.idinter = 0;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idtechnicien = idtechnicien;
		this.idmateriel = idmateriel;
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
	public int getIdtechnicien() {
		return idtechnicien;
	}
	public void setIdtechnicien(int idtechnicien) {
		this.idtechnicien = idtechnicien;
	}
	public int getIdmateriel() {
		return idmateriel;
	}
	public void setIdmateriel(int idmateriel) {
		this.idmateriel = idmateriel;
	} 
	
}
