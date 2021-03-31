//Reading and Writing an Image

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImage
{
	public static void main(String args[]) throws IOException
	{
		int width = 963;
		int height = 640;
		
		BufferedImage image = null;
		File f = null;
		
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/f9.jpg");
			image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(f);
			System.out.println("Reading complete");
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
		
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/output1.jpg");
			ImageIO.write(image,"jpg",f);
			System.out.println("Writing complete");
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
	}
}
