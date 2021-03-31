import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyRedFilter
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
		
		//to convert to Green image
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int p = image.getRGB(x, y);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				
				//set new RGB value
				p = (a<<24) | (r<<16) | (0<<8) | (0<<0);
								
				image.setRGB(x,y,p);
				
			}
		}
		
		// write image
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MyRedFilter.jpg");
			ImageIO.write(image,"jpg",f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
