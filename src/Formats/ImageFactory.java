/**
 * Fabrique permettant de traiter l'image selon le format choisi (parmi ceux disponibles, cf classe FormatsDisponibles)
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 24.04.2014
 */
package Formats;

public class ImageFactory 
{
	/**
	 * Créer une interface pour traiter une image d'un format implémentant cette interface.
	 * 
	 * @param format - le chemin de destination de la photo à décompresser.
	 * 
	 * @return une interface permettant de traiter une image correspondant au format de la photo à décompresser
	 */
	public static ImageInterface create(String format) throws Exception
	{
		//Cas où le format n'est pas le bon
		if (FormatsDisponibles.exist(format) == false)
		{
			throw new Exception("Le format " + format + "n'est pas pris en charge par le logiciel.");
		}
		
		//Cas où le format est ESI
		else if (format.equals("ESI"))
		{
			return new EnsicaSimpleImage();
		}
		
		//Cas où le format est JPEG ou PNG
		else
		{
			return new AutresFormats();
		}
				
	}
}
