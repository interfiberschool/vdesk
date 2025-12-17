package xyz.beachmont.vdesk.desktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import xyz.beachmont.vdesk.desktop.editor.EditorTool;

/**
 * Handles all editor operations
 */
public class VDKEditor implements KeyListener {
  public VDKEditor() {
    this.tools = new ArrayList<>();
    this.toolKeys = new ArrayList<>();
  }

  private ArrayList<EditorTool> tools;

  /// @brief  List of keys registered to the current EditorTool object
  private ArrayList<Integer> toolKeys;
  public EditorTool activeTool = null;

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
}
