package com.example.memorygamemvvm.model;

public class Emoji {
    private static final String[] EMOJIS = {
            "😎", "😂", "😊", "🤣", "❤", "👌",
            "😒", "👍", "🎉", "😆", "💣", "💍",
            "🌹", "🎂", "🎃", "🤢", "🎶", "👀",
            "✨", "🎁", "🤩", "🤡", "🤠", "👽",
            "💩", "🤓", "🦄", "🧠", "🎱", "👌",
            "🎈", "💰"
    };
    public static String getEmoji(int emojiID) {
        if (emojiID<EMOJIS.length) {
            return EMOJIS[emojiID];
        }
        else return "";
    }
}
