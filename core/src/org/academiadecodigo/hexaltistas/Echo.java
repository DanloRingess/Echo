package org.academiadecodigo.hexaltistas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.hexaltistas.screens.ActiveScreen;
import org.academiadecodigo.hexaltistas.screens.AppScreen;
import org.academiadecodigo.hexaltistas.screens.InactiveScreen;
import org.academiadecodigo.hexaltistas.screens.ScreenType;

import java.util.HashMap;
import java.util.Map;

public class Echo extends Game {

	private Map<ScreenType, AppScreen> screenMap;

	private SpriteBatch batch;
	private Skin appSkin;
	private TextureAtlas textureAtlas;
 	private Camera camera;
	private Viewport viewport;

	private Texture phone;
 	private Texture map;

	@Override
	public void create () {

		screenMap = new HashMap();

		appSkin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));
		textureAtlas = new TextureAtlas("skin/flat-earth-ui.atlas");
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

		phone = new Texture("phone.jpeg");
		map = new Texture("map.jpg");

		loadSpriteBatch();

		AppScreen inactiveScreen = new InactiveScreen(this);
		AppScreen activeScreen = new ActiveScreen(this);

		inactiveScreen.init();
		activeScreen.init();

		screenMap.put(ScreenType.INACTIVE_SCREEN, inactiveScreen);
		screenMap.put(ScreenType.ACTIVE_SCREEN, activeScreen);

		super.setScreen(inactiveScreen);
	}

	@Override
	public void render () {
	    super.render();
	    loadSpriteBatch();
		//super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		appSkin.dispose();
		textureAtlas.dispose();

		for (AppScreen screen : screenMap.values()) {
			screen.dispose();
		}
	}

	public void setScreen(ScreenType screen) {
		super.setScreen(screenMap.get(screen));
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

	private void loadSpriteBatch() {
		batch.begin();
		batch.draw(phone, 0, 0);
		batch.draw(map, 333, 0);
		batch.end();
	}
}
