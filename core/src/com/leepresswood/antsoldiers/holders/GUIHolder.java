package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.leepresswood.antsoldiers.management.GameNumbers;
import com.leepresswood.antsoldiers.screens.ScreenGame;

public class GUIHolder extends Holder
{
	private Sprite[] block_sprites;
	
	public GUIHolder(ScreenGame screen_game, int level)
	{
		float x = 0f;
		float y = 0f;
		float size = 50f;
		
		block_sprites = new Sprite[GameNumbers.NUMBER_OF_BLOCKS];	
		for(int i = 0; i < GameNumbers.NUMBER_OF_BLOCKS; i++)
		{
			block_sprites[i] = new Sprite(screen_game.assets.block_textures[i]);
			block_sprites[i].setBounds(x, y, size, size);
			x += size;
		}		
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
				s.draw(batch);
		batch.end();
	}
}
