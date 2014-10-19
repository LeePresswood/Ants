package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameHolder extends Holder
{	
	private OrthographicCamera camera;
	private final int CAMERA_WIDTH = 800;
	private final int CAMERA_HEIGHT = 400;
	
	private GameGrid grid;
	
	public GameHolder(ScreenGame screenGame, int level)
	{		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);
		
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
		camera.update();
	}

	@Override
	public void render()
	{
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			
		batch.end();
	}
}
