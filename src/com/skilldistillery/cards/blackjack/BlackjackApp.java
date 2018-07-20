package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {


	public static void main(String[] args) {

		BlackjackApp ba = new BlackjackApp();
		ba.run();
	}


	private void run() {
		Scanner sc = new Scanner(System.in);
		Deck deck = new Deck();
		deck.shuffleDeck();
		int userCardValue = 0;
		int dealerCardValue = 0;
//		Hand userHand = new BlackjackHand();
//		Hand dealerHand = new BlackjackHand();
		List<Card> userHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		System.out.println("Let's Play Blackjack!");
		Card c = deck.dealCard();
		userHand.add(c);
		userCardValue = c.getValue();
		Card d = deck.dealCard();
		dealerHand.add(d);
		dealerCardValue = d.getValue();
		c = deck.dealCard();
		userHand.add(c);
		userCardValue += c.getValue();
		System.out.println("Your hand: ");
		printHandAndValue(userHand, userCardValue);
		System.out.println();
		System.out.println("Dealer hand: ");
		printHandAndValue(dealerHand, dealerCardValue);
		System.out.print("Would you like to Hit or Stay? ");
		String input = sc.nextLine();
		while ((input.equalsIgnoreCase("HIT")) || userCardValue <= 21) {
			c = deck.dealCard();
			userCardValue += c.getValue();
			printHandAndValue(userHand, userCardValue);
			System.out.print("Hit or Stay? ");
			input = sc.nextLine();			
		}
		
	}

	private void printHandAndValue(List<Card> card, int value) {
		for (Card card2 : card) {
			System.out.println(card2);
		}
		System.out.println("Total card value: " + value);
	}
	
	private void hitOrStay() {
		
	}
}
