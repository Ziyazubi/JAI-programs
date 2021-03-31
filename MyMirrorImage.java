import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyMirrorImage
{
	public static void main(String args[]) throws IOException
	{
		//BufferedImage for source image
		BufferedImage simg = null;
		
		//file object
		File f = null;
		
		//read source image file
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/mm19.jpg");
			simg = ImageIO.read(f);
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
		
		int width = simg.getWidth();
		int height = simg.getHeight();
		
		//BufferedImage for mirror image
		BufferedImage mimg =  new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
		
		//create mirror image pixel by pixel
		for(int y = 0; y < height; y++)
		{
			for(int lx = 0, rx = width*2-1; lx < width; lx++,rx--)
			{
				//lx starts from left side of the image
				//rx starts from the right side of the image
				
				int p = simg.getRGB(lx, y);
				
				//set mirror image pixel value - both left and right
				mimg.setRGB(lx,y,p);
				mimg.setRGB(rx,y,p);
			}
		}

		//save image
		try
		{
			f = new File("/home/zubi/programs/JAVA/JAI_programs/MyMirrorImage.png");
			ImageIO.write(mimg,"png",f);
		}
		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
	}
}
