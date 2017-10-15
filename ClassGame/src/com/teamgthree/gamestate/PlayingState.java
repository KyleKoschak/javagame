package com.teamgthree.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.teamgthree.control.Boundries;
import com.teamgthree.control.LevelUp;
import com.teamgthree.game.Game;
import com.teamgthree.game.Model.AttackAction;
import com.teamgthree.game.Model.IdleAction;
import com.teamgthree.game.Model.TravelAction;
import com.teamgthree.game.View.Direction;

public class PlayingState extends GameState {
	
	private static boolean moveLeft;
	private static boolean moveRight;
	private static boolean moveUp;
	private static boolean moveDown;
	private static int speed = 10;
	private Font font = new Font("helvetica", Font.BOLD, 100);
	private LevelUp levelUp = new LevelUp();
	private Boundries boundry = new Boundries();

	public PlayingState(GameStateManager gsm) {
		super(gsm);
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
	}


	@Override
	public void update() {
		move();
		levelUp.levelUp();
		boundry.doBoundries();
	}

	@Override
	public void draw(Graphics g) {
		levelUp.drawLevelBar(g);
		
		//Draw life at top
		for (int i = 0; i < Game.player.getHealth(); i++) {
			g.setColor(Color.RED);
			g.fillRect(i * 50 + 15, 20, 40, 20);
		}
		
		//Draw Gameover
		if (Game.player.getHealth() <= 0) {
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 85, 100);
		}
	}

	@Override
	public void keyPressed(int e) {
		//Only do key input if player is alive
		if (!Game.player.isDead()) {
			//Move Left
			if (e == KeyEvent.VK_LEFT || e == KeyEvent.VK_A) {
	
				moveLeft = true;
				moveRight = false;
	
				if (!(Game.player.getAction() instanceof TravelAction) &&
					!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new TravelAction(Direction.WEST));
					Game.player.setCurrentDirection(Direction.WEST);
				}
			}
			
			//Move Right
			if (e == KeyEvent.VK_RIGHT || e == KeyEvent.VK_D) {
	
				moveLeft = false;
				moveRight = true;
	
				if (!(Game.player.getAction() instanceof TravelAction) &&
					!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new TravelAction(Direction.EAST));
					Game.player.setCurrentDirection(Direction.EAST);
				}
			}
	
			//Move Up
			if (e == KeyEvent.VK_UP || e == KeyEvent.VK_W) {

				moveUp = true;
				moveDown = false;
	
				if (!(Game.player.getAction() instanceof TravelAction) &&
					!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new TravelAction(Direction.NORTH));
					Game.player.setCurrentDirection(Direction.NORTH);
				}
			}
	
			//Move Down
			if (e == KeyEvent.VK_DOWN || e == KeyEvent.VK_S) {

				moveUp = false;
				moveDown = true;
	
				if (!(Game.player.getAction() instanceof TravelAction) &&
					!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new TravelAction(Direction.SOUTH));
					Game.player.setCurrentDirection(Direction.SOUTH);
				}
			}
			
			//Attack
			if (e == KeyEvent.VK_SPACE) {
				Game.player.setActionChanged(true);
				Game.player.setAction(new AttackAction(Game.player.getCurrentDirection()));
			}
			
			//Sprint
			if (e == KeyEvent.VK_SHIFT) {
				speed = 15;
			}
		}//End if not dead
		
		//Pause
		if (e == KeyEvent.VK_ESCAPE) {
			//Stop all movement
			moveLeft = false;
			moveRight = false;
			moveUp = false;
			moveDown = false;
				
			//Become idle if not dead
			if (!Game.player.isDead()) {
			Game.player.setActionChanged(true);
			Game.player.setAction(new IdleAction(Game.player
					.getCurrentDirection()));
			}
				
			//Go to paused state
			gsm.setCurrentState(GameStateManager.PAUSEDSTATE);
		}
	}

	@Override
	public void keyReleased(int e) {
		
		if (!Game.player.isDead()) {
			if (e == KeyEvent.VK_LEFT || e == KeyEvent.VK_A) {
				moveLeft = false;
				
				if (!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new IdleAction(Game.player.getCurrentDirection()));
				}
			}
	
			if (e == KeyEvent.VK_RIGHT || e == KeyEvent.VK_D) {
				moveRight = false;
				
				if (!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new IdleAction(Game.player.getCurrentDirection()));
				}
			}
	
			if (e == KeyEvent.VK_UP || e == KeyEvent.VK_W) {
				moveUp = false;
				
				if (!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new IdleAction(Game.player.getCurrentDirection()));
				}
			}
	
			if (e == KeyEvent.VK_DOWN || e == KeyEvent.VK_S) {
				moveDown = false;
				
				if (!(Game.player.getAction() instanceof AttackAction)) {
					Game.player.setActionChanged(true);
					Game.player.setAction(new IdleAction(Game.player.getCurrentDirection()));
				}
			}
	
			if (e == KeyEvent.VK_SPACE) {
				Game.player.setActionChanged(true);
				Game.player.setAction(new IdleAction(Game.player
						.getCurrentDirection()));
			}
			
			//Sprint
			if (e == KeyEvent.VK_SHIFT) {
				speed = 10;
			}
		}
	}
	
	private void move () {
		if (!Game.player.isDead()) {
			if (moveLeft  && !moveRight) {
				Game.player.getSprite()
						.setX(Game.player.getSprite().getX() - speed);
			}
	
			if (!moveLeft && moveRight) {
				Game.player.getSprite()
						.setX(Game.player.getSprite().getX() + speed);
			}
	
			if (!moveUp && moveDown) {
				Game.player.getSprite()
						.setY(Game.player.getSprite().getY() + speed);
			}
	
			if (moveUp && !moveDown) {
				Game.player.getSprite()
						.setY(Game.player.getSprite().getY() - speed);
			}
		}
	}
}
