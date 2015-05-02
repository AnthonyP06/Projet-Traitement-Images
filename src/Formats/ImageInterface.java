/**
 * Interface gérant le traitement pre-filtrage et post-filtrage des images.
 * 
 * @author Anthony Pagliai & Colin Mourard
 * @version 1.0 - 04.04.2014
 */
package Formats;

import java.awt.image.BufferedImage;

public interface ImageInterface 
{
	BufferedImage decompresser(String name) throws Exception;
	void compresser(BufferedImage image, String pathname, String format) throws Exception;
}
