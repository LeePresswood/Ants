//This class holds all the tiles in the level. It also handles clicks on the game side of the screen.
package com.leepresswood.antsoldiers.gamegrid;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.gamegrid.tiles.BlockAir;
import com.leepresswood.antsoldiers.gamegrid.tiles.BlockDiagonal;
import com.leepresswood.antsoldiers.gamegrid.tiles.BlockGroundSolid;
import com.leepresswood.antsoldiers.gamegrid.tiles.GridBlock;
import com.leepresswood.antsoldiers.management.GameNumbers;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GameGrid
{
	private ScreenGame screen_game;
	
	private int index_counter;
	private GridBlock[][] blocks;
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
				blocks[j][i].setBounds(current_x, current_y, GameNumbers.BLOCK_SIZE, GameNumbers.BLOCK_SIZE);
				current_x += GameNumbers.BLOCK_SIZE;
			}	
			
			//After finishing the row, go down a row and restart.
			current_x = 0f;
			current_y += GameNumbers.BLOCK_SIZE;
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
		for(int j = 0; j < blocks_down; j++)
			for(int i = 0; i < blocks_across; i++)
				blocks[j][i].update(delta);
	}

	public void updateAnt(Ant ant, float delta)
	{//Ant passed into this function. Find its block and call that block's nextPosition().
		//The floor of the X and Y values for the ants is the block coordinate the ant is on.
		int x = (int) Math.floor(ant.down.x);
		int y = (int) Math.floor(ant.down.y);
		
		//Move the ant based upon that block's rules.
		if(!doForwardBlock(x, y, delta, ant))
			blocks[y][x].nextPosition(ant, delta);
		
		//Turning around happens when left or right of the ant is a wall.
		checkTurnAround(x, y, ant);
	}
	
	private boolean doForwardBlock(int x, int y, float delta, Ant ant)
	{//We need to check in front of the ant to see if another set of rules overrides the ground's rules.		
		boolean override = false;
		
		if(ant.direction == 1)
		{//Right
			if(ant.right.x >= blocks[y + 1][x + 1].getX() && blocks[y + 1][x + 1].type != GameNumbers.BLOCK_AIR && x < screen_game.game_holder.WORLD_TOTAL_HORIZONTAL - 1)
			{
				override = true;
				blocks[y + 1][x + 1].nextPosition(ant, delta);
			}
		}
		else
		{//Left
			if(ant.left.x <= blocks[y + 1][x - 1].getX() + blocks[y + 1][x - 1].getWidth() && blocks[y + 1][x - 1].type != GameNumbers.BLOCK_AIR && x > 1)
			{
				override = true;
				blocks[y + 1][x - 1].nextPosition(ant, delta);
			}
		}
		
		return override;
	}
	
	private void checkTurnAround(int x, int y, Ant ant)
	{
		//Do ceiling logic
		if(ant.up.y >= blocks[y + 1][x].getY() && GridBlock.isSolidAtBottom(blocks[y + 1][x].type))
		{
			ant.setPosition(ant.getX(), blocks[y + 1][x].getY() - ant.getHeight());
			//ant.angle.x *= 0.85f;
			ant.angle.y = 0f;
			ant.direction *= -1;
		}		
		
		/* Logic for Turn-Around Checking:
		 * Get the ant's direction.
		 * Check the ant's right/left border with the left/right side of the next block respectively.
		 * If touching, turn around.
		 * You don't have to worry about out-of-bounds cases. Every level will have a full box around it.
		 */		
		if(ant.direction == 1)
		{//Right
			int next = y + 1;
			if(ant.up.y <= blocks[y][x].getY() + blocks[y][x].getHeight())
				next--;
			
			if(ant.right.x >= blocks[next][x + 1].getX() && GridBlock.isSolid(blocks[next][x + 1].type, true))
			{
				ant.setPosition(blocks[next][x + 1].getX() - ant.getWidth(), ant.getY());
				ant.angle.x *= -1f;
				ant.angle.y = 0f;
				ant.direction *= -1;
			}
		}
		else
		{//Left
			int next = y + 1;
			if(ant.up.y <= blocks[y][x].getY() + blocks[y][x].getHeight())
				next--;
			
			if(ant.left.x <= blocks[next][x - 1].getX() + blocks[next][x - 1].getWidth() && GridBlock.isSolid(blocks[next][x - 1].type, false))
			{
				ant.setPosition(blocks[next][x - 1].getX() + blocks[next][x - 1].getWidth(), ant.getY());
				ant.angle.x *= -1f;
				ant.angle.y = 0f;
				ant.direction *= -1;
			}
		}
	}
	
	private GridBlock getGridblockFromType(int type, int counter)
	{//This logic is put down here to make the block creation neater.
		switch(type)
		{
			case GameNumbers.BLOCK_AIR:
				return new BlockAir(counter, type, screen_game.assets.block_textures[type]);
			case GameNumbers.BLOCK_GROUND_SOLID:
				return new BlockGroundSolid(counter, type, screen_game.assets.block_textures[type]);
			case GameNumbers.BLOCK_GROUND_SLOPED_RIGHT:
			case GameNumbers.BLOCK_GROUND_SLOPED_LEFT:
			case GameNumbers.BLOCK_CEILING_SLOPED_RIGHT:
			case GameNumbers.BLOCK_CEILING_SLOPED_LEFT:
				return new BlockDiagonal(counter, type, screen_game.assets.block_textures[type]);
			case GameNumbers.BLOCK_SPAWNER:
				return null;
			case GameNumbers.BLOCK_GOAL:
				return null;
			default:
				System.out.println("Error: Unrecognized block type \"" + type + "\" at value " + counter + ".");
				return null;
		}
	}
}
