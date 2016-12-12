package com.bvancleave.examples;

/**
 * @author Bradley Van Cleave
 * 
 * Write a class whose instances represent a single playing card from a deck of
 *  cards. Playing cards have two distinguishing properties: rank and suit.
 */
public class Card {
	private final int rank;
	private final int suit;
	
	private Card( int rank, int suit ) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}
	
	public static class CardBuilder {
		private int rank;
		private int suit;
		
		public CardBuilder() {}
		
		public CardBuilder withRank( int rank ) {
			this.rank = rank;
			return this;
		}
		
		public CardBuilder withSuit( int suit ) {
			this.suit = suit;
			return this;
		}
		
		public Card build() {
			Card card = new Card( rank, suit );
			 if ( ! isValidRank( card.getRank() ) )
				 throw new IllegalArgumentException("Invalid Rank");
			 if ( ! isValidSuit( card.getSuit() ) )
				 throw new IllegalArgumentException("Invalid Suit");
			 
			return card;
		}
		
		public static boolean isValidRank( int rank ) {
			return Rank.ACE <= rank && Rank.KING >= rank;
		}
		
		public static boolean isValidSuit( int suit ) {
			return Suit.CLUBS <= suit && Suit.SPADES >= suit;
		}
	}
	
	public static void main( String[] args ) {
		Card card = new Card.CardBuilder()
					.withRank(Rank.ACE)
					.withSuit(Suit.CLUBS)
					.build();
		
		System.out.println(card);
	}

	@Override
	public String toString() {
		return "Card [rank=" + rankToString(rank) 
			+ ", suit=" + suitToString(suit) + "]";
	}
	
	public static String rankToString( int rank ) {
		switch( rank ) {
			case Rank.ACE : return "ACE";
			case Rank.TWO : return "TWO";
			case Rank.THREE : return "THREE";
			case Rank.FOUR : return "FOUR";
			case Rank.FIVE : return "FIVE";
			case Rank.SIX : return "SIX";
			case Rank.SEVEN : return "SEVEN";
			case Rank.EIGHT : return "EIGHT";
			case Rank.NINE : return "NINE";
			case Rank.TEN : return "TEN";
			case Rank.JACK : return "JACK";
			case Rank.QUEEN : return "QUEEN";
			case Rank.KING : return "KING";
			default : 
				throw new IllegalArgumentException("Invalid Rank");
		}
	}
	
	public static String suitToString( int suit ) {
		switch( suit ) {
			case Suit.CLUBS : return "CLUBS";
			case Suit.DIAMONDS : return "DIAMONDS";
			case Suit.HEARTS : return "HEARTS";
			case Suit.SPADES : return "SPADES";
			default :
				throw new IllegalArgumentException("Invalid Suit");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + suit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
}

