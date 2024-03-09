package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Admin;
import controleur.Controleur;

public class PanelProfil extends PanelPrincipal implements ActionListener {

  private JTextArea txtInfos = new JTextArea();
  private JButton btModifier = new JButton("Modifier");

  private JPanel panelForm = new JPanel();

  private JTextField txtNom = new JTextField();
  private JTextField txtPrenom = new JTextField();
  private JTextField txtEmail = new JTextField();
  private JTextField txtAdresse = new JTextField();
  private JTextField txtCodePostal = new JTextField();
  private JTextField txtTel = new JTextField();
  private JPasswordField txtMdp = new JPasswordField();
  private JButton btAnnuler = new JButton("Annuler");
  private JButton btEnregistrer = new JButton("Enregistrer");

  private JButton btAjouter = new JButton("Ajouter");

  private JPanel panelFormAjout = new JPanel();

  private JTextField txtNomAjout = new JTextField();
  private JTextField txtPrenomAjout = new JTextField();
  private JTextField txtEmailAjout = new JTextField();
  private JPasswordField txtMdpAjout = new JPasswordField();
  private JTextField txtCodePostalAjout = new JTextField();
  private JTextField txtTelAjout = new JTextField();
  private JTextField txtAdresseAjout = new JTextField();
  private JButton btAnnulerAjout = new JButton("Annuler");
  private JButton btEnregistrerAjout = new JButton("Enregistrer");

  private Admin unAdmin;
  private Admin newAdmin;

  public PanelProfil(Admin unAdmin) {
    super(new Color(181, 135, 79));
    this.unAdmin = unAdmin;
    this.newAdmin = null;

    this.txtInfos.setBounds(40, 50, 260, 200);
    String infos = "\n --Informations de votre profil --" +
        "\n\n Nom : " +
        unAdmin.getNom() +
        "\n\n Prénom : " +
        unAdmin.getPrenom() +
        "\n\n Email : " +
        unAdmin.getEmail() +
        "\n\n Adresse : " +
        unAdmin.getAdresse() +
        "\n\n Code Postal : " +
        unAdmin.getCodePostal() +
        "\n\n Téléphone : " +
        unAdmin.getTel();

    this.txtInfos.setText(infos);
    this.txtInfos.setBackground(new Color(181, 135, 79));
    this.add(this.txtInfos);

    // construction du panel Form
    this.panelForm.setBounds(350, 50, 450, 250);
    this.panelForm.setBackground(new Color(181, 135, 79));
    this.panelForm.setLayout(new GridLayout(9, 1));
    this.panelForm.add(new JLabel("Nom : "));
    this.panelForm.add(this.txtNom);
    this.panelForm.add(new JLabel("Prénom : "));
    this.panelForm.add(this.txtPrenom);
    this.panelForm.add(new JLabel("Email : "));
    this.panelForm.add(this.txtEmail);
    this.panelForm.add(new JLabel("Adresse : "));
    this.panelForm.add(this.txtAdresse);
    this.panelForm.add(new JLabel("Code Postal : "));
    this.panelForm.add(this.txtCodePostal);
    this.panelForm.add(new JLabel("Telephone : "));
    this.panelForm.add(this.txtTel);
    this.panelForm.add(new JLabel("MDP : "));
    this.panelForm.add(this.txtMdp);
    this.panelForm.add(this.btAnnuler);
    this.panelForm.add(this.btEnregistrer);

    this.panelForm.setVisible(false);
    this.add(this.panelForm);

    this.btModifier.setBounds(100, 300, 100, 30);
    this.add(this.btModifier);

    // construction du panel Form Ajout
    this.panelFormAjout.setBounds(350, 50, 450, 250);
    this.panelFormAjout.setBackground(new Color(181, 135, 79));
    this.panelFormAjout.setLayout(new GridLayout(9, 1));
    this.panelFormAjout.add(new JLabel("Nom : "));
    this.panelFormAjout.add(this.txtNomAjout);
    this.panelFormAjout.add(new JLabel("Prénom : "));
    this.panelFormAjout.add(this.txtPrenomAjout);
    this.panelFormAjout.add(new JLabel("Email : "));
    this.panelFormAjout.add(this.txtEmailAjout);
    this.panelFormAjout.add(new JLabel("Adresse : "));
    this.panelFormAjout.add(this.txtAdresseAjout);
    this.panelFormAjout.add(new JLabel("Code Postal : "));
    this.panelFormAjout.add(this.txtCodePostalAjout);
    this.panelFormAjout.add(new JLabel("Telephone : "));
    this.panelFormAjout.add(this.txtTelAjout);
    this.panelFormAjout.add(new JLabel("MDP : "));
    this.panelFormAjout.add(this.txtMdpAjout);
    this.panelFormAjout.add(this.btAnnulerAjout);
    this.panelFormAjout.add(this.btEnregistrerAjout);

    this.panelFormAjout.setVisible(false);
    this.add(this.panelFormAjout);

    this.btAjouter.setBounds(0, 300, 100, 30);
    this.add(this.btAjouter);

    // rendre les boutons ecoutables
    this.btAjouter.addActionListener(this);
    this.btModifier.addActionListener(this);
    this.btEnregistrer.addActionListener(this);
    this.btEnregistrerAjout.addActionListener(this);
    this.btAnnuler.addActionListener(this);
    this.btAnnulerAjout.addActionListener(this);

    // remplir les données
    this.txtNom.setText(unAdmin.getNom());
    this.txtPrenom.setText(unAdmin.getPrenom());
    this.txtEmail.setText(unAdmin.getEmail());
    this.txtAdresse.setText(unAdmin.getAdresse());
    this.txtCodePostal.setText(unAdmin.getCodePostal());
    this.txtTel.setText(unAdmin.getTel());

  }

