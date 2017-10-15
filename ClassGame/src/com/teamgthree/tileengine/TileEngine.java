package com.teamgthree.tileengine;

import java.awt.Graphics;

public class TileEngine {
	private TileMap map;
	
	public TileEngine(TileMap map) {
		this.map = map;
	}
	
	public void drawMap(Graphics g) {
		int[][] currentMap = this.map.getMapArray();
		
		for(int y = 0; y < currentMap.length; y++) {
			for( int x = 0; x < currentMap[y].length; x++) {
				int index = currentMap[y][x] - 1;
				int tilesPerRow = this.map.TILE_SHEET_WIDTH / this.map.TILE_WIDTH;
				int row = (int) Math.floor(index / tilesPerRow );
				int yOffset = row * this.map.TILE_HEIGHT;
				int xOffset = (index - row * tilesPerRow) * this.map.TILE_WIDTH;
				int destX1 = x * this.map.TILE_WIDTH;
				int destX2 = destX1 + this.map.TILE_WIDTH;
				int destY1 = y * this.map.TILE_HEIGHT;
				int destY2 = destY1 + this.map.TILE_HEIGHT;
				
				/*System.out.println("Dest X1: " + destX1);
				System.out.println("Dest Y1: " + destY1);
				System.out.println("Dest X2: " + destX2);
				System.out.println("Dest Y2: " + destY2);
				System.out.println("xOffset: " + xOffset);
				System.out.println("yOffset: " + yOffset);
				System.out.println();*/
				
				g.drawImage(this.map.getTileSheet(), 
							destX1,
							destY1, 
							destX2, 
							destY2, 
							xOffset,
							yOffset,
							xOffset + this.map.TILE_WIDTH, 
							yOffset + this.map.TILE_HEIGHT, 
							null);
				
			}
		}
		
	}
}
