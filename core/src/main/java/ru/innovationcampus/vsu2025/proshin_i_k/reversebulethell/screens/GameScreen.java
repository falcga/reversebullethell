package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.screens;

import com.badlogic.gdx.Gdx;
<<<<<<< HEAD
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.*;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.components.*;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.managers.MemoryManager;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.BulletObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.GameObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.ShipObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.TrashObject;

import java.util.ArrayList;

public class GameScreen extends ScreenAdapter {

    Main main;
    GameSession gameSession;
    TrashObject trashObject;

    ArrayList<ShipObject> shipArray;
    ArrayList<BulletObject> bulletArray;
    ArrayList<BulletObject> enemyBulletArray;

    ContactManager contactManager;

    MovingBackgroundView backgroundView;
    ImageView topBlackoutView;
    LiveView liveView;
    TextView scoreTextView;
    ButtonView pauseButton;

    ImageView fullBlackoutView;
    TextView pauseTextView;
    ButtonView homeButton;
    ButtonView continueButton;

    TextView recordsTextView;
    RecordsListView recordsListView;
    ButtonView homeButton2;

    public GameScreen(Main main) {
        this.main = main;
        gameSession = new GameSession();

        contactManager = new ContactManager(main.world);

        shipArray = new ArrayList<>();
        bulletArray = new ArrayList<>();
        enemyBulletArray = new ArrayList<>();

        trashObject = new TrashObject(
                GameSettings.SCREEN_WIDTH / 2, 150,
                GameSettings.TRASH_WIDTH, GameSettings.TRASH_HEIGHT,
                GameResources.TRASH_IMG_PATH,
                main.world
        );

        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);
        topBlackoutView = new ImageView(0, 1180, GameResources.BLACKOUT_TOP_IMG_PATH);
        liveView = new LiveView(305, 1215);
        scoreTextView = new TextView(main.commonWhiteFont, 50, 1215);
        pauseButton = new ButtonView(
                605, 1200,
                46, 54,
                GameResources.PAUSE_IMG_PATH
        );

        fullBlackoutView = new ImageView(0, 0, GameResources.BLACKOUT_FULL_IMG_PATH);
        pauseTextView = new TextView(main.largeWhiteFont, 282, 842, "Pause");
        homeButton = new ButtonView(
                138, 695,
                200, 70,
                main.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH,
                "Home"
        );
        continueButton = new ButtonView(
                393, 695,
                200, 70,
                main.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH,
                "Continue"
        );

        recordsListView = new RecordsListView(main.commonWhiteFont, 690);
        recordsTextView = new TextView(main.largeWhiteFont, 206, 842, "Last records");
        homeButton2 = new ButtonView(
                280, 365,
                160, 70,
                main.commonBlackFont,
                GameResources.BUTTON_SHORT_BG_IMG_PATH,
                "Home"
        );

=======
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.ContactManager;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameResources;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSession;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.Main;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.BulletObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.ShipObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.TrashObject;

public class GameScreen implements Screen {
    GameSession gameSession;
    Main main;
    ShipObject shipObject;
    ArrayList<TrashObject> trashArray;
    ArrayList<BulletObject> bulletArray;
    ContactManager contactManager;

    public GameScreen(Main main) {
        this.main = main;
        gameSession = new GameSession();
        contactManager = new ContactManager(main.world);

        trashArray = new ArrayList<>();
        bulletArray = new ArrayList<>();
        shipObject = new ShipObject(
            GameSettings.SCREEN_WIDTH / 2, 150,
            GameSettings.SHIP_WIDTH, GameSettings.SHIP_HEIGHT,
            GameResources.SHIP_IMG_PATH,
            main.world
        );

        System.out.println("WHAT");
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
    }

    @Override
    public void show() {
<<<<<<< HEAD
        restartGame();
=======
        gameSession.startGame();
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
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
    }

