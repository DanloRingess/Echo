package org.academiadecodigo.hexaltistas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hexaltistas.model.PlaceType;
import org.academiadecodigo.hexaltistas.screens.*;

import java.util.HashMap;
import java.util.Map;

public class Echo extends Game {

    private Map<ScreenType, AppScreen> screenMap;

    private SpriteBatch batch;
    private Skin appSkin;
    private TextureAtlas textureAtlas;
    private Camera camera;
    private Viewport viewport;

    private PlaceType placeType;

    private Music music;


    @Override
    public void create() {

        screenMap = new HashMap();

        appSkin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));
        textureAtlas = new TextureAtlas("skin/flat-earth-ui.atlas");
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

        AppScreen inactiveScreen = new InactiveScreen(this);
        AppScreen activeScreen = new ActiveScreen(this);

        inactiveScreen.init();
        activeScreen.init();

        screenMap.put(ScreenType.INACTIVE_SCREEN, inactiveScreen);
        screenMap.put(ScreenType.ACTIVE_SCREEN, activeScreen);

        super.setScreen(inactiveScreen);
        music = Gdx.audio.newMusic(Gdx.files.internal("davinci.ogg"));
        music.setLooping(true);
        music.play();

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        appSkin.dispose();
        textureAtlas.dispose();

        for (AppScreen screen : screenMap.values()) {
            screen.dispose();
        }
    }

    public void setScreen(ScreenType screen) {
        super.setScreen(screenMap.get(screen));

        music.stop();

        switch (placeType) {


            case ANGOLA:
                music = Gdx.audio.newMusic(Gdx.files.internal("angola.ogg"));
                music.setLooping(true);
                music.play();
                break;
            case GOA:
                music = Gdx.audio.newMusic(Gdx.files.internal("goa.ogg"));
                music.setLooping(true);
                music.play();
                break;

            case BRASIL:
                music = Gdx.audio.newMusic(Gdx.files.internal("brasil.ogg"));
                music.setLooping(true);
                music.play();
                break;

            case MOCAMBIQUE:
                music = Gdx.audio.newMusic(Gdx.files.internal("mocambique.ogg"));
                music.setLooping(true);
                music.play();
                break;

                default:
                    music = Gdx.audio.newMusic(Gdx.files.internal("davinci.ogg"));
                    music.setLooping(true);
                    music.play();
        }
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Skin getAppSkin() {
        return appSkin;
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setplaceId(PlaceType placeType) {

        this.placeType = placeType;
    }

    public void setMusic(ScreenType type) {

    }

}
