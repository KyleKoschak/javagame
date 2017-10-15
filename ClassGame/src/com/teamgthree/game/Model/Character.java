package com.teamgthree.game.Model;


import com.teamgthree.game.View.Direction;
import com.teamgthree.tileengine.Sprite;

public abstract class Character implements Entity {
	private String mName;
	private int health;
	private int mStrength;
	private int mIntelligence;
	private int mLuck;
	private int dexterity = 5;
	private Sprite sprite;
	private Action action;
	private Boolean actionChanged = false;
	private MapManager mapManager;
	private Classes characterClass;
	private boolean isDead;
	private int elapsedFrames = 0;
	private Direction currentDirection = Direction.EAST;
	
	/**
	 * creates instance of Character
	 * 
	 * @param mapManager
	 */
	public Character(MapManager mapManager) {
		this.mapManager = mapManager;
		this.action = new IdleAction(Direction.EAST);
		this.isDead = false;
		this.health = 5;
	}
	
	/**
	 * gets character dexterity
	 * 
	 * @return
	 */
	public int getDexterity() {
		return dexterity;
	}
	
	/**
	 * sets character dexterity
	 * 
	 * @param dexterity
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	/**
	 * gets character class
	 * 
	 * @return
	 */
	public Classes getCharacterClass() {
		return characterClass;
	}
	
	/**
	 * sets character class
	 * 
	 * @param characterClass
	 */
	public void setCharacterClass(Classes characterClass) {
		this.characterClass = characterClass;
	}

	/**
	 * gets mapManager
	 * 
	 * @return
	 */
	public MapManager getMapManager() {
		return mapManager;
	}

	/**
	 * gets character action
	 * 
	 * @return
	 */
	public Action getAction() {
		return action;
	}
	
	/**
	 * sets character action
	 * 
	 * @param action
	 */
	public void setAction(Action action) {
		this.action = action;
	}
	
	/**
	 * gets character sprite
	 * 
	 * @return sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * sets character sprite
	 * 
	 * @param sprite
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getmName() {
		return mName;
	}
	
	/**
	 * sets character name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.mName = name;
	}
	
	/**
	 * gets character strength
	 * 
	 * @return
	 */
	public int getStrength() {
		return mStrength;
	}
	
	/**
	 * sets character strength
	 * 
	 * @param strength
	 */
	public void setStrength(int strength) {
		this.mStrength = strength;
	}
	
	/**
	 * gets character intelligence
	 * 
	 * @return
	 */
	public int getIntelligence() {
		return mIntelligence;
	}
	
	/**
	 * set character intelligence
	 * @param intelligence
	 */
	public void setIntelligence(int intelligence) {
		this.mIntelligence = intelligence;
	}
	
	/**
	 * gets character luck
	 * 
	 * @return
	 */
	public int getLuck() {
		return mLuck;
	}
	
	/**
	 * sets character luck
	 * 
	 * @param luck
	 */
	public void setLuck(int luck) {
		this.mLuck = luck;
	}
	
	/**
	 * sets character health
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * gets character health
	 * 
	 * @return
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * gets character action changed
	 * 
	 * @return
	 */
	public Boolean getActionChanged() {
		return actionChanged;
	}

	/**
	 * sets change in characters action
	 * 
	 * @param b
	 */
	public void setActionChanged(boolean b) {
		this.actionChanged = b;
	}
	
	/**
	 * sets characters current direction
	 * 
	 * @param direction
	 */
	public void setCurrentDirection (Direction direction) {
		this.currentDirection = direction;
	}
	
	/**
	 * gets characters current direction
	 * 
	 * @return
	 */
	public Direction getCurrentDirection() {
		return this.currentDirection;
	}
	
	/**
	 * sets character dead/alive
	 * 
	 * @param dead
	 */
	public void setDead(boolean dead) {
			this.isDead = dead;
	}
	
	
	/**
	 * returns true if character is dead, otherwise false
	 * 
	 * @return
	 */
	public boolean isDead() {
		return isDead;
	}
	
	public int getElapsedFrames() {
		return elapsedFrames;
	}

	public void setElapsedFrames(int elapsedFrames) {
		this.elapsedFrames = elapsedFrames;
	}

	/**
	 * updates character state
	 */
	public void updateState() {

	}
	
	
	
}
