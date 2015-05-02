/**
 * Le filtre Warhol produit une mosa�que de 4 images identiques � l'image initiale (type Photomaton) avec des couleurs types PopArt.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 15.05.2014
 */
package Filtres;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Warhol implements Filtre
{
	public BufferedImage appliquerFiltre(BufferedImage image)
	{
		// Construction d'une nouvelle image (l'image trait�e) "Buffered" de m�mes caract�ristiques que l'image initiale. 
		BufferedImage traite = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
	
		// Boucle sur les lignes et les colonnes de l'image de d�part pour passer les pixels carr� par carr� de taille 2x2
		for (int y = 0; y < image.getHeight()-1; y=y+2)		// On se d�place suivant les y de 2 pixels en 2 pixels
		{
			for (int x=0; x < image.getWidth()-1; x=x+2)		// On se d�place suivant les x de 2 pixels en 2 pixels
			{
				// On initialise les couleurs � 0
				int red = 0;
				int green = 0;
				int blue = 0;	
			
				//On travaille sur le carre 2x2 (image de d�part) dont les composantes sont les pixels (x,y) ; (x+1,y) & (x,y+1) ; (x+1,y+1)
				Color color11 = new Color(image.getRGB(x, y));        // Couleur du pixel en haut � gauche
				Color color12 = new Color(image.getRGB(x, y+1));	  // Couleur du pixel en bas � gauche
				Color color21 = new Color(image.getRGB(x+1, y));	  // Couleur du pixel en haut � droite
				Color color22 = new Color(image.getRGB(x+1, y+1));	  // Couleur du pixel en bas � droite
				
				// On somme les composantes rouges des 4 pixels du carr�
				red = (int)((color11.getRed()+color12.getRed()+color21.getRed()+color22.getRed())/4);				
				
				// On somme les composantes vertes des 4 pixels du carr�
				green = (int)((color11.getGreen()+color12.getGreen()+color21.getGreen()+color22.getGreen())/4);		
				
				// On somme les composantes bleues des 4 pixels du carr�
				blue = (int)((color11.getBlue()+color12.getBlue()+color21.getBlue()+color22.getBlue())/4);			
				
				// Definition de toutes les couleurs PopArt.
				Color noir = new Color(0, 0, 0);
				Color blanc = new Color(255, 255, 255);
				Color cyan = new Color(0, 255, 255);
				Color magenta = new Color(255, 0, 255);
				Color jaune = new Color(255, 255, 0);
				Color jaunepale = new Color(255,255,180);
				Color vertfluo = new Color(0, 255, 80);
				Color rouge = new Color(255, 0, 0);
				Color orange = new Color(255,162,68);
				Color violet = new Color(64,0,128);
				
				//Couleur 1
				if(red+green+blue < 255)
				{
					traite.setRGB(x/2, y/2, noir.getRGB());		//En haut � gauche		
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2, blanc.getRGB());		//En haut � droite
					traite.setRGB(x/2, y/2+(int)(traite.getHeight()/2), blanc.getRGB());	//En bas � gauche
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2+(int)(traite.getHeight()/2), noir.getRGB());	//En bas � droite
				}
				
				//Couleur 2
				else if(red+green+blue<510 && red+green+blue >=255)
				{
					traite.setRGB(x/2, y/2, jaune.getRGB());		//En haut � gauche				
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2, rouge.getRGB());		//En haut � droite
					traite.setRGB(x/2, y/2+(int)(traite.getHeight()/2), violet.getRGB());	//En bas � gauche
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2+(int)(traite.getHeight()/2), jaunepale.getRGB());	//En bas � droite
				}
				
				//Couleur 3
				else
				{
					traite.setRGB(x/2, y/2, magenta.getRGB());			//En haut � gauche			
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2, vertfluo.getRGB());		//En haut � droite
					traite.setRGB(x/2, y/2+(int)(traite.getHeight()/2), orange.getRGB());		//En bas � gauche
					traite.setRGB(x/2+(int)(traite.getWidth()/2), y/2+(int)(traite.getHeight()/2), cyan.getRGB());	//En bas � droite
				}
			}
		}
		return traite;
	}
}

