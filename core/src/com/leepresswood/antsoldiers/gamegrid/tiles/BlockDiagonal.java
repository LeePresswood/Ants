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
		setDiagonal(x, y, width, height);		
	}
	
	private void setDiagonal(float x, float y, float width, float height)
	{//After setting the bounds, we also want to set the diagonal part.
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
	
	private float getYFromX(float x)
	{
		float slope = (end.y - start.y) / (end.x - start.x);System.out.println(this.getY() + slope * (x - start.x));
		return this.getY() + slope * (x - start.x);
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
		
		if(is_ceiling)
		{//Top collision
			
		}
		else
		{//Bottom collision
			//Make sure we're above the diagonal.
			float diag_y = getYFromX(ant.down.x);
			if(ant.down.y < diag_y)
				ant.setY(diag_y);
			
			//Change the vector
			ant.angle = new Vector2((end.x - start.x) * GameNumbers.ANT_SPEED * ant.direction, (end.y - start.y) * GameNumbers.ANT_SPEED * ant.direction);
			ant.update(delta);
			ant.newPositions();
		}
	}	
}
