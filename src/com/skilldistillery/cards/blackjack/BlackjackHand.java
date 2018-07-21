package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		setCards(new ArrayList<>());
	}

	@Override
	public int getHandValue() {
		return getValue();
	}
	
}
