package project;

public abstract class ValidateCard {

	private static String[] VALID_RANKS = { "ACE", "KING", "QUEEN", "JACK", "TEN", "NINE", "EIGHT", "SEVEN", "SIX",
			"FIVE", "FOUR", "THREE", "TWO" };
	private static String[] VALID_SUITS = { "SPADES", "CLUBS", "HEARTS", "DIAMONDS" };

	public static String getValidRank(String input) {
		input = input.toUpperCase();
		for (String rank : VALID_RANKS) {
			if (input.equals(rank)) {
				return input;
			}
		}
		
		switch (input) {
		case ("A"):
		case ("14"):
			return "ACE";
		case ("K"):
		case ("13"):
			return "KING";
		case ("Q"):
		case ("12"):
			return "QUEEN";
		case ("J"):
		case ("11"):
			return "JACK";
		case ("10"):
			return "TEN";
		case ("9"):
			return "NINE";
		case ("8"):
			return "EIGHT";
		case ("7"):
			return "SEVEN";
		case ("6"):
			return "SIX";
		case ("5"):
			return "FIVE";
		case ("4"):
			return "FOUR";
		case ("3"):
			return "THREE";
		case ("2"):
			return "TWO";
		}
		return null;
	}

	public static String getValidRank(int input) {
		if (input > 1 && input < 15) {
			return getValidRank(String.valueOf(input));
		}
		return null;
	}

	public static String getValidSuit(String input) {
		input = input.toUpperCase();
		for (String suit : VALID_SUITS) {
			if (input.equals(suit)) {
				return input;
			}
		}
		return null;
	}

	public static int valueOfRank(String rank) {
		int value = 1;
		if (rank == null) {
			return 0;
		}

		switch (rank) {
		case ("ACE"):
			value += 1;
		case ("KING"):
			value += 1;
		case ("QUEEN"):
			value += 1;
		case ("JACK"):
			value += 1;
		case ("TEN"):
			value += 1;
		case ("NINE"):
			value += 1;
		case ("EIGHT"):
			value += 1;
		case ("SEVEN"):
			value += 1;
		case ("SIX"):
			value += 1;
		case ("FIVE"):
			value += 1;
		case ("FOUR"):
			value += 1;
		case ("THREE"):
			value += 1;
		case ("TWO"):
			value += 1;
			return value;
		default:
			return 0;
		}

	}
}
