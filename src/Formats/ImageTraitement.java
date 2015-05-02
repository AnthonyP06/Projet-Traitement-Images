package Formats;

import java.awt.image.BufferedImage;

public class ImageTraitement 
{
	/**
	 * Decompresser une photo au format d�sir� (parmi ceux pris en charge par le logiciel)
	 * 
	 * @param pathname - le chemin de destination de la photo � d�compresser
	 * @param imageinterface - permet de d�compresser en fonction du format de la photo � d�compresser
	 * 
	 * @return fichier de type BufferedImage pr�t � recevoir les filtres choisis par l'utilisateur.
	 */
	public static BufferedImage decompresser(String pathname, ImageInterface imageinterface) throws Exception
	{
		//Application de la m�thode de d�compression ind�pendemment du format
		BufferedImage image = imageinterface.decompresser(pathname);
		return image;
	}
	
	
/**
 * 	Compresser une photo au format choisi par l'utilisateur (parmi ceux pris en charge par le logiciel)
 * 
 * @param image l'image que l'on souhaite compresser
 * @param pathname le chemin de destination o� le fichier sera cr��
 * @param format le format de compression
 * @param imageinterface l'interface qui permet d'appliquer la compression d'image selon le format choisi
 */
public static void compresser(BufferedImage image, String pathname, String format, ImageInterface imageinterface) throws Exception
	{
		//Cr�ation de l'image finale
		imageinterface.compresser(image, pathname, format);
	} 
}

