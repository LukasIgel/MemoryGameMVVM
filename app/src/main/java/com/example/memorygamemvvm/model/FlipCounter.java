package com.example.memorygamemvvm.model;

public class FlipCounter {
    private int count = 0;
    public String getCount() {
        return ""+count;
    }
    public void countUp() {
        count++;
    }
}
