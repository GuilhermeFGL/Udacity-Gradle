package com.example.android.jokes;

import java.util.Random;

public final class Jokes {

    private static final Random RANDON = new Random();
    private static final String[] sJokes = {
            "piada 1",
            "piada 2",
            "piada 3",
            "piada 4",
            "piada 5",
            "piada 6",
            "piada 7",
            "piada 8",
            "piada 9",
            "piada 10"
    };

    public static String getJoke() {
        return sJokes[RANDON.nextInt(sJokes.length)];
    }
}
