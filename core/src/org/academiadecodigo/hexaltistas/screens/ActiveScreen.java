package org.academiadecodigo.hexaltistas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import org.academiadecodigo.hexaltistas.Echo;


public class ActiveScreen extends AbstractScreen {

    private Texture appBackground;
    Label title = new Label("About this location", game.getAppSkin());
    TextButton test = new TextButton("test me up", game.getAppSkin());
    Label description = new Label("some bs \n about this location", game.getAppSkin());
    Table titleTable = new Table();

    public ActiveScreen(Echo game) {
        super(game);

        this.appBackground = new Texture("map_background.png");


    }

    @Override
    public void init() {
        super.init();

        titleTable.setFillParent(true);

        titleTable.top().left();

        titleTable.add(title).pad(101, 30, 0, 0);
        titleTable.row();
        titleTable.add(description).pad(0, 30, 0, 0);
        titleTable.row();
        titleTable.add(test).pad(10, 30, 0, 0);
    }

    @Override
    public void show() {

        super.show();
        setupAppTables();

    }

    private void setupAppTables() {

        test.setText("po caralho");
        description.setText("po caralho");




        stage.addActor(titleTable);
    }

    @Override
    protected void loadSpriteBatch() {
        batch.begin();
        batch.draw(phone, 0, 0);
        batch.draw(map, 333, 0);
        batch.draw(appBackground, 26, 100);
        batch.end();
    }


}
