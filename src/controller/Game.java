package controller;

import view.Frame;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import constants.Actions;
import constants.Directions;
import model.*;
import interfaces.*;

public class Game implements ControllerInterface {
	public Map map;
	public Component farmer;
	public Component goose;
	public Component bean;
	public Component fox;
	public Ship ship;
	public boolean hasLost;
	public static Game game;
	public static Frame frame;
	public static void main(String[]args){
		
		game = new Game();
		game.farmer = new Component("src/farmer.png",0);
		game.goose = new Component("src/goose.png",1);
		game.bean = new Component("src/beans.png",2);
		game.fox = new Component("src/fox.png",3);
		game.ship = new Ship();
		game.map = new Map(game.farmer, game.goose, game.bean, game.fox, game.ship);
		try {
			frame = new Frame(getFarmerImage(),
					getGooseImage(),
					getBeanImage(),
					getFoxImage(),
					getShipImage(),
					Game.game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	public Game(){
		
	}
	public static ImageIcon getFarmerImage() throws IOException{
		return game.farmer.getImage();
	}
	public static ImageIcon getGooseImage() throws IOException{
		return game.goose.getImage();
	}
	public static ImageIcon getBeanImage() throws IOException{
		return game.bean.getImage();
	}
	public static ImageIcon getFoxImage() throws IOException{
		return game.fox.getImage();
	}
	public static ImageIcon getShipImage() throws IOException{
		return game.ship.getImage();
	}

	@Override
	public int move(int id, int direction) {
		// TODO Auto-generated method stub

		int result = 0;
		if(hasLost != true){
			System.out.println("Not looser");
		switch(id){
		case 0:
			result = map.move(farmer, direction);
			
			if(result == Actions.EMBARK){
				frame.getObjectsInTheboat().add(frame.getFarmerImageLabel());

			}else if(result == Actions.DEBARK){
				if(direction == Directions.LEFT){
					frame.getPane2Left().add(frame.getFarmerImageLabel());
				}else{
					frame.getPane2Right().add(frame.getFarmerImageLabel());
				}
			}
			SwingUtilities.updateComponentTreeUI(frame);
			hasLost = map.hasLost();
		break;
		case 1:
			result = map.move(goose, direction);
			if(result == Actions.EMBARK){
				frame.getObjectsInTheboat().add(frame.getGooseImageLabel());

			}else if(result == Actions.DEBARK){
				if(direction == Directions.LEFT){
					frame.getPane3Left().add(frame.getGooseImageLabel());
				}else{
					frame.getPane3Right().add(frame.getGooseImageLabel());
				}
			}
			SwingUtilities.updateComponentTreeUI(frame);
			hasLost = map.hasLost();
		break;
		case 2:
			result = map.move(bean, direction);
			if(result == Actions.EMBARK){
				   frame.getObjectsInTheboat().add(frame.getBeanImageLabel());

			}else if(result == Actions.DEBARK){
				if(direction == Directions.LEFT){
					frame.getPane1Left().add(frame.getBeanImageLabel());
				}else{
					frame.getPane1Right().add(frame.getBeanImageLabel());
				}
			}
			SwingUtilities.updateComponentTreeUI(frame);
			hasLost = map.hasLost();

		break;
		case 3:
			result = map.move(fox, direction);
			if(result == Actions.EMBARK){;
			frame.getObjectsInTheboat().add(frame.getFoxImageLabel());

		}else if(result == Actions.DEBARK){
			if(direction == Directions.LEFT){
				frame.getPane4Left().add(frame.getFoxImageLabel());
			}else{
				frame.getPane4Right().add(frame.getFoxImageLabel());
			}
		}
		SwingUtilities.updateComponentTreeUI(frame);
			hasLost = map.hasLost();
		break;
		case 4:
			result = map.move(ship, direction);
			if(result == Actions.MOVED){
				if(direction == Directions.LEFT){
					frame.getWaterPaneLeft().add(frame.getBoatPanelRight());
				}else{
					frame.getWaterPaneRight().add(frame.getBoatPanelRight());
				}
				SwingUtilities.updateComponentTreeUI(frame);
			}
			hasLost = map.hasLost();
			break;
		}
		System.out.println(hasLost);
		return result;
		}
		return 0;
	}
}
