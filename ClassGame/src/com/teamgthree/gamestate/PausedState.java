package com.teamgthree.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.teamgthree.control.LevelUp;

public class PausedState extends GameState {
	
	private static int currentSelection = 0;
	PlayingState ps = new PlayingState(gsm);
	Font font = new Font ("helvetica", Font.BOLD, 50);
	Font buttonFont = new Font ("helvetica", Font.BOLD, 30);
	private String[] buttons = { "CONTINUE", "SAVE GAME", "MAIN MENU" };
	
	private LevelUp levelUp = new LevelUp();

	public PausedState (GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		levelUp.drawLevelBar(g);
		
		//Draw "Paused"
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("PAUSED", 300, 100);
		
		// Draw Buttons
		g.setFont(buttonFont);
		for (int i = 0; i < buttons.length; i++) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(305, 225 + (i * 100), 200, 40);
			if (i == currentSelection) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}
			
			g.drawString(buttons[i], 320, 255 + (i * 100));
		}
		
		
	}

	@Override
	public void keyPressed(int e) {
		if (e == KeyEvent.VK_DOWN) {
			currentSelection++;
			if (currentSelection >= 3) {
				currentSelection = 0;
			}
		}
		
		if (e == KeyEvent.VK_UP) {
			--currentSelection;
			if (currentSelection < 0) {
				currentSelection = 2;
			}
		}
		
		if (e == KeyEvent.VK_SPACE || e == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) { 		// PLAY
				gsm.setCurrentState(GameStateManager.PLAYINGSTATE);
			} else if (currentSelection == 1) { // SAVE GAME
				
			} else if (currentSelection == 2) { // MAIN MENU
				gsm.setCurrentState(GameStateManager.MENUSTATE);
			}
		}

		if (e == KeyEvent.VK_ESCAPE) {
			gsm.setCurrentState(GameStateManager.PLAYINGSTATE);
		}
	}

	@Override
	public void keyReleased(int e) {
		
	}
	
}
