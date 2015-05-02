/**
 * Filtre diminuant la luminosit� d'une image
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 15.05.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class DiminuerLuminosite implements Filtre
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
				//R�cup�ration des trois couleurs du pixel initial
				Color color = new Color(image.getRGB(x, y));
				int  blue = color.getBlue();
				int red = color.getRed();
				int green = color.getGreen();
				
				//Construction de la couleur de l'image trait�e
				
				//Diminution du rouge
				if(red-40<0)
				{
					red=0;
				}
				else
				{
					red = red - 40;
				}
				
				//Diminution du vert
				if(green-40<0)
				{
					green=0;
				}
				else
				{
					green = green - 40;
				}
				
				//Diminution du bleu
				if(blue-40<0)
				{
					blue=0;
				}
				else
				{
					blue = blue - 40;
				}
				
				//D�finition de la nouvelle couleur
				Color coloration = new Color(red, green, blue);
				
				//Application de la couleur � l'image trait�e
				traite.setRGB(x, y, coloration.getRGB());
			}
		}
		return traite;
	}
}


