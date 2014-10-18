//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.leepresswood.antsoldiers.management.LevelParser;

public class GameGrid
{
	private Sprite[] blocks;
	
	public GameGrid(int level)
	{
		//The passed in level needs to be parsed
		int[][] grid_values = LevelParser.getGrid(level);
	}
	
	public Sprite[] getBlocks()
	{
		return blocks;
	}
}
