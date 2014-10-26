package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.management.GameNumbers;

public abstract class GridBlock extends Sprite
{
	public int index;
	public int type;
	
	public GridBlock(int index, int type, Texture texture)
	{
		super(texture);
		this.index = index;
		this.type = type;
	}
	
	/* This function is where the moving magic happens.
	 * Pass in the bottom-middle of the ant and the speed the ant is traveling.
	 * this function will return the new location of the ant.
	 */
	public abstract void nextPosition(Ant ant, float antSpeed);
	
	public void update(float delta)
	{
		
	}
	
	public static boolean isSolid(int type, boolean is_left_of_block)
	{//Call this in the turnaround logic. It determines if you can walk through this block or not.
		switch(type)
		{		
			case GameNumbers.BLOCK_AIR:
				return false;
			case GameNumbers.BLOCK_GROUND_SOLID:
				return true;
			case GameNumbers.BLOCK_GROUND_SLOPED_RIGHT:
				return is_left_of_block;
			case GameNumbers.BLOCK_GROUND_SLOPED_LEFT:
				return !is_left_of_block;
			case GameNumbers.BLOCK_CEILING_SLOPED_RIGHT:
				return is_left_of_block;
			case GameNumbers.BLOCK_CEILING_SLOPED_LEFT:
				return !is_left_of_block;
			case GameNumbers.BLOCK_SPAWNER:
				return false;
			case GameNumbers.BLOCK_GOAL:
				return false;
			default:
				System.out.println("Error: Type " + type + " is not defined for isSolid().");
				return false;
		}
	}
}
