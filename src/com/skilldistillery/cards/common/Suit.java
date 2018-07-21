package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("\u2665"), SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u2666");

	Suit(String s) {
		name = s;
	}

	final private String name;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
