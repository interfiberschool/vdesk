package xyz.beachmont.vdesk.desktop.gfx;

/**
 * Base renderer class
 */
public interface IRenderer {
  /// @brief  Called every frame when this renderer is active
  public void render(GfxContent g);
}
