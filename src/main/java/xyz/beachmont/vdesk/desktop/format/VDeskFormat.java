package xyz.beachmont.vdesk.desktop.format;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * .vdk file format structure
 */
public class VDeskFormat implements Serializable {
  public VDeskFormat()  {
    this.points = new ArrayList<>();
    this.boxes = new ArrayList<>();
    this.alliance = Alliance.Blue;
    this.field = new VDKFieldParameters();
  }

  /// @brief  VDesk version number
  public static int VDESK_VERSION = 2;

  /// @brief  Points of interest
  public ArrayList<VDKPoint> points;

  /// @brierf  Bounding boxes
  public ArrayList<VDKBoundingBox> boxes;

  /// @brief  Alliance for this .vdk file
  public Alliance alliance;

  /// @brief  Field parameters
  public VDKFieldParameters field;

  /// @brief  Save to a string
  public String save() {
    String result = "$vdk_version " + VDESK_VERSION + "\n";
    result += "$vdk_alliance " + alliance + "\n";
    result += this.field.save() + "\n";

    for (VDKPoint p : points) {
      result += p.save() + "\n";
    }

    for (VDKBoundingBox b : boxes) {
      result += "$" + b.className + " " + b.getObjectState() + "\n";
    }

    return result;
  }
}
