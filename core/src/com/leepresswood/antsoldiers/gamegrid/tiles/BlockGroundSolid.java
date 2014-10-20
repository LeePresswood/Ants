package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BlockGroundSolid extends GridBlock
{

	public BlockGroundSolid(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public Vector2 next_position(Vector2 current_position, Vector2 speed)
	{
		return null;
	}
	
}
