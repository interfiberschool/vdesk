package xyz.beachmont.vdesk.desktop.format;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * .vdk file format structure
 */
public class VDeskFormat implements Serializable {
  public VDeskFormat()  {
    this.points = new ArrayList<>();
    this.alliance = Alliance.Blue;
  }

  /// @brief  VDesk version number
  public static int VDESK_VERSION = 2;

  /// @brief  Points of interest
  public ArrayList<VDKPoint> points;

  /// @brief  Alliance for this .vdk file
  public Alliance alliance;

  /// @brief  Save to a string
  public String save() {
    String result = "$vdk_version " + VDESK_VERSION + "\n";
    result += "$vdk_points " + points.size() + "\n";
    result += "$vdk_alliance " + alliance + "\n";

    for (VDKPoint p : points) {
      result += p.save() + "\n";
    }

    return result;
  }
}
