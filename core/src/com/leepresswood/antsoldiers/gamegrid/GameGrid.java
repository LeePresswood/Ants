//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.management.LevelParser;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameGrid
{
	public GridBlock[][] blocks;
	
	public GameGrid(ScreenGame screen_game, int[][] grid)
	{
		//The passed in level grid has all the block types. Make the blocks using the collected data.
		int blocks_down = grid.length;
		int blocks_across = grid[0].length;
		int index_counter = 0;
		float current_x = 0f;
		float current_y = 0f;
		
		blocks = new GridBlock[blocks_down][blocks_across];
		for(int j = 0; j < blocks_down; j++)
		{
			for(int i = 0; i < blocks_across; i++)
			{
				blocks[j][i] = new GridBlock(index_counter++, grid[j][i], screen_game.assets.block_textures[grid[j][i]]);
				blocks[j][i].setBounds(current_x, current_y, 1, 1);
				current_x += 1f;
			}	
			
			//After finishing the row, go down a row and restart.
			current_x = 0f;
			current_y += 1f;
		}
				
	}
	
	
}
