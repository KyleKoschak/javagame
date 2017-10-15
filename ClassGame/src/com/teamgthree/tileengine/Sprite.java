/**
 * 
 */
package com.teamgthree.tileengine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author josh
 *
 */
public class Sprite {
	private int spriteSheetWidth;
	private String spriteSheet;
	private final int SPRITE_WIDTH;
	private final int SPRITE_HEIGHT;
	private BufferedImage sprite;
	private int x;
	private int sourceX;
	private Animation animation;

	
	public int getSPRITE_WIDTH() {
		return SPRITE_WIDTH;
	}

	public int getSPRITE_HEIGHT() {
		return SPRITE_HEIGHT;
	}

	public int getSpriteSheetWidth() {
		return spriteSheetWidth;
	}
	
	public void setSpriteSheetWidth(int spriteSheetWidth) {
		this.spriteSheetWidth = spriteSheetWidth;
	}
	
	public String getSpriteSheet() {
		return spriteSheet;
	}
	
	public void setSpriteSheet(String spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	
	public Animation getAnimation() {
		return animation;
	}
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	public int getSourceX() {
		return sourceX;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int y;
	
	public Sprite(String spriteSheet, int spriteWidth, int spriteHeight, int spriteSheetWidth) {
		this.spriteSheet = spriteSheet;
		this.SPRITE_HEIGHT = spriteHeight;
		this.SPRITE_WIDTH = spriteWidth;
		this.spriteSheetWidth = spriteSheetWidth;
		this.x = 96;
		this.y = 96;
		
		this.loadSpriteSheet();
		
	}

	public void loadSpriteSheet(){
		try {
			this.sprite = ImageIO.read(new File(this.spriteSheet));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("COULD NOT FIND SPRITE SHEET");
		}
	}
	
	public void drawSprite( Graphics g ) {
		
		int tilesPerRow = this.spriteSheetWidth / this.SPRITE_WIDTH;
		int row = (int) Math.floor(this.getAnimation().getCurrentFrame() / tilesPerRow );
		int yOffset = row * this.SPRITE_HEIGHT;
		int xOffset = (this.getAnimation().getCurrentFrame() - row * tilesPerRow) * this.SPRITE_WIDTH;
		int destX1 = this.x;
		int destX2 = destX1 + this.SPRITE_WIDTH;
		int destY1 = this.y;
		int destY2 = destY1 + this.SPRITE_HEIGHT;
		
		/*System.out.println("Dest X1: " + destX1);
		System.out.println("Dest Y1: " + destY1);
		System.out.println("Dest X2: " + destX2);
		System.out.println("Dest Y2: " + destY2);
		System.out.println("xOffset: " + xOffset);
		System.out.println("yOffset: " + yOffset);
		System.out.println();*/
		
		
		g.drawImage(this.sprite, 
				destX1,
				destY1, 
				destX2, 
				destY2, 
				xOffset,
				yOffset,
				xOffset + this.SPRITE_WIDTH, 
				yOffset + this.SPRITE_HEIGHT, 
				null);
	}
	
}
