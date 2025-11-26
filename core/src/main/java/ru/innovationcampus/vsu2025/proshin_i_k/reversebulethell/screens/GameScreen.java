package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameResources;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSession;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.Main;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.ShipObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.TrashObject;

public class GameScreen implements Screen {
    Main main;
    ShipObject shipObject;
    ArrayList<TrashObject> trashArray;
    private GameSession gameSession;

    public GameScreen(Main main) {
        this.main = main;
        trashArray = new ArrayList<>();
        shipObject = new ShipObject(
            GameSettings.SCREEN_WIDTH / 2, 150,
            GameSettings.SHIP_WIDTH, GameSettings.SHIP_HEIGHT,
            GameResources.SHIP_IMG_PATH,
            main.world
        );
        System.out.println("WHAT");
    }

    @Override
    public void show() {
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

    @Override
    public void render(float delta) {

        main.stepWorld();
        handleInput();

        if (gameSession.shouldSpawnTrash()) {
            TrashObject trashObject = new TrashObject(
                GameSettings.TRASH_WIDTH, GameSettings.TRASH_HEIGHT,
                GameResources.TRASH_IMG_PATH,
                main.world
            );
            trashArray.add(trashObject);
        }

        updateTrash();

        draw();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            main.touch = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            shipObject.move(main.touch);
        }
    }

    private void draw() {

        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        main.batch.begin();
        shipObject.draw(main.batch);
        for (TrashObject trash : trashArray) trash.draw(main.batch);
        main.batch.end();
    }
    private void updateTrash() {
        for (int i = 0; i < trashArray.size(); i++) {
            if (!trashArray.get(i).isInFrame()) {
                main.world.destroyBody(trashArray.get(i).body);
                trashArray.remove(i--);
            }
        }
    }
}
