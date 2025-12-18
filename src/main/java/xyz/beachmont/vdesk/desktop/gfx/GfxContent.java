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

  /**
   * Draw centered text
   * @param text Text to draw
   * @param x Base x coordinate
   * @param y Base y coordinate, font height is added
   */
  public void drawText(String text, int x, int y) {
    int fWidth = this.graphics.getFontMetrics().stringWidth(text);

    this.graphics.drawString(text, x-(fWidth/2), y + this.graphics.getFontMetrics().getHeight());
  }

  /**
   * Draw a 2D box
   * @param x1 Origin of the box (x)
   * @param y1 Origin of the box (y)
   * @param x2 Corner of the box (x)
   * @param y2 Corner of the box (y)
   */
  public void drawBox(int x1, int y1, int x2, int y2) {
    this.graphics.fillRect(x1, y1, x2-x1, y2-y1);
  }

  /**
   * Override the draw color for methods which do not support it
   * @param color Overriding color
   */
  public void setColor(Color color) {
    this.graphics.setColor(color);
  }
}
