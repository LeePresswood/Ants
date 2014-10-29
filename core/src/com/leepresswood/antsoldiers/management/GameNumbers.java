package com.leepresswood.antsoldiers.management;

public final class GameNumbers
{	
	//Textures for the map blocks.
	public static final int NUMBER_OF_BLOCKS = 8;
	public static final int BLOCK_AIR = 0;
	public static final int BLOCK_GROUND_SOLID = 1;
	public static final int BLOCK_GROUND_SLOPED_RIGHT = 2;
	public static final int BLOCK_GROUND_SLOPED_LEFT = 3;
	public static final int BLOCK_CEILING_SLOPED_RIGHT = 4;
	public static final int BLOCK_CEILING_SLOPED_LEFT = 5;
	public static final int BLOCK_SPAWNER = 6;
	public static final int BLOCK_GOAL = 7;
	
	//Block Numbers
	public static final float BLOCK_SIZE = 1;
	
	//Game Constants
	public static final float GRAVITY = -5f;
	
	//Ant Numbers
	public static final int ANTS_NUMBER_SPAWNED = 10;
	public static final float ANTS_SPAWN_DELAY = 0.3f;
	public static final float ANT_SIZE = 0.15f;
	public static final float ANT_SPEED = 1.75f;
}
