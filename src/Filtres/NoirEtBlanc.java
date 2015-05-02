/**
 * Transforme une photo en noir et blanc.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class NoirEtBlanc implements Filtre
{
	public BufferedImage appliquerFiltre(BufferedImage image)
	{
		// Construction d'une nouvelle image (l'image trait�e) "Buffered" de m�mes caract�ristiques que l'image initiale. 
		BufferedImage traite = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// Boucle sur les lignes et les colonnes de l'image trait�e pour passer tous les pixels
		for (int y = 0; y < traite.getHeight(); y++)
		{
			for (int x=0; x < traite.getWidth(); x++)
			{
				//R�cup�ration de la couleur de l'image initiale
				Color color = new Color(image.getRGB(x, y));
				int  red = color.getRed();
				int  green = color.getGreen();
				int  blue = color.getBlue();
				
				//Construction de la couleur de l'image trait�e
				int couleur = (int)((red + green + blue) / 3);
				Color coloration = new Color(couleur, couleur, couleur);
				
				//Application de la couleur � l'image trait�e
				traite.setRGB(x, y, coloration.getRGB());
			}
		}
	return traite;
	}
}
