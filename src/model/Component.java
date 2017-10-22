package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Component {
	 protected String picture;
	 protected int shipIndex;
	 protected int id;
	 protected int position;
	 public Component(String picture, int id){
		 this.picture = picture;
		 shipIndex = 0;
		 position = 2;
		 this.id = id;
	 }
	 public ImageIcon getImage() throws IOException{
		 BufferedImage bufferdImage = ImageIO.read(new File(picture));
         ImageIcon icon = new ImageIcon(bufferdImage);
         Image image = icon.getImage();
         Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         icon = new ImageIcon(newimg);
         return icon;
	 }
	 public boolean equals(Component obj){
		 if(obj.id == id){
			 return true;
		 }
		return false; 
	 }
}
