package com.teamgthree.game.Model;

import com.teamgthree.game.Game;

public class EnemyDragon extends Enemy implements EnemyInterface {
	
	public EnemyDragon() {
		super("dragon.png", Game.getMapManager(), Enemies.DRAGON);
		
		this.setMovementSpeed(6);
		this.setGrantedXP(80);
	}

	@Override
	public void stats(int strength, int dexterity, int intelligence) {
		this.setStrength(strength);
		this.setIntelligence(intelligence);
		this.setDexterity(dexterity);
	}
}
