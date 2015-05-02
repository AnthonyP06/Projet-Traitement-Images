/**
 * Filtre ne faisant aucune opération sur une photo. Pratique pour utiliser le logiciel comme un convertisseur de formats d'images.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Filtres;

import java.awt.image.BufferedImage;

public class NoFilter implements Filtre
{
	public BufferedImage appliquerFiltre(BufferedImage image)
	{
		return image;
	}
}
