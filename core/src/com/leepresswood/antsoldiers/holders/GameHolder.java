package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameHolder extends Holder
{	
	private OrthographicCamera camera;
	private final int CAMERA_WIDTH = 800;
	private int CAMERA_HEIGHT = 400;
	
	private Sprite ant;
	
	private GameGrid grid;
	
	public GameHolder(ScreenGame screen_game, int level)
	{		
		//Use the level parser to determine how many squares across and down our world has.
		
		
		
		//Create the camera using the found number of blocks above.
		camera = new OrthographicCamera();
		camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		ant = new Sprite(screen_game.assets.texture_ant);
		ant.setBounds(0, 300, 50, 50);
		
		//Initialize the grid.
		//grid = new GameGrid(origin_point, holder_size, level, block_textures);
	}

	@Override
	public void doTouch(float x, float y)
	{
		
	}

	@Override
	public void update(float delta)
	{
		ant.translateX(1f);
		//camera.position.set(ant.getX(), ant.getY(), 0);
		camera.update();
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
