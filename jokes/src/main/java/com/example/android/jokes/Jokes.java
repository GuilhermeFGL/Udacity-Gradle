package com.example.android.jokes;

import java.util.Random;

public final class Jokes {

    private static Integer sLastPosition = -1;
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

    private Jokes() { }

    private static int getRandonNoRepeatPosition() {
        int randonPosition;
        do {
            randonPosition = new Random().nextInt(sJokes.length);
        } while (randonPosition != sLastPosition);
        sLastPosition = randonPosition;
        return randonPosition;
    }

    public static String getJoke() {
        return sJokes[getRandonNoRepeatPosition()];
    }
}
