package project;

import java.util.*;

public class App {

	static Scanner scan = new Scanner(System.in);
	static Deck deck;
	static List<Player> players;

	public static void main(String[] args) {

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>> >>> WAR <<< <<<<<");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<\n");

		Integer size = null;
		while (size == null) {
			size = getIntInput("How many players?");
		}
		initialize(size);

		
		while (!lostPlayer()) {
			playRound();
		}
		
		for (Player player : players) {
			player.describe();
		}
		
		printFinalResults();

	}

	private static boolean lostPlayer() {
		for (Player player : players) {
			if (player.lost()) {
				return true;
			}
		}
		return false;
	}

	private static void initialize(int numOfPlayers) {
		deck = new Deck();
		players = new ArrayList<Player>();
		for (int i = 0; i < 7; i++) {
			deck.shuffle();
		}

		for (int i = 1; i <= numOfPlayers; i++) {
			String name = getStringInput("What is player " + i + "'s name? (press enter to choose default)");
			if (name == null) {
				name = "Player " + i;
			}
			players.add(new Player(name));
		}
		System.out.println();
		dealCards();
	}

	private static void dealCards() {
		while (!deck.isEmpty()) {
			for (Player player : players) {
				player.draw(deck);
			}
		}
	}

	private static Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		if (Objects.isNull(input)) {
			return null;
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return null;
		}

	}

	private static String getStringInput(String prompt) {
		System.out.println();
		System.out.print(prompt + " ");
		String input = scan.nextLine();
		return input.isBlank() ? null : input.trim();
	}

	private static void playRound() {
		List<Card> trick = new ArrayList<Card>();
		Card winner = new Card(0, "Spades");
		boolean tie = false;

		for (Player player : players) {
			Card temp = player.flip();
			System.out.println(player.getName() + " played the " + temp);
			trick.add(temp);
			if (temp.getValue() > winner.getValue()) {
				winner = temp;
				tie = false;
			} else if (temp.getValue() == winner.getValue()) {
				tie = true;
			}
		}

		if (tie) {
			System.out.println("Tie, no points awarded.");
		} else {
			Player win = players.get(trick.indexOf(winner));
			System.out.println(win.getName() + " won the round!");
			win.incrementScore();
		}

		System.out.println();
		displayScores();
		getStringInput("(press any key to continue)");
		System.out.println();
	}

	public static void displayScores() {
		System.out.print(players.getFirst().getName() + ": " + players.getFirst().getScore());
		for (int i = 1; i < players.size(); i++) {
			System.out.print(" || " + players.get(i).getName() + ": " + players.get(i).getScore());
		}
	}
	
	public static void printFinalResults() {
		Player winner = getWinner();
		if (winner == null) {
			System.out.println("TIE // DRAW");
		} else {
			System.out.println(winner.getName() + " won the game with " + winner.getScore() + " points! Congratulations!");
		}
	}
	
	public static Player getWinner() {
		Player result = players.getFirst();
		boolean tie = false;
		for (int i = 1; i < players.size(); i++) {
			if (players.get(i).getScore() > result.getScore()) {
				result = players.get(i);
				tie = false;
			} else if (players.get(i).getScore() == result.getScore()) {
				tie = true;
			}
		}
		
		return tie ? null : result;
	}
}
