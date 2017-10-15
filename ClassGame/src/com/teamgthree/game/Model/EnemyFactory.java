package com.teamgthree.game.Model;

import com.teamgthree.game.Game;



public class EnemyFactory {
	
	/**
	 *creates a specific enemy type
	 *
	 *@param enemyType
	 */
	public EnemyInterface makeEnemy(Enemies enemyType) {

		EnemyInterface enemy = null;
		
		
		switch(enemyType) {
			case ORC:
				enemy = new EnemyOrc();
				enemy.stats(5, 5, 5);
				break;
			case DRAGON:
				enemy = new EnemyDragon();
				enemy.stats(5, 5, 5);
				break;
				
		}
		
		return enemy;
	}
	
	/**
	 *create random types of enemies
	 *
	 *@param numEnemies
	 */
	public void makeRandomEnemies (int numEnemies) {
			
			for( int i = 0; i < numEnemies; i++) {
				int type =  (int) (Math.floor((Math.random() * 2)) + 1);
				Enemy enemy = null;
				
				switch(type) {
					case 1:
						enemy = new EnemyOrc();
						break; 
					case 2:
						enemy = new EnemyDragon();
						break;
				}
				
				enemy.setName("Enemy " + (i + 1));
				Game.getMapManager().addCharacter(enemy);
			}
	}
}
