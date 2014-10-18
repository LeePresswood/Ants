package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.management.GameNumbers;

public class GUIHolder extends Holder
{
	private Sprite[] block_sprites;
	
	public GUIHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the GUI textures
		//TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlases/gui.atlas"));
		
		//The blocks will also be used as a "store", so load those, too.
		float size = 50f;
		float size_of_shelf = size * GameNumbers.NUMBER_OF_BLOCKS;
		float x = holder_size.x / 2f + origin_point.x - size_of_shelf / 2f;
		float y = 0f;
		
		block_sprites = new Sprite[GameNumbers.NUMBER_OF_BLOCKS];	
		for(int i = 0; i < GameNumbers.NUMBER_OF_BLOCKS; i++)
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
