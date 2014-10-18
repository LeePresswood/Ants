package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class GUIHolder extends Holder
{
	private TextureAtlas atlas, game_atlas;
	private Sprite[] block_sprites;

	
	public GUIHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the GUI textures
		//TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlases/gui.atlas"));
		
		//The blocks will also be used as a "store", so load those, too.
		float x = 0f;
		float y = 0f;
		float size = 50f;
		block_sprites = new Sprite[NUMBER_OF_BLOCK_TYPES];	
		for(int i = 0; i < NUMBER_OF_BLOCK_TYPES; i++)
		{
			block_sprites[i] = new Sprite(block_textures[i]);
			block_sprites[i].setBounds(x, y, size, size);
			x += size;
		}
		
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
		batch.begin();
			for(Sprite s : block_sprites)
				drawSprite(s);
		batch.end();
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}
}
