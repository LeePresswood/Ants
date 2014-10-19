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
	private GameGrid grid;
	
	private OrthographicCamera camera;
	
	public GameHolder(ScreenGame screenGame, int level)
	{		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);
		
		//Initialize the grid.
		grid = new GameGrid(origin_point, holder_size, level, block_textures);
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
			GridBlock[][] blocks = grid.getBlocks();
			for(int j = 0; j < blocks.length; j++)
				for(int i = 0; i < blocks[0].length; i++)
					drawSprite(blocks[j][i]);
		batch.end();
	}
}
