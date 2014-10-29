package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.antsoldiers.ants.Ant;

public class BlockDiagonal extends GridBlock
{
	
	public BlockDiagonal(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public void nextPosition(Ant ant, float delta)
	{
		
	}	
}
