package com.bvancleave.examples.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bvancleave.examples.Card;
import com.bvancleave.examples.Deck;
import com.bvancleave.examples.Rank;
import com.bvancleave.examples.Suit;

public class DeckTest {

	@Test
	public void testGetCard() {
		Deck deck = new Deck();
		
		Card card = new Card.CardBuilder()
				.withRank(Rank.ACE)
				.withSuit(Suit.CLUBS)
				.build();
		
		assertEquals( card, deck.getCard(Rank.ACE, Suit.CLUBS) );
	}
	
	@Test
	public void testDeck() {
		Deck deck = new Deck();
		for ( int suit = Suit.CLUBS; suit <= Suit.SPADES; suit++ ) {
			for ( int rank = Rank.ACE; rank <= Rank.KING; rank++ ) {
				Card actual = deck.getCard(rank, suit);
				Card expected = new Card.CardBuilder()
									.withRank(rank)
									.withSuit(suit)
									.build();
				assertEquals( expected, actual );
			}
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		Deck deck = new Deck();
		
		Card card = new Card.CardBuilder()
				.withRank(Rank.ACE)
				.withSuit(Suit.CLUBS)
				.build();
		
		assertEquals( card, deck.getCard(20,20) );
	}

}
