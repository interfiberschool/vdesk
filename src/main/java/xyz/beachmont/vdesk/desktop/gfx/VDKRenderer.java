package xyz.beachmont.vdesk.desktop.gfx;

import java.awt.Color;
import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.format.VDKObject;

/**
 * Renders .vdk files to a graphics context
 */
public class VDKRenderer implements IRenderer {
  private VDKEditor editor;

  public VDKRenderer(VDKEditor editor) {
    this.editor = editor;
  }

  @Override
  public void render(GfxContent c) {
    c.clearBg(Color.BLACK);

    if (editor.activeFile == null) return; // Skip when no file is loaded

    if (editor.activeTool != null) {
      editor.activeTool.whileActive(this.editor, c);
    }

    for (VDKObject p : editor.activeFile.objects) {
      p.render(c);
    }
  }
}
