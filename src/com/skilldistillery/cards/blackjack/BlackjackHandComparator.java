package com.skilldistillery.cards.blackjack;

import java.util.Comparator;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHandComparator implements Comparator<Hand> {


	@Override
	public int compare(Hand o1, Hand o2) {
		if (o1.getHandValue() > o2.getHandValue()) {
			return 1;
		}
		else if (o2.getHandValue() > o1.getHandValue()) {
			return -1;
		}
		return 0;
	}

}