    @Override
    public void render(float delta) {

<<<<<<< HEAD
        handleInput();

        if (gameSession.state == GameState.PLAYING) {
            if (gameSession.shouldSpawnShip()) {
                ShipObject shipObject = new ShipObject(
                        GameSettings.SHIP_WIDTH, GameSettings.SHIP_HEIGHT,
                        GameResources.SHIP_IMG_PATH,
                        main.world
                );
                shipArray.add(shipObject);
            }

            if (trashObject.needToShoot()) {
                BulletObject playerBullet = new BulletObject(
                        trashObject.getX(), trashObject.getY() + trashObject.height / 2,
                        GameSettings.BULLET_WIDTH, GameSettings.BULLET_HEIGHT,
                        GameResources.TRASH_IMG_PATH,
                        main.world,
                        false
                );
                bulletArray.add(playerBullet);
                if (main.audioManager.isSoundOn) main.audioManager.shootSound.play();
            }

            for (ShipObject ship : shipArray) {
                if (ship.needToShoot() && ship.isAlive()) {
                    BulletObject enemyBullet = new BulletObject(
                            ship.getX(), ship.getY() - ship.height / 2,
                            GameSettings.ENEMY_BULLET_WIDTH, GameSettings.ENEMY_BULLET_HEIGHT,
                            GameResources.BULLET_IMG_PATH,
                            main.world,
                            true
                    );
                    enemyBulletArray.add(enemyBullet);
                }
            }

            checkCollisionsByCoordinates();

            if (!trashObject.isAlive()) {
                gameSession.endGame();
                recordsListView.setRecords(MemoryManager.loadRecordsTable());
            }

            updateShips();
            updateBullets();
            updateEnemyBullets();
            backgroundView.move();
            gameSession.updateScore();
            scoreTextView.setText("Score: " + gameSession.getScore());
            liveView.setLeftLives(trashObject.getLiveLeft());

            main.stepWorld();
        }

        draw();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            main.touch = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            switch (gameSession.state) {
                case PLAYING:
                    if (pauseButton.isHit(main.touch.x, main.touch.y)) {
                        gameSession.pauseGame();
                    }
                    trashObject.move(main.touch);
                    break;

                case PAUSED:
                    if (continueButton.isHit(main.touch.x, main.touch.y)) {
                        gameSession.resumeGame();
                    }
                    if (homeButton.isHit(main.touch.x, main.touch.y)) {
                        main.setScreen(main.menuScreen);
                    }
                    break;

                case ENDED:

                    if (homeButton2.isHit(main.touch.x, main.touch.y)) {
                        main.setScreen(main.menuScreen);
                    }
                    break;
            }

=======
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

        if (shipObject.needToShoot()) {
            BulletObject laserBullet = new BulletObject(
                shipObject.getX(), shipObject.getY() + shipObject.height / 2,
                GameSettings.BULLET_WIDTH, GameSettings.BULLET_HEIGHT,
                GameResources.BULLET_IMG_PATH,
                main.world
            );
            bulletArray.add(laserBullet);
        }

        updateTrash();
        updateBullets();

        draw();
    }
    private void handleInput() {
        if (Gdx.input.isTouched()) {
            main.touch = main.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            shipObject.move(main.touch);
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
        }
    }

