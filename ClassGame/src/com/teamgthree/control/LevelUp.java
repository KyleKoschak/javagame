package com.teamgthree.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.teamgthree.game.Game;

public class LevelUp {
	
	private final int barLength = 800;
	Font font = new Font("ariel", Font.BOLD, 20);
	
	/**
	 * Draws the yellow xp bar at the bottom that grows based on current player xp
	 * 
	 * @param g
	 */
	public void drawLevelBar(Graphics g) {
		//XP bar
		g.setColor(Color.BLACK);
		g.fillRect(0, 565, barLength, 20);
		
		//XP of XP bar
		g.setColor(Color.YELLOW);
		g.fillRect(0, 565 , (int) (barLength * (Game.player.getCurrentXP() / Game.player.getXPToLevel())), 20);
		
		//Draw text "Level 1" to screen
		g.setFont(font);
		g.drawString("Level " + (int) Game.player.getCurrentLevel(), 10, 550);
	}
	
	/**
	 * Levels up player
	 * 
	 * @return void
	 */
	public void levelUp () {
		Game.player.setXPToLevel(Game.player.getCurrentLevel() * 400);

		//Increase level
		if (Game.player.getCurrentXP() > Game.player.getXPToLevel()) {
			Game.player.setCurrentLevel(Game.player.getCurrentLevel() + 1);
			Game.player.setCurrentXP(0);
			Game.player.setHealth(5);
		}

	}
	
}
