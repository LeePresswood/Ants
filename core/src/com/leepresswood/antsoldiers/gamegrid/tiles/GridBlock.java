package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

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
	public abstract Vector2 nextPosition(Vector2 current_position, float antSpeed);
}
