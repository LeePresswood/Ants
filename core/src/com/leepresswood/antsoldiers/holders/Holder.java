package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.management.GameNumbers;

public abstract class Holder
{
	protected Vector2 origin_point;
	protected Vector2 holder_size;
	protected SpriteBatch batch;
	
	protected Texture[] block_textures;
	
	public Holder(Vector2 origin_point, Vector2 holder_size)
	{
		this.origin_point = origin_point;
		this.holder_size = holder_size;
		this.batch = new SpriteBatch();
		
		//Grab all the block textures
		block_textures = new Texture[GameNumbers.NUMBER_OF_BLOCKS];
		block_textures[GameNumbers.BLOCK_GROUND_SOLID] = new Texture(Gdx.files.internal("blocks/ground_solid.png"));
		block_textures[GameNumbers.BLOCK_GROUND_SLOPED_RIGHT] = new Texture(Gdx.files.internal("blocks/ground_sloped_right.png"));
		block_textures[GameNumbers.BLOCK_GROUND_SLOPED_LEFT] = new Texture(Gdx.files.internal("blocks/ground_sloped_left.png"));
		block_textures[GameNumbers.BLOCK_CEILING_SLOPED_RIGHT] = new Texture(Gdx.files.internal("blocks/ceiling_sloped_right.png"));
		block_textures[GameNumbers.BLOCK_CEILING_SLOPED_LEFT] = new Texture(Gdx.files.internal("blocks/ceiling_sloped_left.png"));
		block_textures[GameNumbers.BLOCK_SPAWNER] = new Texture(Gdx.files.internal("blocks/spawner.png"));
		block_textures[GameNumbers.BLOCK_GOAL] = new Texture(Gdx.files.internal("blocks/goal.png"));
	}
	
	protected void drawSprite(Sprite s)
	{//Draw the sprites in relation to where the holder's origin_point is.
		batch.draw(s.getTexture(), s.getX() + origin_point.x, s.getY() + origin_point.y, s.getWidth(), s.getHeight());
	}
	
	public abstract void doTouch(float x, float y);
	public abstract void update(float delta);
	public abstract void render();
	public void dispose()
	{
		for(Texture t : block_textures)
			t.dispose();
	}
}
