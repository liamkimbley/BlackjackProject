package com.skilldistillery.cards.blackjack;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {
	private Scanner sc = new Scanner(System.in);
	private int results = 0;
	private int playerHandValue = 0;
	private BlackjackHandComparator bhc;
	private Hand playerHand;
	private Hand dealerHand;
	private String input;
	private Deck deck;

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		String again;

		do {
			ba.run();
			System.out.println("Would you like to play again? Y/N");
			again = ba.sc.nextLine();
		} while (again.equalsIgnoreCase("Y"));

		System.out.println("Thanks for playing!");
		ba.sc.close();

	}

	private void run() {
		deck = new Deck();
		deck.shuffleDeck();
		dealerHand = new BlackjackHand();
		bhc = new BlackjackHandComparator();
		playerHand = new BlackjackHand();

		System.out.println("Let's Play Blackjack!");
		playersDeal();
		dealersDeal();

		blackjack(dealerHand);
		blackjack(playerHand);

		if (playerHand.getHandValue() < 21) {
			playerTurn(playerHand);
		}
		if (playerHand.getHandValue() <= 21) {
			dealerHand.getCards();
			dealerHand = dealerTurn(dealerHand);
		}
//		dealer wins if player busts. or dealer cards higher than user cards
//		user wins if dealer busts. or user cards higher than dealer cards

		results = bhc.compare(playerHand, dealerHand);
		winner(results);

		playerHand.clearHand();
		dealerHand.clearHand();
	}

	private void playersDeal() {
		playerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		System.out.println("Your hand: ");
		printHandAndValue(playerHand, playerHand.getHandValue());
		System.out.println();
	}

	private void dealersDeal() {
		dealerHand.addCard(deck.dealCard());
		System.out.println("Dealer's hand: ");
		printHandAndValue(dealerHand, dealerHand.getHandValue());
		dealerHand.addCard(deck.dealCard());
	}

	private Hand playerTurn(Hand hand) {
//		player's turn: player is dealt a card as long as they hit and have not gone over 21
//		if player goes over 21, game stops immediately

		do {
			System.out.print("Would you like to Hit or Stay? ");
			input = sc.nextLine();
			if (!(input.equalsIgnoreCase("Hit"))) {
				break;
			}
			playerHand.addCard(deck.dealCard());
			playerHandValue = playerHand.getHandValue();
			System.out.println("Your hand: ");
			printHandAndValue(playerHand, playerHand.getHandValue());
			if (playerHandValue > 21) {
				break;
			}
		} while (input.equalsIgnoreCase("Hit"));

		return playerHand;
	}

	private Hand dealerTurn(Hand hand) {
		System.out.println("Dealer hand: ");
		printHandAndValue(dealerHand, dealerHand.getHandValue());
		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(deck.dealCard());
			System.out.println("Dealer hand: ");
			printHandAndValue(dealerHand, dealerHand.getHandValue());
		}

		return dealerHand;
	}

	private void blackjack(Hand hand) {
		if (hand.getCards().size() == 2 && hand.getHandValue() == 21) {
			System.out.println("Blackjack!");
			BlackjackApp.main(null);
		}
	}

	private void winner(int i) {
		if (results == -1) {
			System.out.println("You lose!");
		} else if (results == 0) {
			System.out.println("You both have the same value. Hand is pushed.");
		} else if (results == 1) {
			System.out.println("You Win!");
		}
	}

	private void printHandAndValue(Hand hand, int value) {
		List<Card> cardsInHand = hand.getCards();
		for (Card card : cardsInHand) {
			System.out.println(card);
		}
		System.out.println("Total card value: " + value);
	}

}
