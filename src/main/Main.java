package main;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import printScreen.PrintScreen;
import gifEncoder.AnimatedGifEncoder;


public class Main {
	
	public static void main(String[] args) {
		testPrintScren();
		System.out.println("End!");
	}
	
	public static void testPrintScren() {
		PrintScreen printer = new PrintScreen();
		
		BufferedImage image = printer.printScreen(new Point(30, 50), new Dimension(500, 500));
	    try {
			ImageIO.write(image, "jpg", new File("C:\\Users\\Marco\\Desktop\\test.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void testGifEncoder(){
		 try {
		    	String imageFilePath = "C:\\Users\\Marco\\Desktop\\japones.png";
		    	String imageFilePath2 = "C:\\Users\\Marco\\Desktop\\seta.png";
		    	
		 	    File inputFile = new File(imageFilePath);
		 	    File inputFile2 = new File(imageFilePath2);
		 	    
				BufferedImage image = ImageIO.read(inputFile);
				BufferedImage image2 = ImageIO.read(inputFile2);
				
				AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
				
				String destiny = "C:\\Users\\Marco\\Desktop\\myGif.gif";
				if (gifEncoder.start(destiny)){
					System.out.println("Destino correto");
				}
				gifEncoder.setRepeat(0);
				gifEncoder.setDelay(3000);
				
				if (gifEncoder.addFrame(image)){
					System.out.println("Imagem 1 foi!");
				}
				else {
					System.out.println("Error");
				}
				if (gifEncoder.addFrame(image2)){
					System.out.println("Imagem 2 foi!");
				}
				if (gifEncoder.addFrame(image)){
					System.out.println("Imagem 1 foi!");
				}
				if (gifEncoder.addFrame(image2)){
					System.out.println("Imagem 2 foi!");
				}
				
				
				if (gifEncoder.finish()){
					System.out.println("Finalizado com sucesso!");
				}
				
		    } catch (IOException e) {
				System.out.println("Babou");
			}
	}
	
}
