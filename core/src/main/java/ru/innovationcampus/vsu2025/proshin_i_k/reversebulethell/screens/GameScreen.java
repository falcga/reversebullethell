package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.screens;

import com.badlogic.gdx.Screen;

import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.Main;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.ShipObject;

public class GameScreen implements Screen {
    Main main;
    ShipObject shipObject;
    public GameScreen(Main main) {
        this.main = main;
        shipObject = new ShipObject(
            GameSettings.SCREEN_WIDTH / 2, 150,
            GameSettings.SHIP_WIDTH, GameSettings.SHIP_HEIGHT,
            GameResources.SHIP_IMG_PATH,
            main.world
        );
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
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
