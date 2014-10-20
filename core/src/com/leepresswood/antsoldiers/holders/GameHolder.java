package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;
import com.leepresswood.antsoldiers.management.LevelParser;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameHolder extends Holder
{	
	private OrthographicCamera camera;
	private final int WORLD_VIEW = 7;
	private int WORLD_TOTAL_HORIZONTAL;
	private int WORLD_TOTAL_VERTICAL;
	
	//Scrolling and touching.
	private boolean touched;
	private Vector2 dragOld;
	private Vector2 dragNew;
	
	private Sprite ant;
	
	private GameGrid grid;
	
	public GameHolder(ScreenGame screen_game, int level)
	{		
		//Use the level parser to determine how many total squares across and down our world has.
		LevelParser lp = new LevelParser(level);
		WORLD_TOTAL_HORIZONTAL = lp.width;
		WORLD_TOTAL_VERTICAL = lp.height;
		
		//Create the camera using the found number of blocks above.
		camera = new OrthographicCamera(WORLD_VIEW, WORLD_VIEW * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();
		
		ant = new Sprite(screen_game.assets.texture_ant);
		ant.setBounds(0, 0, 0.2f, 0.2f);
		
		//Initialize the grid.
		//grid = new GameGrid(origin_point, holder_size, level, block_textures);
	}

	public void scroll(float delta_x, float delta_y)
	{//Do the scrolling.
		camera.translate(delta_x, delta_y);
		camera.update();
	}
	
	public void scroll_stop()
	{//Check camera boundaries and move if necessary.
		float left = camera.viewportWidth / 2f + 1f;
		float right = -camera.viewportWidth / 2f - 1f;
		float top = left;
		float down = right;
		
		//X
		if(camera.position.x > left)
			camera.position.set(left, camera.position.y, camera.position.z);
		else if(camera.position.x < right)
			camera.position.set(right, camera.position.y, camera.position.z);
		
		//Y
		if(camera.position.y > top)
			camera.position.set(camera.position.x, top, camera.position.z);
		else if(camera.position.y < down)
			camera.position.set(camera.position.x, down, camera.position.z);
		
		camera.update();
	}

	@Override
	public void update(float delta)
	{
		//ant.translateX(0.1f);		
		
		//camera.position.set(ant.getX(), ant.getY(), 0);
	}

	@Override
	public void render()
	{
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			ant.draw(batch);
		batch.end();
	}
}
