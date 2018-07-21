package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	private Scanner sc = new Scanner(System.in);
	private int userCardValue = 0;
	private int dealerCardValue = 0;
	private List<Card> userHand;
	private List<Card> dealerHand;
	private String again = null;
	private String input;
	private Card c;
	private Card d;
	private Deck deck;
	

	public static void main(String[] args) {

		BlackjackApp ba = new BlackjackApp();
		ba.run();
	}


	private void run() {
		deck = new Deck();
		deck.shuffleDeck();
		userHand = new ArrayList<>();
		dealerHand = new ArrayList<>();
		
		System.out.println("Let's Play Blackjack!");
		do {
		c = deck.dealCard();
		userHand.add(c);
		userCardValue = c.getValue();
		d = deck.dealCard();
		dealerHand.add(d);
		dealerCardValue = d.getValue();
		c = deck.dealCard();
		userHand.add(c);
		userCardValue += c.getValue();
		System.out.println("Your hand: ");
		printHandAndValue(userHand, userCardValue);
		System.out.println();
		printHandAndValue(dealerHand, dealerCardValue);
		System.out.print("Would you like to Hit or Stay? ");
		input = sc.nextLine();
		
			do {
				if (input.equalsIgnoreCase("Stay")) {
					break;
				}
				c = deck.dealCard();
				userHand.add(c);
				userCardValue += c.getValue();
				System.out.println("Your hand: ");
				printHandAndValue(userHand, userCardValue);
				if (userCardValue >= 21) {
					break;
				}
				System.out.print("Hit or Stay? ");
				input = sc.nextLine();
			} while ((input.equalsIgnoreCase("HIT") && userCardValue <= 21));
			
			if (userCardValue <= 21) {
				do {
					d = deck.dealCard();
					dealerHand.add(d);
					dealerCardValue += d.getValue();
					System.out.println("Dealer hand: ");
					printHandAndValue(dealerHand, dealerCardValue);
				} while (dealerCardValue < 17);
			}
			
//			dealer wins if player busts. or dealer cards higher than user cards
//			user wins if dealer busts. or user cards higher than dealer cards
			
			
			if ((userCardValue > 21)  || (dealerCardValue > userCardValue)){
				System.out.println("You lose!");
			}
			else if ((dealerCardValue > 21) || (userCardValue > dealerCardValue)) {
				System.out.println("You Win!");
			}
			else if (userCardValue == dealerCardValue) {
				System.out.println("You both have the same value. Hand is pushed.");
			}
			System.out.println("Would you like to play again? Y/N");
			again = sc.nextLine();
			userHand.clear();
			dealerHand.clear();
		} while (again.equalsIgnoreCase("Y"));
		
	}

	private void printHandAndValue(List<Card> card, int value) {
		for (Card card2 : card) {
			System.out.println(card2);
		}
		System.out.println("Total card value: " + value);
	}

}
