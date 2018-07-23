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

	public int checkDeckSize() {
//		check deck to see how many cards are left
		int cardsLeft = cards.size();
		return cardsLeft;
	}

	public Card dealCard() {
//		remove a card from the deck
		return cards.remove(0);

	}

	public void shuffleDeck() {
		System.out.println("Dealer is shuffling cards...");
		Collections.shuffle(cards);
	}

}
