package com.teamgthree.game;

import com.teamgthree.game.Model.Character;
import com.teamgthree.game.Model.EnemyFactory;
import com.teamgthree.game.Model.MapManager;
import com.teamgthree.game.Model.Player;
import com.teamgthree.game.View.DisplayablePanel;
import com.teamgthree.game.View.GameWindow;
import com.teamgthree.gamestate.GameStateManager;

public class Game {

	private static boolean isRunning = true;
	private static MapManager mapManager = new MapManager();

	private static final int FPS = 15;
	private static final int FRAME_LENGTH = 1000 / FPS;
	public static Player player;
	private static GameStateManager gsm;
	private static DisplayablePanel displayablePanel;
	private static GameWindow gameWindow;
	private static EnemyFactory sf = new EnemyFactory();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int GAME_WIDTH = 800;
		final int GAME_HEIGHT = 600;

		gsm = new GameStateManager();
		
		gameWindow = new GameWindow("Our First Java Game", GAME_HEIGHT,
				GAME_WIDTH, Game.getMapManager());

		gameWindow.showGameWindow();

		player = new Player(Game.getMapManager());
		player.setName("Josh");
		player.setDexterity(10);
		displayablePanel = gameWindow.getDisplayablePanel();
		displayablePanel.paintComponent(gameWindow.getGraphics());
		sf.makeRandomEnemies(5);
		Game.getMapManager().addCharacter(Game.player);
		
		

		gameLoop();

	}

	public static void gameLoop() {
		while (isRunning) {
			
			try {
				Thread.sleep(FRAME_LENGTH);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (Character character : Game.getMapManager()) {
				character.updateState();
			}
			
			mapManager.updateState();
			gsm.update();
			displayablePanel.repaint();
		}
	} // END GAMELOOP

	public static MapManager getMapManager() {
		return mapManager;
	}
}
