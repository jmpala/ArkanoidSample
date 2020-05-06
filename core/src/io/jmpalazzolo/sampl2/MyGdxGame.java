package io.jmpalazzolo.sampl2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {

	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Block> blocks = new ArrayList<>();

	@Override
	public void create () {
		paddle = new Paddle(50, 15, 50, 5);
		ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 20, 5, 5, paddle);
		shape = new ShapeRenderer();

		int blockWidth = 80;
		int blockHeight = 40;
		for(int y = Gdx.graphics.getHeight() / 2; y + blockHeight < Gdx.graphics.getHeight(); y += blockHeight + 5) {
			for(int x = 5; x + blockWidth < Gdx.graphics.getWidth(); x += blockWidth + 5) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	public void update() {
		ball.update();
		paddle.update();

		for(int x=0; x<blocks.size(); x++) {
			if(blocks.get(x).checkBallColission(ball.circle)) {
				ball.switchYAxis();
				blocks.remove(x);
			}
		}
	}

	@Override
	public void render () {
		update();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		for (Block block: blocks) {
			block.draw(shape);
		}
		shape.end();
	}
}
