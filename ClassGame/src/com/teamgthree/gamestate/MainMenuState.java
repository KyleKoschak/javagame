package com.teamgthree.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MainMenuState extends GameState {

	private static int currentSelection = 0;

	private String[] buttons = { "PLAY", "LOAD", "EXIT" };

	Font titleFont = new Font("helvetica", Font.BOLD, 75); // Big font for title
	Font buttonFont = new Font("helvetica", Font.BOLD, 50); // Smaller font for buttons

	public MainMenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {

		// Background color
		g.setColor(new Color(100, 150, 200));
		g.fillRect(0, 0, 800, 600);

		// Title
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("CIS 241", 250, 100);

		// Draw Buttons
		g.setColor(Color.BLACK);
		g.fillRect(300, 200, 200, 80);
		g.fillRect(300, 300, 200, 80);
		g.fillRect(300, 400, 200, 80);

		g.setFont(buttonFont);

		for (int i = 0; i < buttons.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}

			g.drawString(buttons[i], 330, 255 + (i * 100));
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
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = 2;
			}
		}

		if (e == KeyEvent.VK_SPACE || e == KeyEvent.VK_ENTER) {
			if (currentSelection == 0) { 		// PLAY
				gsm.setCurrentState(GameStateManager.PLAYINGSTATE);
			} else if (currentSelection == 1) { // LOAD
				
			} else if (currentSelection == 2) { // EXIT
				System.exit(0);
			}
		}

	}

	@Override
	public void keyReleased(int e) {

	}

}
