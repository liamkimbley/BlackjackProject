package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
private int value;
private List<Card> cards;	

	public Hand() {
		cards = getCards();
	}
	
	public int getHandValue() {
		return getValue();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public List<Card> getCards(){
// add cards to hand
		cards = new ArrayList<Card>();
		return cards;
	}
	
	public void clearHand() {
		cards.clear();
	}

	public void setValue(int val) {
		this.value = val;
	}

	public int getValue() {
		return value;
	}
}
