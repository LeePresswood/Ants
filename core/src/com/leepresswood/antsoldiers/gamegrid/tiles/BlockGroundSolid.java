package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class BlockGroundSolid extends GridBlock
{
	public BlockGroundSolid(int index, int type, Texture texture)
	{
		super(index, type, texture);
	}

	@Override
	public void nextPosition(Ant ant, float delta)
	{
		/* This is a simple block.
		 * Current position's Y coordinate should be at the very top of this.
		 * dX will be the speed component.
		 */
		ant.angle.x = ant.direction * GameNumbers.ANT_SPEED;
		ant.angle.y = 0f;
		ant.update(delta);
		
		//Ant needs to be on top of this block. Be sure to reset the position again.
		if(ant.getY() < this.getY() + this.getHeight())
			ant.setY(this.getY() + this.getHeight());
		
		ant.newPositions();
	}
}
