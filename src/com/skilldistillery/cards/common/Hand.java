package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Hand {
private int value;
private List<Card> cards;	

	public Hand() {
		
	}
	
	public int getHandValue() {
		return value;
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public List<Card> getCards(){
		return cards;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public void clearHand() {
		cards.clear();
		this.value = 0;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
