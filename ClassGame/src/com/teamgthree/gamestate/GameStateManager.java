package com.teamgthree.gamestate;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager {

	private ArrayList<GameState> states;
	
	private static int currentState;

	public static final int MENUSTATE = 0;
	public static final int PLAYINGSTATE = 1;
	public static final int PAUSEDSTATE = 2;
	
	public GameStateManager() {
		states = new ArrayList<GameState>();
		
		states.add(new MainMenuState(this));
		states.add(new PlayingState(this));
		states.add(new PausedState(this));
		
		currentState = MENUSTATE;
	}

	public void setCurrentState(int state) {
		currentState = state;
	}

	public static int getCurrentState() {
		return currentState;
	}

	public void update() {
		states.get(currentState).update();
	}

	public void draw(Graphics g) {
		states.get(currentState).draw(g);
	}

	public void keyPressed(int e) {
		states.get(currentState).keyPressed(e);
	}

	public void keyReleased(int e) {
		states.get(currentState).keyReleased(e);
	}
}
