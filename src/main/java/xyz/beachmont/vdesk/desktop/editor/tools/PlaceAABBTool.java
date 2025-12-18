package xyz.beachmont.vdesk.desktop.editor.tools;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.editor.EditorTool;
import xyz.beachmont.vdesk.desktop.format.VDKBoundingBox;
import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

/**
 * Place down an axis-aligned bounding box
 */
public class PlaceAABBTool extends EditorTool {
  private boolean isPlacing = false;
  private int originX = 0;
  private int originY = 0;

  private int cornerX = 0;
  private int cornerY = 0;

  public PlaceAABBTool() {
    super("place_aabb");
  }

  @Override
  public void activated(VDKEditor editor) {
  }

  @Override
  public void whileActive(VDKEditor editor, GfxContent g) {
    if (this.isPlacing) {
      g.setColor(Color.BLUE);
      g.drawBox(this.originX, this.originY, this.cornerX, this.cornerY);
    }
  }

  @Override
  public void deactivated(VDKEditor editor) {
  }

  @Override
  public void keyPressed(VDKEditor editor, KeyEvent e) {
  }

  @Override
  public void mouseClicked(VDKEditor editor, MouseEvent e) {
    if (e.getButton() != MouseEvent.BUTTON1) return;

    if (!this.isPlacing) {
      this.isPlacing = true;

      this.originX = e.getX();
      this.originY = e.getY();

      this.cornerX = this.originX;
      this.cornerY = this.originY;
    } else {
      this.isPlacing = false;

      VDKBoundingBox aabb = new VDKBoundingBox("New bounding box", this.originX, this.originY);

      aabb.xCorner = this.cornerX;
      aabb.yCorner = this.cornerY;

      editor.activeFile.boxes.add(aabb);
    }
  }

  @Override
  public void mouseMoved(VDKEditor editor, MouseEvent e) {
    if (this.isPlacing) {
      this.cornerX = e.getX();
      this.cornerY = e.getY();
    }
  }

}
