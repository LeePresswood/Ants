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
	public Vector2 nextPosition(Vector2 current_position, Vector2 speed)
	{
		/* This is a simple block.
		 * Current position's Y coordinate should be at the very top of this.
		 * X will be dependent on the speed's X component. Speed.y is ignored.
		 */
		return new Vector2(current_position.x + speed.x, this.getY() + this.getHeight());
	}
}
