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

  /**
   * Draw a circle
   * @param color Color of the circle
   * @param x X position of the center
   * @param y Y position of the center
   * @param size W & H of the circle
   */
  public void drawCircle(Color color, int x, int y, int size) {
    this.graphics.setColor(color);

    this.graphics.fillOval(x-(size/2), y-(size/2), size, size);
  }
}
