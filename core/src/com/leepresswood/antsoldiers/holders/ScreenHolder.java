//Holds the screen at a device-independent aspect ratio.
package com.leepresswood.antsoldiers.holders;

import com.badlogic.gdx.Gdx;

public class ScreenHolder
{
	//Go for a 16:9 aspect ratio.
	private float aspect_ratio = 16f / 9f;
	
	public float width;
	public float height;
	
	public ScreenHolder()
	{
		//Use the height of the device to find the width
		height = Gdx.graphics.getHeight();
	}
}
