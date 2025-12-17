package xyz.beachmont.vdesk.desktop.gfx;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Main graphics content renderer
 */
public class GfxContent {
  private Graphics graphics;
  private int w, h;

  public GfxContent(Graphics g, int w, int h) {
    this.graphics = g;

    this.w = w;
    this.h = h;
  }

  /**
   * Clear the background of the graphics window
   * @param clearColor Color to clear too
   */
  public void clearBg(Color clearColor) {
    Color oldColor = this.graphics.getColor();

    // Clear bg
    this.graphics.setColor(clearColor);
    this.graphics.fillRect(0, 0, this.w, this.h);

    // Reset color
    this.graphics.setColor(oldColor);
  }
}
