package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public abstract class Holder
{
	protected Vector2 origin_point;
	protected Vector2 holder_size;
	protected SpriteBatch batch;
	
	public Holder(Vector2 origin_point, Vector2 holder_size)
	{
		this.origin_point = origin_point;
		this.holder_size = holder_size;
		this.batch = new SpriteBatch();
	}
	
	protected void drawSprite(Sprite s)
	{//Draw the sprites in relation to where the holder's origin_point is.
		batch.draw(s.getTexture(), s.getX() + origin_point.x, s.getY() + origin_point.y, s.getWidth(), s.getHeight());
	}
	
	public abstract void doTouch(float x, float y);
	public abstract void update(float delta);
	public abstract void render();
	public abstract void dispose();
}
