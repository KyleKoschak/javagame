package com.teamgthree.game.Model;

import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Animation;
import com.teamgthree.tileengine.Sprite;

public class Player extends Character {
	private String mClass;
	
	private float currentXP;
	private float XPToLevel;
	private float currentLevel;

	/**
	 * creates instance of Player
	 * 
	 * @param mapManager
	 */
	public Player(MapManager mapManager) {

		super(mapManager);
		this.setSprite(new Sprite("blueKnight.png", 96, 96, 960));
		this.setAction(new IdleAction(Direction.EAST));
		this.getSprite().setAnimation(new Animation(0, 0));
		this.setCharacterClass(Classes.MELEE);
		this.currentXP = 0;
		this.currentLevel = 1;
	}
	
	/**
	 * gets players current xp
	 * 
	 * @return
	 */
	public float getCurrentXP() {
		return currentXP;
	}
	
	/**
	 * sets players current xp
	 * 
	 * @param xp
	 */
	public void setCurrentXP (float xp) {
		this.currentXP = xp;
	}
	
	/**
	 * gets players xp needed to level
	 * 
	 * @return
	 */
	public float getXPToLevel() {
		return this.XPToLevel;
	}
	
	/**
	 * sets xp needed for player to level
	 * 
	 * @param XPToLevel
	 */
	public void setXPToLevel(float XPToLevel) {
		this.XPToLevel = XPToLevel;
	}

	
	/**
	 * gets players current level
	 * 
	 * @return
	 */
	public float getCurrentLevel() {
		return currentLevel;
	}
	
	/**
	 * sets characters current level
	 * 
	 * @param level
	 */
	public void setCurrentLevel(float level) {
		this.currentLevel = level;
	}

	/**
	 * gets player class
	 * 
	 * @return
	 */
	public String getmClass() {
		return mClass;
	}

	/**
	 * sets player class
	 * 
	 * @param mClass
	 */
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}

	/**
	 * converts object to a string
	 * 
	 * @return print
	 */
	public String toString() {
		String print = "";
		print = "Character: " + this.getmName();

		return print;
	}

	/**
	 * updates the current state of player object
	 * 
	 * @return void
	 */
	@Override
	public void updateState() {
		
		super.updateState();
		this.getAction().performAction(this);
		this.getSprite().getAnimation().animate();
		
		// Check X, Y
		// System.out.println("X : " + (this.getSprite().getX()));
		// System.out.println("Y : " + (this.getSprite().getY()));
	}
}
