package com.example.android.hackingunittesting.game;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pranit on 3/8/17.
 */
public class GameSessionTest {
    @Test
    public void testGameSession() {
        GameSession session = new GameSession();
        DaggerGameComponent.create().inject(session);
        assertEquals("Hello Dagger", session.data.hello);
    }
}