package org.academiadecodigo.hexaltistas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hexaltistas.Echo;

public class InactiveScreen implements AppScreen {

    private Echo game;

    private SpriteBatch batch;
    private Skin skin;
    private TextureAtlas textureAtlas;
    private Viewport viewport;


    private Stage stage;

    public InactiveScreen(Echo game) {
        this.game = game;
    }

    @Override
    public void init() {
        this.batch = game.getBatch();
        this.skin = game.getAppSkin();
        this.textureAtlas = game.getTextureAtlas();
        this.viewport = game.getViewport();
        viewport.apply(true);

        stage = new Stage(viewport, batch);
    }

    @Override
    public void show() {
        /**
         Gdx.input.setInputProcessor(stage);

         TextButton brasilButton = new TextButton("Padaria Brasil", skin);
         TextButton angolaButton = new TextButton("Avenida de Angola", skin);
         TextButton goaButton = new TextButton("Restaurante Goa", skin);
         TextButton mocambiqueButton = new TextButton("Praça de Moçambique", skin);
         */
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
