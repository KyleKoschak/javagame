package com.teamgthree.game.Model;

import com.teamgthree.game.Game;

public class EnemyOrc extends Enemy implements EnemyInterface {
	
	public EnemyOrc() {
		super("orc.png", Game.getMapManager(), Enemies.DRAGON);
		
		this.setMovementSpeed(3);
		this.setGrantedXP(50);
	}
	
	@Override
	public void stats(int strength, int dexterity, int intelligence) {
		this.setStrength(strength);
		this.setIntelligence(intelligence);
		this.setDexterity(dexterity);
	}
}
