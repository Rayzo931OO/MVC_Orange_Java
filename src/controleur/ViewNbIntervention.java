package controleur;
public class ViewNbIntervention {
	private int nbInters ;
	private int idTechnicien ;

	public ViewNbIntervention(int idTechnicien, int nbInters) {
		this.idTechnicien = idTechnicien;
		this.nbInters = nbInters;
	}

   public int getNbInters() {
      return nbInters;
   }

   public void setNbInters(int nbInters) {
      this.nbInters = nbInters;
   }

   public int getIdTechnicien() {
      return idTechnicien;
   }

   public void setIdTechnicien(int idTechnicien) {
      this.idTechnicien = idTechnicien;
   }
}