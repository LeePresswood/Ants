package com.leepresswood.antsoldiers.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Assets
{
	protected Texture[] block_textures;
	
	public Assets()
	{
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
	
	public void dispose()
	{
		for(Texture t : block_textures)
			t.dispose();
	}
}
