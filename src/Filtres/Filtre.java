/**
 * Interface de la classe filtre contenant la méthode servant à appliquer les filtres.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 04.04.2014
 */
package Filtres;

import java.awt.image.BufferedImage;

public interface Filtre 
{
	BufferedImage appliquerFiltre(BufferedImage image);
}
