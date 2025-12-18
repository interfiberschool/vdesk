package xyz.beachmont.vdesk.desktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import xyz.beachmont.vdesk.desktop.editor.EditorTool;
import xyz.beachmont.vdesk.desktop.format.VDKPoint;
import xyz.beachmont.vdesk.desktop.format.VDeskFormat;

/**
 * Handles all editor operations
 */
public class VDKEditor implements KeyListener, MouseListener, MouseMotionListener {
  public VDKEditor() {
    this.tools = new ArrayList<>();
    this.toolKeys = new ArrayList<>();

    this.activeFile = new VDeskFormat();
    this.activeFile.points.add(new VDKPoint("Hello World", -5, -5));
  }

  private ArrayList<EditorTool> tools;

  /// @brief  List of keys registered to the current EditorTool object
  private ArrayList<Integer> toolKeys;
  public EditorTool activeTool = null;
  public VDeskFormat activeFile = null;

  /// Returns the list of avalible editor tools
  public ArrayList<EditorTool> getTools() {
    return this.tools;
  }

  /// Register a new tool
  public void registerTool(EditorTool tool) {
    this.tools.add(tool);

    System.out.println("Registered tool: " + tool.name);
  }

  /// Set the active tool by its name
  public void setActiveToolByName(String name) {
    for (EditorTool tool : this.tools) {
      if (tool.name == name) {
        this.toolKeys.clear();
        this.activeTool = tool;

        this.activeTool.activated(this);

        System.out.println("Set active tool to: " + name);

        return;
      }
    }

    System.out.println("Invalid tool name for setActiveToolByName(" + name + ")");
  }

  /// Get the active tool
  public EditorTool getActiveTool() {
    return this.activeTool;
  }

  /// Key pressed handler
  @Override
  public void keyPressed(KeyEvent e) {
    if (this.activeTool == null) return;
    if (!this.toolKeys.contains(e.getExtendedKeyCode())) return;

    this.activeTool.keyPressed(this, e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (this.activeTool == null) return;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (this.activeTool == null) return;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (this.activeTool == null) return;

    this.activeTool.mouseClicked(this, e);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (this.activeTool == null) return;

    this.activeTool.mouseMoved(this, e);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    if (this.activeTool == null) return;

    this.activeTool.mouseMoved(this, e);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
  }
}
