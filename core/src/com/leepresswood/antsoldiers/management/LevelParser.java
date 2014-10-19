//Read the passed in level's file and return a 2D array of the values.
package com.leepresswood.antsoldiers.management;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;

public class LevelParser
{
	public static int[][] getGrid(int level)
	{
		Scanner scanner = new Scanner(Gdx.files.internal("levels/" + level + ".lvl").readString());
		int height = scanner.nextInt();
		int width = scanner.nextInt();		
		int[][] grid = new int[height][width];
		
		for(int j = 0; j < height; j++)
			for(int i = 0; i < width; i++)
				grid[j][i] = scanner.nextInt();
		
		scanner.close();		
		return grid;
	}
}
