package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.gamegrid.GameGrid;
import com.leepresswood.antsoldiers.management.GameNumbers;
import com.leepresswood.antsoldiers.management.LevelParser;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameHolder extends Holder
{	
	public OrthographicCamera camera;
	public final int WORLD_VIEW = 10;
	public int WORLD_TOTAL_HORIZONTAL;
	public int WORLD_TOTAL_VERTICAL;
		
	public Ant[] ant;	
	public GameGrid grid;
	
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
		
		//Visible objects will be the ants and the grid (with its items).
		ant = new Ant[GameNumbers.ANTS_NUMBER_SPAWNED];
		for(int i = 0; i < GameNumbers.ANTS_NUMBER_SPAWNED; i++)
			ant[i] = new Ant(i, screen_game.assets.texture_ant, new Vector2(0, 0));
		grid = new GameGrid(screen_game, lp.grid);
	}

	public void scroll(float delta_x, float delta_y)
	{//Do the scrolling.
		camera.translate(delta_x, delta_y);
		camera.update();
	}
	
	public void scroll_stop()
	{//Check camera boundaries and move if necessary.
		float left = WORLD_TOTAL_HORIZONTAL;
		float right = 0;
		float top = WORLD_TOTAL_VERTICAL;
		float down = 0;
		
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
		grid.update(delta);
		
		//Every ant needs to be updated for its position.
		for(Ant a : ant)
		{
			grid.updateAnt(a, delta);
			a.update(delta);
		}
	}

	@Override
	public void render()
	{		
		batch.setProjectionMatrix(camera.combined);		
		batch.begin();
			grid.render(batch);			
			for(Ant a : ant)
				a.draw(batch);			
		batch.end();
	}
}
