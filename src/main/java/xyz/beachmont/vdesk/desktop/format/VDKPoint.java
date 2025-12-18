package xyz.beachmont.vdesk.desktop.format;

public class VDKPoint { 
  public VDKPoint(String name, float x, float y) {
    this.pointName = name;

    this.x = x;
    this.y = y;
  }

  /// @brief  Name of this point
  public String pointName;

  /// @brief Position of this point on the field
  public float x, y;

  public String save() {
    return "$vdk_point (" + pointName + ")," + x + "," + y;
  }
}
