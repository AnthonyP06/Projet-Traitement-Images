/**
 * Fabrique permettant de traiter l'image selon le filtre choisi (parmi ceux disponibles, cf classe FiltresDisponibles)
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 14.05.2014
 */
package Filtres;

public class FiltreFactory 
{
	/**
	 * Créer une interface pour traiter une image d'un format implémentant cette interface.
	 * 
	 * @param filtre - le filtre que l'on veut appliquer.
	 * 
	 * @return une interface permettant de filtrer une image correspondant à celui choisi par l'utilisateur
	 */
	public static Filtre create(String filtre) throws Exception
	{
		//Cas où le filtre n'est pas le bon
		if (FiltresDisponibles.exist(filtre) == false)
		{
			throw new Exception("Le filtre " + filtre + " n'existe pas dans ce logiciel");
		}
		
		//Filtre 0 : NoFilter
		else if (filtre.equals("0"))
		{
			return new NoFilter();
		}
		
		//Filtre 1 : NoirEtBlanc
		else if (filtre.equals("1"))
		{
			return new NoirEtBlanc();
		}
		
		//Filtre 2 : Inversion
		else if (filtre.equals("2"))
		{
			return new Inversion();
		}
		
		//Filtre 3 : Flou
		else if (filtre.equals("3"))
		{
			return new Flou();
		}
		
		//Filtre 4 : Bleu
		else if (filtre.equals("4"))
		{
			return new Bleu();
		}
		
		//Filtre 5 : Rouge
		else if (filtre.equals("5"))
		{
			return new Rouge();
		}
		
		//Filtre 6 : Vert
		else if (filtre.equals("6"))
		{
			return new Vert();
		}
		
		//Filtre 7 : Sepia
		else if (filtre.equals("7"))
		{
			return new Sepia();
		}
		
		//Filtre 8 : Seuil
		else if (filtre.equals("8"))
		{
			return new Seuil();
		}
		
		//Filtre 9 : AugmenterContraste
		else if (filtre.equals("9"))
		{
			return new AugmenterContraste();
		}
		
		//Filtre 10 : DiminuerContraste
		else if (filtre.equals("10"))
		{
			return new DiminuerContraste();
		}
		
		//Filtre 11 : AugmenterLuminosite
		else if (filtre.equals("11"))
		{
			return new AugmenterLuminosite();
		}
		
		//Filtre 12 : DiminuerLuminosite
		else if (filtre.equals("12"))
		{
			return new DiminuerLuminosite();
		}
		
		//Filtre 13 : Photomaton
		else if (filtre.equals("13"))
		{
			return new Photomaton();
		}
		
		//Filtre 14 : Warhol
		else
		{
			return new Warhol();
		}
	}
	
	/**
	 * Donner le nom (sous forme de chaine de caracteres) d'un numéro de filtre passé en argument
	 * 
	 * @param filtre - le numéro du filtre
	 * 
	 * @return le nom du filtre
	 */
	public static String name(String filtre) throws Exception
	{
		//Cas où le filtre n'existe pas
		if (FiltresDisponibles.exist(filtre) == false)
		{
			throw new Exception("Le filtre " + filtre + " n'existe pas dans ce logiciel");
		}
		
		//Sinon...
		else
		{
			String rep = "";
			FiltresDisponibles[] tab = FiltresDisponibles.values(); //Tableau des filtres de l'énumération
			
			//On parcourt la liste des filtres pour voir si un élément du tableau correspond au numéro de filtre passé en paramètre de la méthode.
			for (int i = 0 ; i < tab.length ; i++)
			{
				if (String.valueOf(i).equals(filtre)) {rep = tab[i].name();}
			}
			
			return rep;
		}
	}
}