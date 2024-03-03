package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Controleur;
import controleur.Materiel;
import controleur.Tableau;
import controleur.ViewAdmin;

public class PanelStats extends PanelPrincipal{

	private JTable tableView ;
	private JScrollPane uneScroll ;
	private Tableau unTableau ;

	public PanelStats() {
		super(Color.yellow);

		String entetes [] = {"Nom", "Prénom", "Nb Interventions"};
		this.unTableau = new Tableau(entetes, this.obtenirDonnees());
		this.tableView = new JTable(this.unTableau);
		this.uneScroll = new JScrollPane(tableView);

		this.uneScroll.setBounds(80, 80, 300, 200);
		this.add(this.uneScroll);

	}
	public Object [][] obtenirDonnees (){
		ArrayList<ViewAdmin> lesViewAdmins = Controleur.selectAllViewAdmins();
		Object  matrice[][] = new Object[lesViewAdmins.size()][3];
		int i = 0;
		for (ViewAdmin unViewAdmin : lesViewAdmins) {
			matrice [i][0] = unViewAdmin.getNom();
			matrice [i][1] = unViewAdmin.getPrenom();
			matrice [i][2] = unViewAdmin.getNbInters();
			i++;
		}
		return matrice;
	}

}
