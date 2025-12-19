package xyz.beachmont.vdesk.desktop.format;

import java.awt.Color;
import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

/**
 * Axis aligned bounding box
 */
public class VDKBoundingBox extends VDKObject {
  public VDKBoundingBox(String name, int x, int y) {
    super(name, x, y);

    this.className = "aabb";
  }

  @Override
  public String getObjectState() {
    return xPos + "," + yPos + "," + xCorner + "," + yCorner;
  }

  public int xCorner = 0;
  public int yCorner = 0;

  @Override
  public void render(GfxContent content) {
    content.setColor(Color.YELLOW);
    content.drawBox(this.xPos, this.yPos, this.xCorner, this.yCorner);
  }
}
