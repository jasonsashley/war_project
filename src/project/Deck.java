package project;

import java.util.*;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();

		for (int i = 1; i < 5; i++) {
			for (int j = 2; j < 15; j++) {
				switch (i) {
				case (1):
					cards.add(new Card(j, "Spades"));
					break;
				case (2):
					cards.add(new Card(j, "Clubs"));
					break;
				case (3):
					cards.add(new Card(j, "Hearts"));
					break;
				case (4):
					cards.add(new Card(j, "Diamonds"));
					break;
				}
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		try {
			Card temp = cards.getFirst();
			cards.removeFirst();
			return temp;
		} catch(NoSuchElementException e) {
			return null;
		}

	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	

}
