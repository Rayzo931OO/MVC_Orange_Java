package controleur;

public class Intervention {
	private int idinter; 
	private String description, dateinter;
	private float prix;
	private int idadmin, idmateriel;
	
	public Intervention(int idinter, String description, String dateinter, float prix, int idadmin,
			int idmateriel) {
		super();
		this.idinter = idinter;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idadmin = idadmin;
		this.idmateriel = idmateriel;
	} 
	public Intervention( String description, String dateinter, float prix, int idadmin,
			int idmateriel) {
		super();
		this.idinter = 0;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idadmin = idadmin;
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
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public int getIdmateriel() {
		return idmateriel;
	}
	public void setIdmateriel(int idmateriel) {
		this.idmateriel = idmateriel;
	} 
	
}
