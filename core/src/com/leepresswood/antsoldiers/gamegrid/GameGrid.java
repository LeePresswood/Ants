//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.gamegrid.tiles.BlockGroundSolid;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.management.GameNumbers;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameGrid
{
	public GridBlock[][] blocks;
	private int index_counter;
	
	private ScreenGame screen_game;
	
	private int blocks_down;
	private int blocks_across;	
	
	public GameGrid(ScreenGame screen_game, int[][] grid)
	{
		this.screen_game = screen_game;
		blocks_down = grid.length;
		blocks_across = grid[0].length;
		index_counter = 0;
		
		//The passed in level grid has all the block types. Make the blocks using the collected data.
		blocks = new GridBlock[blocks_down][blocks_across];
		
		float current_x = 0f;
		float current_y = (blocks_down - 1) * GameNumbers.BLOCK_SIZE;		
		for(int j = 0; j < blocks_down; j++)
		{
			for(int i = 0; i < blocks_across; i++)
			{
				blocks[j][i] = getGridblockFromType(grid[j][i], index_counter++);
				blocks[j][i].setBounds(current_x, current_y, GameNumbers.BLOCK_SIZE, GameNumbers.BLOCK_SIZE);
				current_x += GameNumbers.BLOCK_SIZE;
			}	
			
			//After finishing the row, go down a row and restart.
			current_x = 0f;
			current_y -= GameNumbers.BLOCK_SIZE;
		}				
	}
	
	private GridBlock getGridblockFromType(int type, int counter)
	{
		switch(type)
		{
			case GameNumbers.BLOCK_GROUND_SOLID:				//Solid.
				return new BlockGroundSolid(counter, type, screen_game.assets.block_textures[type]);
			default:
				System.out.println("Error: Unrecognized block type at value " + counter + ".");
				return null;
		}
	}

	public void render(SpriteBatch batch)
	{
		for(int j = 0; j < blocks_down; j++)
			for(int i = 0; i < blocks_across; i++)
				blocks[j][i].draw(batch);
	}

	public void update(float delta)
	{//Update tiles here. Good for animated tiles.
		
	}

	public void updateAnt(Ant ant, float delta)
	{//Ant passed into this function. Find its block and call that block's nextPosition().
		//The floor of the X and Y values for the ants is the block coordinate the ant is on.
		int x = (int) Math.floor(ant.down.x);
		int y = (int) Math.floor(ant.down.y);
		
		//Move the ant based upon that block's rules.
		Vector2 next = blocks[y][x].nextPosition(ant, GameNumbers.ANT_SPEED * delta);
		ant.setPosition(next.x, next.y);
	}
}
