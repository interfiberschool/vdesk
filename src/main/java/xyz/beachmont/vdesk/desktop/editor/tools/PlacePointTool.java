package xyz.beachmont.vdesk.desktop.editor.tools;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import xyz.beachmont.vdesk.desktop.VDKEditor;
import xyz.beachmont.vdesk.desktop.editor.EditorTool;
import xyz.beachmont.vdesk.desktop.format.VDKPoint;
import xyz.beachmont.vdesk.desktop.gfx.GfxContent;

public class PlacePointTool extends EditorTool {
  public PlacePointTool() {
    super("place_point");
  }

  @Override
  public void activated(VDKEditor editor) {
  }

  @Override
  public void whileActive(VDKEditor editor, GfxContent g) {
  }

  @Override
  public void deactivated(VDKEditor editor) {
  }

  @Override
  public void keyPressed(VDKEditor editor, KeyEvent e) {
  }

  @Override
  public void mouseClicked(VDKEditor editor, MouseEvent e) {
    if (editor.activeFile == null) {
      JOptionPane.showMessageDialog(null, "You can only place points when a file is loaded", this.name + " tool", JOptionPane.ERROR_MESSAGE);

      return;
    }

    VDKPoint p = new VDKPoint("New point", e.getX(), e.getY());
    editor.activeFile.points.add(p);
  }

}
