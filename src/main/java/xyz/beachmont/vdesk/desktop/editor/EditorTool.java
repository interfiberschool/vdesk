package xyz.beachmont.vdesk.desktop.editor;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

public abstract class EditorTool {
  public EditorTool(String name) {
    this.name = name;
  }

  /// @brief  EditorTool display name
  public String name;

  /// @brief  Called when this tool is activated
  public abstract void activated(VDKEditor editor);

  /// @brief  Called every frame while this tool is active
  public abstract void whileActive(VDKEditor editor, GfxContent g);

  /// @brief  Called when this tool is deactivated to perform cleanup tasks (ex: remove keybinds)
  public abstract void deactivated(VDKEditor editor);

  /// @brief  Called when one of this tools shortcuts is pressed
  public abstract void keyPressed(VDKEditor editor, KeyEvent e);

  /// @brief  Called when the mouse is clicked while this tool is active
  public abstract void mouseClicked(VDKEditor editor, MouseEvent e);

  /// @brief  Called when the mouse is moved
  public abstract void mouseMoved(VDKEditor editor, MouseEvent e);
}
