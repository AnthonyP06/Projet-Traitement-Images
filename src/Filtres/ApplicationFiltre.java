
/**
 * Permet d'appliquer n'importe quel filtre parmi la liste exhaustive de filtres propos�s par la classe FiltresDisponibles.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 24.04.2014
 */
package Filtres;

import java.awt.image.BufferedImage;

public class ApplicationFiltre 
{
	/**
	 * Appliquer un filtre quelconque � une image de type BufferedImage.
	 * 
	 * @param image - l'image � traiter
	 * @param filtre - le filtre � appliquer
	 * 
	 * @return l'image traitee, de type BufferedImage.
	 */
	public static BufferedImage application(BufferedImage image, Filtre filtre)
	{
		image = filtre.appliquerFiltre(image);
		return image;
	}
}
