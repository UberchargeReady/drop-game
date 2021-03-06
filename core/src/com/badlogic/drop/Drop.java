package com.badlogic.drop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class Drop extends Game {

	public SpriteBatch batch;
	public BitmapFont font;

	public void create() {
		batch = new SpriteBatch();
		//Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}

//public class Drop extends ApplicationAdapter {
//
//	private static final long DROP_INTERVAL_NANOSECS = 1000000000 / 2;
//
//	private OrthographicCamera camera;
//	private SpriteBatch batch;
//	private Vector3 touchPos;
//
//	private Texture dropImage;
//	private Texture bucketImage;
//	private Sound dropSound;
//	private Music rainMusic;
//
//	private Rectangle bucket;
//	private Array<Rectangle> raindrops;
//
//	private long lastDropTime;
//
//	@Override
//	public void create () {
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false, 800, 480);
//		batch = new SpriteBatch();
//		touchPos = new Vector3();
//
//		// load the images for the droplet and the bucket, 64x64 pixels each
//		dropImage = new Texture(Gdx.files.internal("droplet.png"));
//		bucketImage = new Texture(Gdx.files.internal("bucket.png"));
//
//		// load the drop sound effect and the rain background "music"
//		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
//		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
//
//		// start the playback of the background music immediately
//		rainMusic.setLooping(true);
//		rainMusic.play();
//
//		bucket = createBucketInstance();
//
//		raindrops = new Array<Rectangle>();
//		spawnRaindrop();
//	}
//
//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		batch.draw(bucketImage, bucket.x, bucket.y);
//		for(Rectangle raindrop: raindrops) {
//			batch.draw(dropImage, raindrop.x, raindrop.y);
//		}
//		batch.end();
//
//		if(Gdx.input.isTouched()) {
//			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touchPos);
//			bucket.x = touchPos.x - 64 / 2;
//		}
//
//		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
//
//		if(bucket.x < 0) bucket.x = 0;
//		if(bucket.x > 800 - 64) bucket.x = 800 - 64;
//
//		if(TimeUtils.nanoTime() - lastDropTime > DROP_INTERVAL_NANOSECS) spawnRaindrop();
//
//		Iterator<Rectangle> iter = raindrops.iterator();
//		while(iter.hasNext()) {
//			Rectangle raindrop = iter.next();
//			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//			if(raindrop.y + 64 < 0) iter.remove();
//			else if(raindrop.overlaps(bucket)) {
//				dropSound.play();
//				iter.remove();
//			}
//		}
//	}
//
//	private void spawnRaindrop() {
//		Rectangle raindrop = new Rectangle();
//		raindrop.x = MathUtils.random(0, 800-64);
//		raindrop.y = 480;
//		raindrop.width = 64;
//		raindrop.height = 64;
//		raindrops.add(raindrop);
//		lastDropTime = TimeUtils.nanoTime();
//	}
//
//	private Rectangle createBucketInstance() {
//		Rectangle bucket = new Rectangle();
//		bucket.x = 800 / 2 - 64 / 2;
//		bucket.y = 20;
//		bucket.width = 64;
//		bucket.height = 64;
//		return bucket;
//	}
//
//	@Override
//	public void dispose() {
//		dropImage.dispose();
//		bucketImage.dispose();
//		dropSound.dispose();
//		rainMusic.dispose();
//		batch.dispose();
//	}
//}
