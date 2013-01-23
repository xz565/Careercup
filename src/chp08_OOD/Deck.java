package chp08_OOD;

import java.util.ArrayList;

public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public void setDeckOfCard(ArrayList<T> deckOfCards) {}
	
	public void shuffle() {
		T temp;
		int index;
		for(int i = 0; i < cards.size(); i++) {
			index = (int)(Math.random() * (cards.size() - i)) + i;
			temp = cards.get(i);
			cards.add(i, cards.get(index));
			cards.add(index, temp);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
}
