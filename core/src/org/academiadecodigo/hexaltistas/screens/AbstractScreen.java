package org.academiadecodigo.hexaltistas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hexaltistas.Echo;
import org.academiadecodigo.hexaltistas.model.PlaceType;

public abstract class AbstractScreen implements AppScreen {

    private Echo game;

    private SpriteBatch batch;
    private Skin skin;
    private TextureAtlas textureAtlas;
    private Viewport viewport;

    private Texture phone;
    private Texture map;

    private Stage stage;

    public AbstractScreen(Echo game) {
        this.game = game;
    }

    @Override
    public void init() {
        this.batch = game.getBatch();
        this.skin = game.getAppSkin();
        this.textureAtlas = game.getTextureAtlas();
        this.viewport = game.getViewport();
        viewport.apply(true);


        phone = new Texture("phone.jpeg");
        map = new Texture("map.jpg");

        stage = new Stage(viewport, batch);
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);

        setupTables();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        loadSpriteBatch();

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

    private void loadSpriteBatch() {
        batch.begin();
        batch.draw(phone, 0, 0);
        batch.draw(map, 333, 0);
        batch.end();
    }

    private void setupTables() {

        TextButton leavePlaceButton = new TextButton("Leave Place", skin);
        TextButton exitAppButton = new TextButton("Exit App Demo", skin);

        leavePlaceButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("changed to inactive screen");
                game.setScreen(ScreenType.INACTIVE_SCREEN);
            }
        });

        exitAppButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("exiting app");
                Gdx.app.exit();
            }
        });

        TextButton brasilButton = new TextButton("Padaria Brasil", skin);
        TextButton angolaButton = new TextButton("Avenida de Angola", skin);
        TextButton goaButton = new TextButton("Restaurante Goa", skin);
        TextButton mocambiqueButton = new TextButton("Praca de Mocambique", skin);

        addClickListener(brasilButton, PlaceType.BRASIL);
        addClickListener(angolaButton, PlaceType.ANGOLA);
        addClickListener(goaButton, PlaceType.GOA);
        addClickListener(mocambiqueButton, PlaceType.MOCAMBIQUE);

        Table rightSideTable = new Table(skin);
        Table leftSideTable = new Table(skin);

        rightSideTable.setFillParent(true);
        leftSideTable.setFillParent(true);

        rightSideTable.right();
        rightSideTable.bottom();
        leftSideTable.center();
        leftSideTable.bottom();

        rightSideTable.add(brasilButton);
        rightSideTable.row().pad(150);
        rightSideTable.add(goaButton);
        rightSideTable.row().pad(50);
        rightSideTable.add(leavePlaceButton);

        rightSideTable.toFront();

        leftSideTable.add(angolaButton);
        leftSideTable.row().pad(100);
        leftSideTable.add(mocambiqueButton);
        leftSideTable.row().pad(50);
        leftSideTable.add(exitAppButton);

        leftSideTable.toFront();

        stage.addActor(rightSideTable);
        stage.addActor(leftSideTable);
    }

    private void addClickListener(TextButton textButton, final PlaceType placeType) {

        textButton.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("changed to active screen");
                game.setplaceId(placeType);
                game.setScreen(ScreenType.ACTIVE_SCREEN);
            }
        });
    }

}
