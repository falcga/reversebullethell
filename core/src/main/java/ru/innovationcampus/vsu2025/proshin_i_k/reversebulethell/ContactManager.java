package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell;


<<<<<<< HEAD
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.BulletObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.GameObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.ShipObject;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.TrashObject;
=======
import com.badlogic.gdx.physics.box2d.*;
import ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects.GameObject;
>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e

public class ContactManager {

    World world;

    public ContactManager(World world) {
        this.world = world;

        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

                Fixture fixA = contact.getFixtureA();
                Fixture fixB = contact.getFixtureB();

                int cDef = fixA.getFilterData().categoryBits;
                int cDef2 = fixB.getFilterData().categoryBits;

<<<<<<< HEAD
                Object userDataA = fixA.getUserData();
                Object userDataB = fixB.getUserData();

                if (userDataA == null || userDataB == null) return;
                if (!(userDataA instanceof GameObject) || !(userDataB instanceof GameObject)) return;

                GameObject objA = (GameObject) userDataA;
                GameObject objB = (GameObject) userDataB;
                
                if ((cDef == GameSettings.BULLET_BIT && cDef2 == GameSettings.SHIP_BIT)
                    || (cDef2 == GameSettings.BULLET_BIT && cDef == GameSettings.SHIP_BIT)) {
                    BulletObject bullet = null;
                    ShipObject ship = null;
                    
                    if (objA instanceof BulletObject && !((BulletObject) objA).isEnemyBullet()) {
                        bullet = (BulletObject) objA;
                    } else if (objB instanceof BulletObject && !((BulletObject) objB).isEnemyBullet()) {
                        bullet = (BulletObject) objB;
                    }
                    
                    if (objA instanceof ShipObject) {
                        ship = (ShipObject) objA;
                    } else if (objB instanceof ShipObject) {
                        ship = (ShipObject) objB;
                    }
                    
                    if (bullet != null) {
                        bullet.hit();
                        bullet.markShipDestroyed();
                    }
                    if (ship != null) {
                        ship.hit();
                        Vector2 impulse = new Vector2(0, GameSettings.BULLET_IMPULSE_FORCE);
                        ship.body.applyLinearImpulse(impulse, ship.body.getWorldCenter(), true);
                    }
                }

                if ((cDef == GameSettings.SHIP_BIT && cDef2 == GameSettings.TRASH_BIT)
                    || (cDef2 == GameSettings.SHIP_BIT && cDef == GameSettings.TRASH_BIT)) {
                    if (objA instanceof TrashObject) {
                        objA.hit();
                    }
                    if (objB instanceof TrashObject) {
                        objB.hit();
                    }
=======
                if (cDef == GameSettings.TRASH_BIT && cDef2 == GameSettings.BULLET_BIT
                    || cDef2 == GameSettings.TRASH_BIT && cDef == GameSettings.BULLET_BIT
                    || cDef == GameSettings.TRASH_BIT && cDef2 == GameSettings.SHIP_BIT
                    || cDef2 == GameSettings.TRASH_BIT && cDef == GameSettings.SHIP_BIT) {

                    ((GameObject) fixA.getUserData()).hit();
                    ((GameObject) fixB.getUserData()).hit();

>>>>>>> f85ea08e922905eb3281ceb08540506d20a8979e
                }
            }

            @Override
            public void endContact(Contact contact) {
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }
        });

    }

}