  public boolean verifyFields(String nom, String prenom, String email, String codePostal, String telephone,
      String adresse, String mdp) {
        boolean ok = false;
    String regexEmail = "^(.+)@(\\S+)$";
    String regexMdp = "^(?=.*[a-zA-Z]).{3,}$";
    String regexCodePostal = "^[0-9]{5}$";
    String regexTel = "^[0-9]{10}$";
    // nom, prenom et adresse ne doivent pas être vide, avec au moins 3 caractères
    if (nom.length() >= 3) {
      if (prenom.length() >= 3) {
        if (adresse.length() >= 3) {
          // verification du regex pour le code postal
          if (Pattern.compile(regexCodePostal).matcher(codePostal).matches()) {
            // verification du regex pour le téléphone
            if (Pattern.compile(regexTel).matcher(telephone).matches()) {
              // verification du regex pour l'email
              if (Pattern.compile(regexEmail).matcher(email).matches()) {
                // verification du regex pour le mot de passe
                if (Pattern.compile(regexMdp).matcher(mdp).matches()) {
                  // si les deux regex correspondent, définissez ok à true
                  return true;
                } else {
                  JOptionPane.showMessageDialog(this, "Mot de passe pas au bon format : 3 caractère minimum");
                }
              } else {
                JOptionPane.showMessageDialog(this, "Email pas au bon format");
              }
            } else {
              JOptionPane.showMessageDialog(this, "Téléphone pas au bon format : 10 chiffres");
            }
          } else {
            JOptionPane.showMessageDialog(this, "Code postal pas au bon format : 5 chiffres");
          }
        } else {
          JOptionPane.showMessageDialog(this, "Adresse pas au bon format : 3 caractère minimum");
        }
      } else {
        JOptionPane.showMessageDialog(this, "Prénom pas au bon format : 3 caractère minimum");
      }

    } else {
      JOptionPane.showMessageDialog(this, "Nom pas au bon format : 3 caractère minimum");
    }
    return ok;
  }

