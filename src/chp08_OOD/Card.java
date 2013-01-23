package chp08_OOD;

public abstract class Card {
	
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}
	
	/*
	 * Method like value() don't make much sense 
	 * without a specific game attached to them */
	public abstract int value();
	
	public Suit suit() { return suit; }
	
}
