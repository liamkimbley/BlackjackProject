package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		getCards();
	}

	@Override
	public int getHandValue() {
		return getValue();
	}
	
//	public int setHandValue() {
//		if (getValue() < 21) {
//			
//		}
//	}
}
