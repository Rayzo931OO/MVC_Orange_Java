package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Admin;
import controleur.OrangeEvent;

public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btAdmins = new JButton("Techniciens");
	private JButton btMateriels = new JButton("Materiels");
	private JButton btInterventions = new JButton("Interventions");
	private JButton btStats = new JButton("Stats");
	private JButton btProfil = new JButton("Profil");
	private JButton btQuitter = new JButton("Quitter");

	private JPanel panelMenu = new JPanel ();
	private static PanelProfil unPanelProfil ;
	private static PanelTechniciens unPanelAdmins = new PanelTechniciens();
	private static PanelMateriels unPanelMateriels = new PanelMateriels();
	private static PanelInterventions unPanelInterventions = new PanelInterventions();
	private static PanelStats unPanelStats = new PanelStats();


	public  VueGenerale(Admin unAdmin) {

		unPanelProfil =  new PanelProfil(unAdmin);

		this.setTitle("Orange Event 2024");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1000, 600);
		this.getContentPane().setBackground(new Color ( 181, 135, 79  ));
		this.setLayout(null);
		this.setResizable(false);
		//installation du panel menu
		panelMenu.setBounds(100, 20, 800, 30);
		panelMenu.setLayout(new GridLayout(1, 6));
		panelMenu.setBackground(new Color ( 181, 135, 79));
		panelMenu.add(this.btProfil);
		panelMenu.add(this.btAdmins);
		panelMenu.add(this.btMateriels);
		panelMenu.add(this.btInterventions);
		panelMenu.add(this.btStats);
		panelMenu.add(this.btQuitter);
		this.add(panelMenu);

		//rendre les boutons cliquables
		this.btQuitter.addActionListener(this);
		this.btAdmins.addActionListener(this);
		this.btMateriels.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btProfil.addActionListener(this);

		//ajout des pannels dans la fenetre
		this.add(unPanelProfil);
		this.add(unPanelAdmins);
		this.add(unPanelMateriels);
		this.add(unPanelInterventions);
		this.add(unPanelStats);

		this.setVisible(true);
	}

	public void afficher (int choix) {
		unPanelProfil.setVisible(false);
		unPanelAdmins.setVisible(false);
		unPanelMateriels.setVisible(false);
		unPanelInterventions.setVisible(false);
		unPanelStats.setVisible(false);

		switch (choix) {
		case 1 : unPanelProfil.setVisible(true); break;
		case 2 : unPanelAdmins.setVisible(true); break;
		case 3 : unPanelMateriels.setVisible(true); break;
		case 4 : unPanelInterventions.setVisible(true); break;
		case 5 : unPanelStats.setVisible(true); break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.btQuitter == e.getSource())
		{
			OrangeEvent.rendreVisibleGenerale(false, null);
			OrangeEvent.rendreVisibleConnexion(true);
		}
		else if (e.getSource() == this.btProfil) {
			afficher(1);
		}
		else if (e.getSource() == this.btAdmins) {
			afficher(2);
		}
		else if (e.getSource() == this.btMateriels) {
			afficher(3);
		}
		else if (e.getSource() == this.btInterventions) {
			afficher(4);
		}
		else if (e.getSource() == this.btStats) {
			afficher(5);
		}
	}

}






















