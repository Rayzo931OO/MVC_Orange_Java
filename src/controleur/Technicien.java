package controleur;

/**
 * La classe Technicien représente un technicien dans le système.
 */
public class Technicien {
   private int idTechnicien;
   private String nom, prenom, email, mdp, codePostal, adresse, tel, role;

   /**
    * Constructeur de la classe Technicien avec tous les attributs.
    *
    * @param idTechnicien L'identifiant du technicien
    * @param nom          Le nom du technicien
    * @param prenom       Le prénom du technicien
    * @param email        L'adresse email du technicien
    * @param mdp          Le mot de passe du technicien
    * @param codePostal   Le code postal du technicien
    * @param adresse      L'adresse du technicien
    * @param tel          Le numéro de téléphone du technicien
    */
   public Technicien(int idTechnicien, String nom, String prenom, String email, String codePostal,String adresse, String tel, String mdp) {
      super();
      this.idTechnicien = idTechnicien;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.codePostal = codePostal;
      this.adresse = adresse;
      this.tel = tel;
      this.mdp = mdp;
      this.role = "technicien";
   }

   /**
    * Constructeur de la classe Technicien sans l'identifiant.
    *
    * @param nom         Le nom du technicien
    * @param prenom      Le prénom du technicien
    * @param email       L'adresse email du technicien
    * @param mdp         Le mot de passe du technicien
    * @param codePostal  Le code postal du technicien
    * @param adresse     L'adresse du technicien
    * @param tel         Le numéro de téléphone du technicien
    */
   public Technicien(String nom, String prenom, String email, String codePostal,String adresse, String tel, String mdp) {
      super();
      this.idTechnicien = 0;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.codePostal = codePostal;
      this.adresse = adresse;
      this.tel = tel;
      this.mdp = mdp;
      this.role = "technicien";
   }

   /**
    * Obtient l'identifiant du technicien.
    *
    * @return L'identifiant du technicien
    */
   public int getIdTechnicien() {
      return idTechnicien;
   }

   /**
    * Définit l'identifiant du technicien.
    *
    * @param idTechnicien Le nouvel identifiant du technicien
    */
   public void setIdTechnicien(int idTechnicien) {
      this.idTechnicien = idTechnicien;
   }

   /**
    * Obtient le nom du technicien.
    *
    * @return Le nom du technicien
    */
   public String getNom() {
      return nom;
   }

   /**
    * Définit le nom du technicien.
    *
    * @param nom Le nouveau nom du technicien
    */
   public void setNom(String nom) {
      this.nom = nom;
   }

   /**
    * Obtient le prénom du technicien.
    *
    * @return Le prénom du technicien
    */
   public String getPrenom() {
      return prenom;
   }

   /**
    * Définit le prénom du technicien.
    *
    * @param prenom Le nouveau prénom du technicien
    */
   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   /**
    * Obtient l'adresse email du technicien.
    *
    * @return L'adresse email du technicien
    */
   public String getEmail() {
      return email;
   }

   /**
    * Définit l'adresse email du technicien.
    *
    * @param email La nouvelle adresse email du technicien
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * Obtient le mot de passe du technicien.
    *
    * @return Le mot de passe du technicien
    */
   public String getMdp() {
      return mdp;
   }

   /**
    * Définit le mot de passe du technicien.
    *
    * @param mdp Le nouveau mot de passe du technicien
    */
   public void setMdp(String mdp) {
      this.mdp = mdp;
   }

   /**
    * Obtient le code postal du technicien.
    *
    * @return Le code postal du technicien
    */
   public String getCodePostal() {
      return codePostal;
   }

   /**
    * Définit le code postal du technicien.
    *
    * @param codePostal Le nouveau code postal du technicien
    */
   public void setCodePostal(String codePostal) {
      this.codePostal = codePostal;
   }

   /**
    * Obtient l'adresse du technicien.
    *
    * @return L'adresse du technicien
    */
   public String getAdresse() {
      return adresse;
   }

   /**
    * Définit l'adresse du technicien.
    *
    * @param adresse La nouvelle adresse du technicien
    */
   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   /**
    * Obtient le numéro de téléphone du technicien.
    *
    * @return Le numéro de téléphone du technicien
    */
   public String getTel() {
      return tel;
   }

   /**
    * Définit le numéro de téléphone du technicien.
    *
    * @param tel Le nouveau numéro de téléphone du technicien
    */
   public void setTel(String tel) {
      this.tel = tel;
   }

   /**
    * Obtient le rôle du technicien.
    *
    * @return Le rôle du technicien
    */
   public String getRole() {
      return role;
   }

   /**
    * Définit le rôle du technicien.
    *
    * @param role Le nouveau rôle du technicien
    */
   public void setRole(String role) {
      this.role = role;
   }
}
