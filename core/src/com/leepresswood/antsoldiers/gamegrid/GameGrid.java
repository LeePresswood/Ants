//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.management.LevelParser;

public class GameGrid
{
	private GridBlock[][] blocks;
	
	public GameGrid(Vector2 origin_point, Vector2 holder_size, int level, Texture[] block_textures)
	{
		//The passed in level needs to be parsed
		//int[][] grid_values = LevelParser.getGrid(level);
		int blocks_across = grid_values[0].length;
		int blocks_down = grid_values.length;
		
		//Determine the size and location of the field's blocks. Should be the holder size / number of blocks.
		float block_size = holder_size.x / (float) blocks_across;
		float current_x = origin_point.x;
		float current_y = origin_point.y;
System.out.println(origin_point.y);
		//Make the blocks using the collected data.
		blocks = new GridBlock[blocks_down][blocks_across];
		for(int j = 0; j < blocks_down; j++)
		{
			for(int i = 0; i < blocks_across; i++)
			{
				blocks[j][i] = new GridBlock(grid_values[j][i], block_textures[grid_values[j][i]]);
				blocks[j][i].setBounds(current_x, current_y, block_size, block_size);
				current_x += block_size;
			}	
			
			//After finishing the row, go down a row and restart.
			current_x = origin_point.x;
			current_y += block_size;
		}
				
	}
	
	public GridBlock[][] getBlocks()
	{
		//return null;
		return blocks;
	}
}
