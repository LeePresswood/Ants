package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class GUIHolder extends Holder
{
	public GUIHolder(Vector2 origin_point, Vector2 holder_size)
	{
		super(origin_point, holder_size);
		
		//Grab all the GUI textures
		//TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("atlases/gui.atlas"));
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
