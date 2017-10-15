package com.teamgthree.game.View;

import javax.swing.JFrame;

import com.teamgthree.control.Keyboard;
import com.teamgthree.game.Model.MapManager;


public class GameWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int GAME_WIDTH;
	final int GAME_HEIGHT;
	private MapPanel mapPanel;
	private DisplayablePanel displayablePanel;
	private MapManager mapManager;
	
	
	public DisplayablePanel getDisplayablePanel() {
		return displayablePanel;
	}

	public void setDisplayablePanel(DisplayablePanel displayablePanel) {
		this.displayablePanel = displayablePanel;
	}

	public GameWindow(String title, int height, int width, MapManager mapManager) {
		this.GAME_HEIGHT = height;
		this.GAME_WIDTH = width;
		this.setTitle(title);
		this.setSize(this.GAME_WIDTH, this.GAME_HEIGHT);
		this.setLocation(100, 100);
		this.setResizable(false);
		
		this.mapManager = mapManager;
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mapPanel = new MapPanel(800, 600);
		this.displayablePanel = new DisplayablePanel(this.mapManager);
		this.displayablePanel.setOpaque(false);
		this.setRootPane(this.mapPanel);
		this.setContentPane(displayablePanel);
		
		this.addKeyListener(new Keyboard());
		
	}
	
	public void buildInterface() {
		
	}
	
	public void showGameWindow() {
		this.setVisible(true);
	}
	
	public MapPanel getMapPanel() {
		return this.mapPanel;
	}
}
