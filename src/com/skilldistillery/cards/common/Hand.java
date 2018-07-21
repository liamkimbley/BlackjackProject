package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Hand {
private int value;
private List<Card> cards;	

	public Hand() {
		
	}
	
	public int getHandValue() {
		return getValue();
	}
	
	public void addCard(Card c) {
		this.value += c.getValue();
		cards.add(c);
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	public void clearHand() {
		cards.clear();
		this.value = 0;
	}

	public int getValue() {
		return value;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
