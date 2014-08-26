package com.leepresswood.antsoldiers.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.leepresswood.antsoldiers.GameAntSoldiers;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 405;
		config.height = 720;
		new LwjglApplication(new GameAntSoldiers(), config);
	}
}
