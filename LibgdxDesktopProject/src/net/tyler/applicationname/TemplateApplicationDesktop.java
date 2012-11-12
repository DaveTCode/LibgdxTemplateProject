package net.tyler.applicationname;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class TemplateApplicationDesktop {

  public static void main(String[] args) {
    new LwjglApplication(new TemplateApplicationGame(), 
                         "Template Application", 
                         Configuration.GAME_WIDTH(), 
                         Configuration.GAME_HEIGHT(),
                         true);
  }

}
