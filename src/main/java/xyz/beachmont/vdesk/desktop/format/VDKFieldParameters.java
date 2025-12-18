package xyz.beachmont.vdesk.desktop.format;

public class VDKFieldParameters {
  /// @brief  Width of the field in cm
  public float width = 0.f;

  /// @brief  Height of the field in cm
  public float height = 0.f;

  /**
   * Set the field parameters for a Vex V5 comp
   */
  public void setForV5() {
    // 12x12 field (ft)

    width = (12 * 12) * 2.54f;
    height = (12 * 12) * 2.54f;
  }

  /**
   * Set the field parameters for a Vex IQ comp
   */
  public void setForIQ() {
    // 6x8 field (ft)

    width = (6 * 12) * 2.54f;
    height = (8 * 12) * 2.54f;
  }

  public String save() {
    return "$vdk_field " + this.width + "," + this.height;
  }
}
