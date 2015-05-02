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
	AugmenterContraste, DiminuerContraste, AugmenterLuminosite, DiminuerLuminosité, Photomaton,
	Warhol;
	
	/**
	 * Vérifier si le filtre passé en paramètre est bien un filtre géré par le logiciel.
	 * 
	 * @param filtre - le filtre, désigné par son numéro (en tant que String) dont on vérifie l'existence
	 * 
	 * @return true si OK, false si le filtre n'est pas géré par le logiciel.
	 */
	public static boolean exist(String filtre)
	{
		boolean rep = false;
		FiltresDisponibles[] tab = FiltresDisponibles.values(); //Tableau des filtres de l'énumération
		
		//On parcourt la liste des filtres pour voir si un élément du tableau correspond au numéro de filtre passé en paramètre de la méthode.
		for (int i = 0 ; i < tab.length ; i++)
		{
			if (String.valueOf(i).equals(filtre)) {rep = true;}
		}
		
		return rep;
	}
}
