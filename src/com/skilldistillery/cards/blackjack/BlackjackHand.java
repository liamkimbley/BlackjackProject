package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		setCards(new ArrayList<>());
	}

	public int getHandValue() {
		return super.getHandValue();
	}

	@Override
	public void setValue(int value) {
		super.setValue(value);
	}

	@Override
	public void addCard(Card c) {
		super.setValue(c.getValue() + super.getHandValue());
		super.addCard(c);
		List<Card> cards = super.getCards();
		for (Card card : cards) {
			if ((card.getValue() == 11) && (super.getHandValue() > 21)) {
				super.setValue(super.getHandValue() - 10);
			}
		}
	}

}
