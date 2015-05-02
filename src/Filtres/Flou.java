/**
 * Filtre appliquant un flou à la photo.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Flou implements Filtre
{
	/**
	 * Le filtre flou fait une moyenne des valeurs RGB du pixel courant ainsi que des 8 pixels autour du pixel courant. Le calcul est fait pour chaque pixel.
	 */
	public BufferedImage appliquerFiltre(BufferedImage image)
	{
		// Construction d'une nouvelle image (l'image traitée) "Buffered" de mêmes caractéristiques que l'image initiale. 
		BufferedImage traite = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		// Boucle sur les lignes et les colonnes de l'image traitée pour passer tous les pixels
		for (int y = 0; y < traite.getHeight(); y++)
		{
			for (int x=0; x < traite.getWidth(); x++)
			{
				int red = 0;
				int green = 0;
				int blue = 0;
				
				//Si on est sur un bord
				if(x==0 || x==image.getWidth()-1 || y==0 || y==image.getHeight()-1)
				{
					//Cas particulier du coin en haut à gauche
					if(x==0 && y==0)
					{
						for (int i=0; i<2; i++)
						{
							for (int j=0; j<2; j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/4), (int)(green/4), (int)(blue/4));
						traite.setRGB(x, y, coloration.getRGB());
					}
				
					// Cas particulier du coin en bas à gauche
					else if(x==0 && y==image.getHeight()-1)
					{
						for (int i=0; i<2; i++)
						{
							for (int j=image.getHeight()-2; j<image.getHeight(); j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/4), (int)(green/4), (int)(blue/4));
						traite.setRGB(x, y, coloration.getRGB());
					}
				
					//Cas particulier du coin en haut à droite
					else if(x==image.getWidth()-1 && y==0)
					{
						for (int i=image.getWidth()-2; i<image.getWidth(); i++)
						{
							for (int j=0; j<2; j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/4), (int)(green/4), (int)(blue/4));
						traite.setRGB(x, y, coloration.getRGB());
					}
				
					//Cas particulier du coin en bas à droite
					else if(x==image.getWidth()-1 && y==image.getHeight()-1)
					{
						for (int i=image.getWidth()-2; i<image.getWidth(); i++)
						{
							for (int j=image.getHeight()-2; j<image.getHeight(); j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/4), (int)(green/4), (int)(blue/4));
						traite.setRGB(x, y, coloration.getRGB());
					}
				
					//Cas particulier du bord supérieur
					else if(y==0 && x!=0 && x!=image.getWidth()-1)
					{
						for (int i=x-1; i<x+2; i++)
						{
							for (int j=y; j<y+2; j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/6), (int)(green/6), (int)(blue/6));
						traite.setRGB(x, y, coloration.getRGB());
					}
					
					//Cas particulier du bord inférieur
					else if(y==image.getHeight()-1 && x!=0 && x!=image.getWidth()-1)
					{
						for (int i=x-1; i<x+2; i++)
						{
							for (int j=image.getHeight()-2; j<image.getHeight(); j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/6), (int)(green/6), (int)(blue/6));
						traite.setRGB(x, y, coloration.getRGB());
					}
					
					//Cas particulier du bord latéral droit
					else if(x==image.getWidth()-1 && y!=0 && y!=image.getHeight()-1)
					{
						for (int i=image.getWidth()-2; i<image.getWidth(); i++)
						{
							for (int j=y-1; j<y+2; j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/6), (int)(green/6), (int)(blue/6));
						traite.setRGB(x, y, coloration.getRGB());
					}
					
					//Cas particulier du bord latéral gauche
					else if(x==0 && y!=0 && y!=image.getHeight()-1)
					{
						for (int i=x; i<x+2; i++)
						{
							for (int j=y-1; j<y+2; j++)
							{
								Color color = new Color(image.getRGB(i, j));
								red = red + color.getRed();
								green = green + color.getGreen();
								blue = blue + color.getBlue();
							}
						}
						Color coloration = new Color((int)(red/6), (int)(green/6), (int)(blue/6));
						traite.setRGB(x, y, coloration.getRGB());
					}
				}
				
				//Si on n'est pas sur le bord
				else
				{
					for (int j = y-1; j < y+2 ; j++)
					{
						for (int i = x-1; i < x+2; i++)
						{
							Color color = new Color(image.getRGB(i, j));
							red=red + color.getRed();
							green=green + color.getGreen();
							blue=blue + color.getBlue();
						}
					}	
					Color coloration = new Color((int)(red/9), (int)(green/9), (int)(blue/9));
					traite.setRGB(x, y, coloration.getRGB());	
				}
			}
		}
		return traite;
	}
}
