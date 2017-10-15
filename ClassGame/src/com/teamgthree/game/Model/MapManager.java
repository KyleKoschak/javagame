package com.teamgthree.game.Model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import com.teamgthree.game.View.Direction;

public class MapManager implements Iterable<Character> {
	private ArrayList<Character> characters = new ArrayList<>();

	@Override
	public Iterator<Character> iterator() {
		return characters.iterator();
	}

	public void addCharacter(Character character) {
		this.characters.add(character);
	}
	
	public ArrayList<Character> getCharacters() {
		return this.characters;
	}

	public boolean intersects(Character character) {
		boolean intersects = false;

		Rectangle charRect = new Rectangle(character.getSprite().getX(),
				character.getSprite().getY(), character.getSprite()
						.getSPRITE_WIDTH(), character.getSprite()
						.getSPRITE_HEIGHT());

		for (Character otherCharacter : this.characters) {
			Rectangle otherCharRect = new Rectangle(otherCharacter.getSprite()
					.getX(), otherCharacter.getSprite().getY(), character
					.getSprite().getSPRITE_WIDTH(), character.getSprite()
					.getSPRITE_HEIGHT());
			if (otherCharRect.intersects(charRect)) {
				intersects = true;
			}
		}

		return intersects;
	}

	public Character intersects(Rectangle rect) {
		Character intersects = null;

		for (Character otherCharacter : this.characters) {
			Rectangle otherCharRect = new Rectangle(otherCharacter.getSprite()
					.getX(), otherCharacter.getSprite().getY(), otherCharacter
					.getSprite().getSPRITE_WIDTH(), otherCharacter.getSprite()
					.getSPRITE_HEIGHT());
			if (otherCharRect.intersects(rect)) {
				intersects = otherCharacter;
			}
		}

		return intersects;
	}

	public boolean intersectsPlayer(Character character) {
		boolean intersects = false;
		Rectangle charRect = new Rectangle(character.getSprite().getX(),
				character.getSprite().getY(), character.getSprite()
						.getSPRITE_WIDTH(), character.getSprite()
						.getSPRITE_HEIGHT());

		for (Character otherCharacter : this.characters) {

			if (otherCharacter instanceof Player) {
				Rectangle otherCharRect = new Rectangle(otherCharacter
						.getSprite().getX(), otherCharacter.getSprite().getY(),
						character.getSprite().getSPRITE_WIDTH(), character
								.getSprite().getSPRITE_HEIGHT());
				if (otherCharRect.intersects(charRect)) {
					intersects = true;
				}
				break;
			}
		}
		return intersects;
	}

	public void updateState() {
		ArrayList<Character> deadEnemies = new ArrayList<>();
		
		for (Character character : characters) {
			if (character instanceof Enemy && character.isDead() && 
					character.getElapsedFrames() == 100) {
				deadEnemies.add(character);
			}
		}
		
		System.out.println("Dead enemies: " + deadEnemies);
		characters.removeAll(deadEnemies);
	}

	public Character isInRange(Character character) {
		Character isInRange = null;
		Rectangle rect = null;
		if (character instanceof Player) { // Player is attacking an Enemy
			Direction direction = ((Player) character).getCurrentDirection();
			switch (direction) {
			case EAST: // make sure there is an enemy to the right of the player
				rect = new Rectangle(character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getY(), character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case WEST: // make sure there is an enemy to the left of the player
				rect = new Rectangle(character.getSprite().getX()
						- character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getY(), character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case NORTH: // make sure there is an enemy below the player
				rect = new Rectangle(character.getSprite().getX(), character
						.getSprite().getY()
						- character.getSprite().getSPRITE_HEIGHT(), character
						.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case SOUTH: // make sure there is an enemy above the player
				rect = new Rectangle(character.getSprite().getX(), character
						.getSprite().getY()
						+ character.getSprite().getSPRITE_HEIGHT(), character
						.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			default:
				break;
			}
			isInRange = intersects(rect);

		} else { // Enemy is attacking the player
			Direction direction = ((Enemy) character).getCurrentDirection();

			switch (direction) {
			case EAST: // make sure there is an enemy to the right of the player
				rect = new Rectangle(character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getY(), character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case WEST: // make sure there is an enemy to the left of the player
				rect = new Rectangle(character.getSprite().getX()
						- character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getY(), character.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case NORTH: // make sure there is an enemy below the player
				rect = new Rectangle(character.getSprite().getX(), character
						.getSprite().getY()
						- character.getSprite().getSPRITE_HEIGHT(), character
						.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			case SOUTH: // make sure there is an enemy above the player
				rect = new Rectangle(character.getSprite().getX(), character
						.getSprite().getY()
						+ character.getSprite().getSPRITE_HEIGHT(), character
						.getSprite().getX()
						+ character.getSprite().getSPRITE_WIDTH(), character
						.getSprite().getSPRITE_HEIGHT());
				break;
			default:
				break;
			}
			isInRange = intersects(rect);

		}
		return isInRange;
	}

}
