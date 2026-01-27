package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings;

public class BulletObject extends GameObject {

    public boolean wasHit;
    private boolean isEnemyBullet;
    private boolean destroyedShip;

    public BulletObject(int x, int y, int width, int height, String texturePath, World world, boolean isEnemyBullet) {
        super(texturePath, x, y, width, height, isEnemyBullet ? GameSettings.ENEMY_BULLET_BIT : GameSettings.BULLET_BIT, world);
        this.isEnemyBullet = isEnemyBullet;
        body.setLinearVelocity(new Vector2(0, isEnemyBullet ? GameSettings.ENEMY_BULLET_VELOCITY : GameSettings.BULLET_VELOCITY));
        body.setBullet(true);
        wasHit = false;
        destroyedShip = false;
    }

    public boolean hasToBeDestroyed() {
        if (isEnemyBullet) {
            return wasHit || (getY() + height / 2 < 0);
        } else {
            return destroyedShip || (getY() - height / 2 > GameSettings.SCREEN_HEIGHT);
        }
    }

    @Override
    public void draw(com.badlogic.gdx.graphics.g2d.SpriteBatch batch) {
        if (isEnemyBullet) {
            float x = getX() - (width / 2f);
            float y = getY() - (height / 2f);
            float originX = width / 2f;
            float originY = height / 2f;
            batch.draw(texture, x, y, originX, originY, width, height, 1f, 1f, 180f, 0, 0, texture.getWidth(), texture.getHeight(), false, false);
        } else {
            super.draw(batch);
        }
    }

    @Override
    public void hit() {
        wasHit = true;
    }

    public void markShipDestroyed() {
        destroyedShip = true;
    }

    public boolean isEnemyBullet() {
        return isEnemyBullet;
    }
}
