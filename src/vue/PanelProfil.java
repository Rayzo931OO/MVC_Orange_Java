package vue;

import controleur.Admin;
import controleur.Controleur;
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

public class PanelProfil extends PanelPrincipal implements ActionListener {

  private JTextArea txtInfos = new JTextArea();
  private JButton btModifier = new JButton("Modifier");

  private JPanel panelForm = new JPanel();

  private JTextField txtNom = new JTextField();
  private JTextField txtPrenom = new JTextField();
  private JTextField txtEmail = new JTextField();
  private JPasswordField txtMdp = new JPasswordField();
  private JButton btAnnuler = new JButton("Annuler");
  private JButton btEnregistrer = new JButton("Enregistrer");

  private JButton btAjouter = new JButton("Ajouter");

  private JPanel panelFormAjout = new JPanel();

  private JTextField txtNomAjout = new JTextField();
  private JTextField txtPrenomAjout = new JTextField();
  private JTextField txtEmailAjout = new JTextField();
  private JPasswordField txtMdpAjout = new JPasswordField();
  private JButton btAnnulerAjout = new JButton("Annuler");
  private JButton btEnregistrerAjout = new JButton("Enregistrer");

  private Admin unAdmin;
  private Admin newAdmin;

  public PanelProfil(Admin unAdmin) {
    super(new Color(181, 135, 79));
    this.unAdmin = unAdmin;
	this.newAdmin = null;

    this.txtInfos.setBounds(40, 50, 260, 200);
    String infos =
      "\n --Informations de votre profil --" +
      "\n\n Nom : " +
      unAdmin.getNom() +
      "\n\n Prénom : " +
      unAdmin.getPrenom() +
      "\n\n Email : " +
      unAdmin.getEmail();

    this.txtInfos.setText(infos);
    this.txtInfos.setBackground(new Color(181, 135, 79));
    this.add(this.txtInfos);

    //construction du panel Form
    this.panelForm.setBounds(350, 50, 450, 250);
    this.panelForm.setBackground(new Color(181, 135, 79));
    this.panelForm.setLayout(new GridLayout(6, 1));
    this.panelForm.add(new JLabel("Nom : "));
    this.panelForm.add(this.txtNom);
    this.panelForm.add(new JLabel("Prénom : "));
    this.panelForm.add(this.txtPrenom);
    this.panelForm.add(new JLabel("Email : "));
    this.panelForm.add(this.txtEmail);
    this.panelForm.add(new JLabel("MDP : "));
    this.panelForm.add(this.txtMdp);
    this.panelForm.add(this.btAnnuler);
    this.panelForm.add(this.btEnregistrer);

    this.panelForm.setVisible(false);
    this.add(this.panelForm);

    this.btModifier.setBounds(100, 300, 100, 30);
    this.add(this.btModifier);

    //construction du panel Form Ajout
    this.panelFormAjout.setBounds(350, 50, 450, 250);
    this.panelFormAjout.setBackground(new Color(181, 135, 79));
    this.panelFormAjout.setLayout(new GridLayout(6, 1));
    this.panelFormAjout.add(new JLabel("Nom : "));
    this.panelFormAjout.add(this.txtNomAjout);
    this.panelFormAjout.add(new JLabel("Prénom : "));
    this.panelFormAjout.add(this.txtPrenomAjout);
    this.panelFormAjout.add(new JLabel("Email : "));
    this.panelFormAjout.add(this.txtEmailAjout);
    this.panelFormAjout.add(new JLabel("MDP : "));
    this.panelFormAjout.add(this.txtMdpAjout);
    this.panelFormAjout.add(this.btAnnulerAjout);
    this.panelFormAjout.add(this.btEnregistrerAjout);

    this.panelFormAjout.setVisible(false);
    this.add(this.panelFormAjout);

    this.btAjouter.setBounds(0, 300, 100, 30);
    this.add(this.btAjouter);

    //rendre les boutons ecoutables
    this.btAjouter.addActionListener(this);
    this.btModifier.addActionListener(this);
    this.btEnregistrer.addActionListener(this);
	this.btEnregistrerAjout.addActionListener(this);
    this.btAnnuler.addActionListener(this);
	this.btAnnulerAjout.addActionListener(this);

    //remplir les données
    this.txtNom.setText(unAdmin.getNom());
    this.txtPrenom.setText(unAdmin.getPrenom());
    this.txtEmail.setText(unAdmin.getEmail());
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
      //on peut vider les champs
    } else if (e.getSource() == this.btEnregistrer) {
      boolean ok = true;
      String nom = this.txtNom.getText();
      String prenom = this.txtPrenom.getText();
      String email = this.txtEmail.getText();
      String mdp = new String(this.txtMdp.getPassword());
      //on controle les données avant modification

      String regex = "^(.+)@(\\S+)$";
      ok = Pattern.compile(regex).matcher(email).matches();

      if (ok) {
        //on va enregistrer les modifs dans la base.
        this.unAdmin.setNom(nom);
        this.unAdmin.setPrenom(prenom);
        this.unAdmin.setEmail(email);
        this.unAdmin.setMdp(mdp);
        Controleur.updateAdmin(unAdmin);

        JOptionPane.showMessageDialog(this, "Modification effectuée");
        this.panelForm.setVisible(false);
        //actualiser les infos Admin dans la txtInfos
        String infos =
          "\n --Informations de votre profil --" +
          "\n\n Nom : " +
          unAdmin.getNom() +
          "\n\n Prénom : " +
          unAdmin.getPrenom() +
          "\n\n Email : " +
          unAdmin.getEmail();

        this.txtInfos.setText(infos);
      }
    } else if (e.getSource() == this.btAnnulerAjout) {
      this.panelFormAjout.setVisible(false);
      //on peut vider les champs
    } else if (e.getSource() == this.btEnregistrerAjout) {
      String nom = this.txtNomAjout.getText();
      String prenom = this.txtPrenomAjout.getText();
      String email = this.txtEmailAjout.getText();
      String mdp = new String(this.txtMdpAjout.getPassword());
      //on controle les données avant modification

      String regexEmail = "^(.+)@(\\S+)$";
      String regexMdp = "^(?=.*[a-zA-Z]).{3,}$";

      boolean ok = false;
      newAdmin = new Admin( "", "", "", "");
      // Vérification du regex pour l'email
      if (Pattern.compile(regexEmail).matcher(email).matches()) {
        // Vérification du regex pour le mot de passe
        if (Pattern.compile(regexMdp).matcher(mdp).matches()) {
          // Si les deux regex correspondent, définissez ok à true
          ok = true;
        }else{
			JOptionPane.showMessageDialog(this, "Mot de passe pas au bon format : 3 caractère minimum");
		}
      }else{
		JOptionPane.showMessageDialog(this, "Email pas au bon format");
	  }
      if (ok) {
        //on va enregistrer les modifs dans la base.
        this.newAdmin.setNom(nom);
        this.newAdmin.setPrenom(prenom);
        this.newAdmin.setEmail(email);
        this.newAdmin.setMdp(mdp);
        Controleur.createAdmin(newAdmin);

        JOptionPane.showMessageDialog(this, "Ajout effectuée");
        this.panelFormAjout.setVisible(false);
        //actualiser les infos Admin dans la txtInfos
        String infos =
          "\n --Informations de votre profil --" +
          "\n\n Nom : " +
          unAdmin.getNom() +
          "\n\n Prénom : " +
          unAdmin.getPrenom() +
          "\n\n Email : " +
          unAdmin.getEmail();

        this.txtInfos.setText(infos);
      }
    }
  }
}
