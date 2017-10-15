package com.teamgthree.game.Model;

import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Animation;

public class BeenHitAction implements Action {

		private Direction direction;

		public BeenHitAction(Direction direction) {
			this.direction = direction;
		}

		@Override
		public void performAction(Character character) {

			switch (this.direction) {

			case EAST:
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(84, 92));
				}
				break;
			case NORTH:
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(111, 119));
				}
				break;
			case SOUTH:
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(93, 101));
				}
				break;
			case WEST:
				if (character.getActionChanged()) {
					character.getSprite().setAnimation(new Animation(102, 110));
				}
				break;
			default:
				break;
			}
			
			character.setElapsedFrames(character.getElapsedFrames() + 1);
			character.setDead(true);
			character.setActionChanged(false);
		}
	}

