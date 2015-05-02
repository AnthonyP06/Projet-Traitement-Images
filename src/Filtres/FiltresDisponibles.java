/**
 * Liste exhaustive de tous les filtres disponibles pour l'utilisateur.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 24.04.2014
 */
package Filtres;

public enum FiltresDisponibles 
{
	NoFilter, NoirEtBlanc, Inversion, Flou, Bleu, Rouge, Vert, Sepia, Seuil,
	AugmenterContraste, DiminuerContraste, AugmenterLuminosite, DiminuerLuminosit�, Photomaton,
	Warhol;
	
	/**
	 * V�rifier si le filtre pass� en param�tre est bien un filtre g�r� par le logiciel.
	 * 
	 * @param filtre - le filtre, d�sign� par son num�ro (en tant que String) dont on v�rifie l'existence
	 * 
	 * @return true si OK, false si le filtre n'est pas g�r� par le logiciel.
	 */
	public static boolean exist(String filtre)
	{
		boolean rep = false;
		FiltresDisponibles[] tab = FiltresDisponibles.values(); //Tableau des filtres de l'�num�ration
		
		//On parcourt la liste des filtres pour voir si un �l�ment du tableau correspond au num�ro de filtre pass� en param�tre de la m�thode.
		for (int i = 0 ; i < tab.length ; i++)
		{
			if (String.valueOf(i).equals(filtre)) {rep = true;}
		}
		
		return rep;
	}
}
