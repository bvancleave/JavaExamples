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
