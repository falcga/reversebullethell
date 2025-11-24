package ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.objects;

import static ru.innovationcampus.vsu2025.proshin_i_k.reversebulethell.GameSettings.SCALE;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class GameObject {
    public final int height;
    public final int width;

    public Body body;
    Texture texture;
    GameObject(String texturePath, int x, int y, int width, int height, World world) {
        this.width = width;
        this.height = height;

        Texture texture = new Texture(texturePath);
        Body body = createBody(x, y, world);
    }
    private Body createBody(float x, float y, World world) {
        BodyDef def = new BodyDef(); // def - defenition (определение) это объект, который содержит все данные, необходимые для посторения тела

        def.type = BodyDef.BodyType.DynamicBody; // тип тела, который имеет массу и может быть подвинут под действием сил
        def.fixedRotation = true; // запрещаем телу вращаться вокруг своей оси
        Body body = world.createBody(def); // создаём в мире world объект по описанному нами определению

        CircleShape circleShape = new CircleShape(); // задаём коллайдер в форме круга
        int width = 0;
        int height = 0;
        circleShape.setRadius(Math.max(width, height) * SCALE / 2f); // определяем радиус круга коллайдера

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape; // устанавливаем коллайдер
        fixtureDef.density = 0.1f; // устанавливаем плотность тела
        fixtureDef.friction = 1f; // устанвливаем коэффициент трения

        body.createFixture(fixtureDef); // создаём fixture по описанному нами определению
        circleShape.dispose(); // так как коллайдер уже скопирован в fixutre, то circleShape может быть отчищена, чтобы не забивать оперативную память.

        body.setTransform(x * SCALE, y * SCALE, 0); // устанавливаем позицию тела по координатным осям и угол поворота
        return body;
    }
    public int getX() {
        return (int) (body.getPosition().x / SCALE);
    }

    public int getY() {
        return (int) (body.getPosition().y / SCALE);
    }

    public void setX(int x) {
        body.setTransform(x * SCALE, body.getPosition().y, 0);
    }

    public void setY(int y) {
        body.setTransform(body.getPosition().x, y * SCALE, 0);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, getX() - (width / 2f), getY() - (height / 2f), width, height);
    }
}
