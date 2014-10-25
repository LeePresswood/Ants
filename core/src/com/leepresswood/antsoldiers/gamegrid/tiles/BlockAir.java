package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.antsoldiers.ants.Ant;

public class BlockAir extends GridBlock
{
	public BlockAir(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public void nextPosition(Ant ant, float speed)
	{
		/* This is an air block.
		 * Ant's current Y coordinate should fall each update. This will eventually lead to a walkable block.
		 * X coordinate should not change.
		 */
		ant.setPosition(ant.getX(), ant.getY() - speed);
	}
}
