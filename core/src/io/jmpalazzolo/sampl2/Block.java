package io.jmpalazzolo.sampl2;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


public class Block {

    int x, y, width, height;
    Rectangle rectangle;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x, y, width, height);
    }

    public boolean checkBallColission(Circle circle) {
        return Intersector.overlaps(circle, rectangle);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
