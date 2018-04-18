package com.example.android.jokes;

import java.util.Random;

public final class Jokes {

    private static final Random RANDON = new Random();
    private static final String[] sJokes = {
            "joke 1",
            "joke 2",
            "joke 3",
            "joke 4",
            "joke 5",
            "joke 6",
            "joke 7",
            "joke 8",
            "joke 9",
            "joke 10"
    };

    public static String getJoke() {
        return sJokes[RANDON.nextInt(sJokes.length)];
    }
}
