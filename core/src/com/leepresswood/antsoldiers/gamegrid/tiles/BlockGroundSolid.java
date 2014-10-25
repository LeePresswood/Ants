package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.antsoldiers.ants.Ant;

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
		
		//==================SOMETHING WRONG HERE======================
		if(ant.getY() < this.getY() + this.getHeight())	//Push to top.
		{
			ant.setY(this.getY() + this.getHeight());
		}
		
		ant.setPosition(ant.getX() + speed * ant.direction, ant.getY());
	}
}
