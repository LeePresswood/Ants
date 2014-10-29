package com.leepresswood.antsoldiers.ants;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class Ant extends Sprite
{
	public int index;	
	public Vector2 up, down, left, right;
	public int direction = 1;
	
	public Vector2 angle;
	
	public Ant(int index, Texture texture, Vector2 position)
	{
		super(texture);
		setBounds(position.x, position.y, GameNumbers.ANT_SIZE, GameNumbers.ANT_SIZE);
		
		this.index = index;
		
		angle = new Vector2(0, 0);
		
		up = new Vector2();
		down = new Vector2();
		left = new Vector2();
		right = new Vector2();
		newPositions();
	}

	public void newPositions()
	{//All vectors related to the middle of that side.		
		up.x = this.getX() + GameNumbers.ANT_SIZE / 2f;
		up.y = this.getY() + GameNumbers.ANT_SIZE;
		
		down.x = this.getX() + GameNumbers.ANT_SIZE / 2f;
		down.y = this.getY();
		
		left.x = this.getX();
		left.y = this.getY() + GameNumbers.ANT_SIZE / 2f;
		
		right.x = this.getX() + GameNumbers.ANT_SIZE;
		right.y = this.getY() + GameNumbers.ANT_SIZE / 2f;
	}
	
	public void update(float delta)
	{//Don't change the position here. That will be changed by the blocks. This will change the walking animation and bounds of the ant.
		//Animation.
		
		
		//Repositioning.
		translate((float) (delta * angle.len() * Math.cos(angle.angleRad())), (float) (delta * angle.len() * Math.sin(angle.angleRad())));
	}
}
