package com.leepresswood.antsoldiers.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Assets
{
	public Texture texture_ant;
	public Texture[] block_textures;
	
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
		
		//Ants. For now, only one. Could be cool to have different types eventually from which you can pick or get randomly.
		texture_ant = new Texture(Gdx.files.internal("ants/ant.png"));;
	}
	
	public void dispose()
	{
		for(Texture t : block_textures)
			t.dispose();
		
		texture_ant.dispose();
	}
}
