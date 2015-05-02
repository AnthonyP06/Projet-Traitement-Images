package Formats;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class AutresFormats implements ImageInterface
{
	
	/**
	 * Construction d'une image de type BufferedImage prete � l'application des diff�rents filtres impl�ment�s.
	 * 
	 * @param pathname - chemin d'acc�s du nom de l'image � d�compresser.
	 * 
	 * @return une image prete � l'emploi !
	 */
	public BufferedImage decompresser(String pathname) throws Exception
	{
		//On construit un fichier capable d'�tre lu par Eclipse pour produire une BufferedImage
		File source = new File(pathname);
		
		//Construction de la BufferedImage
		BufferedImage image = ImageIO.read(source);
		
		return image;
	}
	
	/**
	 * Construction d'une image au format JPEG ou PNG dans le dossier sp�cifi� en argument.
	 * 
	 * @param image - l'image que l'on veut compresser au format choisi.
	 * @param pathname - le chemin de destination
	 * @param format - le format choisi : JPEG ou PNG
	 * 
	 */
	public void compresser(BufferedImage image, String pathname, String format) throws Exception
	{
		//Creation du fichier File dans lequel sera impl�ment� l'image.
		File destination = new File(pathname);
		
		//Ecriture de l'image filtr�e dans ce nouveau fichier.
		ImageIO.write(image, format, destination);
	}
}
