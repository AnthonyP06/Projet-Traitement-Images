/**
 * Liste exhaustive de tous les formats gérés par le logiciel.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Formats;

public enum FormatsDisponibles 
{
	JPEG, PNG, ESI;


	/**
	 * Vérifier si le format passé en paramètre est bien un format géré par le logiciel.
	 * 
	 * @param format - le format dont on vérifie la compatibilité
	 * 
	 * @return true si OK, false si le format n'est pas géré par le logiciel.
	 */
	public static boolean exist(String format)
	{
		boolean rep = false;
		FormatsDisponibles[] tab = FormatsDisponibles.values(); //Tableau des formats de l'énumération
		
		//On parcourt la liste des formats pour voir si un élément du tableau correspond au format passé en paramètre de la méthode.
		for (int i = 0 ; i < tab.length ; i++)
		{
			if (tab[i].name().equals(format)) {rep = true;}
		}
		
		return rep;
	}
}
	
	