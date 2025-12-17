package xyz.beachmont.vdesk.desktop.gfx;

import java.awt.Color;
import java.awt.Graphics;

import xyz.beachmont.vdesk.desktop.VDKEditor;

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
  }
}
