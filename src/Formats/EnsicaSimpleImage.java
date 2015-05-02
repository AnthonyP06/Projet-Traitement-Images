/**
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 07.04.2014 
 */
package Formats;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.awt.Color;

public class EnsicaSimpleImage implements ImageInterface
{	
	/**
	 * Creation d'une image de type BufferedImage prete à l'application des différents filtres implémentés.
	 * 
	 * @param pathname - chemin d'accès de l'image à décompresser.
	 * 
	 * @return une image prete à l'emploi !
	 */
	public BufferedImage decompresser(String pathname) throws Exception
	{
		//On initialise le fichier ESI à parcourir.
		FileInputStream file = new FileInputStream(pathname);
		Scanner scan = new Scanner(file);
		
		//Construction d'une nouvelle BufferedImage de caractéristiques "colonnes*lignes" correspondant à l'image ESI à décompresser.
		int largeur = scan.nextInt();
		int hauteur = scan.nextInt();
		
		BufferedImage image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);
		
		//On remplit les pixels de la BufferedImage creee avec les données contenues dans le fichier scan.
		for (int j = 0; j<hauteur; j++)
		{
			for (int i = 0; i<(3*largeur); i=i+3) //On s'interesse à un triplet d'entiers
			{
				//Recuperation des données RGB du fichier ESI.
				int red = scan.nextInt();
				int green = scan.nextInt();
				int blue = scan.nextInt();
				
				//Creation de la couleur RGB associée.
				Color color = new Color(red, green, blue);
				
				//Coloriage du pixel (i/3,j) avec la couleur RGB.
				image.setRGB(i/3,j,color.getRGB());
			}
		}
		
		scan.close();
		return image;
	}

	/**
	 * Compression d'une image au format ESI
	 */
	public void compresser(BufferedImage image, String pathname, String format) throws Exception
	{
		//Initialisation du nouveau fichier ESI dans lequel nous allons écrire.
		FileOutputStream file = new FileOutputStream(pathname);
		PrintWriter scan = new PrintWriter(file);
		
		//On ecrit la premiere ligne du fichier ESI : largeur puis hauteur
		scan.print(image.getWidth());
		scan.print(" "); //Ajout d'un espace après les entiers
		scan.print(image.getHeight());
		scan.println(); //Saut de ligne
		
		//On ecrit ensuite chaque ligne du fichier ESI en parcourant image ligne par ligne
		for (int j = 0; j<image.getHeight(); j++)
		{
			for (int i = 0; i<image.getWidth(); i++)
			{
				//Récupération des 3 couleurs du pixel (i,j)
				Color color = new Color(image.getRGB(i,j));
				int rouge = color.getRed();
				int vert = color.getGreen();
				int bleu = color.getBlue();
				
				//Ecriture de ces couleurs dans le fichier ESI
				scan.print(rouge);
				scan.print(" "); //Espace
				scan.print(vert);
				scan.print(" "); //Espace
				scan.print(bleu);
				scan.print(" "); //Espace
			}
			
			//Saut de ligne à la fin de l'écriture d'une ligne
			scan.println();
		}
		scan.close();
	}
}
