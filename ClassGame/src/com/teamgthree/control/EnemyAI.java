package com.teamgthree.control;

import com.teamgthree.game.Game;
import com.teamgthree.game.Model.AttackAction;
import com.teamgthree.game.Model.BeenHitAction;
import com.teamgthree.game.Model.DeathAction;
import com.teamgthree.game.Model.Enemy;
import com.teamgthree.game.Model.EnemyDragon;
import com.teamgthree.game.Model.TravelAction;
import com.teamgthree.game.View.Direction;

public class EnemyAI {

	private int speed;

	public EnemyAI() {
		speed = 0;
	}

	/**
	 * Moves enemies towards player and attack. Kill enemies attacked by player.
	 * 
	 * @param enemy
	 */
	public void AI(Enemy enemy) {
		enemy.setTargetX(Game.player.getSprite().getX());
		enemy.setTargetY(Game.player.getSprite().getY());
		speed = enemy.getMovementSpeed();

		// If enemy not near player
		if (!(Game.getMapManager().intersectsPlayer(enemy)) && !enemy.isDead()) {
			
			if ((enemy.getAction() instanceof TravelAction)) {
				enemy.setActionChanged(true);
				enemy.setAction(new TravelAction(enemy.getCurrentDirection()));
			}
			
			//Enemy move EAST
			if (enemy.getSprite().getX() <= enemy.getTargetX() - 36) {
				enemy.getSprite().setX(enemy.getSprite().getX() + speed);
				enemy.setCurrentDirection(Direction.EAST);
				enemy.setActionChanged(false);
					enemy.setActionChanged(true);
					enemy.setAction(new TravelAction(enemy.getCurrentDirection()));
			}
			//Enemy move WEST
			if (enemy.getSprite().getX() >= enemy.getTargetX() + 72) {
				enemy.getSprite().setX(enemy.getSprite().getX() - speed);
				enemy.setCurrentDirection(Direction.WEST);
				enemy.setActionChanged(false);
				enemy.setActionChanged(true);
				enemy.setAction(new TravelAction(enemy.getCurrentDirection()));
			}
			//Enemy move SOUTH
			if (enemy.getSprite().getY() <= enemy.getTargetY() - 36) {
				enemy.getSprite().setY(enemy.getSprite().getY() + speed);
				enemy.setCurrentDirection(Direction.SOUTH);
				enemy.setActionChanged(false);
					enemy.setActionChanged(true);
					enemy.setAction(new TravelAction(enemy.getCurrentDirection()));
			}
			//Enemy move NORTH
			if (enemy.getSprite().getY() >= enemy.getTargetY() + 72) {
				enemy.getSprite().setY(enemy.getSprite().getY() - speed);
				enemy.setCurrentDirection(Direction.NORTH);
				enemy.setActionChanged(false);
				enemy.setActionChanged(true);
				enemy.setAction(new TravelAction(enemy.getCurrentDirection()));
			}

		} else { // Enemy is close enough to attack

			if (!enemy.isDead()) {
				if (!(enemy.getAction() instanceof AttackAction)) {
					enemy.setActionChanged(true);
					enemy.setAction(new AttackAction(enemy
							.getCurrentDirection()));
				}
				
				//IF player is attacking or enemy is attacking
				if (Game.player.getAction() instanceof AttackAction || enemy.getAction() instanceof AttackAction)
				{
					//IF player is facing toward enemy and attacking
					if (Game.player.getCurrentDirection() == Direction.NORTH && enemy.getCurrentDirection() == Direction.SOUTH ||
						Game.player.getCurrentDirection() == Direction.EAST && enemy.getCurrentDirection() == Direction.WEST ||
						Game.player.getCurrentDirection() == Direction.SOUTH && enemy.getCurrentDirection() == Direction.NORTH ||
						Game.player.getCurrentDirection() == Direction.WEST && enemy.getCurrentDirection() == Direction.EAST) {
							
						//IF Player is near end of attack
						if (Game.player.getSprite().getAnimation().getCurrentFrame() == 39 ||
							Game.player.getSprite().getAnimation().getCurrentFrame() == 52 ||
							Game.player.getSprite().getAnimation().getCurrentFrame() == 65 ||
							Game.player.getSprite().getAnimation().getCurrentFrame() == 78) {
								
							if (enemy instanceof EnemyDragon) {
								enemy.setDead(true);
								enemy.setActionChanged(true);
								enemy.setAction(new DeathAction(enemy.getCurrentDirection()));
							}
							else {
								enemy.setDead(true);
								enemy.setActionChanged(true);
								enemy.setAction(new BeenHitAction(enemy.getCurrentDirection()));
							}
						}
						
						//IF Enemy is near end of attack
						if (enemy.getSprite().getAnimation().getCurrentFrame() == 39 ||
							enemy.getSprite().getAnimation().getCurrentFrame() == 52 ||
							enemy.getSprite().getAnimation().getCurrentFrame() == 65 ||
							enemy.getSprite().getAnimation().getCurrentFrame() == 78) {
							
							Game.player.setHealth(Game.player.getHealth() - 1);
							
							//IF player has no life
							if (Game.player.getHealth() == 0) {
								Game.player.setActionChanged(true);
								Game.player.setAction(new DeathAction(Game.player.getCurrentDirection()));
								Game.player.setDead(true);
							}
						}
						
					}
				}
				//Grant experience if enemy is dead
				if (enemy.isDead()) {
					Game.player.setCurrentXP(Game.player.getCurrentXP() + enemy.getGrantedXP());
				}
			}
		}
	}
}


