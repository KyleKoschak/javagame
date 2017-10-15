package com.teamgthree.game.Model;

import com.teamgthree.control.EnemyAI;
import com.teamgthree.gamestate.GameStateManager;
import com.teamgthree.tileengine.Animation;
import com.teamgthree.tileengine.Sprite;


public class Enemy extends Character {
	private int targetX;
	private int targetY;
	private EnemyAI ai = new EnemyAI();
	private int moveSpeed;
	private int grantedXP;

	/**
	 * creates instance of enemy
	 * 
	 * @param spriteSheet, mapManager, enemies
	 */
	public Enemy(String spriteSheet, MapManager mapManager, Enemies enemies) {
		super(mapManager);
		//System.out.println(spriteSheet);
		this.setSprite(new Sprite(spriteSheet, 96, 96, 960));
		this.getSprite().setAnimation(new Animation(16, 23));
		this.getSprite().setX((int) Math.floor(Math.random() * 704));
		this.getSprite().setY((int) Math.floor(Math.random() * 504));
		this.setTargetX(this.getSprite().getX());
		this.setTargetY(this.getSprite().getY());
		this.moveSpeed = 0;
		this.grantedXP = 0;
	}
	
	/**
	 * gets the enemy target Y
	 * 
	 * @return
	 */
	public int getTargetY() {
		return targetY;
	}

	/**
	 * sets the enemies target Y
	 * 
	 * @param targetY
	 */
	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}
	
	/**
	 * gets the enemy target X
	 * 
	 * @return
	 */
	public int getTargetX() {
		return targetX;
	}
	
	/**
	 * sets the enemies target X
	 * 
	 * @param targetX
	 */
	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}
	
	/**
	 * sets the enemies movement speed
	 * 
	 * @param moveSpeed
	 */
	public void setMovementSpeed (int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	/**
	 * gets the enemy movement speed
	 * 
	 * @return
	 */
	public int getMovementSpeed () {
		return this.moveSpeed;
	}
	
	/**
	 * gets the enemies granted xp
	 * 
	 * @return
	 */
	public int getGrantedXP () {
		return grantedXP;
	}
	
	/**
	 * sets the enemies granted xp
	 * 
	 * @param grantedXP
	 */
	public void setGrantedXP(int grantedXP) {
		this.grantedXP = grantedXP;
	}

	public String toString() {
		String print = "";
		print = "Enemy: " + this.getmName();
		
		return print;
	}
	
	@Override
	public void updateState() {
		super.updateState();
		
		if (GameStateManager.getCurrentState() == GameStateManager.PLAYINGSTATE) {
			this.getAction().performAction(this);
			this.getSprite().getAnimation().animate();
			ai.AI(this);
		}

	}
}
