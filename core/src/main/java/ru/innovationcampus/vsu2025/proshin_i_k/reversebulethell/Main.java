package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.screens.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);

        GameScreen gameScreen = new GameScreen(this);
        setScreen(gameScreen);

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
