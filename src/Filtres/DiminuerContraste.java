/**
 * Filtre diminuant le contraste d'une image
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 15.05.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class DiminuerContraste implements Filtre
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
				int blue = color.getBlue();
				int red = color.getRed();
				int green = color.getGreen();
				int niveau = blue + red + green;
				
				//Construction de la nouvelle couleur en fonction d'un critère : la valeur du niveau 
				//Niveau bas
				if(niveau < 382)
				{
					//Augmentation du rouge
					if(red+20 > 255)
					{
						red = 255;
					}
					else
					{
						red = red + 20;
					}
					
					//Augmentation du vert
					if(green+20 > 255)
					{
						green = 255;
					}
					else
					{
						green = green + 20;
					}
					
					//Augmentation du bleu
					if(blue+20 > 255)
					{
						blue = 255;
					}
					else
					{
						blue = blue + 20;
					}
				}
				
				//Niveau haut
				else
				{
					//Diminution du rouge
					if(red-20 < 0)
					{
						red = 0;
					}
					else
					{
						red = red - 20;
					}
					
					//Diminution du vert
					if(green-20 < 0)
					{
						green = 0;
					}
					else
					{
						green = green - 20;
					}
					
					//Diminution du bleu
					if(blue-20 < 0)
					{
						blue = 0;
					}
					else
					{
						blue = blue - 20;
					}
				}
				//Definition de la nouvelle couleur
				Color coloration = new Color(red, green, blue);
					
				//Application de la couleur à l'image traitée
				traite.setRGB(x, y, coloration.getRGB());
			}	
		}
		return traite;
	}
}
