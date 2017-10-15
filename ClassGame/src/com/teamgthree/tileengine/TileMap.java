package com.teamgthree.tileengine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileMap {
	public final int TILE_WIDTH;
	public final int TILE_HEIGHT;
	public final int TILE_SHEET_HEIGHT;
	public final int TILE_SHEET_WIDTH;
	private int[][] mapArray;
	private BufferedImage tileSheet;
	
	public BufferedImage getTileSheet() {
		return tileSheet;
	}

	public int[][] getMapArray() {
		return mapArray;
	}

	TileMap(int[][] mapArray, int tileHeight, int tileWidth, int tileSheetHeight, int tileSheetWidth, String tileSheet) {
		this.mapArray = mapArray;
		this.TILE_HEIGHT = tileHeight;
		this.TILE_WIDTH = tileWidth;
		this.TILE_SHEET_HEIGHT = tileSheetHeight;
		this.TILE_SHEET_WIDTH = tileSheetWidth;
		try{
			this.tileSheet = ImageIO.read(new File(tileSheet));
		} catch(IOException e) {
			System.out.println("Could not find tile sheet!");
		}
	}
	
	public static TileMap loadMap(String mapName) {
		TileMap tileMap;
		int[][] mapArray;
		switch(mapName) {
			case "A1":
				mapArray = new ReadMap().read();
				tileMap = new TileMap(mapArray, 32, 32, 32, 384, "grass-tiles-2-small.png");
				break;
			case "A2":
				mapArray = new ReadMap().read();
				tileMap = new TileMap(mapArray, 32, 32, 32, 384, "grass-tiles-2-small.png");
				break;
			default:
				mapArray = new int[][]
						{
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
						};
				tileMap = new TileMap(mapArray, 32, 32, 64, 128, "part1_tileset.png");
		}
		
		return tileMap;
	}
	
}
