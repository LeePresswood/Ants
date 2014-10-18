//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.management.LevelParser;

public class GameGrid
{
	private GridBlock[] blocks;
	
	public GameGrid(int level, Texture[] block_textures)
	{
		//The passed in level needs to be parsed
		int[][] grid_values = LevelParser.getGrid(level);
		
		
	}
	
	public GridBlock[] getBlocks()
	{
		return null;
		//return blocks;
	}
}
