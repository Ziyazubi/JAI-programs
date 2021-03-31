import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MySepiaFilter
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
		
		//to convert to sepia
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				int p = image.getRGB(x, y);
				
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = (p>>0)&0xff;
				
				//to calculate tr, tg, tb
				
				int tr = (int)(0.393*r + 0.769*g + 0.189*b);
				int tg = (int)(0.349*r + 0.686*g + 0.168*b);
				int tb = (int)(0.272*r + 0.534*g + 0.131*b);
				
				if(tr<255)
				{
					r = 255;
				}
				else
				{
					r = tr;
				}
				
				if(tg<255)
				{
					r = 255;
				}
				else
				{
					r = tg;
				}
				
				if(tb<255)
				{
					r = 255;
				}
				else
				{
					r = tb;
				}
				
				//set new RGB value
				p = (a<<24) | (r<<16) | (g<<8) | (b<<0);
								
				image.setRGB(x,y,p);
				
			}
		}
		
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MySepiaFilter.jpg");
			ImageIO.write(image,"jpg",f);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
