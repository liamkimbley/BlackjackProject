package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = makeDeck();
	}

	private List<Card> makeDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(s, r));
			}
		}
		return deck;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int checkDeckSize() {
//		check deck to see how many cards are left
		int cardsLeft = cards.size();
		return cardsLeft;
	}

	public Card[] dealCard(int input) throws Exception {
//		remove a card from the deck
		Card[] cards = new Card[input];
		if (input > 52) {
			throw new Exception("Cannot deal more than  52 cards");
		} else {
			for (int i = 0; i < input; i++) {
				cards[i] = this.cards.remove(0);
			}
			return cards;
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(cards);
	}

}
