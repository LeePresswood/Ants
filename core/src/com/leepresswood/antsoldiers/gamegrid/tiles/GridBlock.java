package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class GridBlock extends Sprite
{
	public int index;
	public int type;
	
	public GridBlock(int index, int type, Texture texture)
	{
		super(texture);
		this.index = index;
		this.type = type;
	}
	
	public abstract Vector2 next_position(Vector2 current_position, Vector2 speed);
}
