package Games;

import java.util.ArrayList;

import Deck.Card;

import net.dv8tion.jda.core.entities.User;

public class Player {

	public User user;
	private ArrayList<Card> hand;
	private boolean inGame = false;
	private boolean stand = false;
	private String name;

	public Player(User user) {
		this.user = user;
		if (user == null) {
			name = "bot";
		} else {
			name = user.getName();
		}
		hand = new ArrayList<>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void addCards(ArrayList<Card> cards) {
		hand.addAll(cards);
	}

	public boolean removeCard(Card card) {
		return hand.remove(card);
	}

	public ArrayList<Card> removeAll() {
		ArrayList<Card> temp = new ArrayList<>(hand);
		hand = new ArrayList<>();
		return temp;
	}

	public String showHand() {
		String str = "";
		for (Card card : hand) {
			str += (card.toStringBlock() + "\n");
		}
		return str;
	}

	public String showVisCards() {
		String str = "*" + user.getName() + "'s* visible cards:";

		for (int i = 1; i < hand.size(); i++) {
			str += "\n\t" + showCard(i);
		}
		str += "\n";

		return str;
	}

	public String showCard(int i) {
		return hand.get(i).toString();
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public int getNumCards() {
		return hand.size();
	}
	
	public String getName() {
		return name;
	}

	public void setActive(boolean b) {
		inGame = b;
	}

	public boolean isActive() {
		return inGame;
	}

	public boolean isStand() {
		return stand;
	}

	public void setStand(boolean b) {
		stand = b;
	}
	
	public int getBJValues() {
		int val = 0;
		
		for (Card card : hand) {
			int tempVal = card.getRank();
			if (tempVal > 10) {
				tempVal = 10;
			}
			val += tempVal;
		}
		
		return val;
	}

	public boolean equals(Player player) {
		return player.user.getName().equals(this.user.getName());
	}

}
