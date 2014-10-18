package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class GameHolder extends Holder
{
	private Texture texture_ant;
	
	public GameHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the game textures
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlases/game.pack"));
		
		//Blocks
		
		
		//Ants
		texture_ant = atlas.createSprite("ant").getTexture();
		
		
	}

	@Override
	public void update(float delta)
	{
		
	}

	@Override
	public void render()
	{
		
	}
}
