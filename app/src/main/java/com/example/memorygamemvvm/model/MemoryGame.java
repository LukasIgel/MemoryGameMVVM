package com.example.memorygamemvvm.model;

import android.os.Handler;
import android.os.Looper;

import java.util.Arrays;
import java.util.Collections;

public class MemoryGame {
    private MemoryCard previousCard;
    private MemoryCard[] memoryCards;
    private FlipCounter flipCounter = new FlipCounter();


    public MemoryGame(int numberOfCards){
        memoryCards = new MemoryCard[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            memoryCards[i] = new MemoryCard();
            memoryCards[i].setContent(Emoji.getEmoji(i/2));
        }
        Collections.shuffle(Arrays.asList(memoryCards));
    }
    public String getMemoryCardContent(int i) {
        return memoryCards[i].getCurrentContent();
    }
    public String getFlipCount() {
        return flipCounter.getCount();
    }
    public void increaseFlipCount() {
        flipCounter.countUp();
    }
    public MemoryCard getMemoryCard(int i) {
        return memoryCards[i];
    }

    public int checkIfPair(MemoryCard currentCard) throws InterruptedException {
        if (previousCard == null) {
            previousCard = currentCard;
            return -1;
        } else {
            if (currentCard.getContent().equals(previousCard.getContent())) {
                currentCard.freeze();
                previousCard.freeze();
                previousCard = null;
                return -1;
            } else {
                previousCard.flip();
                currentCard.flip();
                int previousCardId = Arrays.asList(memoryCards).indexOf(previousCard);
                previousCard = null;
                return previousCardId;
            }
        }
    }
}
