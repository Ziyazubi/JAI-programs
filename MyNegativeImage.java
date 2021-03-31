import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyNegativeImage
{
	public static void main(String args[]) throws IOException
	{
		BufferedImage image = null;
		File f = null;
		
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/f9.jpg");
			image = ImageIO.read(f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		//to get image width and height
		int width = image.getWidth();
		int height = image.getHeight();
		
		//to convert to Negative image
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int p = image.getRGB(x, y);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = (p>>0)&0xff;
				
				//subtract RGB from 255
				r = 255 - r;
				g = 255 - g;
				b = 255 - b;
				
				//set new RGB value
				p = (a<<24) | (r<<16) | (g<<8) | (b<<0);
								
				image.setRGB(x,y,p);
			}
		}
		
		// write image
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MyNegativeImage.jpg");
			ImageIO.write(image,"jpg",f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
