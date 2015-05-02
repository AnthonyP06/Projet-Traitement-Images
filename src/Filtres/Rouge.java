/**
 * Filtre ne gardant que la composante rouge de chaque pixel
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Rouge implements Filtre
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
				//R�cup�ration de la couleur rouge du pixel initial
				Color color = new Color(image.getRGB(x, y));
				int  red = color.getRed();
				
				//Construction de la couleur de l'image trait�e
				Color coloration = new Color(red, 0, 0);
				
				//Application de la couleur � l'image trait�e
				traite.setRGB(x, y, coloration.getRGB());
			}
		}
	return traite;
	}
}

