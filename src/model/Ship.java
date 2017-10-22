package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Ship extends Component {

	public Component firstComponent;
	public Component secondComponent;
	public Ship() {
		super("src/sailing.png",4);
		position = 1;
	}
	
	public boolean add(Component c){
		if(firstComponent != null && secondComponent != null){
			return false;
		}
		if(firstComponent == null){
			firstComponent = c;
			c.shipIndex = 1;
		}else{
			secondComponent = c;
			c.shipIndex = 2;
		}
		return true;
	}
	public boolean remove(Component c){
		if(firstComponent.equals(c)){
			firstComponent.shipIndex = 0;
			firstComponent = null;
			return true;
		}else if(secondComponent.equals(c)){
			secondComponent.shipIndex = 0;
			secondComponent = null;
			return true;
		}
		return false;
	}
	public ImageIcon[] getImages() throws IOException{
		ImageIcon[] images = new ImageIcon[3];
		images[0] = getImage();
		if(firstComponent != null){
			images[1] = firstComponent.getImage();
		}
		if(secondComponent != null){
			images[2] = secondComponent.getImage();
		}
		return images;
	}
	public ImageIcon getImage() throws IOException{
		 BufferedImage bufferdImage = ImageIO.read(new File(picture));
        ImageIcon icon = new ImageIcon(bufferdImage);
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);
        return icon;
	 }
}
