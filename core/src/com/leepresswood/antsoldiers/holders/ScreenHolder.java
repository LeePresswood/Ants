//Holds the screen at a device-independent aspect ratio.
package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;

public class ScreenHolder
{
	//Go for a 16:9 aspect ratio.
	private float aspect_ratio = 16f / 9f;
	
	//Positioning.
	public float x;
	public float y;
	public float width;
	public float height;
	
	public ScreenHolder()
	{
		//Use the height of the device to find the width.
		height = Gdx.graphics.getHeight();
		
		//The width should be the height / aspect_ratio.
		width = height / aspect_ratio;
		
		//If the above width is greater than the screen's width, use the screen's width to determine the height instead.
		if(width >= Gdx.graphics.getWidth())
		{
			width = Gdx.graphics.getWidth();
			height = width * aspect_ratio;
		}
		
		//Determine where the x and y locations are by using the width and height.
		x = Gdx.graphics.getWidth() / 2f - width / 2f;
		y = Gdx.graphics.getHeight() / 2f - height / 2f;
	}
}
