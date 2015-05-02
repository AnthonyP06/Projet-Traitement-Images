/**
 * Filtre qui prend le complémentaire des valeurs RGB de chaque pixel
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Inversion implements Filtre
{
	public BufferedImage appliquerFiltre(BufferedImage image)
	{
		// Construction d'une nouvelle image (l'image traitée) "Buffered" de mêmes caractéristiques que l'image initiale. 
		BufferedImage traite = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// Boucle sur les lignes et les colonnes de l'image traitée pour passer tous les pixels
		for (int y = 0; y < traite.getHeight(); y++)
		{
			for (int x=0; x < traite.getWidth(); x++)
			{
				//Récupération de la couleur de l'image initiale
				Color color = new Color(image.getRGB(x, y));
				int  red = color.getRed();
				int  green = color.getGreen();
				int  blue = color.getBlue();
				
				//Construction de la couleur de l'image traitée
				Color coloration = new Color(255 - red, 255 - green, 255 - blue);
				
				//Application de la couleur à l'image traitée
				traite.setRGB(x, y, coloration.getRGB());
			}
		}
		return traite;
	}
}

