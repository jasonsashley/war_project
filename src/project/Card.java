package project;

public class Card {

	private int value;
	private String rank;
	private String suit;

	public Card(String rank, String suit) {
		setRank(rank);
		setSuit(suit);
		setValue();
	}

	public Card(int value, String suit) {
		this(String.valueOf(value), suit);
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public void setRank(String rank) {
		this.rank = ValidateCard.getValidRank(rank);
		setValue();
	}

	public void setRankByValue(int value) {
		this.rank = ValidateCard.getValidRank(value);
		setValue();
	}

	public void setSuit(String suit) {
		this.suit = ValidateCard.getValidSuit(suit);
		;
	}

	private void setValue() {
		value = ValidateCard.valueOfRank(rank);
	}

	public void describe() {
		System.out.println(toString());
	}

	// @@Override
	public String toString() {
		return rank + " of " + suit;
	}

}
