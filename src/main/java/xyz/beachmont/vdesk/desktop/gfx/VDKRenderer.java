package xyz.beachmont.vdesk.desktop.gfx;

import java.awt.Color;
import java.awt.Graphics;

import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.format.VDKPoint;

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

    // Render points first
    for (VDKPoint p : editor.activeFile.points) {
      c.drawCircle(Color.YELLOW, (int) p.x, (int) p.y, 10);
    }
  }
}
