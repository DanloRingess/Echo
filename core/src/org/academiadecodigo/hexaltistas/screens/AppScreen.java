package org.academiadecodigo.hexaltistas.screens;

import com.badlogic.gdx.Screen;

public interface AppScreen extends Screen {

    void init();

    @Override
    void show();

    @Override
    void render(float delta);

    @Override
    void resize(int width, int height);

    @Override
    void pause();

    @Override
    void resume();

    @Override
    void hide();

    @Override
    void dispose();
}
