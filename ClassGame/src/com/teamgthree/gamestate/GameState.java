package com.teamgthree.gamestate;

import java.awt.Graphics;

public abstract class GameState {
	
	public GameStateManager gsm;
	
	public GameState (GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int e);
	public abstract void keyReleased(int e);
}
