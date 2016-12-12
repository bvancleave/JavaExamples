package com.bvancleave.examples;

/**
 * 
 * @author Bradley Van Cleave
 *
 * Write a class whose instances represents a full deck of cards.
 */
public class Deck {
	public static final int numRanks = 13;
	public static final int numSuits = 4;
	public static final int numCards = numRanks * numSuits;
	
	private Card[][] cards;
	
	public Deck() {
		cards = new Card[numSuits][numRanks];
		for ( int suit = Suit.CLUBS; suit <= Suit.SPADES; suit++ ) {
			for ( int rank = Rank.ACE; rank <= Rank.KING; rank++ ) {
				cards[suit][rank-1] = new Card.CardBuilder()
										.withRank(rank)
										.withSuit(suit)
										.build();
			}
		}
	}
	
	public Card getCard( int rank, int suit ) {
		if ( ! Card.CardBuilder.isValidRank(rank) ) {
			throw new IllegalArgumentException("Invalid Rank");
		}
		
		if ( !Card.CardBuilder.isValidSuit(suit) ) {
			throw new IllegalArgumentException("Invalid Suit");
		}
		
		return cards[suit][rank-1];
	}
}
