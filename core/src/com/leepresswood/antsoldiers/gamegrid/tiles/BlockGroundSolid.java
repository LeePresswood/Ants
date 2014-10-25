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
	public Vector2 nextPosition(Ant ant, float speed)
	{
		/* This is a simple block.
		 * Current position's Y coordinate should be at the very top of this.
		 * X will be dependent on the speed's X component. Speed.y is ignored.
		 */
		if(ant.right.x >= 1 || ant.left.x <= 0)
			ant.direction *= -1;
		return new Vector2(ant.getX() + speed * ant.direction, this.getY() + GameNumbers.BLOCK_SIZE * 0.999f);
	}
}
