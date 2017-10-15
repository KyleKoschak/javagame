package com.teamgthree.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.teamgthree.gamestate.GameStateManager;

public class Keyboard implements KeyListener {

	private GameStateManager gsm;

	public Keyboard() {
		gsm = new GameStateManager();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode()); //For key on different states
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode()); //For key on different states
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}
}