package xyz.beachmont.vdesk.desktop.format;

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
}
