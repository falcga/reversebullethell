package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.TimeUtils;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;

import java.util.Random;

public class ShipObject extends GameObject {

    private static final int paddingHorizontal = 30;
    long lastShotTime;
    private int livesLeft;
    private boolean hasAppeared;

    public ShipObject(int width, int height, String texturePath, World world) {
        super(
                texturePath,
                width / 2 + paddingHorizontal + (new Random()).nextInt((GameSettings.SCREEN_WIDTH - 2 * paddingHorizontal - width)),
                GameSettings.SCREEN_HEIGHT + height / 2,
                width, height,
                GameSettings.SHIP_BIT,
                world
        );

        body.setLinearVelocity(new Vector2(0, -GameSettings.SHIP_VELOCITY));
        livesLeft = 1;
        hasAppeared = false;
    }

    public boolean isAlive() {
        return livesLeft > 0;
    }

    public boolean isInFrame() {
        return getY() + height / 2 > 0;
    }

    public void markAsAppeared() {
        hasAppeared = true;
    }

    public boolean hasAppeared() {
        return hasAppeared;
    }

    @Override
    public void draw(SpriteBatch batch) {
        float x = getX() - (width / 2f);
        float y = getY() - (height / 2f);
        float originX = width / 2f;
        float originY = height / 2f;
        batch.draw(texture, x, y, originX, originY, width, height, 1f, 1f, 180f, 0, 0, texture.getWidth(), texture.getHeight(), false, false);
    }

    public boolean needToShoot() {
        if (TimeUtils.millis() - lastShotTime >= GameSettings.ENEMY_SHOOTING_COOL_DOWN) {
            lastShotTime = TimeUtils.millis();
            return true;
        }
        return false;
    }

    @Override
    public void hit() {
        livesLeft -= 1;
    }
}
