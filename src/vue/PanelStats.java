package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Controleur;
import controleur.Tableau;
import controleur.ViewNbIntervention;

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
		ArrayList<ViewNbIntervention> lesViewNbIntervention = Controleur.ViewNbIntervention();
		Object  matrice[][] = new Object[lesViewNbIntervention.size()][3];
		int i = 0;
		for (ViewNbIntervention unViewNbIntervention : lesViewNbIntervention) {
			matrice [i][0] = unViewNbIntervention.getIdTechnicien();
			matrice [i][1] = unViewNbIntervention.getIdTechnicien();
			matrice [i][2] = unViewNbIntervention.getNbInters();
			i++;
		}
		return matrice;
	}

}
