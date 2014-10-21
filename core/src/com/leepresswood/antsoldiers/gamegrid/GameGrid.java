//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
		float current_y = 0f;		
		for(int j = 0; j < blocks_down; j++)
		{
			for(int i = 0; i < blocks_across; i++)
			{
				blocks[j][i] = getGridblockFromType(grid[j][i], index_counter++);
				blocks[j][i].setBounds(current_x, current_y, 1, 1);
				current_x += 1.1f;
			}	
			
			//After finishing the row, go down a row and restart.
			current_x = 0f;
			current_y += 1.1f;
		}				
	}
	
	private GridBlock getGridblockFromType(int type, int counter)
	{
		switch(type)
		{
			case GameNumbers.BLOCK_GROUND_SOLID:				//Solid.
				return new BlockGroundSolid(counter, type, screen_game.assets.block_textures[type]);
			default:
				System.out.println("Error: Unrecognized block type.");
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

	public void updateAnt(Ant a, float delta)
	{//Ant passed into this function. Find its block and call that block's nextPosition().
		
	}
}
