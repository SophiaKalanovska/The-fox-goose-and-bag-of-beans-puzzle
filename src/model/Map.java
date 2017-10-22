package model;

import java.awt.Desktop.Action;

import javax.swing.text.Position;

import constants.*;

public class Map {
	private Component farmer;
	private Component goose;
	private Component bean;
	private Component fox;
	private Ship ship;


	public Map(Component farmer, Component goose, Component bean, Component fox, Ship ship) {
		super();
		// 0: farmer
		// 1: goose
		// 2: bean
		// 3: fox
		this.farmer = farmer;
		this.goose = goose;
		this.bean = bean;
		this.fox = fox;
		this.ship = ship;
		this.ship.position = Positions.SHIP_RIGHT;
		this.farmer.position = Positions.RIGHT_PANEL;
		this.goose.position = Positions.RIGHT_PANEL;
		this.bean.position = Positions.RIGHT_PANEL;
		this.fox.position = Positions.RIGHT_PANEL;

	}
	private int moveShip(int direction){
		if(farmer.position == Positions.IN_SHIP_POSITION){
			if(direction == ship.position){
				return Actions.FAILURE;
			}
			ship.position = direction;
			return Actions.MOVED;
		}
		return Actions.FAILURE;
	}
	private int embark(Component component){

		switch(component.id){
		case 0:
			if(ship.add(farmer)){
				farmer.position = 1;
				return Actions.EMBARK;
			}
			break;
		case 1:
			if(ship.add(goose)){
				goose.position = 1;
				return Actions.EMBARK;
			}
			break;
		case 2:
			if(ship.add(bean)){
				bean.position = 1;
				return Actions.EMBARK;
			}
			break;
		case 3:
			if(ship.add(fox)){
				fox.position = 1;
				return Actions.EMBARK;
			}
			break;

		}
		return Actions.FAILURE;
	}
	private int debark(Component component){
		// 0: farmer
		// 1: goose
		// 2: bean
		// 3: fox
		switch(component.id){
		case 0:
			if(ship.remove(farmer)){
				System.out.println("farmer removed");
				if(ship.position == Positions.SHIP_LEFT){
					farmer.position = Positions.LEFT_PANEL;
				}else{
					farmer.position = Positions.RIGHT_PANEL;
				}
				return Actions.DEBARK;
			}
			break;
		case 1:
			if(ship.remove(goose)){
				if(ship.position == Positions.SHIP_LEFT){
					goose.position = Positions.LEFT_PANEL;
				}else{
					goose.position = Positions.RIGHT_PANEL;
				}
				return Actions.DEBARK;
			}
			break;
		case 2:
			if(ship.remove(bean)){
				if(ship.position == Positions.SHIP_LEFT){
				bean.position = Positions.LEFT_PANEL;
				}else{
					bean.position = Positions.RIGHT_PANEL;
				}
				return Actions.DEBARK;
			}
			break;
		case 3:
			if(ship.remove(fox)){
				if(ship.position == Positions.SHIP_LEFT){
					fox.position = Positions.LEFT_PANEL;
				}else{
					fox.position = Positions.RIGHT_PANEL;
				}
				return Actions.DEBARK;
			}
			break;

		}
		return Actions.FAILURE;
	}

	public int move(Component component, int direction){
		System.out.println("direction "+ direction);
		System.out.println("ship position : " + ship.position);
		switch(component.id){
		case 0:
			
			if(farmer.position == Positions.IN_SHIP_POSITION){

				if(ship.position == direction){
					return debark(farmer);
				}
			}
			else if((farmer.position == Positions.RIGHT_PANEL && direction == Directions.RIGHT) ||(farmer.position == Positions.LEFT_PANEL && direction == Directions.LEFT)){
				return Actions.FAILURE;
			}else{
				return embark(farmer);
			}
			break;
		case 1:
			if(goose.position == Positions.IN_SHIP_POSITION){

				if(ship.position == direction){
					return debark(goose);
				}
			}
			else if((goose.position == Positions.RIGHT_PANEL && direction == Directions.RIGHT) ||(goose.position == Positions.LEFT_PANEL && direction == Directions.LEFT)){
				return Actions.FAILURE;
			}else{
				return embark(goose);
			}
			break;
		case 2:
			if(bean.position == Positions.IN_SHIP_POSITION){
				
				if(ship.position == direction){
					System.out.println("debarking");
					return debark(bean);
				}
			}
			else if((bean.position == Positions.RIGHT_PANEL && direction == Directions.RIGHT) ||(bean.position == Positions.LEFT_PANEL && direction == Directions.LEFT)){
				
				return Actions.FAILURE;
			}else{
				return embark(bean);
			}
			break;
		case 3:
			if(fox.position == Positions.IN_SHIP_POSITION){

				if(ship.position == direction){
					System.out.println("debarking");
					return debark(fox);
				}
			}
			else if((fox.position == Positions.RIGHT_PANEL && direction == Directions.RIGHT) ||(fox.position == 0 && direction == Directions.LEFT)){
				return Actions.FAILURE;
			}else{
				return embark(fox);
			}
			break;
		case 4:
			return moveShip(direction);
		}
		return 0;
	}
	public boolean hasLost(){
		if(goose.position == bean.position ){
			if(farmer.position == 1){
				if((ship.position == Positions.SHIP_LEFT && goose.position == Positions.LEFT_PANEL) || (ship.position  == Positions.SHIP_RIGHT && goose.position == Positions.RIGHT_PANEL)){
					return false;
				}
				return true;
			}
			
		}else if(fox.position == goose.position ){
			if(farmer.position == Positions.IN_SHIP_POSITION){
				if((ship.position == Positions.LEFT_PANEL && goose.position == Positions.LEFT_PANEL) || (ship.position  == Positions.SHIP_RIGHT && goose.position == Positions.RIGHT_PANEL)){
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	


}
