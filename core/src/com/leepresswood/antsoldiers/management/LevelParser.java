//Read the passed in level's file and return a 2D array of the values.
package com.leepresswood.antsoldiers.management;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;

public class LevelParser
{
	public int height, width;
	public int[][] grid;
	
	public LevelParser(int level)
	{
		//Read the text from the file.
		Scanner scanner = new Scanner(Gdx.files.internal("levels/" + level + ".lvl").readString());
		
		//First two values are the width and height of the world (in blocks).
		height = scanner.nextInt();
		width = scanner.nextInt();		
		
		//Every integer that remains is the value for which block we're using.
		grid = new int[height][width];
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				grid[j][i] = scanner.nextInt();
		
		scanner.close();		
	}
}
