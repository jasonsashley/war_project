package project;

import java.util.*;

public class Player {

	private List<Card> hand;
	private int score;
	private String name;

	public Player() {
		this("Default");
	}

	public Player(String name) {
		this.name = name;
		score = 0;
		hand = new ArrayList<Card>();
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public Card flip() {
		Card temp = hand.getFirst();
		hand.removeFirst();
		return temp;
	}

	public void draw(Deck deck) {
		Card temp = deck.draw();
		if (temp != null) {
			hand.add(temp);
		}
	}
	
	public void incrementScore() {
		score++;
	}
	
	public void describe() {
		System.out.println("--------------------");
		System.out.println(name + "'s Scoreboard\n");
		System.out.println("score: " + score);
		System.out.println("hand:::");
		for (Card card : hand) {
			card.describe();
		}
		System.out.println("--------------------");
	}
	
	public boolean lost() {
		return hand.isEmpty();
	}

}
