package com.teamgthree.game.Model;

import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Animation;

public class AttackAction implements Action {
	private Direction direction;

	public AttackAction(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void performAction(Character character) {

		switch (this.direction) {

		case EAST:
			if (character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(32, 44));
			}
			break;
		case NORTH:
			if (character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(71, 83));
			}
			break;
		case SOUTH:
			if (character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(45, 57));
			}
			break;
		case WEST:
			if (character.getActionChanged()) {
				character.getSprite().setAnimation(new Animation(58, 70));
			}
			break;
		default:
			//break;
		}
		
		character.setActionChanged(false);

	}
}
