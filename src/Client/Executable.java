/**
 * Classe exécutable qui est celle utilisée par le client. Les arguments sont entrés dans l'ordre suivant et séparés par un espace ou un saut de ligne :
 * - chemin d'accès de la photo à filtrer
 * - format de la photo à filtrer
 * - chemin de destination de la photo filtrée
 * - format de la photo filtrée
 * - liste des filtres à appliquer : on écrit, en les séparant d'un espace, les numéros des filtres à appliquer
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 24.04.2014
 */
package Client;

import java.awt.image.BufferedImage;
import Formats.ImageInterface;
import Formats.ImageFactory;
import Formats.ImageTraitement;
import Filtres.ApplicationFiltre;
import Filtres.Filtre;
import Filtres.FiltreFactory;

public class Executable 
{
	/**
	 * REMARQUE : on ne traite pas les exceptions dans ce code puisqu'elles sont déjà traitées dans FiltreFactory et ImageFactory
	 * 
	 * @param args - cf description de la classe 
	 */
	public static void main(String[] args) throws Exception 
	{
		
		/**
		//Affichage des arguments dans la console (à titre informatif ...)
		for(String arg: args) 
		{
	        System.out.println(arg);
		}
		*/
		
		//Initialisation de la BufferedImage sur laquelle seront appliqués les filtres successifs.
		BufferedImage image = null;
				
		//Decompression de la photo args[0] au format args[1]
		ImageInterface imageinterface = ImageFactory.create(args[1]); 
		image = ImageTraitement.decompresser(args[0], imageinterface);
		
		//Application du/des filtre(s) choisi(s) par l'utilisateur et affichage du temps d'execution
		for (int i = 4; i < args.length; i++)
		{	
			long startTime = System.currentTimeMillis();
			
			Filtre filtre = FiltreFactory.create(args[i]);
			image = ApplicationFiltre.application(image, filtre);
			
			long endTime = System.currentTimeMillis();
			//Nom du filtre et affichage sur la console
			String name = FiltreFactory.name(args[i]);
			System.out.println("Temps d'execution du filtre " + args[i] + " (" + name + ")" + " : " + (endTime-startTime) + " ms");
		}
		
		//Compression de la photo avec le nom args[2] au format args[3]
		imageinterface = ImageFactory.create(args[3]); 
		ImageTraitement.compresser(image, args[2], args[3], imageinterface);
	}
}
