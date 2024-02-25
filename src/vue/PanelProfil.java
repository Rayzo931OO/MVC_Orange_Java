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

import controleur.Controleur;
import controleur.Admin;

public class PanelProfil extends PanelPrincipal implements ActionListener
{
	private JTextArea txtInfos = new JTextArea();
	private JButton btModifier = new JButton("Modifier");
	
	private JPanel panelForm = new JPanel (); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField();
	private JTextField txtQualif = new JTextField();
	private JTextField txtEmail= new JTextField();
	private JPasswordField txtMdp = new JPasswordField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	private Admin unAdmin ; 
	
	public PanelProfil( Admin unAdmin ) {
		super(new Color ( 181, 135, 79  ));
		
		this.unAdmin = unAdmin; 
		
		this.txtInfos.setBounds(40, 50, 260, 200);
		String infos ="\n --Informations de votre profil --" 
					 + "\n\n Nom : "+unAdmin.getNom()
					 + "\n\n Prénom : "+unAdmin.getPrenom()
					 + "\n\n Qualification : "+unAdmin.getQualification()
					 + "\n\n Email : "+unAdmin.getEmail();
		
		this.txtInfos.setText(infos);
		this.txtInfos.setBackground(new Color ( 181, 135, 79  ));
		this.add(this.txtInfos);
		
		//construction du panel Form 
		this.panelForm.setBounds(350, 50, 450, 250);
		this.panelForm.setBackground(new Color ( 181, 135, 79  ));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom : ")); 
		this.panelForm.add(this.txtNom); 
		this.panelForm.add(new JLabel("Prénom : ")); 
		this.panelForm.add(this.txtPrenom); 
		this.panelForm.add(new JLabel("Qualification : ")); 
		this.panelForm.add(this.txtQualif); 
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
		
		//rendre les boutons ecoutables 
		this.btModifier.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//remplir les données 
		this.txtNom.setText(unAdmin.getNom());
		this.txtPrenom.setText(unAdmin.getPrenom());
		this.txtQualif.setText(unAdmin.getQualification());
		this.txtEmail.setText(unAdmin.getEmail());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btModifier) {
			this.panelForm.setVisible(true);
		}
		else if (e.getSource() == this.btAnnuler) {
			this.panelForm.setVisible(false);
			//on peut vider les champs 
		}
		else if (e.getSource() == this.btEnregistrer) {
			boolean ok = true ; 
			String nom = this.txtNom.getText(); 
			String prenom = this.txtPrenom.getText(); 
			String qualif = this.txtQualif.getText(); 
			String email = this.txtEmail.getText(); 
			String mdp =new String(this.txtMdp.getPassword()); 
			//on controle les données avant modification 
			 
		
			String regex ="^(.+)@(\\S+)$";
			ok = Pattern.compile(regex).matcher(email).matches(); 
					
			if (ok) {
				//on va enregistrer les modifs dans la base. 
				this.unAdmin.setNom(nom); 
				this.unAdmin.setPrenom(prenom); 
				this.unAdmin.setQualification(qualif);
				this.unAdmin.setEmail(email);
				this.unAdmin.setMdp(mdp);
				Controleur.updateAdmin (unAdmin);
				
				JOptionPane.showMessageDialog(this, "Modification effectuée");
				this.panelForm.setVisible(false);
				//actualiser les infos Admin dans la txtInfos 
				String infos ="\n --Informations de votre profil --" 
						 + "\n\n Nom : "+unAdmin.getNom()
						 + "\n\n Prénom : "+unAdmin.getPrenom()
						 + "\n\n Qualification : "+unAdmin.getQualification()
						 + "\n\n Email : "+unAdmin.getEmail();
			
				this.txtInfos.setText(infos);
			}
		}
		
	}
}




























