package com.example.memorygamemvvm.model;

public class MemoryCard {
    private String content = "default";
    private boolean isFlippedUp = false;
    private boolean isFrozen = false;

    public String getCurrentContent() {
        if(isFlippedUp) {
            return content;
        }
        else {
            return "";
        }
    }
    public void flip() {
        if(isFlippedUp) {
            isFlippedUp = false;
        }
        else {
            isFlippedUp = true;
        }
    }
    public void setContent(String newContent){
        this.content = newContent;
    }

    public String getContent() {
        return content;
    }

    public void freeze() {
        isFrozen = true;
    }
    public boolean checkIfFrozen() {
        return isFrozen;
    }
}
