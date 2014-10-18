//Read the passed in level's file and return a 2D array of the values.
package com.leepresswood.antsoldiers.management;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;

public class LevelParser
{
	public static int[][] getGrid(int level)
	{
		Scanner scanner;
		int[][] grid = null;
		try
		{
			scanner = new Scanner(Gdx.files.internal("levels/" + level + ".lvl").file());
			int height = scanner.nextInt();
			int width = scanner.nextInt();
			grid = new int[height][width];
			
			for(int j = 0; j < height; j++)
				for(int i = 0; i < width; i++)
					grid[j][i] = scanner.nextInt();
			
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}
		
		return grid;
	}
}
