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
		
		speed = new Vector2(0.1f, 0f);
	}
}
