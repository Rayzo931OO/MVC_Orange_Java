package controleur;

public class Client {
   private int idClient;
   private String nom, prenom, email, mdp, codePostal, adresse, tel, role;

   public Client(int idClient, String nom, String prenom, String email, String codePostal,String adresse, String tel, String mdp) {
      super();
      this.idClient = idClient;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.codePostal = codePostal;
      this.adresse = adresse;
      this.tel = tel;
      this.mdp = mdp;
      this.role = "technicien";
   }

   public Client(String nom, String prenom, String email, String codePostal,String adresse, String tel, String mdp) {
      super();
      this.idClient = 0;
      this.nom = nom;
      this.prenom = prenom;
      this.email = email;
      this.codePostal = codePostal;
      this.adresse = adresse;
      this.tel = tel;
      this.mdp = mdp;
      this.role = "technicien";
   }

   public int getIdClient() {
      return idClient;
   }

   public void setIdClient(int idClient) {
      this.idClient = idClient;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getMdp() {
      return mdp;
   }

   public void setMdp(String mdp) {
      this.mdp = mdp;
   }

   public String getCodePostal() {
      return codePostal;
   }

   public void setCodePostal(String codePostal) {
      this.codePostal = codePostal;
   }

   public String getAdresse() {
      return adresse;
   }

   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }
}
