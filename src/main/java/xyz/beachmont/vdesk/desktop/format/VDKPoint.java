package xyz.beachmont.vdesk.desktop.format;

import java.awt.Color;

import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

public class VDKPoint extends VDKObject { 
  public VDKPoint(String name, int x, int y) {
    super(name, x, y);

    this.className = "vdk_point";
  }

  @Override
  public String getObjectState() {
    return "$(" + this.objectName + ")," + this.xPos + "," + this.yPos;
  }

  @Override
  public void render(GfxContent content) {
    content.drawCircle(Color.WHITE, this.xPos, this.yPos, 10);
    content.drawText(this.objectName, this.xPos, this.yPos);
  }
}
