/**
 * Filtre pour lequel on change un pixel en noir ou en blanc suivant un critère seuil.
 * Si la somme des composantes rouge/vert/bleu est inférieure à ce seuil, on change le pixel en blanc.
 * Dans le cas contraire, on le change en noir.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 15.05.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Seuil implements Filtre
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
				//Récupération des trois couleurs du pixel initial
				Color color = new Color(image.getRGB(x, y));
				int  blue = color.getBlue();
				int red = color.getRed();
				int green = color.getGreen();
				int seuil = blue + red + green;
				
				if(seuil<300)
				{
					//Construction de la couleur de l'image traitée (noir)
					Color coloration = new Color(0, 0, 0);
					
					//Application de la couleur à l'image traitée
					traite.setRGB(x, y, coloration.getRGB());
				}
				
				else
				{
					
					//Construction de la couleur de l'image traitée (blanc)
					Color coloration = new Color(255, 255, 255);
					
					//Application de la couleur à l'image traitée
					traite.setRGB(x, y, coloration.getRGB());
				}
			}
	
		}
		return traite;
	}
}
