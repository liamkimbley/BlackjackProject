package com.skilldistillery.cards.blackjack;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {
//	private int userCardValue = 0;
//	private int dealerCardValue = 0;
	private int winner = 0;
	private BlackjackHandComparator bhc;
	private Hand player1;
	private Hand dealerHand;
	private String input;
	private Card c;
	private Card d;
	private Deck deck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BlackjackApp ba = new BlackjackApp();
		String again;
		
		do {
			ba.run(sc);
			System.out.println("Would you like to play again? Y/N");
			again = sc.nextLine();
		} while (again.equalsIgnoreCase("Y"));

		sc.close();
	}

	private void run(Scanner sc) {
		deck = new Deck();
		deck.shuffleDeck();
		player1 = new BlackjackHand();
		dealerHand = new BlackjackHand();
		bhc = new BlackjackHandComparator();

		System.out.println("Let's Play Blackjack!");

		do {
			initialDeal();
//			userCardValue = player1.getHandValue();
			if (player1.getHandValue() < 21) {
				System.out.print("Would you like to Hit or Stay? ");
				input = sc.nextLine();

				if (input.equalsIgnoreCase("Stay")) {
					break;
				}
				c = deck.dealCard();
				player1.addCard(c);
//				userCardValue = player1.getHandValue();
				System.out.println("Your hand: ");
				printHandAndValue(player1, player1.getHandValue());
				if (player1.getHandValue() >= 21) {
					break;
				}
				System.out.print("Hit or Stay? ");
				input = sc.nextLine();
			}
		} while ((input.equalsIgnoreCase("HIT") && player1.getHandValue() <= 21));

		if (player1.getHandValue() <= 21) {
			do {
				d = deck.dealCard();
				dealerHand.addCard(d);
				System.out.println("Dealer hand: ");
				printHandAndValue(dealerHand, dealerHand.getHandValue());
			} while (dealerHand.getHandValue() < 17);
		}

//			dealer wins if player busts. or dealer cards higher than user cards
//			user wins if dealer busts. or user cards higher than dealer cards
		winner = bhc.compare(player1, dealerHand);

		if ((player1.getHandValue() > 21) || (winner == -1)) {
			System.out.println("You lose!");
		} else if ((winner == 1) || dealerHand.getHandValue() < 21) {
			System.out.println("You Win!");
		} else if (winner == 0) {
			System.out.println("You both have the same value. Hand is pushed.");
		}
		player1.clearHand();
		dealerHand.clearHand();

	}

	private void initialDeal() {
		c = deck.dealCard();
		player1.addCard(c);
		d = deck.dealCard();
		dealerHand.addCard(d);
		c = deck.dealCard();
		player1.addCard(c);
		System.out.println("Your hand: ");
		printHandAndValue(player1, player1.getHandValue());
		System.out.println();
		System.out.println("Dealer's hand: ");
		printHandAndValue(dealerHand, dealerHand.getHandValue());
	}

	private void printHandAndValue(Hand hand, int value) {
		List<Card> cardsInHand = hand.getCards();
		for (Card card : cardsInHand) {
			System.out.println(card);
		}
		System.out.println("Total card value: " + value);
	}

}
