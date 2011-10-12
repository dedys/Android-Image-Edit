package com.owleyes.moustache;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CustomImageView extends ImageView {
  private boolean pressed = false;
  private Point coords = new Point();

  /**
   * A new CustomImageView with context CONTEXT.
   * 
   */
  public CustomImageView(Context context) {
    super(context);
  }

  /**
   * Restores this imageView to the point (X, Y).
   * 
   */
  public void restore(int x, int y) {
    this.layout(x - this.getWidth() / 2, y
        - this.getHeight() / 2, x
        + this.getWidth() / 2, y
        + this.getHeight() / 2);

  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    /**
     * TODO(baugarten): Find a way to update the view such that
     * MotionEvent.ACTION_MOVE actually causes the image to update in real-time.
     */
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        pressed = true;
        coords.x = (int) event.getX();
        coords.y = (int) event.getY();
        break;
      case MotionEvent.ACTION_MOVE:
        coords.x = (int) event.getX();
        coords.y = (int) event.getY();

        this.layout(coords.x - this.getWidth()
            / 2, coords.y - this.getHeight(),
            coords.x + this.getWidth() / 2,
            coords.y + this.getHeight() / 2);
        ((RelativeLayout) this.getParent())
            .invalidate();
        return true;
      case MotionEvent.ACTION_UP:

        break;
      case MotionEvent.ACTION_OUTSIDE:

        break;
    }
    return super.onTouchEvent(event);
  }

}
