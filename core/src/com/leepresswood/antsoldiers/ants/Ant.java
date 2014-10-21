package com.leepresswood.antsoldiers.ants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ant extends Sprite
{
	public int index;
	public Vector2 position;
	public Vector2 speed;
	
	public Ant(int index, Texture texture, Vector2 position)
	{
		this.index = index;
		this.position = position;
		
		speed = new Vector2(1f, 0f);
	}

	public void update(float delta)
	{//Don't change the position here. That will be changed by the blocks. This will just change the walking animation of the ant.
		
	}
}
