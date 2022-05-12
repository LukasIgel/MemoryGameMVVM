package com.example.memorygamemvvm.viewmodel;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.memorygamemvvm.model.MemoryCard;
import com.example.memorygamemvvm.model.MemoryGame;

import java.util.ArrayList;

public class MemoryGameViewModel extends BaseObservable {
    private MemoryGame memoryGame;
    private int numberOfCards = 12;
    @Bindable
    public ObservableField<String> flipCounter, card00, card01, card02, card03, card04, card05, card06, card07, card08, card09, card10, card11;
    public ArrayList<ObservableField<String>> memoryCards;
    private int[] cardIds;

    public MemoryGameViewModel() {
        card00 = new ObservableField<>();
        card01 = new ObservableField<>();
        card02 = new ObservableField<>();
        card03 = new ObservableField<>();
        card04 = new ObservableField<>();
        card05 = new ObservableField<>();
        card06 = new ObservableField<>();
        card07 = new ObservableField<>();
        card08 = new ObservableField<>();
        card09 = new ObservableField<>();
        card10 = new ObservableField<>();
        card11 = new ObservableField<>();

        memoryCards = new ArrayList<>();
        memoryCards.add(card00);
        memoryCards.add(card01);
        memoryCards.add(card02);
        memoryCards.add(card03);
        memoryCards.add(card04);
        memoryCards.add(card05);
        memoryCards.add(card06);
        memoryCards.add(card07);
        memoryCards.add(card08);
        memoryCards.add(card09);
        memoryCards.add(card10);
        memoryCards.add(card11);

        memoryGame = new MemoryGame(numberOfCards);
        for (int i = 0; i < numberOfCards; i++) {
            memoryCards.get(i).set(memoryGame.getMemoryCardContent(i));
        }
        flipCounter = new ObservableField<>();
        flipCounter.set("Flips: "+memoryGame.getFlipCount());
    }
    public void onButtonClicked(int btn) {
        /**
        numberGuessingGame.check(button);
        numberGuessingGame.roll();
        numberRight.set(""+ numberGuessingGame.getRandomNumberRight());
        numberLeft.set(""+ numberGuessingGame.getRandomNumberLeft());
        score.set("Score: "+ numberGuessingGame.getScore());
         */
        if(!(memoryGame.getMemoryCard(btn).checkIfFrozen())) {
            memoryGame.increaseFlipCount();
            memoryGame.getMemoryCard(btn).flip();
            memoryCards.get(btn).set(memoryGame.getMemoryCardContent(btn));
            flipCounter.set("Flips: "+memoryGame.getFlipCount());

            int previousUnequalCardId = -1;
            try {
                previousUnequalCardId = memoryGame.checkIfPair(memoryGame.getMemoryCard(btn));
                System.out.println(previousUnequalCardId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (previousUnequalCardId != -1) {
                final Handler handler = new Handler(Looper.getMainLooper());
                int finalPreviousUnequalCardId = previousUnequalCardId;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        memoryCards.get(finalPreviousUnequalCardId).set("");
                        memoryCards.get(btn).set("");                    }
                }, 1000);

            }
        }
    }
}
