package io.jmpalazzolo.sampl2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class Ball {
    int x;
    int y;
    int radius;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;
    Circle circle;
    Paddle paddle;

    public Ball(int x, int y, int radius, int xSpeed, int ySpeed, Paddle paddle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        circle = new Circle(x, y, radius);
        this.paddle = paddle;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        circle.setPosition(x, y);

        if(x < radius || x > (Gdx.graphics.getWidth() - radius)) {
            xSpeed = -xSpeed;
        }

        if(Intersector.overlaps(circle, paddle.rectangle) || y > (Gdx.graphics.getHeight() - radius)) {
            ySpeed = -ySpeed;
        }
    }

    public void switchYAxis() {
        ySpeed = -ySpeed;
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radius);
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)) {
            color = Color.GREEN;
        } else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        return Math.random()>.5;
    }
}
