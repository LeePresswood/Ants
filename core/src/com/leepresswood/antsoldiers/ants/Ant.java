package com.leepresswood.antsoldiers.ants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class Ant extends Sprite
{
	public int index;
	public Vector2 position;
	
	public Vector2 up, down, left, right;
	
	public Ant(int index, Texture texture, Vector2 position)
	{
		super(texture);
		setBounds(0, 0, GameNumbers.ANT_SIZE, GameNumbers.ANT_SIZE);
		
		this.index = index;
		this.position = position;
		
		up = new Vector2();
		down = new Vector2();
		left = new Vector2();
		right = new Vector2();	
		newPositions();
	}

	private void newPositions()
	{//All vectors related to the middle of that side.		
		up.x = position.x + GameNumbers.ANT_SIZE / 2f;
		up.y = position.y + GameNumbers.ANT_SIZE;
		
		down.x = position.x + GameNumbers.ANT_SIZE / 2f;
		down.y = position.y;
		
		left.x = position.x;
		left.y = position.y + GameNumbers.ANT_SIZE / 2f;
		
		right.x = position.x + GameNumbers.ANT_SIZE;
		right.y = position.y + GameNumbers.ANT_SIZE / 2f;
	}
	
	public void update(float delta)
	{//Don't change the position here. That will be changed by the blocks. This will change the walking animation and bounds of the ant.
		//Animation.
		
		
		//Positioning.
		newPositions();
	}
}
