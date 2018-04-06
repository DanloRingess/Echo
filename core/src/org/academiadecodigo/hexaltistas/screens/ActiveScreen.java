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

    public ActiveScreen(Echo game) {
        super(game);
        this.appBackground = new Texture("map_background.png");
    }

    @Override
    public void show() {
        super.show();

        setupAppTables();

    }

    private void setupAppTables() {

        Label title = new Label("About this location", skin);
        TextButton test = new TextButton("test me up", skin);

        Table titleTable = new Table();
        titleTable.setFillParent(true);

        titleTable.top().left();

        titleTable.add(title).pad(101,30,0,0);
        titleTable.row();
        titleTable.add(test);


        stage.addActor(titleTable);
    }

    @Override
    protected void loadSpriteBatch() {
        batch.begin();
        batch.draw(phone, 0, 0);
        batch.draw(map, 333, 0);
        batch.draw(appBackground,26,100 );
        batch.end();
    }
}
