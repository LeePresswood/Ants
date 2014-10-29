package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.ants.Ant;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class BlockDiagonal extends GridBlock
{
	private boolean is_ceiling;
	private Vector2 start, end;
	
	public BlockDiagonal(int index, int type, Texture texture)
	{
		super(index, type, texture);
		
		start = new Vector2();
		end = new Vector2();
	}
	
	@Override
	public void setBounds(float x, float y, float width, float height)
	{
		super.setBounds(x, y, width, height);
		
		//After setting the bounds, we also want to set the diagonal part.
		switch(type)
		{
			case GameNumbers.BLOCK_GROUND_SLOPED_RIGHT:
				is_ceiling = false;
				
				start.x = x;
				start.y = y;				
				end.x = x + width;
				end.y = y + height;
				
				return;
			case GameNumbers.BLOCK_GROUND_SLOPED_LEFT:
				is_ceiling = false;
				
				start.x = x;
				start.y = y + height;				
				end.x = x + width;
				end.y = y;
				
				return;
			case GameNumbers.BLOCK_CEILING_SLOPED_RIGHT:
				is_ceiling = true;
				
				start.x = x;
				start.y = y + height;				
				end.x = x + width;
				end.y = y;
				
				return;
			case GameNumbers.BLOCK_CEILING_SLOPED_LEFT:
				is_ceiling = true;
				
				start.x = x;
				start.y = y;				
				end.x = x + width;
				end.y = y + height;
				
				return;
		}
	}

	@Override
	public void nextPosition(Ant ant, float delta)
	{
		/* How this works will be dependent on a few things:
		 * 1. Is this a ground or ceiling?
		 * 		Ground using the ant's bottom to determine collision. Ceiling uses ant's top.
		 * 2. Which side?
		 * 		We'll probably just keep it simple and make the ant go up or down at a constant rate.
		 * 		We need to check if we go up the ramp or hit it on the broad side.
		 * 3. Ceiling collision.
		 * 		Go off in some weird angle?
		 * 		Fall straight down?
		 * 		Side note: Anti-gravity could be cool in the future.
		 */
		
		ant.angle = ant.angle.add(0, GameNumbers.GRAVITY * delta);
		ant.update(delta);
		ant.newPositions();
	}	
}
