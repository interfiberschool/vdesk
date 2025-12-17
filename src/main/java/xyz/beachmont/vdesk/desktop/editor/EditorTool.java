package xyz.beachmont.vdesk.desktop.editor;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import xyz.beachmont.vdesk.desktop.VDKEditor;

public abstract class EditorTool {
  public EditorTool(String name) {
    this.name = name;
  }

  /// @brief  EditorTool display name
  public String name;

  /// @brief  Called when this tool is activated
  public abstract void activated(VDKEditor editor);

  /// @brief  Called every frame while this tool is active
  public abstract void whileActive(VDKEditor editor, Graphics g);

  /// @brief  Called when this tool is deactivated to perform cleanup tasks (ex: remove keybinds)
  public abstract void deactivated(VDKEditor editor);

  /// @brief  Called when one of this tools shortcuts is pressed
  public abstract void keyPressed(VDKEditor editor, KeyEvent e);
}
