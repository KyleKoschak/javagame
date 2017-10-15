package com.teamgthree.game.View;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.teamgthree.game.Model.Character;
import com.teamgthree.game.Model.MapManager;
import com.teamgthree.gamestate.GameStateManager;

public class DisplayablePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapManager mapManager;
	GameStateManager gsm = new GameStateManager();

	public DisplayablePanel(final MapManager mapManager) {
		this.mapManager = mapManager;
	}

	@Override
	public void paintComponent(Graphics g) {
		this.setOpaque(false);
		super.paintComponent(g);

		for (Character character : mapManager) {
			character.getSprite().drawSprite(g);
		}
		
		gsm.draw(g);
	}

}
