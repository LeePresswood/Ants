package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class BlockGroundSolid extends GridBlock
{
	public BlockGroundSolid(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public void nextPosition(Ant ant, float speed)
	{
		/* This is a simple block.
		 * Current position's Y coordinate should be at the very top of this.
		 * dX will be dependent on the speed component.
		 */
		if(ant.getY() < this.getY() + this.getHeight())	//Push to top.
			ant.setY(this.getY() + this.getHeight());
		
		ant.setPosition(ant.getX() + speed * ant.direction, ant.getY());
	}
}
