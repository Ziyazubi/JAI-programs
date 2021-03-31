import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyCreatedImage
{
	public static void main(String args[]) throws IOException
	{
		//image dimension
		int width = 640;
		int height = 320;
		
		//create Buffered Image object image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		//file object
		File f = null;
		
		//create random image pixel by pixel
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				
				int a = (int)(Math.random()*256); //aplha
				int r = (int)(Math.random()*256); //red
				int g = (int)(Math.random()*256); //green
				int b = (int)(Math.random()*256); //blue
				
				//set new RGB value
				int p = (a<<24) | (r<<16) | (g<<8) | (b<<0); //pixel
								
				image.setRGB(x,y,p);
				
			}
		}
		
		// write image
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MyCreatedImage.png");
			ImageIO.write(image,"png",f);
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
	}
}
