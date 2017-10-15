package com.teamgthree.control;

import com.teamgthree.game.Game;
import com.teamgthree.game.Model.EnemyFactory;
import com.teamgthree.tileengine.ReadMap;

public class Boundries {
	
	ReadMap map = new ReadMap();
	EnemyFactory ef = new EnemyFactory();
	
	/**
	 * If player moves off screen, appear at opposite end.
	 * 
	 * @return void
	 */
	public void doBoundries() {

		//If player off screen
		if (Game.player.getSprite().getX() < -40) {
			Game.player.getSprite().setX(730);
			newMap();
		} else if (Game.player.getSprite().getX() > 730) {
			Game.player.getSprite().setX(-40);
			newMap();
		} else if (Game.player.getSprite().getY() > 490) {
			Game.player.getSprite().setY(-50);
			newMap();
		} else if (Game.player.getSprite().getY() < -50) {
			Game.player.getSprite().setY(490);
			newMap();
		}
	}
	
	/**
	 * Clear enemies on screen and adds new enemies
	 * 
	 * @return void
	 */
	private void newMap() {
		Game.getMapManager().getCharacters().clear();
		ef.makeRandomEnemies(5);
		Game.getMapManager().addCharacter(Game.player);
	}
}
