/**
 * Filtre appliquant un effet sépia sur la photo
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 15.05.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Sepia implements Filtre
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
				int niveau = blue + red + green;
				
				//Construction de la nouvelle couleur en fonction de la valeur du niveau
				if(niveau<125)
				{
					//Nouveau rouge
					if((int)( 94 - (125-niveau)/3)<0)
					{
						red = 0;
					}
					else
					{
						red = (int)( 94 - (125-niveau)/3); 
					}
					
					//Nouveau vert
					if((int)(38 - (125-niveau)/3)<0)
					{
						green = 0;
					}
					else
					{
						green = (int)(38 - (125-niveau)/3); 
					}
					
					//Nouveau bleu
					if((int)(18 - (125-niveau)/3)<0)
					{
						blue = 0;
					}
					else
					{
						blue = (int)(18 - (125-niveau)/3); 
					}
				}
				else
				{
					//Nouveau rouge
					if((int)(94 + (niveau-125)/3)>255)
					{
						red = 255;
					}
					else
					{
						red = (int)(94 + (niveau-125)/3); 
					}
					
					//Nouveau vert
					if((int)(38 + (niveau-125)/3)>255)
					{
						green = 255;
					}
					else
					{
						green = (int)(38 + (niveau-125)/3); 
					}
					
					//Nouveay bleu
					if((int)(18 + (niveau-125)/3)>255)
					{
						blue = 255;
					}
					else
					{
						blue = (int)(18 + (niveau-125)/3); 
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

