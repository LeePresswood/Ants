package com.leepresswood.antsoldiers.gamegrid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GridBlock extends Sprite
{
	public GridBlock(int type, Texture texture)
	{
		super(texture);
	}
	public int coord_x;
	public int coord_y;
	
	private Vector2 location;
	private float size;
}
