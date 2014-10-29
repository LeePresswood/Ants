package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class BlockAir extends GridBlock
{
	public BlockAir(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public void nextPosition(Ant ant, float delta)
	{
		//New idea: Use vectors.
		ant.angle = ant.angle.add(0, GameNumbers.GRAVITY * delta);

		/* This is an air block.
		 * Ant's current Y coordinate should fall each update. This will eventually lead to a walkable block.
		 * X coordinate should not change.
		 */
		//ant.setPosition(ant.getX() + ant.dX, ant.getY() + ant.dY);
	}
}
