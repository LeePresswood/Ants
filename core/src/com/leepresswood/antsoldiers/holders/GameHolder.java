package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class GameHolder extends Holder
{
	private TextureAtlas atlas;
	private Texture texture_ant, texture_ground_solid, texture_ground_sloped_right, texture_ground_sloped_left, texture_ceiling_sloped_left, texture_ceiling_sloped_right, texture_spawner, texture_goal;
	
	public GameHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the game textures
		atlas = new TextureAtlas(Gdx.files.internal("atlases/game.pack"));
		
		//Blocks
		texture_ground_solid = atlas.findRegion("ground_solid").getTexture();
		texture_ground_sloped_right = atlas.findRegion("ground_sloped_right").getTexture();
		texture_ground_sloped_left = atlas.findRegion("ground_sloped_left").getTexture();
		texture_ceiling_sloped_left = atlas.findRegion("ceiling_sloped_right").getTexture();
		texture_ceiling_sloped_right = atlas.findRegion("ceiling_sloped_left").getTexture();
		texture_spawner = atlas.findRegion("spawner").getTexture();
		texture_goal = atlas.findRegion("goal").getTexture();
		
		//Ants
		texture_ant = atlas.findRegion("ant").getTexture();
		
		
	}

	@Override
	public void doTouch(float x, float y)
	{
		
	}

	@Override
	public void update(float delta)
	{
		
	}

	@Override
	public void render()
	{
		
	}

	@Override
	public void dispose()
	{
		atlas.dispose();
	}
}
