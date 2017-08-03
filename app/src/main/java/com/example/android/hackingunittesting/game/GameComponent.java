package com.example.android.hackingunittesting.game;

import dagger.Component;

@Component(modules = GameModule.class) public interface GameComponent {
    void inject(GameSession obj);
}
