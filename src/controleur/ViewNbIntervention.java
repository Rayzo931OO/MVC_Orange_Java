package controleur;
public class ViewNbIntervention {
	private int nbInters ;
   private String nom;
   private String prenom;

   public ViewNbIntervention( String nom, String prenom, int nbInters) {
		this.nbInters = nbInters;
      this.nom = nom;
      this.prenom = prenom;
	}

   public int getNbInters() {
      return nbInters;
   }

   public void setNbInters(int nbInters) {
      this.nbInters = nbInters;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getPrenom() {
      return prenom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }
}