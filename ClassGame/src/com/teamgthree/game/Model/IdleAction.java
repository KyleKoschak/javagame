package com.teamgthree.game.Model;

import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Animation;

public class IdleAction implements Action {
	private Direction direction;
	
	public IdleAction(Direction direction) {
		this.direction = direction;
	}
	
	/**
	 * handles the idle action
	 * 
	 * @param character
	 */
	@Override
	public void performAction(Character character) {
		
		switch(this.direction) {
				
		case EAST:
			if(character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(0, 7));
			}
			break;
		case NORTH:
			if(character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(24, 31));
			}
			break;
		case SOUTH:
			if(character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(8, 15));
			}
			break;
		case WEST:
			if(character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(16, 23));
			}
			break;
		default:
			break;
		}
		
	}

}
