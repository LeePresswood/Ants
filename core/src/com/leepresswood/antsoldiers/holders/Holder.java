package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Holder
{	
	protected SpriteBatch batch;
	
	public Holder()
	{		
		batch = new SpriteBatch();
	}
	
	public abstract void update(float delta);
	public abstract void render();
}
