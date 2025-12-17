package xyz.beachmont.vdesk.desktop;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import xyz.beachmont.vdesk.desktop.editor.EditorTool;
import xyz.beachmont.vdesk.desktop.editor.boot.VDeskToolLoader;
import xyz.beachmont.vdesk.desktop.gfx.GfxContent;
import xyz.beachmont.vdesk.desktop.gfx.VDKRenderer;

public class VDeskApplication extends JFrame {
  private VDKEditor editor;

  VDeskApplication() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      System.out.println("VDesk failed to set the native LAF:");
      e.printStackTrace();
    }

    // Basic setup

    setTitle("VDesk v1.0");
    setSize(800, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Setup the editor

    this.editor = new VDKEditor();
    VDeskToolLoader.loadTools(this.editor);

    // Menu bar
    JMenuBar bar = new JMenuBar();

    JMenu file = new JMenu("File");

    JMenuItem createVdk = new JMenuItem("Create .vdk file");

    file.add(createVdk);
    file.add("Open .vdk file");
    file.add("Save .vdk file");
    file.add("Save .vdk file as");

    JMenu edit = new JMenu("Edit");

    JMenu tools = new JMenu("Tools");

    for (EditorTool tool : this.editor.getTools()) {
      JMenuItem activateTool = new JMenuItem(tool.name);
      activateTool.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          editor.setActiveToolByName(tool.name);
        }
      });

      tools.add(activateTool);
    }
    
    JMenu field = new JMenu("Field");
    field.add("Set field type");
    field.add("Set constraints");

    JMenuItem setAlliance = new JMenuItem("Set alliance mode");

    setAlliance.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] choices = { "Red", "Blue", "Generic" };

        JOptionPane.showOptionDialog(null, "Select .vdk alliance mode", "VDesk", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
      }
    });

    field.add(setAlliance);

    JMenu help = new JMenu("Help");

    JMenuItem about = new JMenuItem("About VDesk");
    about.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, Config.version + "\n" + Config.copyright + "\n" + Config.extraInfo, "About VDesk", JOptionPane.INFORMATION_MESSAGE);
      }
    });

    help.add(about);

    bar.add(file);
    bar.add(edit);
    bar.add(tools);
    bar.add(field);
    bar.add(help);

    setJMenuBar(bar);

    VDeskCore core = new VDeskCore(this.editor);
    setContentPane(core);
  }

  class VDeskCore extends JPanel {
    private VDKEditor editor;
    private VDKRenderer renderer;

    public VDeskCore(VDKEditor editor) {
      this.editor = editor;
      this.renderer = new VDKRenderer(this.editor);

      this.addKeyListener(editor);
      this.addMouseListener(editor);

      System.out.println("VDeskCore init");
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      // Render the .vdk file
      GfxContent content = new GfxContent(g, getWidth(), getHeight());
      this.renderer.render(content);

      try {
        Thread.sleep(1/60); // Sleep to obtain frame rate (kinda a hack)
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      this.repaint(); // Request screen to be redrawn
    }

  };
}
