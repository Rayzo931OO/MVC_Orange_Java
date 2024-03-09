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

   public int getIdTechnicien() {
      return idTechnicien;
   }
}