    private void draw() {

        main.camera.update();
        main.batch.setProjectionMatrix(main.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        main.batch.begin();
<<<<<<< HEAD
        backgroundView.draw(main.batch);
        for (ShipObject ship : shipArray) ship.draw(main.batch);
        trashObject.draw(main.batch);
        for (BulletObject bullet : bulletArray) bullet.draw(main.batch);
        for (BulletObject bullet : enemyBulletArray) bullet.draw(main.batch);
        topBlackoutView.draw(main.batch);
        scoreTextView.draw(main.batch);
        liveView.draw(main.batch);
        pauseButton.draw(main.batch);

        if (gameSession.state == GameState.PAUSED) {
            fullBlackoutView.draw(main.batch);
            pauseTextView.draw(main.batch);
            homeButton.draw(main.batch);
            continueButton.draw(main.batch);
        } else if (gameSession.state == GameState.ENDED) {
            fullBlackoutView.draw(main.batch);
            recordsTextView.draw(main.batch);
            recordsListView.draw(main.batch);
            homeButton2.draw(main.batch);
        }

        main.batch.end();

    }

    private void checkCollisionsByCoordinates() {
        for (int i = 0; i < bulletArray.size(); i++) {
            BulletObject playerBullet = bulletArray.get(i);
            if (playerBullet.hasToBeDestroyed()) continue;
            
            for (int j = 0; j < enemyBulletArray.size(); j++) {
                BulletObject enemyBullet = enemyBulletArray.get(j);
                if (enemyBullet.hasToBeDestroyed()) continue;
                
                if (isColliding(playerBullet, enemyBullet)) {
                    enemyBullet.hit();
                }
            }
        }
        
        for (int i = 0; i < bulletArray.size(); i++) {
            BulletObject playerBullet = bulletArray.get(i);
            if (playerBullet.hasToBeDestroyed()) continue;
            
            for (int j = 0; j < shipArray.size(); j++) {
                ShipObject ship = shipArray.get(j);
                if (!ship.isAlive()) continue;
                
                if (isColliding(playerBullet, ship)) {
                    playerBullet.hit();
                    playerBullet.markShipDestroyed();
                    ship.hit();
                    com.badlogic.gdx.math.Vector2 impulse = new com.badlogic.gdx.math.Vector2(0, GameSettings.BULLET_IMPULSE_FORCE);
                    ship.body.applyLinearImpulse(impulse, ship.body.getWorldCenter(), true);
                }
            }
        }
        
        for (int i = 0; i < enemyBulletArray.size(); i++) {
            BulletObject enemyBullet = enemyBulletArray.get(i);
            if (enemyBullet.hasToBeDestroyed()) continue;
            
            if (isColliding(enemyBullet, trashObject)) {
                enemyBullet.hit();
                trashObject.hit();
            }
        }
    }
    
    private boolean isColliding(GameObject obj1, GameObject obj2) {
        float obj1Left = obj1.getX() - obj1.width / 2f;
        float obj1Right = obj1.getX() + obj1.width / 2f;
        float obj1Bottom = obj1.getY() - obj1.height / 2f;
        float obj1Top = obj1.getY() + obj1.height / 2f;
        
        float obj2Left = obj2.getX() - obj2.width / 2f;
        float obj2Right = obj2.getX() + obj2.width / 2f;
        float obj2Bottom = obj2.getY() - obj2.height / 2f;
        float obj2Top = obj2.getY() + obj2.height / 2f;
        
        return obj1Left < obj2Right && obj1Right > obj2Left &&
               obj1Bottom < obj2Top && obj1Top > obj2Bottom;
    }

    private void updateShips() {
        for (int i = 0; i < shipArray.size(); i++) {
            ShipObject ship = shipArray.get(i);
            
            if (ship.isInFrame() && !ship.hasAppeared()) {
                ship.markAsAppeared();
            }

            boolean hasToBeDestroyed = false;
            
            if (ship.hasAppeared() && !ship.isInFrame()) {
                gameSession.destructionRegistration();
                if (main.audioManager.isSoundOn) main.audioManager.explosionSound.play(0.2f);
                hasToBeDestroyed = true;
            }
            
            if (!ship.isAlive()) {
                gameSession.destructionRegistration();
                if (main.audioManager.isSoundOn) main.audioManager.explosionSound.play(0.2f);
                hasToBeDestroyed = true;
            }

            if (hasToBeDestroyed) {
                main.world.destroyBody(ship.body);
                shipArray.remove(i--);
            }
        }
    }

    private void updateBullets() {
=======
        shipObject.draw(main.batch);
        for (TrashObject trash : trashArray) trash.draw(main.batch);
        for (BulletObject bullet : bulletArray) bullet.draw(main.batch);
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
    private void updateBullets() {
        System.out.println("size: " + bulletArray.size());
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
        for (int i = 0; i < bulletArray.size(); i++) {
            if (bulletArray.get(i).hasToBeDestroyed()) {
                main.world.destroyBody(bulletArray.get(i).body);
                bulletArray.remove(i--);
            }
        }
    }
<<<<<<< HEAD

    private void updateEnemyBullets() {
        for (int i = 0; i < enemyBulletArray.size(); i++) {
            if (enemyBulletArray.get(i).hasToBeDestroyed()) {
                main.world.destroyBody(enemyBulletArray.get(i).body);
                enemyBulletArray.remove(i--);
            }
        }
    }

    private void restartGame() {

        for (int i = 0; i < shipArray.size(); i++) {
            main.world.destroyBody(shipArray.get(i).body);
            shipArray.remove(i--);
        }

        for (int i = 0; i < bulletArray.size(); i++) {
            main.world.destroyBody(bulletArray.get(i).body);
            bulletArray.remove(i--);
        }

        for (int i = 0; i < enemyBulletArray.size(); i++) {
            main.world.destroyBody(enemyBulletArray.get(i).body);
            enemyBulletArray.remove(i--);
        }

        if (trashObject != null) {
            main.world.destroyBody(trashObject.body);
        }

        trashObject = new TrashObject(
                GameSettings.SCREEN_WIDTH / 2, 150,
                GameSettings.TRASH_WIDTH, GameSettings.TRASH_HEIGHT,
                GameResources.TRASH_IMG_PATH,
                main.world
        );

        shipArray.clear();
        bulletArray.clear();
        enemyBulletArray.clear();
        gameSession.startGame();
    }

=======
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
}
