package printScreen;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PrintScreen {
	public BufferedImage printScreen(Point originPoint, Dimension printDimension) {
	    Rectangle screenRect = new Rectangle(originPoint, printDimension);
	    
	    // criar screenshot  
	    Robot robot = null;  
	    try {  
	        robot = new Robot();  
	    } catch (AWTException e) {  
	        e.printStackTrace();  
	    }  
	    
	    BufferedImage image = robot.createScreenCapture(screenRect);          
	 
		return image;
	}        
}
