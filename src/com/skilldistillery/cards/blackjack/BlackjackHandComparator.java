package com.skilldistillery.cards.blackjack;

import java.util.Comparator;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHandComparator implements Comparator<Hand> {


	@Override
	public int compare(Hand o1, Hand o2) {
		if (o1.getHandValue() > 21) {
			return -1;
		}
		else if (o2.getHandValue() > 21) {
			return 1;
		}
		else if (o1.getHandValue() > o2.getHandValue()) {
			return 1;
		}
		else if (o1.getHandValue() < o2.getHandValue()) {
			return -1;
		}
		else  {
			return 0;
		}
	}

}
