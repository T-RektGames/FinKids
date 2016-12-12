package com.trekt.finkids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.trekt.finkids.FinGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "FinKids";
		config.width =640;
		config.height = 360;
		new LwjglApplication(new FinGame(), config);
	}
}
