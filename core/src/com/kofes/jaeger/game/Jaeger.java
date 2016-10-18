package com.kofes.jaeger.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import com.kofes.jaeger.actors.Surface;
import com.kofes.jaeger.actors.npcs.Tree;


public class Jaeger extends Game {
	private OrthographicCamera camera;

	public static float WIDTH;
	public static float HEIGHT;

	//BUTTON!
	private Sprite pauseButtonSprite;
	private Texture pauseButtonTexture;


	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;//Отрисовка shape'ов
	private Surface surface;
	private Tree[] tree; //Всего 3 дерева по центру
//    private LinkedList<Bug> bugs;// Жуки распространяются по степени плотности и времени

	@Override
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH / 2, HEIGHT / 2);

		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		tree = new Tree[3];
		tree[0] = new Tree(new Vector2(0.30f, 0.26f));
		tree[1] = new Tree(new Vector2(0.50f, 0.22f));
		tree[2] = new Tree(new Vector2(0.70f, 0.26f));

		surface = Surface.getInstance();
		//BUTTON!
		pauseButtonTexture = new Texture(Gdx.files.internal("pausebutton.png"));
		pauseButtonSprite = new Sprite(pauseButtonTexture);
		pauseButtonSprite.setPosition(0.00f * WIDTH, (1.00f - 0.05f*WIDTH/HEIGHT) * HEIGHT);
		pauseButtonSprite.setSize(0.05f*WIDTH, 0.05f * WIDTH);
	}

	@Override
	public void render () {
		camera.update();

		//Background - Sky!
		Gdx.gl.glClearColor(191/256f, 255/256f, 255/256f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_ARRAY_BUFFER_BINDING);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		//SURFACE!
		surface.draw(shapeRenderer);

		//TREES!
		for (int i = 0; i < 3; ++i)
			tree[i].draw(shapeRenderer);

		shapeRenderer.end();

		batch.begin();

		//PAUSE BUTTON!
		pauseButtonSprite.draw(batch);

		batch.end();

		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}

}
