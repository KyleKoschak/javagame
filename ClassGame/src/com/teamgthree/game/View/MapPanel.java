package com.teamgthree.game.View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JRootPane;

import com.teamgthree.tileengine.ReadMap;
import com.teamgthree.tileengine.TileEngine;
import com.teamgthree.tileengine.TileMap;

public class MapPanel extends JRootPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int MAP_WIDTH;
	final int MAP_HEIGHT;
	private TileEngine tileEngine;

	MapPanel(int height, int width) {
		this.MAP_HEIGHT = height;
		this.MAP_WIDTH = width;
		this.setBackground(Color.BLACK);
		this.tileEngine = new TileEngine(TileMap.loadMap(new ReadMap().getMap()));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		tileEngine.drawMap(g);
	}
	
	public void setTileEngine() {
		this.tileEngine = new TileEngine(TileMap.loadMap(new ReadMap().getMap()));
	}
}
