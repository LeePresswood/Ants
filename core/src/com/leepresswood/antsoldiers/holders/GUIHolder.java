package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class GUIHolder extends Holder
{
	private TextureAtlas atlas, game_atlas;
	private Sprite[] tile_sprites;

	
	public GUIHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the GUI textures
		//TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlases/gui.atlas"));
		
		//The tiles will also be used, so load those, too.
		game_atlas = new TextureAtlas(Gdx.files.internal("atlases/game.pack"));
		tile_sprites = new Sprite[7];
		
		tile_sprites[0] = atlas.createSprite("ground_solid");
		tile_sprites[1] = atlas.createSprite("ground_sloped_right");
		tile_sprites[2] = atlas.createSprite("ground_sloped_left");
		tile_sprites[3] = atlas.createSprite("ceiling_sloped_right");
		tile_sprites[4] = atlas.createSprite("ceiling_sloped_left");
		tile_sprites[5] = atlas.createSprite("spawner");
		tile_sprites[6] = atlas.createSprite("goal");
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
		game_atlas.dispose();
	}
}
