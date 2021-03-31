import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyGrayScale
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
		
		//to convert to grayscale
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int p = image.getRGB(x, y);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = (p>>0)&0xff;
				
				//calculate average
				
				int avg = (r+g+b)/3;
				
				//replace RGB value with average
				p = (a<<24) | (avg<<16) | (avg<<8) | (avg<<0);
				image.setRGB(x,y,p);
				
			}
		}
		
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MyGrayScale.jpg");
			ImageIO.write(image,"jpg",f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
