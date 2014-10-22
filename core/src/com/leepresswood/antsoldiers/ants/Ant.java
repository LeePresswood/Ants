package com.leepresswood.antsoldiers.ants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ant extends Sprite
{
	public int index;
	public Vector2 position;
	
	public Vector2 up, down, left, right;
	
	public Ant(int index, Texture texture, Vector2 position)
	{
		this.index = index;
		this.position = position;
		
		up = new Vector2();
		down = new Vector2();
		left = new Vector2();
		right = new Vector2();
	}

	public void update(float delta)
	{//Don't change the position here. That will be changed by the blocks. This will change the walking animation and bounds of the ant.
		
	}
}
