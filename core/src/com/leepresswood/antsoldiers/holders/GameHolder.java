package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
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
		
		ant = new Sprite(screen_game.assets.texture_ant);
		ant.setBounds(0, 0, 0.2f, 0.2f);
		
		//Initialize the grid.
		//grid = new GameGrid(origin_point, holder_size, level, block_textures);
	}

	public void scroll()
	{
		
	}

	@Override
	public void update(float delta)
	{
		//ant.translateX(0.1f);
		//Do the scrolling.
		if (Gdx.input.justTouched())
		{
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			dragOld = dragNew;
		}
		if (Gdx.input.isTouched())
		{
			dragNew = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (!dragNew.equals(dragOld))
			{
				camera.translate((dragOld.x - dragNew.x) * 0.0095f, 0); //Translate by subtracting the vectors
				camera.update();
				dragOld = dragNew; //Drag old becomes drag new.
			}
		}
		
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
