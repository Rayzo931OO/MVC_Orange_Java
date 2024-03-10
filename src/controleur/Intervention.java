package controleur;

/**
 * La classe Intervention représente une intervention dans le système.
 * Elle contient des informations telles que l'ID de l'intervention, la description, la date, le statut, l'ID du technicien, l'ID du client et l'ID de l'équipement.
 */
public class Intervention {
	private int idinter;
	private String description, dateinter, status;
	private int idTechnicien, idMateriel, idClient;

	/**
	 * Constructeur de la classe Intervention avec tous les paramètres.
	 *
	 * @param idinter       L'ID de l'intervention
	 * @param description   La description de l'intervention
	 * @param dateinter     La date de l'intervention
	 * @param status        Le statut de l'intervention
	 * @param idTechnicien  L'ID du technicien associé à l'intervention
	 * @param idClient      L'ID du client associé à l'intervention
	 * @param idMateriel    L'ID de l'équipement associé à l'intervention
	 */
	public Intervention(int idinter, String description, String dateinter, String status, int idTechnicien, int idClient, int idMateriel) {
		super();
		this.idinter = idinter;
		this.description = description;
		this.dateinter = dateinter;
		this.status = status;
		this.idTechnicien = idTechnicien;
		this.idClient = idClient;
		this.idMateriel = idMateriel;
	}

	/**
	 * Constructeur de la classe Intervention sans l'ID de l'intervention.
	 *
	 * @param description   La description de l'intervention
	 * @param dateinter     La date de l'intervention
	 * @param status        Le statut de l'intervention
	 * @param idTechnicien  L'ID du technicien associé à l'intervention
	 * @param idClient      L'ID du client associé à l'intervention
	 * @param idMateriel    L'ID de l'équipement associé à l'intervention
	 */
	public Intervention(String description, String dateinter, String status, int idTechnicien, int idClient, int idMateriel) {
		super();
		this.idinter = 0;
		this.description = description;
		this.dateinter = dateinter;
		this.status = status;
		this.idTechnicien = idTechnicien;
		this.idClient = idClient;
		this.idMateriel = idMateriel;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdTechnicien() {
		return idTechnicien;
	}

	public void setIdTechnicien(int idTechnicien) {
		this.idTechnicien = idTechnicien;
	}

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


}