  public void viderChamps () {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtEmail.setText("");
		this.txtCodePostal.setText("");
		this.txtAdresse.setText("");
		this.txtTel.setText("");
		this.txtMdp.setText("");
		this.btEnregistrer.setText("Enregistrer");
	}
	public void viderChamps (String type) {
		if (type.equals("Modifier")) {
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtEmail.setText("");
			this.txtCodePostal.setText("");
			this.txtAdresse.setText("");
			this.txtTel.setText("");
			this.txtMdp.setText("");
      this.btEnregistrer.setText("Enregistrer");
		}else if (type.equals("Ajout")) {
			this.txtNomAjout.setText("");
			this.txtPrenomAjout.setText("");
			this.txtEmailAjout.setText("");
			this.txtCodePostalAjout.setText("");
			this.txtAdresseAjout.setText("");
			this.txtTelAjout.setText("");
			this.txtMdpAjout.setText("");
      this.btEnregistrerAjout.setText("Enregistrer");
		}

	}
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.btModifier) {
      this.panelForm.setVisible(true);
      this.panelFormAjout.setVisible(false);
    } else if (e.getSource() == this.btAjouter) {
      this.panelFormAjout.setVisible(true);
      this.panelForm.setVisible(false);
    } else if (e.getSource() == this.btAnnuler) {
      this.panelForm.setVisible(false);
      // on peut vider les champs
    } else if (e.getSource() == this.btEnregistrer) {
      String nom = this.txtNom.getText();
      String prenom = this.txtPrenom.getText();
      String email = this.txtEmail.getText();
      String codePostal = this.txtCodePostal.getText();
      String telephone = this.txtTel.getText();
      String adresse = this.txtAdresse.getText();
      String mdp = new String(this.txtMdp.getPassword());
      // on controle les données avant modification

      if (verifyFields(nom, prenom, email, codePostal, telephone, adresse, mdp)) {
        // on va enregistrer les modifs dans la base.
        this.unAdmin.setNom(nom);
        this.unAdmin.setPrenom(prenom);
        this.unAdmin.setEmail(email);
        this.unAdmin.setCodePostal(codePostal);
        this.unAdmin.setTel(telephone);
        this.unAdmin.setAdresse(adresse);
        this.unAdmin.setMdp(mdp);
        Controleur.updateAdmin(unAdmin);

        JOptionPane.showMessageDialog(this, "Modification effectuée");
        this.panelForm.setVisible(false);
        // actualiser les infos Admin dans la txtInfos
        String infos = "\n --Informations de votre profil --" +
            "\n\n Nom : " +
            unAdmin.getNom() +
            "\n\n Prénom : " +
            unAdmin.getPrenom() +
            "\n\n Email : " +
            unAdmin.getEmail() +
            "\n\n Adresse : " +
            unAdmin.getAdresse() +
            "\n\n Code Postal : " +
            unAdmin.getCodePostal() +
            "\n\n Téléphone : " +
            unAdmin.getTel();

        this.txtInfos.setText(infos);
        this.viderChamps("Modifier");
      }
    } else if (e.getSource() == this.btAnnulerAjout) {
      this.panelFormAjout.setVisible(false);
      // on peut vider les champs
    } else if (e.getSource() == this.btEnregistrerAjout) {
      String nom = this.txtNomAjout.getText();
      String prenom = this.txtPrenomAjout.getText();
      String email = this.txtEmailAjout.getText();
      String codePostal = this.txtCodePostalAjout.getText();
      String telephone = this.txtTelAjout.getText();
      String adresse = this.txtAdresseAjout.getText();
      String mdp = new String(this.txtMdpAjout.getPassword());
      // on controle les données avant modification
      newAdmin = new Admin("", "", "", "", "", "", "");
      if (verifyFields(nom, prenom, email, codePostal, telephone, adresse, mdp)) {
        // on va enregistrer les modifs dans la base.
        this.newAdmin.setNom(nom);
        this.newAdmin.setPrenom(prenom);
        this.newAdmin.setEmail(email);
        this.newAdmin.setCodePostal(codePostal);
        this.newAdmin.setTel(telephone);
        this.newAdmin.setAdresse(adresse);
        this.newAdmin.setMdp(mdp);
        Controleur.createAdmin(newAdmin);

        JOptionPane.showMessageDialog(this, "Ajout effectuée");
        this.panelFormAjout.setVisible(false);
        // actualiser les infos Admin dans la txtInfos
        String infos = "\n --Informations de votre profil --" +
            "\n\n Nom : " +
            unAdmin.getNom() +
            "\n\n Prénom : " +
            unAdmin.getPrenom() +
            "\n\n Email : " +
            unAdmin.getEmail() +
            "\n\n Adresse : " +
            unAdmin.getAdresse() +
            "\n\n Code Postal : " +
            unAdmin.getCodePostal() +
            "\n\n Téléphone : " +
            unAdmin.getTel();

        this.txtInfos.setText(infos);
        this.viderChamps("Ajout");
      }
    }
  }
}
