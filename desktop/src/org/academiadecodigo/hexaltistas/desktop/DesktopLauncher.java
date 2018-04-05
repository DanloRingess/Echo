package org.academiadecodigo.hexaltistas.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.hexaltistas.Echo;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

    config.title = "Echo";
        config.useGL30 = false;
        config.width = 1000;
        config.height = 700;
        config.resizable = false;

        new LwjglApplication(new Echo(), config);
    }
}
