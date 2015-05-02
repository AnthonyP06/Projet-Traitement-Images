/**
 * Liste exhaustive de tous les formats g�r�s par le logiciel.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Formats;

public enum FormatsDisponibles 
{
	JPEG, PNG, ESI;


	/**
	 * V�rifier si le format pass� en param�tre est bien un format g�r� par le logiciel.
	 * 
	 * @param format - le format dont on v�rifie la compatibilit�
	 * 
	 * @return true si OK, false si le format n'est pas g�r� par le logiciel.
	 */
	public static boolean exist(String format)
	{
		boolean rep = false;
		FormatsDisponibles[] tab = FormatsDisponibles.values(); //Tableau des formats de l'�num�ration
		
		//On parcourt la liste des formats pour voir si un �l�ment du tableau correspond au format pass� en param�tre de la m�thode.
		for (int i = 0 ; i < tab.length ; i++)
		{
			if (tab[i].name().equals(format)) {rep = true;}
		}
		
		return rep;
	}
}
	
	