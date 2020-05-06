package io.jmpalazzolo.sampl2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {

    int x;
    int y;
    int width;
    int height;

    Rectangle rectangle;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }

    public void handleInput() {
        x = Gdx.input.getX();
    }

    public void update() {
        handleInput();
        rectangle.setX(x);
        rectangle.setY(y);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
