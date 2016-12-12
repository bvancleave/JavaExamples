package com.bvancleave.examples.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bvancleave.examples.Card;
import com.bvancleave.examples.Rank;
import com.bvancleave.examples.Suit;

public class CardTest {

	@Test
	public void buildCard() {
		Card card = new Card.CardBuilder()
						.withRank(Rank.ACE)
						.withSuit(Suit.CLUBS)
						.build();
		
		assertEquals( Rank.ACE, card.getRank() );
		assertEquals( Suit.CLUBS, card.getSuit() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyInvalidRank0() {
		Card card = new Card.CardBuilder()
				.withRank(0)
				.withSuit(Suit.CLUBS)
				.build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyInvalidRank20() {
		Card card = new Card.CardBuilder()
				.withRank(20)
				.withSuit(Suit.CLUBS)
				.build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyInvalidSuitNeg1() {
		Card card = new Card.CardBuilder()
				.withRank(Rank.ACE)
				.withSuit(-1)
				.build();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyInvalidSuit10() {
		Card card = new Card.CardBuilder()
				.withRank(Rank.ACE)
				.withSuit(10)
				.build();
	}
	
	@Test
	public void testToString() {
		assertEquals( "ACE", Card.rankToString(Rank.ACE) );
		assertEquals( "CLUBS", Card.suitToString(Suit.CLUBS) );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidRankToString() {
		assertEquals( "ACE", Card.rankToString(0) );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidSuitToString() {
		assertEquals( "CLUBS", Card.suitToString(10) );
	}

}
