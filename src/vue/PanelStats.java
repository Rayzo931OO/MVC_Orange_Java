package vue;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Controleur;
import controleur.Materiel;
import controleur.Tableau;
import controleur.ViewTech;

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
		ArrayList<ViewTech> lesViewTechs = Controleur.selectAllViewTechs();  
		Object  matrice[][] = new Object[lesViewTechs.size()][3];
		int i = 0; 
		for (ViewTech unViewTech : lesViewTechs) {
			matrice [i][0] = unViewTech.getNom(); 
			matrice [i][1] = unViewTech.getPrenom(); 
			matrice [i][2] = unViewTech.getNbInters(); 
			 
			i++;
		}
		return matrice;
	}

}
