package xyz.beachmont.vdesk.desktop.editor.boot;

import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.editor.tools.PlacePointTool;

public class VDeskToolLoader {
  public static void loadTools(VDKEditor editor) {
    System.out.println("Begin registering editor tools...");

    editor.registerTool(new PlacePointTool());
  }
}
