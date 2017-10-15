package com.teamgthree.game.Model;

import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Animation;

public class DeathAction implements Action {

	private Direction direction;

	public DeathAction(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void performAction(Character character) {

		System.out.println(character.isDead());
		
		switch (this.direction) {
		case EAST:
			if (!(character.getSprite().getAnimation().getCurrentFrame() == 128)) {
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(120, 128));
				}
			} else {
				//Keep enemy dead on the ground
				character.getSprite().setAnimation(new Animation (128, 128));
			}
			break;
		case NORTH:
			if (!(character.getSprite().getAnimation().getCurrentFrame() == 153)) {
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(146, 153));
				}
			} else {
				//Keep enemy dead on the ground
				character.getSprite().setAnimation(new Animation (153, 153));
			}
			break;
		case SOUTH:
			if (!(character.getSprite().getAnimation().getCurrentFrame() == 137)) {
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(129, 137));
				}
			} else {
				//Keep enemy dead on the ground
				character.getSprite().setAnimation(new Animation (137, 137));
			}

			break;
		case WEST:
			if (!(character.getSprite().getAnimation().getCurrentFrame() == 145)) {
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(138, 145)); 
				}
			} else {
				//Keep enemy dead on the ground
				character.getSprite().setAnimation(new Animation (145, 145));
			}
			break;
		default:
			break;
		}
		character.setElapsedFrames(character.getElapsedFrames() + 1);
		character.setActionChanged(false);
		character.setDead(true);
	}
}
