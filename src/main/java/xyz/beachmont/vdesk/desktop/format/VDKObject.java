package xyz.beachmont.vdesk.desktop.format;

import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

/**
 * Base object class for objects within a VDK file
 */
public abstract class VDKObject {
  public VDKObject(String name, int x, int y) {
    this.objectName = name;
    this.xPos = x;
    this.yPos = y;
  }

  public String objectName;

  /// @brief  Name used inside .vdk files, such as: vdk_point
  public String className;
  
  /// @brief  X position of this object
  public int xPos;

  /// @brief  Y position of this object
  public int yPos;

  public abstract String getObjectState();

  /**
   * Render this object in the scene
   * @param content Content renderer
   */
  public abstract void render(GfxContent content);
}
